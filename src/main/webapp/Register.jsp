<%--
  Created by IntelliJ IDEA.
  User: evgenii
  Date: 11.03.2024
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <form action="Register" method="POST">
        Почта: <input type="text" name="email"/>
        Логин: <input type="text" name="login"/>
        Пароль: <input type="password" name="password"/>
        <input type="submit" value="Зарегистрироваться">
    </form>

    <a href="Login">Войти (я уже зарегистрирован</a>
</head>
<body>

</body>
</html>
