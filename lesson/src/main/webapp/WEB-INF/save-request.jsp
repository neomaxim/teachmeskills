<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="static java.time.LocalTime.now" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 05.11.2023
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>Forms</title>
</head>
<body>
<form action="formInfo" method="POST">
    Name: <input name="username" />
    <br><br>
    Age: <input name="userage"/>
    <br><br>
       Country: <select name="country">
    <option></option>
    <option>Russia</option>
    <option>Belarus</option>
    <option>USA</option>
    <option>Germany</option>
</select>
        <br><br>
    <input type="submit" value="Подать данные заявки" />
</form>
</body>
</html>
