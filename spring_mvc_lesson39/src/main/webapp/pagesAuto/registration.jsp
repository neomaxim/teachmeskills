<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auto Registration</title>
</head>
<body>
<form action="/add" method="post">
    <input type="text" name="vin" placeholder="VIN: " value="${user.vin}" required/> <label>${vinErrorLabel}</label>
    <br/>
    <input type="text" name="brand" placeholder="BRAND: " value="${user.brand}"/> <label>${brandErrorLabel}</label>
    <br/>
    <input type="number" name="year" placeholder="YEAR: " value="${user.year}" required/>
    <label>${yearErrorLabel}</label> <br/>
    <input type="submit" value="Register"/>
</form>

</body>
</html>
