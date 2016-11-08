import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Formalize")
public class Formalize extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomsNumber = request.getParameter("selectApartment");
        String time = request.getParameter("datatime") + "_" + request.getParameter("datatime2");
        if (DataBaseUse.formalize(roomsNumber, time)) {
            request.setAttribute("message", "Time appointed");
        } else {
            request.setAttribute("message", "Change enother time");
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
