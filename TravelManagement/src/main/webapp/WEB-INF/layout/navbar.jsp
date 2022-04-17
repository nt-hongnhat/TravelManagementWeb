<%--
  Created by IntelliJ IDEA.
  User: hongn
  Date: 4/15/2022
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="collapse navbar-collapse " id="navbarResponsive">
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
                <a class="nav-link" href="">
                    <%--                    <span><i class="fa-solid fa-right-to-bracket"></i></span>--%>
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
