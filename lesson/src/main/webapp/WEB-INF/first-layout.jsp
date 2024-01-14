<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 17.11.2023
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<style><%@include file="../css/style.css"%></style>


<html>
<head>
    <title>StartPageHtml</title>





</head>
<body>

<form action="verse" method="POST">
    <div id="container">
        <div id="header">


            <h2>header (шапка сайта)</h2>



        </div>

        <div id="navigation">


            <h2>Блок навигации</h2>
        </div>

        <div id="sidebar">
            <h2>Левая панель</h2>
            Name: <input name="username" />
        </div>

        <div id="content">
            <h2>Основной контент страницы</h2>
        </div>

        <div id="clear">

        </div>

        <div id="footer">
            <h2>footer (низ сайта)</h2>
        </div>
    </div>
</form>
</body>
</html>
