<%--
  Created by IntelliJ IDEA.
  User: hongn
  Date: 4/18/2022
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/tour" var="action"/>
<div class="row justify-content-center">
    <div class="col-lg-12">
        <form method="get" action="${action}">
            <div class="row my-3">
                <div class="col-md-3">
                    <div class="form-floating px-lg-2 py-lg-2">
                        <label for="inputDepartureDate">Ngày khởi hành</label>
                        <input class="form-control" id="inputDepartureDate" name="inputDepartureDate" type="date"
                               placeholder="Ngày khởi hành" min="2022-04-18" max="2022-05-01"/>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-floating px-lg-2 py-lg-2">
                        <label for="departureProvince">Nơi khởi hành</label>
                        <select class="form-control" id="departureProvince" name="departureProvince">
                            <c:forEach var="province" items="${provinces}">
                                <option>${province.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-floating px-lg-2 py-lg-2">
                        <label for="destinationProvince">Nơi đến</label>
                        <select class="form-control" id="destinationProvince" name="departureProvince">
                            <c:forEach var="province" items="${provinces}">
                                <option>${province.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-floating mt-4 px-lg-3 py-lg-3">
                        <input class="btn btn-primary btn-block" type="submit" placeholder="" value="Tìm kiếm">
                    </div>
                </div>
            </div>

        </form>

    </div>
</div>

<div class="container px-4 px-lg-5 mt-5">
    <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
        <c:forEach var="tour" items="${tours}">
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Product image-->
                    <img class="card-img-top" src="" alt="...">
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">${tour.name}</h5>
                            <!-- Product price-->
                            <h5 class="text-danger">${tour.price} VNĐ</h5>
                            <h6>${tour.description}</h6>

                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center">
                            <a class="btn btn-outline-dark mt-auto" href="#">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
