<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/5/2022
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container mt-md-3">
    <div class="row" style="margin-top: 4rem; width: 100%; height: 100%">
        <div class="col-md-6">
            <div class="card" >
                <div class="card-body ">
                    <h3 class="card-title text-uppercase text-center">${message}</h3>
                    <h6 class="card-subtitle mb-2 text-muted text-center">
                        Cảm ơn Quý khách hàng quan tâm đến: <strong>TravelMore</strong>
                    </h6>
                    <p class="card-text text-white bg-dark text-center" style="padding: .4rem; margin-top: 2rem">
                        Đơn hàng của quý khách đang được xử lý
                    </p>
                    <div class="card-text text-white text-center bg-primary" style="padding: 1rem">
                        Mã đặt tour của Quý khách là:<br>
                        <h4 style="margin: 0; margin-top: .5rem; padding: 0">${bookingId}</h4>
                    </div>
                    <div class="card-text text-center" style="font-size: small; margin-top: 1rem">
                        Nhân viên của chúng tôi liên hệ với Quý khách trong thời gian sớm nhất,<br>
                        Nếu có thắc mắc, Quý khách vui lòng liên hệ qua số hotline <strong>1900 1234</strong> <br>
                        Xin chân thành cảm ơn quý khách
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <img src="${pageContext.request.contextPath}/img/PowerfulReasons_hero.jpg" alt="" class="card-img"
                 style="width: 100%; height: 100%; object-fit: cover">
        </div>
    </div>
</div>
