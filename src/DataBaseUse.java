import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.*;

public class DataBaseUse {

    private static DataSource ds;

    static {
        try {
            Context initcon = new InitialContext();
            Context envContext = (Context) initcon.lookup("java:comp/env");
            ds = (DataSource) envContext.lookup("jdbc/user");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private static boolean valideVisit(String room, String time) {
        ResultSet valid = null;
        Connection connection = null;
        Statement statement = null;
        String meetingInD = "select rooms from realtor where rooms = '" + room + "' AND datatime = '" + time + "'";
        try {
            connection = ds.getConnection();
            statement = connection.createStatement();
            valid = statement.executeQuery(meetingInD);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return true;
        }
        try {
            return valid.next();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (valid != null) {
                    valid.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    }

    public static boolean formalize(String room, String time) {
        int resault;
        String queryAdd = "INSERT INTO realtor(rooms, datatime) VALUES ('" + room + "', '" + time + "')";
        if (!valideVisit(room, time)) {
            Connection connection = null;
            Statement statement = null;

            try {
                connection = ds.getConnection();
                statement = connection.createStatement();
                resault = statement.executeUpdate(queryAdd);
                return true;
            } catch (SQLException e) {
                System.err.println("Error connection or update database.");
                return false;
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
            }
        } else {
            System.out.println("Unvalide visisit or error open conection.");
            return false;
        }
    }

}
