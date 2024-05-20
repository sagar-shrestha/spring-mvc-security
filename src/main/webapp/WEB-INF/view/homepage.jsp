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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello :  ${username}</h1>
<br/>
<sec:authorize access='hasAuthority("TRAINER")'>
<a href="${pageContext.request.contextPath}/trainer">Show trainer's dashboard</a>
</sec:authorize>

<sec:authorize access='hasAuthority("CODER")'>
<a href="${pageContext.request.contextPath}/coder">Show coder's dashboard</a>
</sec:authorize>
<a href="#">Show student's dahsboard</a>
<form:form action="logout" method="POST">
    <input type="submit" value="logout">
</form:form>
</body>
</html>
