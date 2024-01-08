<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>AUTO</title>
</head>
<body>

<h2>Auto</h2>
<table>
    <tr>
        <th>id</th>
        <th>vin</th>
        <th>year</th>
        <th>brand</th>
    </tr>
    <c:forEach var="auto" items="${autoList}">
        <tr>
            <td>${auto.id}</td>
            <td>${auto.vin}</td>
            <td>${auto.year}</td>
            <td>${auto.brand}</td>
            <td>
                <a href="/edit/${auto.id}">edit</a>
                <a href="/delete/${auto.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new CAR</a>
</body>
</html>
