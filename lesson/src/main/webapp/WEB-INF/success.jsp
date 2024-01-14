<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 03.12.2023
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>WelcomePag</title>
</head>
<body>
<p>Приветствую пользователя : <%= request.getParameter("username") %>
</p>
<p>Пароль : <%= request.getParameter("pwd2")%>
</p>
</body>
</html>
