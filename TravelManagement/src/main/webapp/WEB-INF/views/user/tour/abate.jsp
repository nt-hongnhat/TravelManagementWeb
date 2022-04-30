<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/29/2022
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="row" style="margin-top: 3rem">
        <div class="col-md-5">
            <img class="card-img-" left src="..." alt="Card image cap">
        </div>
        <div class="col-md-7">
            <div class="card" >
                <div class="card-header">
                    ${tour.name}
                </div>
                <div class="card-body">
                    <div class="row ">
                        <div class="col-md-4 font-weight-light">Mã tour</div>
                        <div class="col-md-8">${tour.id}</div>
                    </div>
                    <div class="row" style="margin-top: .5rem">
                        <div class="col-md-4 font-weight-light">Thời gian</div>
                        <div class="col-md-8">${tour.duration}</div>
                    </div>
                    <div class="row" style="margin-top: .5rem">
                        <div class="col-md-4 font-weight-light">Giá</div>
                        <div class="col-md-8">${tour.price}</div>
                    </div>
                    <div class="row" style="margin-top: .5rem">
                        <div class="col-md-4 font-weight-light">Ngày khởi hành</div>
                        <div class="col-md-8"><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${minDate}" /></div>
                    </div>
                    <div class="row" style="margin-top: .5rem">
                        <div class="col-md-4 font-weight-light">Nơi khởi hành</div>
                        <div class="col-md-8">${tour.trip}</div>
                    </div>
                    <div class="row" style="margin-top: .5rem">
                        <div class="col-md-4 font-weight-light">Số chỗ còn nhận</div>
                        <div class="col-md-8"></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card border-danger mb-3" style="margin-top: 1rem">
            <div class="card-body text-danger">
                <p class="card-text">Các khoản phí phát sinh (nếu có) như: phụ thu dành cho khách nước ngoài, việt kiều; phụ thu phòng đơn; phụ thu chênh lệch giá tour… Nhân viên Du Lịch Việt sẽ gọi điện thoại tư vấn cho quý khách ngay sau khi có phiếu xác nhận booking. (Trong giờ hành chính)
                    <br>Trường hợp quý khách không đồng ý các khoản phát sinh, phiếu xác nhận đặt phòng của quý khách sẽ không có hiệu lực.</p>
            </div>
        </div>
        <div class="col-12">
            <hr>
            <h3 class="text-center text-uppercase">BẢNG GIÁ TOUR CHI TIẾT</h3>
            <table class="table table-bordered table-dark">
                <thead>
                <tr>
                    <th scope="col">Loại giá\Độ tuổi</th>
                    <c:forEach items="${surchanges}" var="surchange">
                        <th scope="col">${surchange.name}</th>
                    </c:forEach>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Giá</th>
                    <c:forEach items="${surchanges}" var="surchange">
                         <th scope="col">
                             <fmt:formatNumber
                                     type = "number"
                                     maxFractionDigits = "3"
                                     value = "${Math.round(surchange.percentage * tour.price / 1000) * 1000 }" /> đ
                         </th>
                    </c:forEach>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="col-12">
            <br>
            <h3 class="text-center text-uppercase">thông tin liên hệ</h3>
            <form:form method="post" action="" modelAttribute="booking">
                <div class="row mb-3">
                    <div class="col-md-4">
                        <div class="form-floating mb-3 mb-md-0">
                            <label for="inputName">Họ và tên</label>
                            <input name="booking.customerName" class="form-control" id="inputName" type="text"
                                   placeholder="Nguyễn Văn A....">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-floating mb-3">
                            <label for="email">Email</label>
                            <input name="booking.email" class="form-control" id="email" type="email"
                                   placeholder="Nhập số điện thoại...">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-floating mb-3">
                            <label for="phone">Số điện thoại</label>
                            <input name="booking.phone" class="form-control" id="phone" type="text"
                                   placeholder="Nhập số điện thoại...">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-floating mb-3">
                            <label for="address">Địa chỉ</label>
                            <input name="booking.address" class="form-control" id="address" type="text"
                                   placeholder="Nhập địa chỉ...">
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="form-floating mb-3">
                            <label for="note">Ghi chú</label>
                            <input name="booking.note" class="form-control" id="note" type="text"
                                   placeholder="Nhập ghi chú...">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="form-floating mb-3">
                            <label for="numberAdult">Người lớn</label>
                            <input name="booking.note" class="form-control" id="numberAdult" type="number"
                                   value="1">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-floating mb-3">
                            <label for="numberAgegroup02">Trẻ em(5 - 11 tuổi)</label>
                            <input name="booking.bookingDetail.numberAgegroup02" class="form-control"
                                   id="numberAgegroup02" type="number"
                                   value="0">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-floating mb-3">
                            <label for="numberAgegroup25">Trẻ nhỏ(2 - 5 tuổi)</label>
                            <input name="booking.bookingDetail.numberAgegroup25" class="form-control"
                                   id="numberAgegroup25" type="number"
                                   value="0">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="form-floating mb-3">
                            <label for="numberAgegroup511">Sơ sinh( < 2 tuổi)</label>
                            <input name="booking.bookingDetail.numberAgegroup511" class="form-control"
                                   id="numberAgegroup511" type="number"
                                   value="0">
                        </div>
                    </div>
                    <hr>

                    <p class="col-12">Tổng giá trị:</p>

                    <h3 class="col-12 text-center text-uppercase" style="margin-bottom: 1rem">Phương thức thanh toán</h3>

<%--                    Check way to abate--%>
                    <div class="form-check col-md-6">
                        <input class="form-check-input" type="radio" name="radioDefault" id="radioDefault" checked>
                        <label class="form-check-label" for="radioDefault">
                            Thanh toán tại quầy TravelMore
                        </label>
                    </div>
                    <div class="form-check col-md-6">
                        <input class="form-check-input" type="radio" name="radioMomo" id="radioMomo">
                        <label class="form-check-label" for="radioMomo">
                            Thanh toán qua ví Momo
                        </label>
                    </div>
                    <div class="form-check col-md-6">
                        <input class="form-check-input" type="radio" name="radioBanking" id="radioBanking" checked>
                        <label class="form-check-label" for="radioBanking">
                            Thanh toán chuyển khoản qua ngân hàng
                        </label>
                    </div>
                    <div class="form-check col-md-6">
                        <input class="form-check-input" type="radio" name="radioVnpay" id="radioVnpay">
                        <label class="form-check-label" for="radioVnpay">
                            Thanh toán qua VNPAY
                        </label>
                    </div>
                    <div class="col-12 ">
                        <div class="form-group" >
                            <input class="btn btn-primary btn-block text-uppercase "
                                   type="submit" value="hoàn thành"
                                   style="max-width: 10rem; margin: auto; margin-top: 2rem">
                        </div>
                    </div>
                </div>



            </form:form>

        </div>
    </div>
</div>

