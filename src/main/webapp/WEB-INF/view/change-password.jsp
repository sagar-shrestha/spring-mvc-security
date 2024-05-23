<%--
  Created by IntelliJ IDEA.
  User: sagar
  Date: 22-05-2024
  Time: 07:33
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

<h1>Reset Password</h1>

<c:if test="${param.invalidOldPassword != null}">Invalid Old Password</c:if>
<c:if test="${param.invalidNewAndConfirmPassword != null}">Invalid new and confirm password</c:if>
<form:form action="savePassword" method="post" modelAttribute="changePassword">
<label>Old Password</label>
    <form:input path="oldPassword"/>
    <br/>
    <label>New Password</label>
    <form:input path="newPassword"/>
    <br/>
    <label>Confirm Password</label>
    <form:input path="confirmPassword"/>
    <br/>
    <input value="Change Password" type="submit">
</form:form>

</body>
</html>
