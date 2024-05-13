<%--
  Created by IntelliJ IDEA.
  User: sagar
  Date: 10-05-2024
  Time: 07:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sign up</h1>
<form:form action="process-signup" method="POST" modelAttribute="signupdto">
Username: <form:input path="username"/><br/>
Password: <form:input path="password"/><br/>
        <input type="submit" value="signup"/>
</form:form>
</body>
</html>
