<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/5/2022
  Time: 11:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${errorMessage != null}">
    <div class="alert alert-danger">
            ${errorMessage}
    </div>
</c:if>

<c:url value="/register" var="action"/>
<div class="row justify-content-center">
    <div class="col-lg-7">
        <div class="card shadow-lg border-0 rounded-lg mt-5">
            <div class="card-header"><h3 class="text-center font-weight-light my-4">Tạo tài khoản</h3></div>
            <div class="card-body">
                <%--@elvariable id="user" type="java"--%>
                <form:form method="post" action="${action}" modelAttribute="user">
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <div class="form-floating mb-3 mb-md-0">
                                <label for="inputFirstName">Họ</label>
                                <form:input class="form-control" id="inputFirstName" type="text"
                                            placeholder="Nguyễn" path="firstName"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-floating">
                                <label for="inputLastName">Tên</label>
                                <form:input class="form-control" id="inputLastName" type="text"
                                            placeholder="Văn A" path="lastName"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-floating mb-3">
                        <label for="inputEmail">Địa chỉ email</label>
                        <form:input class="form-control" id="inputEmail" type="email"
                                    placeholder="name@example.com" path="email"/>
                    </div>
                    <div class="form-floating mb-3">
                        <label for="inputUsername">Tên tài khoản</label>
                        <form:input class="form-control" id="inputUsername" type="text"
                                    placeholder="Nhập tên tài khoản" path="username"/>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <div class="form-floating mb-3 mb-md-0">
                                <label for="inputPassword">Mật khẩu</label>
                                <form:input class="form-control" id="inputPassword" type="password"
                                            placeholder="Tạo mật khẩu" path="password"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-floating">
                                <label for="inputPasswordConfirm">Xác nhận mật khẩu</label>
                                <form:input class="form-control" id="inputPasswordConfirm" type="password"
                                            placeholder="Nhập lại mật khẩu" path="confirmPassword"/>
                            </div>
                        </div>
                    </div>
                    <div class="mt-4 mb-0">
                        <div class="d-grid">
                            <input class="btn btn-primary btn-block" type="submit" value="Tạo tài khoản">
                        </div>
                    </div>
                </form:form>
            </div>
            <div class="card-footer text-center py-3">
                <div class="small">
                    <a href="<c:url value="/login"/>">Đã có tài khoản? Tiếp tục đăng nhập</a>
                </div>
            </div>
        </div>
    </div>
</div>
