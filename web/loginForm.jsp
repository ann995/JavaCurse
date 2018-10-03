<%--
  Created by IntelliJ IDEA.
  User: Uszek
  Date: 03.10.2018
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="login.do" method=POST>
        Username:
        <input name="username" type="text">
        <br>
        Password:
        <input name="password" type="password">
        <br>
        <input value="Send" type="submit">
    </form>
</body>
</html>
