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

    <link rel='stylesheet prefetch' href='https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css'>
</head>
</html>

<div class="container">
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
                            <fmt:formatDate type="both"
                                            dateStyle="short" timeStyle="short" value="${tourDeparture.departure}"/>
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
                        <%--@elvariable id="booking" type="com.lth.pojos.Booking"--%>
                        <form:form cssClass="admin-form" method="get" action="" modelAttribute="booking">
                            <div class="form-group">
                                <input value="<fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${minDate}" />"
                                       readonly style="width: 100%; padding: .5rem; margin-top: 1rem">
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
                        <button class="btn btn-primary col-md-12 btn-tourSchedule" data-toggle="collapse"
                                data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
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

    <%--BÌNH LUẬN--%>
    <section id="feedback">
        <h5 class="text-muted text-center">Đánh giá chuyến du lịch</h5>
        <%--@elvariable id="feedback" type="com.lth.pojos.Feedback"--%>
        <c:url value="/api/add-feedback" var="action"/>
        <form class="">
            <div class="row mb-3">
                <div class="col-12 form-floating text-center mb-3">
                    <div class="stars d-inline-flex flex-row-reverse" id="rating">
                        <small id="star-rating" style="display: none"></small>
                        <input class="star star-5" id="star-5" type="radio" name="rating" value="5" checked/>
                        <label class="star star-5" for="star-5"></label>
                        <input class="star star-4" id="star-4" type="radio" name="rating" value="4"/>
                        <label class="star star-4" for="star-4"></label>
                        <input class="star star-3" id="star-3" type="radio" name="rating" value="3"/>
                        <label class="star star-3" for="star-3"></label>
                        <input class="star star-2" id="star-2" type="radio" name="rating" value="2"/>
                        <label class="star star-2" for="star-2"></label>
                        <input class="star star-1" id="star-1" type="radio" name="rating" value="1"/>
                        <label class="star star-1" for="star-1"></label>
                    </div>
                    <label for="comment"></label><textarea class="form-control" rows="3" id="comment" name="comment"
                                                           placeholder="Hãy chia sẻ những điều bạn thích về chuyến du lịch này nhé!"></textarea>
                </div>
                <div class="col-12 form-floating text-right mb-3">
                    <input class="btn btn-danger" type="button"
                           onclick="addFeedback(${tour.id},1)" value="Thêm đánh giá"/>
                </div>
            </div>
        </form>

        <%--Hiển thị feedback--%>
        <div id="feedbackSection">
        </div>
        <c:forEach var="feedback" items="${feedbacks}">
            <div class="media border my-2 p-3">
                <img src="https://dulichviet.com.vn/images/bandidau/Du-lich-Chau-a/Thai-Lan/du-lich-thai-lan-tham-quan-chua-nui-vang-gia-tot-du-lich-viet.jpg"
                     alt="${feedback.user.username}" class="mr-3 mt-3 rounded-circle" style="width:60px;height: 60px;
                      background-size: cover">
                <div class="media-body">
                    <h6>
                        <c:choose>
                            <c:when test="${feedback.user.firstName != null && feedback.user.lastName != null}">
                                ${feedback.user.lastName} ${feedback.user.firstName}
                            </c:when>
                            <c:otherwise>Ẩn danh</c:otherwise>
                        </c:choose>
                        <small><i class="feedback-createDate">${feedback.createdDate}</i></small>
                    </h6>
                    <p>
                        <c:choose>
                            <c:when test="${feedback.rating > 0}"><small>
                                <c:forEach begin="1" end="5" varStatus="loop">
                                    ${(loop.index > feedback.rating) ? '<i class="fa-regular fa-star"></i>' : '<i class="fa-solid fa-star"></i>'}
                                </c:forEach>
                            </small></c:when>
                        </c:choose>

                    </p>
                    <p>${feedback.comment}</p>
                </div>
            </div>
        </c:forEach>
    </section>
</div>

<script>
    moment.updateLocale('vi', {
        relativeTime: {
            future: "trong %s",
            past: "%s trước",
            s: 'vài giây',
            ss: '%d giây',
            m: "một phút",
            mm: "%d phút",
            h: "một giờ",
            hh: "%d giờ",
            d: "một ngày",
            dd: "%d ngày",
            w: "một tuần",
            ww: "%d tuần",
            M: "một tháng",
            MM: "%d tháng",
            y: "một năm",
            yy: "%d năm"
        }
    });
    moment.locale('vi');
    window.onload = function () {
        let dates = document.querySelectorAll(".feedback-createDate");

        for (let i = 0; i < dates.length; i++) {
            let d = dates[i];
            d.innerText = moment(d.innerText).fromNow();
        }
    }
</script>
