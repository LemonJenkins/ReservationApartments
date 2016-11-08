<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data</title>
    <style>
        .fig {
            text-align: left;
            margin-bottom: 0px;
        }
    </style>
</head>
<body>
<table border="1" width="60%" cellpadding="5">
    <tr>
        <th bgcolor="#5692f8"><h3 class="fig">Оформление заявки</h3></th>
    </tr>
    <tr>
        <th bgcolor="#94bdff">
            <form method="get" action="/Formalize" class="fig">
                Тип квартиры:
                <select name="selectApartment">
                    <option selected="selected">Сколько комнат</option>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                </select>
                <input type="date" name="datatime">
                <input type="time" name="datatime2" step="3600">
                <input type="submit" name="registr" value="Оформить">
            </form>
        </th>
    </tr>
</table>
<p class="fig">${message}</p>
</body>
</html>

