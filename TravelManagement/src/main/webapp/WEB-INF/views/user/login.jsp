<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Đã có lỗi xảy ra! Vui lòng quay lại sau!
    </div>
</c:if>

<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Bạn không có quyền truy cập
    </div>
</c:if>

<c:url value="/login" var="action"/>

<div class="row justify-content-center">
    <div class="col-lg-5">
        <div class="card shadow-lg border-0 rounded-lg">
            <div class="card-header">
                <h3 class="text-center font-weight-light my-4">Đăng nhập</h3>
            </div>
            <div class="card-body">
                <form method="post" action="${action}" class="was-validated">
                    <div class="form-floating mb-3">
                        <label for="inputUsername">Tên đăng nhập</label>
                        <input class="form-control" id="inputUsername" name="username" type="text" placeholder=""
                               required>
                        <%--                            <div class="valid-feedback">Valid.</div>--%>
                        <div class="invalid-feedback">Please fill out this field.</div>
                    </div>
                    <div class="form-floating mb-3">
                        <label for="inputPassword">Mật khẩu</label>
                        <input class="form-control" id="inputPassword" name="password" type="password"
                               placeholder="" required>
                        <%--                            <div class="valid-feedback">Valid.</div>--%>
                        <div class="invalid-feedback">Please fill out this field.</div>
                    </div>
                    <div class="form-check mb-3">
                        <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="">
                        <label class="form-check-label" for="inputRememberPassword">Ghi nhớ mật khẩu</label>
                    </div>
                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                        <a class="small col-lg-6" href="#">Quên mật khẩu?</a>
                        <input class="btn btn-primary btn-block col-lg-6" type="submit" value="Đăng nhập">
                    </div>
                </form>
            </div>
            <div class="card-footer text-center py-3">
                <div class="small">
                    <a href="<c:url value="/register"/>">Chưa có tài khoản? Đăng ký!</a>
                </div>
            </div>
        </div>
    </div>
</div>

