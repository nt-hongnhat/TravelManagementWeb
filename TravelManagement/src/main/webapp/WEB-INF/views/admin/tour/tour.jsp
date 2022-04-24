
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/21/2022
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Dashboard</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item active">Dashboard</li>
        </ol>

        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                    Bảng Tour Du Lịch
            </div>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a href="<c:url value="/admin/tour/new"/>" title="Tạo Hồ Sơ Mới" class="nav-link">Tạo</a>
                </li>
            </ul>
            <div class="card-body">
                <table id="datatablesSimple">
                    <thead>
                    <tr>
                        <th>Tên</th>
                        <th>Giá</th>
                        <th>Mô tả</th>
                        <th>Mã chuyến</th>
                        <th>Mã thời điểm</th>
                        <th>Mã thể loại</th>
                    </tr>
                    </thead>
                    <tfoot>

                    <tbody>
                    <c:forEach var="tour" items="${tours}">
                        <tr>
                            <td>${tour.name}</td>
                            <td>${tour.price}</td>
                            <td>${tour.description}</td>
                            <td>${tour.tripId}</td>
                            <td>${tour.durationId}</td>
                            <td>${tour.category}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>
