<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <link rel="icon" type="image/png" href="<c:url value="/res/favicon.png"/>"/>
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
<form class="style" action="${empty auto.vin ? addUrl : editUrl}" name="auto" method="POST">
    <c:choose>
        <c:when test="${!empty auto.vin}">
            <p class="heading">Edit auto</p>
            <input type="hidden" name="id" value="${auto.id}">
        </c:when>
        <c:otherwise>
            <p class="heading">Add new auto</p>
        </c:otherwise>
    </c:choose>
    <p><input type="text" name="vin" placeholder="vin" value="${auto.vin}" maxlength="12" required autofocus
              pattern="^[^\s]+(\s.*)?$">
    <p><input type="number" name="year" placeholder="year" value="${auto.year}" maxlength="4" required
              oninput="if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);">
    <p><input type="text" name="brand" placeholder="brand" value="${auto.brand}" maxlength="10" required>
    <p class="checkbox">
        <label for="status">status
            <c:if test="${auto.status == true}">
                <input type="checkbox" name="status" id="status" value="${auto.status}" checked>
            </c:if>
            <c:if test="${auto.status != true}">
                <input type="checkbox" name="status" id="status">
            </c:if>
            <span class="checkbox-common checkbox-no">no</span>
            <span class="checkbox-common checkbox-yes">yes</span>
        </label>
    </p>
    <p>
        <c:set value="add" var="add"/>
        <c:set value="edit" var="edit"/>
        <input type="submit" value="${empty auto.vin ? add : edit}">
    </p>
    <p class="heading">${message}</p>
</form>
</body>
</html>