<%-- 
    Document   : index
    Created on : Mar 28, 2022, 2:58:57 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="ser" uri="http://www.springframework.org/security/tags" %>

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

<%--<div>--%>
<%--    <c:forEach var="tour" items="${tours}">--%>
<%--        <div class="card" style="width: 18rem;">--%>
<%--            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/bg-main-page.jpg"--%>
<%--                 alt="Card image cap">--%>
<%--            <div class="card-body">--%>
<%--                <h5 class="card-title">${tour.name}123</h5>--%>
<%--                <p class="card-text">${tour.price}</p>--%>
<%--                <a href="#" class="btn btn-primary">Go somewhere</a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>

<%--    <div class="container px-4 px-lg-5 mt-5">--%>
<%--        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">--%>
<%--            <C:forEach var="tour" items="${tours}">--%>
<%--                <div class="col mb-5">--%>
<%--                    <div class="card h-100">--%>
<%--                        <!-- Product image-->--%>
<%--                        <img class="card-img-top" src="" alt="...">--%>
<%--                        <!-- Product details-->--%>
<%--                        <div class="card-body p-4">--%>
<%--                            <div class="text-center">--%>
<%--                                <!-- Product name-->--%>
<%--                                <h5 class="fw-bolder">${tour.name}</h5>--%>
<%--                                <!-- Product price-->--%>
<%--                                <h5 class="text-danger">${tour.price} VNĐ</h5>--%>
<%--                                <h6>${tour.description}</h6>--%>

<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- Product actions-->--%>
<%--                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                            <div class="text-center">--%>
<%--                                <a class="btn btn-outline-dark mt-auto" href="#">Chi tiết</a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </C:forEach>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<c:forEach var="category" items="${categories}">
    <div class="container-fluid py-3">
        <div class="d-flex">
            <h4 class="p-2">${category.name}
            </h4>
            <div id="" class="collapse">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <c:forEach var="tour" items="${toursByCate}">
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
        </div>



            <%--        <div class="content">--%>

            <%--            <div class="site-section bg-left-half mb-5">--%>
            <%--                <div class="container owl-2-style">--%>
            <%--                    <div class="owl-carousel owl-2 owl-loaded owl-drag">--%>

            <%--                        <div class="owl-stage-outer">--%>
            <%--                            <div class="owl-stage"--%>
            <%--                                 style="transform: translate3d(-2533px, 0px, 0px); transition: all 1s ease 0s; width: 3801px;">--%>
            <%--                                <div class="owl-item cloned" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="/resources/images/bg-main-page.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Consectetur Adipisicing Elit</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item cloned" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_5.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Beatae Doloribu</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item cloned" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_6.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Accusantium Eius Soluta</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_1.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Consectetur Adipisicing Elit</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_2.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Beatae Doloribu</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_3.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Accusantium Eius Soluta</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_4.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Consectetur Adipisicing Elit</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_5.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Beatae Doloribu</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item active" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_6.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Accusantium Eius Soluta</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item cloned active" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_1.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Consectetur Adipisicing Elit</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item cloned active" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_2.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Beatae Doloribu</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                                <div class="owl-item cloned" style="width: 296.667px; margin-right: 20px;">--%>
            <%--                                    <div class="">--%>
            <%--                                        <a href="#"><img src="images/img_3.jpg" alt="Image" class="img-fluid"></a>--%>
            <%--                                        <h3><a href="#">Accusantium Eius Soluta</a></h3>--%>
            <%--                                    </div>--%>
            <%--                                </div>--%>
            <%--                            </div>--%>
            <%--                        </div>--%>
            <%--                        <div class="owl-nav">--%>
            <%--                            <button type="button" role="presentation" class="owl-prev"><span--%>
            <%--                                    aria-label="Previous">‹</span></button>--%>
            <%--                            <button type="button" role="presentation" class="owl-next"><span aria-label="Next">›</span>--%>
            <%--                            </button>--%>
            <%--                        </div>--%>
            <%--                    </div>--%>

            <%--                </div>--%>
            <%--            </div>--%>

            <%--        </div>--%>
    </div>
</c:forEach>

