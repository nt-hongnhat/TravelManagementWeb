<%@ page import="java.text.DecimalFormat" %><%--
    Document   : index
    Created on : Mar 28, 2022, 2:58:57 PM
    Author     : PC
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="ser" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<% DecimalFormat decimalFormat = new DecimalFormat("###, ###, ###");%>

<ser:authorize access="hasRole('CUSTOMER')">
    <div>
        <h2>Đây là tài khoản</h2>
    </div>
</ser:authorize>

<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(numberOfTourPaginationItem)}" var="i">
            <li class="page-item"><a class="page-link" href="<c:url value="/" />?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</div>

<div class="container-fluid mt-md-3">
    <section id="#tours">
        <h3 class="mb-3">${numberOfTourPaginationItem} TOUR DU LỊCH</h3>
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach var="tour" items="${tours}">
                <div class="card-group col mb-5">
                    <div class="card w-100 h-100">
                        <img class="card-img-top" src="${tour.image}" alt="${tour.name}">
                        <div class="card-body">
                            <h5 class="card-title">${tour.name}</h5>
                            <p class="card-text">${tour.description}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">${tour.trip}</li>
                            <li class="list-group-item">${tour.duration}</li>
                            <li class="list-group-item text-danger">
                                <i class="fa-solid fa-wallet"></i>
                                <fmt:formatNumber value="${tour.price}" type="number" pattern="###,###,###"/> VNĐ
                            </li>
                        </ul>
                        <div class="card-body">
                            <a href="<c:url value="/tour/${tour.id}"/>" class="btn btn-outline-primary justify-content-center">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
    <section id="#news">
        <h3 class="mb-3">${numberOfTourPaginationItem} TIN TỨC MỚI NHẤT</h3>
        <c:forEach items="${news}" var="news">
            <div class="card-columns">
                <div class="card">
                    <img class="card-img-top" src="https://dulichviet.com.vn/images/bandidau/thoi-diem-ly-tuong-cung-nhung-diem-den-ly-tuong-khi-di-du-lich-duc.jpg" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">${news.title}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">${news.quantityLikes} - ${news.quantityViews}</h6>
                        <p class="card-text">${news.content}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </section>
</div>

