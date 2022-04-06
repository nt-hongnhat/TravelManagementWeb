<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Document   : header
    Created on : Mar 31, 2022, 8:59:00 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav id="nav" class="navbar navbar-expand-md sticky-top">
            <a href="" class="navbar-brand">TravelMore</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Tour</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Thông tin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Liên hệ</a>
                    </li>
                </ul>

                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <a class="nav-link nav-button" href="<c:url value="/login" />">Đăng nhập</a>
                    <a class="nav-link nav-button" href="<c:url value="/register" />">Dăng ký</a>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <a class="nav-link nav-button" href="<c:url value="/" />">
                            ${pageContext.request.userPrincipal.name}
                    </a>
                    <a class="nav-link nav-button" href="<c:url value="/logout" />">
                        Đăng xuất
                    </a>
                </c:if>
            </div>
</nav>
