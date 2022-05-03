<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/28/2022
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>${tour.name}</title>
    </head>
</html>

<div class="container mt-md-3">
    <section id="#tours">
        <h3 class="mb-3">${tour.name}</h3>
        <p>
            <c:forEach begin="1" end="5" varStatus="loop">
                ${(loop.index > rating[1]) ? '<i class="fa-regular fa-star"></i>' : '<i class="fa-solid fa-star"></i>'}
            </c:forEach>
            <span>
                ${rating[1]}/5<span class="font-weight-light"> trong</span>
                ${rating[0]} <span class="font-weight-light text-uppercase">đánh giá</span>
            </span>
        </p>
        <div class="row justify-content-left">
            <div class="col-md-8">
                <img class="card-img-top" src="<c:url value="${tour.image}"/>" alt="${tour.name}"/>
            </div>
            <div class="d-none d-sm-none d-md-block col-md-4">
                <div class="card card-body">
                    <p>
                        ${tour.name}
                        <hr>
                    </p>
                    <div class="row ">
                        <div class="col-md-4">Mã tour</div>
                        <div class="col-md-8">${tour.id}</div>
                    </div>
                    <hr>
                    <div class="row ">
                        <div class="col-md-4">Thời gian</div>
                        <div class="col-md-8">${tour.duration}</div>
                    </div>
                    <hr>
                    <div class="row ">
                        <div class="col-md-4">Xuất phát</div>
                        <div class="col-md-8">${tour.trip}</div>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <h5> Điểm nhấn hành trình</h5>
                    <div class="row trip-content">
                        <div class="col-md-3">Hành trình</div>
                        <div class="col-md-9">
                            <c:forEach items="${tourPlace}" var="tourPlaceItem" varStatus="status">
                                ${tourPlaceItem.places}
                                ${not status.last ? '<i class="fa-solid fa-arrow-right"></i>' : '<br/>'}
                            </c:forEach>
                        </div>
                        <div class="col-md-3">Lịch trình</div>
                        <div class="col-md-9">
                            ${tour.duration}
                        </div>
                        <div class="col-md-3">Khởi hành</div>
                        <div class="col-md-9">
                            <c:forEach items="${tourDepartures}" var="tourDeparture" varStatus="status">
                                <fmt:formatDate type = "both"
                                                dateStyle = "short" timeStyle = "short" value = "${tourDeparture.departure}" />
                                ${not status.last ? ';' : '.'}
                            </c:forEach>
                        </div>
                    </div>
                <p> ${tour.description}</p>
            </div>
            <div class=" col-md-4" style="margin-top: 2rem">
                <div class="card">
                    <div class="card-header">
                        Giá từ <strong style="font-size: 1.3rem">${tour.price}</strong>
                    </div>
                    <div class="card-body">
                        <form:form cssClass="admin-form" method="get" action="" modelAttribute="booking" >
                            <div class="form-group">
                                <input value="<fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${minDate}" />" readonly style="width: 100%; padding: .5rem; margin-top: 1rem">
                            </div>

                            <div class="form-group">
                                <a class="btn btn-primary" type="submit"
                                       href="${pageContext.request.contextPath}/tour/${tour.id}/abate"
                                        style="width: 100%">Đặt tour</a>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <h5> Lịch trình</h5>
                <c:forEach items="${tourSchedules}" var="tourSchedule">
                    <p>
                        <button class="btn btn-primary col-md-12 btn-tourSchedule" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                                ${tourSchedule.name}
                        </button>
                    </p>
                    <div class="collapse" id="collapseExample">
                        <div class="card card-body">
                                ${tourSchedule.description}
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</div>
