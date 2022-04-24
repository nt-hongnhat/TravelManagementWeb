<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.math.BigDecimal" %><%--
    Document   : index
    Created on : Mar 28, 2022, 2:58:57 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="ser" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<div class="container-fluid py-3" id="tours">
    <h3 class="text-center">${numberOfTour} TOUR DU LỊCH</h3>
    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        <c:forEach var="tour" items="${tours}">
            <div class="col my-3">
                <div class="card h-100">
                    <!-- Tour image-->
                    <img class="card-img-top h-auto" src="<c:url value="/resources/images/bg-main-page.jpg"/>"
                         alt="...">
                    <!-- Tour details-->
                    <div class="card-body p-3">
                        <div class="">
                            <!-- Tour name-->
                            <h6 class="fw-bolder ca">${tour.name}</h6>
                            <!-- Tour price-->
                            <h6 class="text-danger text-right">
                                <fmt:formatNumber value="${tour.price}" type="number"/> VNĐ
                            </h6>
                            <p class="card-text">
                                <span><i class="fa-solid fa-clock"></i></span>
                                <span>${tour.durationId.quantityDays} ngày
                                    ${tour.durationId.quantityNights} đêm</span>
                            </p>
                            <p>
                                <span><i class="fa-solid fa-calendar-check"></i></span>
                                <span>${tour.tripId.departureProvinceId.name}</span>
                            </p>
                        </div>
                    </div>
                    <!-- Tour actions-->
                    <div class="card-footer p-3 pt-0 border-top-0 bg-transparent">
                        <div class="text-center">
                            <a class="btn btn-outline-dark mt-auto" href="#">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="container-fluid py-3" id="hotels">
    <h3 class="text-center">KHÁCH SẠN</h3>
    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        <c:forEach var="tour" items="${tours}">
            <div class="col my-3">
                <div class="card h-100">
                    <!-- Tour image-->
                    <img class="card-img-top h-auto" src="<c:url value="/resources/images/bg-main-page.jpg"/>"
                         alt="...">
                    <!-- Tour details-->
                    <div class="card-body p-3">
                        <div class="">
                            <!-- Tour name-->
                            <h6 class="fw-bolder ca">${tour.name}</h6>
                            <!-- Tour price-->
                            <h6 class="text-danger text-right">
                                <fmt:formatNumber value="${tour.price}" type="number"/> VNĐ
                            </h6>
                            <p class="card-text">
                                <span><i class="fa-solid fa-clock"></i></span>
                                <span>${tour.durationId.quantityDays} ngày
                                    ${tour.durationId.quantityNights} đêm</span>
                            </p>
                            <p>
                                <span><i class="fa-solid fa-calendar-check"></i></span>
                                <span>${tour.tripId.departureProvinceId.name}</span>
                            </p>
                        </div>
                    </div>
                    <!-- Tour actions-->
                    <div class="card-footer p-3 pt-0 border-top-0 bg-transparent">
                        <div class="text-center">
                            <a class="btn btn-outline-dark mt-auto" href="#">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
<div class="container-fluid py-3" id="news">
    <h3 class="text-center">TIN TỨC GẦN ĐÂY</h3>
    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        <c:forEach var="tour" items="${tours}">
            <div class="col my-3">
                <div class="card h-100">
                    <!-- Tour image-->
                    <img class="card-img-top h-auto" src="<c:url value="/resources/images/bg-main-page.jpg"/>"
                         alt="...">
                    <!-- Tour details-->
                    <div class="card-body p-3">
                        <div class="">
                            <!-- Tour name-->
                            <h6 class="fw-bolder ca">${tour.name}</h6>
                            <!-- Tour price-->
                            <h6 class="text-danger text-right">
                                <fmt:formatNumber value="${tour.price}" type="number"/> VNĐ
                            </h6>
                            <p class="card-text">
                                <span><i class="fa-solid fa-clock"></i></span>
                                <span>${tour.durationId.quantityDays} ngày
                                    ${tour.durationId.quantityNights} đêm</span>
                            </p>
                            <p>
                                <span><i class="fa-solid fa-calendar-check"></i></span>
                                <span>${tour.tripId.departureProvinceId.name}</span>
                            </p>
                        </div>
                    </div>
                    <!-- Tour actions-->
                    <div class="card-footer p-3 pt-0 border-top-0 bg-transparent">
                        <div class="text-center">
                            <a class="btn btn-outline-dark mt-auto" href="#">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
