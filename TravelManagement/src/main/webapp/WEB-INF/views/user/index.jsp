<%@ page %><%--
    Document   : index
    Created on : Mar 28, 2022, 2:58:57 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="ser" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <h3 class="mb-3">${numberOfTour} TOUR DU LỊCH</h3>
        <div class="row gx-4 gx-lg-5 row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach items="${tours}" var="tour">
                <div class="col mb-3">
                    <div class="card h-100">
                        <img class="card-img-top" src="<c:url value="${tour.image}"/>" alt="${tour.name}"/>
                        <!-- Tour image-->
                        <!-- Tour details-->
                        <div class="card-body p-2"><h5 class="card-title text-center">
                            <a class="text-justify text-decoration-none text-info" href="">${tour.name}</a>
                        </h5>
                            <h6><i class="fa-solid fa-calendar-check"></i>${tour.trip.departureProvince}</h6>
                            <h6><i class="fa-solid fa-clock"></i>${tour.duration}</h6>
                            <h5 class="text-danger float-end float-right">
                                <i class="fa-solid fa-wallet"></i>
                                <fmt:formatNumber value="${tour.price}" type="number" pattern="###,###,###"/> VNĐ
                            </h5>
                        </div>
                        <!-- Tour actions-->
                        <div class="card-footer p-2 border-top-0 bg-transparent">
                            <div class="text-center">
                                <a class="btn btn-outline-primary mt-auto" href="#">Chi tiết</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
    <section id="#news">
        <h3 class="mb-3">${numberOfTour} TIN TỨC MỚI NHẤT</h3>
        <div class="row gx-3 gx-lg-4 row-cols-1 row-cols-sm-1 row-cols-md-2 row-cols-xl-3 justify-content-center">
            <c:forEach items="${news}" var="news">
                <div class="col mb-3">
                    <div class="card card-deck">
                            <%--                        <img class="card-img-top" src="<c:url value="${news.image}"/>" alt="${news.title}"/>--%>

                        <!-- News details-->
                        <div class="card-body p-2 w-100">
                            <h5 class="card-title text-center">
                                <a class="text-justify text-decoration-none text-info" href="">${news.title}</a>
                            </h5>
                            <h6 class="text-justify text-ellipsis">
                                    ${news.content}
                            </h6>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
</div>

