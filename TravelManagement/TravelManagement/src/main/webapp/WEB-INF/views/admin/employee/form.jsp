<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/21/2022
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/employee/save" var="action"/>

<c:if test="${message != null}">
    <div class="alert alert-danger">
            ${message}
    </div>
</c:if>

<div class="container">
    <form:form cssClass="admin-form" method="post" action="${action}" modelAttribute="employee" enctype="multipart/form-data">
        <div class="form-group">
            <label for="username" class="control-label">Tài khoản &nbsp</label>
            <form:input class="form-control" id="username" path="username"/>
        </div>

        <div class="form-group">
            <label for="password" class="control-label">Mật khẩu &nbsp</label>
            <form:input class="form-control" id="password" path="password"/>
        </div>

        <div class="form-group">
            <label for="email" class="control-label">Email &nbsp</label>
            <form:input class="form-control" id="email" path="email"/>
        </div>

        <div class="form-group">
            <label for="avatar" class="control-label">Đường dẫn hình ảnh &nbsp</label>
            <form:input class="form-control" id="avatar" path="avatar"/>
        </div>

        <div class="form-group">
            <label for="userrole" class="control-label">Loại tài khoản &nbsp</label>
            <form:input class="form-control" id="userrole" path="userRole"/>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="category" class="control-label">Họ &nbsp</label>
                <form:input class="form-control" id="category" path="category"/>
            </div>
            <div class="form-group col-md-6">
                <label for="category" class="control-label">Tên &nbsp</label>
                <form:input class="form-control" id="category" path="category"/>
            </div>
        </div>

        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="${valueButton}">
        </div>
    </form:form>
</div>

