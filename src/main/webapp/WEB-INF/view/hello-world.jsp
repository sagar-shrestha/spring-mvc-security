<%--
  Created by IntelliJ IDEA.
  User: sagar
  Date: 05-04-2024
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>I am spring security</p>

<form:form action="logout" method="POST">
    <input type="submit" value="logout">
</form:form>
</body>
</html>
