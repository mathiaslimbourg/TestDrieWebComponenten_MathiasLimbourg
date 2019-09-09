<%--
  Created by IntelliJ IDEA.
  User: Mathias
  Date: 09/09/2019
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>

    <h2>Give me a name to Login</h2>
    <h2>${message}</h2>

    <form action="testdrie" method="post">
        <input type="text" name="name">
        <input type="submit" value="Push here">
    </form>


</body>
</html>
