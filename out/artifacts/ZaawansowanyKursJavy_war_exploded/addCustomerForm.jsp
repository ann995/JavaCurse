<%--
  Created by IntelliJ IDEA.
  User: Uszek
  Date: 01.10.2018
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
    <form action="customer" method="POST">
        Id:
        <input name="id" type="number">
        Name:
        <input name="name" type="text">
        Surname:
        <input name="surname" type="text">
        BirthYear:
        <input name="birthYear" type="number">
        <br/>
        <input value="Send" type="submit">
    </form>
</body>
</html>
