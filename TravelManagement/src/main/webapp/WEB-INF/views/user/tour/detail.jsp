<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <c:forEach begin="0" end="${}" varStatus="loop">
                ${loop.index > }
                <i class="fa-solid fa-star"></i>
            </c:forEach>
        </p>
        <div class="row justify-content-left">
            <div class="col-md-9">
                <img class="card-img-top" src="<c:url value="${tour.image}"/>" alt="${tour.name}"/>
            </div>
            <div class="col-md-3">

            </div>
            <div class="col-md-9">
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
                            <c:forEach items="${tourPlace}" var="tourPlaceItem" varStatus="status">
                                ${tourPlaceItem.places}
                                ${not status.last ? '<i class="fa-solid fa-arrow-right"></i>' : '<br/>'}
                            </c:forEach>
                        </div>
                    </div>
                <p> ${tour.description}</p>
            </div>

            <div class="col-md-9">
                <h5> Lịch trình</h5>
                <p>
                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">

                    </button>
                </p>
                <div class="collapse" id="collapseExample">
                    <div class="card card-body">
                        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.
                    </div>
                </div>
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
                        <c:forEach items="${tourPlace}" var="tourPlaceItem" varStatus="status">
                            ${tourPlaceItem.places}
                            ${not status.last ? '<i class="fa-solid fa-arrow-right"></i>' : '<br/>'}
                        </c:forEach>
                    </div>
                </div>
                <p> ${tour.description}</p>
            </div>
        </div>
    </section>
</div>
