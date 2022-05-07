
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
        <h1 class="mt-4">Dashboard ${message}</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item active">Dashboard</li>
        </ol>

        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                Bảng Nhân Viên
            </div>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a href="<c:url value="/admin/employee/form"/>" title="Tạo Hồ Sơ Mới" class="nav-link">Tạo</a>
                </li>
            </ul>
            <div class="card-body">
                <table id="datatablesSimple">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Tài khoản</th>
                        <th>Mật khẩu</th>
                        <th>Email</th>
                        <th>Số điện thoại</th>
                        <th>Số CMND</th>
                        <th>Họ và tên</th>
                        <th>Giới tính</th>
                        <th>Ngày sinh</th>
                        <th>Ảnh</th>
                        <th>Ngày tạo</th>
                        <th>Ngày chỉnh sửa</th>
                    </tr>
                    </thead>
                    <tfoot>

                    <tbody>
                    <c:forEach var="employeeItem" items="${employees}">
                        <tr>
                            <td>
                                <a class="btn btn-default"
                                   href="${pageContext.request.contextPath}/admin/employee/edit/${employeeItem.id}">
                                    <span class="fa fa-pencil glyphicon glyphicon-pencil"></span>
                                </a>
                                <a class="btn btn-default"
                                   onclick="return confirm('Bạn có chắc bạn muốn xóa hồ sơ này không?');"
                                   href="${pageContext.request.contextPath}/admin/employee/delete/${employeeItem.id}">
                                    <span class="fa fa-trash glyphicon glyphicon-trash"></span>
                                </a>
                            </td>
                            <td>${employeeItem.username}</td>
                            <td style="max-width: 10rem; overflow: scroll">${employeeItem.password}</td>
                            <td>${employeeItem.email}</td>
                            <td>${employeeItem.userInfoId.phone}</td>
                            <td>${employeeItem.userInfoId.citizenship}</td>
                            <td>${employeeItem.firstName.concat(" ").concat(employeeItem.lastName)}</td>
                            <td>${employeeItem.userInfoId.gender}</td>
                            <td>${employeeItem.userInfoId.dayOfBirth}</td>
                            <td style="max-width: 10rem; overflow: scroll">${employeeItem.avatar}</td>
                            <td>${employeeItem.createdDate}</td>
                            <td>${employeeItem.updatedDate}</td>
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
