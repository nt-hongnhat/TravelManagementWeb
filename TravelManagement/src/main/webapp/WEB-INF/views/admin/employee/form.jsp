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
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ser" uri="http://www.springframework.org/security/tags" %>

<c:url value="/admin/employee/save" var="action"/>

<div class="container">
    <c:if test="${message != null}">
        <div class="alert alert-secondary alert-dismissible fade show fixed-top container" role="alert"
             style="margin-top: 4.8rem; z-index: 9999">
            <strong>${message}</strong>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
    <%--@elvariable id="employee" type="com.lth.pojos.User"--%>
    <form:form cssClass="admin-form" method="post" action="${action}" modelAttribute="employee"
               enctype="multipart/form-data">
        <form:hidden path="id" value="${employee.id}"/>
        <div class="form-group">
            <label for="username" class="control-label">Tài khoản &nbsp</label>
            <c:if test="${isUpdate}">
                <form:input class="form-control" id="username" path="username" required="required" readonly="true"/>
            </c:if>
            <c:if test="${!isUpdate}">
                <form:input class="form-control" id="username" path="username" required="required"/>
            </c:if>
        </div>

        <div class="form-group">
            <label for="password" class="control-label">Mật khẩu &nbsp</label>
            <form:input type="password" class="form-control" id="password" path="password" required="required"/>
        </div>

        <div class="form-group">
            <label for="email" class="control-label">Email &nbsp</label>
            <form:input type="email" class="form-control" id="email" path="email" required="required"/>
        </div>

        <div class="form-group">
            <label for="phone" class="control-label">Số điện thoại &nbsp</label>
            <form:input type="phone" class="form-control" id="phone" path="userInfoId.phone"/>
        </div>

        <div class="form-group">
            <label for="citizenship" class="control-label">Số CMND &nbsp</label>
            <form:input type="number" class="form-control" id="citizenship" path="userInfoId.citizenship"/>
        </div>

        <div class="row">
            <div class="form-group col-md-6">
                <label for="category" class="control-label">Họ</label>
                <form:input class="form-control" id="category" path="lastName" required="required"/>
            </div>
            <div class="form-group col-md-6">
                <label for="category" class="control-label">Tên</label>
                <form:input class="form-control" id="category" path="firstName" required="required"/>
            </div>
        </div>

        <div class="form-group">
            <label class="control-label">Giới tính &nbsp</label>
            <div class="form-check form-check-inline">
                <form:radiobutton class="form-check-input" id="genderMale" value="MALE"
                                  path="userInfoId.gender"/>
                <label class="form-check-label" for="genderMale">Nam</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton class="form-check-input" id="genderFemale" value="FEMALE"
                                  path="userInfoId.gender"/>
                <label class="form-check-label" for="genderFemale">Nữ</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton class="form-check-input" id="genderOther" value="OTHER"
                                  path="userInfoId.gender" checked="checked"/>
                <label class="form-check-label" for="genderOther">Khác</label>
            </div>
        </div>

        <%--        <div class="form-group">--%>
        <%--            <label for="dayOfBirth" class="control-label">Ngày sinh &nbsp</label>--%>
        <%--            <form:input type="date" class="form-control"--%>
        <%--                   placeholder="Chọn..." id="dayOfBirth"--%>
        <%--                          path="userInfoId.dayOfBirth"/>--%>
        <%--        </div>--%>

        <div class="form-group">
            <label for="avatar" class="control-label">Đường dẫn hình ảnh &nbsp</label>
            <form:input type="file" accept=".jpg, .png" class="form-control custom-file" id="avatar" path="avatar"/>
        </div>

        <ser:authorize access="hasRole('ADMIN')">
            <div class="form-group">
                <label for="userrole" class="control-label">Loại tài khoản &nbsp</label>
                <form:select class="form-control custom-select" id="userrole" path="userRole">
                    <form:option value="EMPLOYEE" label="Nhân viên" selected="selected"/>
                    <form:option value="CUSTOMER" label="Khách hàng"/>
                    <form:option value="ADMIN" label="Quản trị viên"/>
                </form:select>
            </div>
        </ser:authorize>

        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="${valueButton}">
        </div>
    </form:form>
</div>

