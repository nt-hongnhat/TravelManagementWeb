
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/5/2022
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${errorMessage != null}">
    <div class="alert alert-danger">
        ${errorMessage}
    </div>
</c:if>

<c:url value="/register" var="action"/>

<form:form method="post" action="${action}" modelAttribute="user">
    <div class="form-group">
        <label for="lastname">Họ</label>
        <form:input type="text" id="lastname" path="lastName" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="firstname">Tên</label>
        <form:input type="text" id="firstname" path="firstName" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="username">Tài khoản</label>
        <form:input type="text" id="username" path="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Mật khẩu</label>
        <form:input type="password" id="password" path="password" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="confirm-password">Xác nhận mật khầu</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Đăng ký"/>
    </div>
</form:form>
