
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/21/2022
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <a href="<c:url value="/admin/tour/form"/>" title="Tạo Hồ Sơ Mới" class="nav-link">Tạo</a>
                </li>
            </ul>
            <div class="card-body">
                <table id="datatablesSimple">
                    <thead>
                    <tr>
                        <th></th>
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
                    <c:forEach var="tourItem" items="${tours}">
                        <tr>
                            <td>
                                <a class="btn btn-default"
                                   href="${pageContext.request.contextPath}/admin/tour/edit/${tourItem.id}">
                                    <span class="fa fa-pencil glyphicon glyphicon-pencil"></span>
                                </a>
                                <a class="btn btn-default"
                                   onclick="return confirm('Bạn có chắc bạn muốn xóa hồ sơ này không?');"
                                   href="${pageContext.request.contextPath}/admin/tour/delete/${tourItem.id}">
                                    <span class="fa fa-trash glyphicon glyphicon-trash"></span>
                                </a>
                            </td>
                            <td>${tourItem.name}</td>
                            <td>${tourItem.price}</td>
                            <td>${tourItem.description}</td>
                            <td>${tourItem.tripId}</td>
                            <td>${tourItem.durationId}</td>
                            <td>${tourItem.category}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                        <ul class="pagination">
                            <c:forEach begin="1" end="${Math.ceil(numberOfTourPaginationItem)}" var="i">
                                <li class="page-item"><a class="page-link" href="<c:url value="/" />?page=${i}">${i}</a></li>
                            </c:forEach>
                        </ul>
                    </tfoot>
                </table>

            </div>
        </div>
    </div>
</main>
