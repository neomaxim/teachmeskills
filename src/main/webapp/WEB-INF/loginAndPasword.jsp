<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 03.12.2023
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<html>
<head>
    <title>LoginAndPassword</title>
</head>
<body>
<form action="frontController" method="POST" onsubmit="return checkForm(this);">
        <p>Username: <input type="text" name="username"></p>
        <p>Password: <input type="password" name="pwd1"></p>
        <p>Confirm Password: <input type="password" name="pwd2"></p>
        <p><input type="submit" value="Login"></p>
    </form>
<script type="text/javascript">
    function checkForm(form)
    {

        if(form.username.value == "") {
            alert("Error: Введите имя пользователя!");
            form.username.focus();
            return false;
        }
        re = /^\w+$/;
        if(!re.test(form.username.value)) {
            alert("Error: Имя пользователя должно содержать только буквы, цифры и символы подчеркивания!");
            form.username.focus();
            return false;
        }

        if(form.pwd1.value != "" && form.pwd1.value == form.pwd2.value) {
            if(form.pwd1.value.length < 6) {
                alert("Error: Пароль должен содержать не менее шести символов!");
                form.pwd1.focus();
                return false;
            }
            if(form.pwd1.value == form.username.value) {
                alert("Error: Пароль должен отличаться от имени пользователя!");
                form.pwd1.focus();
                return false;
            }
            re = /[0-9]/;
            if(!re.test(form.pwd1.value)) {
                alert("Error: Пароль должен содержать хотя бы одну цифру (0-9)!");
                form.pwd1.focus();
                return false;
            }
            re = /[a-z]/;
            if(!re.test(form.pwd1.value)) {
                alert("Error: Пароль должен содержать хотя бы одну строчную букву (a-z)!");
                form.pwd1.focus();
                return false;
            }
            re = /[A-Z]/;
            if(!re.test(form.pwd1.value)) {
                alert("Error: Пароль должен содержать хотя бы одну заглавную букву (A-Z)!");
                form.pwd1.focus();
                return false;
            }
        } else {
            alert("Error: Пожалуйста, проверьте правильность ввода пароля!");
            form.pwd1.focus();
            return false;
        }
        return true;
    }

</script>
</body>
</html>



