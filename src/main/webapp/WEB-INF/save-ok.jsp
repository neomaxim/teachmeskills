<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 05.11.2023
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%!
    int number =1;
%>
<html>
<head>
       <title>ResultForm</title>
</head>
<body>
<form action="formInfo" method="POST">
<p>заявка успешно сохранена </p>
    <p>номер заявки <%= number++ %></p>
<p>Ваше имя : <%= request.getParameter("username") %></p>
<p>Ваш возраст :<%= request.getParameter("userage") %></p>
<p>Ваш регион :<%= request.getParameter("country") %></p>
<br><br>
<input type="submit" value="Завершить работу с данной заявкой" />
</form>
</body>
</html>
