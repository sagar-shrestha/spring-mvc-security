<%--
  Created by IntelliJ IDEA.
  User: sagar
  Date: 08-05-2024
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>My custom login page.</h1>

<c:if test="${param.error != null}">
    <h2 style="color: crimson">Invalid username or password</h2>
</c:if>

<c:if test="${param.logout != null}">
    <h2 style="color: crimson">Successfully logged out. Sign in again.</h2>
</c:if>

<form:form action="process-login" method="POST">
    Username: <input type="text" name="username"><br/>
    Password: <input type="password" name="password"><br/>
    <input type="submit" value="login">
</form:form>
</body>
</html>
