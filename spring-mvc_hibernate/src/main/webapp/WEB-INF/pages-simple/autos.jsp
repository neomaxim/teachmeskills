<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>AUTOS</title>
</head>
<body>
<table>
  <caption>Autos</caption>
  <tr>
    <th>№</th>
    <th>vin</th>
    <th>year</th>
    <th>brand</th>
    <th>status</th>
    <th colspan="2">action</th>
  </tr>
  <c:forEach var="auto" items="${autosList}" varStatus="i">
    <tr>
      <td>${i.index + 1 + (page - 1) * 10}</td>
      <td>${auto.vin}</td>
      <td>${auto.year}</td>
      <td>${auto.brand}</td>
      <td>${auto.status}</td>
      <td><a href="<c:url value="/edit/${auto.id}"/>">edit</a></td>
      <td><a href="<c:url value="/delete/${auto.id}"/>">delete</a></td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="7">
      <a href="<c:url value="/add"/>">Add new auto</a>
      <c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">
        <c:url value="/" var="url">
          <c:param name="page" value="${i.index}"/>
        </c:url>
        <a href="${url}">${i.index}</a>
      </c:forEach>
    </td>
  </tr>
</table>
</body>
</html>
