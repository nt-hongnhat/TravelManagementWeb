<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/login" var="action"/>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Đã có lỗi xảy ra! Vui lòng quay lại sau!
    </div>
</c:if>
<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="text" id="password" name="password" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Đăng nhập"/>
    </div>
</form>