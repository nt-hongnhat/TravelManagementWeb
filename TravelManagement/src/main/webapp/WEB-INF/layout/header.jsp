<%--
    Document   : header
    Created on : Mar 31, 2022, 8:59:00 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark sticky-top" id="mainNav">
    <%--    Brand   --%>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">
        <span>TravelMore</span>
    </a>

    <!--    Toggler/collapsibe Button   -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
        <span>Menu</span>
        <span><i class="fas fa-bars"></i></span>
    </button>
    <%--    Navbar links    --%>
    <div class="navbar-collapse collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/">
                    <%--                    <span><i class="fa-solid fa-house-chimney"></i></span>--%>
                    <span>Trang chủ</span>
                </a>
            </li>

            <%--    Dropdown    --%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="" id="navbar-drop" data-toggle="dropdown">
                    <span>Du lịch</span>
                </a>
                <div class="dropdown-menu">
                    <c:forEach var="cate" items="${categories}">
                        <a class="dropdown-item" href="#">${cate.name}</a>
                    </c:forEach>
                </div>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="">
                    <%--                    <span><i class="fa-solid fa-hotel"></i></span>--%>
                    <span>Khách sạn</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="">
                    <%--                    <span><i class="fa-solid fa-newspaper"></i></span>--%>
                    <span>Tin tức</span>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#contact">
                    <span>Liên hệ</span>
                </a>
            </li>

        </ul>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a id="btnLogin" class="btn btn-success" href="<c:url value="/login"/>" role="button">Đăng nhập</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a class="nav-link nav-button btn-success" href="<c:url value="/" />">
                    ${pageContext.request.userPrincipal.name}
            </a>
            <a id="btnLogout" class="btn btn-danger" href="<c:url value="/logout"/>" role="button">Đăng xuất</a>

        </c:if>

    </div>
</nav>
<header class="container-fluid">
    <div id="demo" class="carousel slide" data-ride="carousel">

        <!-- Indicators -->
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
        </ul>

        <!-- The slideshow -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="<c:url value="/resources/images/flower-1853920_1920.jpg"/>" alt="">
                <div class="carousel-caption">
                    <h3>Los Angeles</h3>
                    <p>We had such a great time in LA!</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value="/resources/images/bg-main-page.jpg"/>" alt="">
                <div class="carousel-caption">
                    <h3>Los Angeles</h3>
                    <p>We had such a great time in LA!</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="<c:url value="/resources/images/flower-1853920_1920.jpg"/>" alt="">
                <div class="carousel-caption">
                    <h3>Los Angeles</h3>
                    <p>We had such a great time in LA!</p>
                </div>
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
</header>