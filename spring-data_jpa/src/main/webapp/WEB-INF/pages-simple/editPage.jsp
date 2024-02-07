<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:choose>
        <c:when test="${empty auto.vin}">
            <title>Add</title>
        </c:when>
        <c:otherwise>
            <title>Edit</title>
        </c:otherwise>
    </c:choose>
</head>
<body>
<c:url value="/add" var="addUrl"/>
<c:url value="/edit" var="editUrl"/>
<form action="${empty auto.vin ? addUrl : editUrl}" name="auto" method="POST">
    <c:choose>
        <c:when test="${!empty auto.vin}">
            <p>Edit auto</p>
            <input type="hidden" name="id" value="${auto.id}">
        </c:when>
        <c:otherwise>
            <p>Add new auto</p>
        </c:otherwise>
    </c:choose>
    <p><input type="text" name="vin" placeholder="vin" value="${auto.vin}" maxlength="12" required>
    <p><input type="number" name="year" placeholder="year" value="${auto.year}" required>
    <p><input type="text" name="brand" placeholder="brand" value="${auto.brand}" maxlength="10" required>
    <p>
        <c:if test="${auto.status == true}">
            <input type="checkbox" name="status" id="status" checked>
        </c:if>
        <c:if test="${status.status != true}">
            <input type="checkbox" name="status" id="status">
        </c:if>
        <label for="status">status</label>
    </p>
    <p>
        <c:set value="add" var="add"/>
        <c:set value="edit" var="edit"/>
        <input type="submit" value="${empty auto.vin ? add : edit}">
    </p>
    <p>${message}</p>
</form>
</body>
</html>