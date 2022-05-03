<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hongn
  Date: 4/18/2022
  Time: 12:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/tours/${categoryId}" var="action"/>
<div class="row justify-content-center">
    <div class="col-lg-12">
        <form method="get" action="${action}">
            <div class="row my-3">
                <div class="col-md-4">
                    <div class="form-floating mt-2 px-lg-2 py-lg-2">
                        <label for="inputDepartureDate">Ngày khởi hành</label>
                        <input class="form-control" id="inputDepartureDate" name="departureDate" type="date"
                               placeholder="Ngày khởi hành" autofocus/>
                        <script>
                            var departureDate = document.getElementById("inputDepartureDate");
                            departureDate.valueAsDate = new Date();
                            departureDate.min = departureDate.value;
                        </script>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="form-floating mt-2 px-lg-2 py-lg-2">
                        <label for="destinationProvince">Nơi đến</label>
                        <select class="form-control" id="destinationProvince" name="departureProvince">
                            <c:forEach var="province" items="${provinces}">
                                <option value="${province.id}">${province.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <%--Thời gian đi--%>
                <div class="col-md-4">
                    <div class="form-floating mt-2 px-lg-2 py-lg-2">
                        <label for="duration">Thời gian đi</label>
                        <select class="form-control" type="checkbox" id="duration" name="duration">
                            <c:forEach var="duration" items="${durations}">
                                <option value="${duration.id}">${duration}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <%-- Khoảng giá--%>
                <div class="row col-12">
                    <div class="col-lg-6">
                        <div class="form-floating mt-2 px-lg-2 py-lg-2">
                            <label for="fromPrice">Khoảng giá: từ <span id="inputFromPrice"></span> đến <span
                                    id="inputToPrice"></span>
                            </label>
                        </div>
                    </div>
                    <%--                    <div class="col-md-6 col-lg-4 pt-0">--%>
                    <%--                        <div class="form-floating mt-2"><input class="form-control slider p-0" type="range"--%>
                    <%--                                                               name="fromPrice" id="fromPrice">--%>

                    <%--                        </div>--%>
                    <%--                    </div>--%>
                    <div class="col-md-12 col-lg-6 d-flex">
                        <input class="form-control custom-range p-0" type="range" name="fromPrice"
                               id="fromPrice">
                        <input class="form-control custom-range  p-0" type="range" name="toPrice" id="toPrice">

                    </div>
                    <%--                    <div class="col-md-6 col-lg-4 pt-0">--%>
                    <%--                        <div class="form-floating mt-2">--%>
                    <%--                            <input class="form-control slider p-0" type="range" name="toPrice" id="toPrice">--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>

                </div>
                <div class="col-md-4 col-sm-12 m-auto">
                    <div class="form-floating mt-3 px-lg-2 py-lg-2">
                        <button class="btn btn-primary btn-block" type="submit">
                            Tìm kiếm
                        </button>
                    </div>
                </div>
            </div>
            <script>
                const numberFormat = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'});
                var sliderFromPrice = document.getElementById("fromPrice");
                var sliderToPrice = document.getElementById("toPrice");
                var outputFromPrice = document.getElementById("inputFromPrice");
                var outputToPrice = document.getElementById("inputToPrice");
                var min = 1000000;
                var max = 10000000;
                var step = 1000;

                sliderFromPrice.step = sliderToPrice.step = step;
                sliderFromPrice.min = sliderToPrice.min = min;
                sliderFromPrice.max = sliderToPrice.max = max;
                sliderFromPrice.value = 1000000;
                sliderToPrice.value = 2000000;

                outputFromPrice.innerHTML = numberFormat.format(sliderFromPrice.value);
                outputToPrice.innerHTML = numberFormat.format(sliderToPrice.value);

                sliderFromPrice.oninput = function () {
                    outputFromPrice.innerHTML = numberFormat.format(this.value);
                    if (sliderToPrice.value < this.value) {
                        sliderToPrice.value = this.value;
                        outputToPrice.innerHTML = numberFormat.format(sliderToPrice.value);
                    }
                }

                sliderToPrice.oninput = function () {
                    outputToPrice.innerText = numberFormat.format(this.value);
                    if (sliderFromPrice.value > this.value) {
                        sliderFromPrice.value = this.value;
                        outputFromPrice.innerHTML = numberFormat.format(sliderFromPrice.value);
                    }
                }
            </script>
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
                            <h5 class="text-danger"><fmt:formatNumber value="${tour.price}" type="number"
                                                                      pattern="###,###,###"/> VNĐ</h5>
                            <h6>${tour.description}</h6>

                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center">
                            <a class="btn btn-outline-dark mt-auto" href="<c:url value="/tour/${tour.id}"/>">Chi
                                                                                                             tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>