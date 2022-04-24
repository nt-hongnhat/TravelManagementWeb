<%-- 
    Document   : footer
    Created on : Mar 31, 2022, 11:12:25 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="action"/>
<div class="container py-3" id="contact">
    <div class="text-center">
        <h2 class="section-heading text-uppercase text-muted">Liên hệ với chúng tôi</h2>
        <%--            <h3 class="section-subheading text-muted">Lorem ipsum dolor sit amet consectetur.</h3>--%>
    </div>
    <div class="container contact-form">
        <form method="post" action="${action}">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <input type="text" name="txtName" class="form-control" placeholder="Tên của bạn *"
                               value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="txtEmail" class="form-control" placeholder="Email của bạn *"
                               value="" required/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="txtPhone" class="form-control" placeholder="Số điện thoại *"
                               value="" required/>
                    </div>

                </div>
                <div class="col-md-6">
                    <div class="form-group">
                            <textarea name="txtMsg" class="form-control" placeholder="Nội dung *"
                                      style="width: 100%; height: 150px;" required></textarea>
                    </div>
                </div>
            </div>
            <div class="form-group text-center">
                <input type="submit" name="btnSubmit" class="btnContact btn-primary float-md-center px-3 py-2"
                       value="Gửi tin nhắn"/>
            </div>
        </form>
    </div>
</div>
<footer class="container-fluid bg-dark py-4">
    <div class="container">
        <div class="d-flex align-items-center justify-content-between small">
            <div class="text-muted">Copyright © Travel More Website 2022</div>
            <div>
                <a href="#">Privacy Policy</a>
                ·
                <a href="#">Terms &amp; Conditions</a>
            </div>
        </div>
    </div>
</footer>
