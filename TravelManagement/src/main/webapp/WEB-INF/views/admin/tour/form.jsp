<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/21/2022
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/tour/save" var="action"/>

<c:if test="${message != null}">
  <div class="alert alert-danger">
      ${message}
  </div>
</c:if>

<div class="container">
  <form:form cssClass="admin-form" method="post" action="${action}" modelAttribute="tour" enctype="multipart/form-data">
    <div class="form-group">
      <label for="name" class="control-label">Tên &nbsp</label>
      <form:input class="form-control" id="name" path="name" required="required"/>
    </div>

    <div class="form-group">
      <label for="price" class="control-label">Giá &nbsp</label>
      <form:input class="form-control" id="price" path="price" required="required" />
    </div>

    <div class="form-group">
      <label for="image" class="control-label">Đường dẫn hình ảnh &nbsp</label>
      <form:input class="form-control" id="image" path="image"/>
    </div>

    <div class="form-group">
      <label for="limitCustomer" class="control-label">Số khách hàng tối đa  &nbsp</label>
      <form:input class="form-control" id="limitCustomer" path="limitCustomer" required="required"/>
    </div>

    <div class="form-group">
      <label for="description" class="control-label">Mô tả &nbsp</label>
      <form:input class="form-control" id="description" path="description"/>
    </div>

    <div class="bg-light row card-body" style="border: 1px solid #999999; border-radius: 1rem">
      <label class="control-label"><h5>Hành trình &nbsp</h5></label>
      <div class="form-group col-md-6">
        <label for="departureProvince" class="control-label">Bắt đầu từ</label>
        <form:select class="form-control" id="departureProvince" path="departureProvince.id">
          <c:forEach items="${provinces}" var="province">
            <form:option value="${province.id}" label="${province.name}"/>
          </c:forEach>
        </form:select>
      </div>
      <div class="form-group col-md-6">
        <label for="destinationProvince" class="control-label">Kết thúc</label>
        <form:select class="form-control" id="destinationProvince" path="destinationProvince.id">
          <c:forEach items="${provinces}" var="province">
            <form:option value="${province.id}" label="${province.name}"/>
          </c:forEach>
        </form:select>
      </div>
    </div>

    <div class="form-group">
      <label for="duration" class="control-label">Thời điểm &nbsp</label>
      <form:select class="form-control" id="duration" path="duration.id">
        <c:forEach items="${durations}" var="duration">
          <form:option value="${duration.id}" label="${duration}"/>
        </c:forEach>
      </form:select>
    </div>

    <div class="form-group">
      <label for="category" class="control-label">Thể loại &nbsp</label>
      <form:select class="form-control" id="category" path="category.id">
        <c:forEach items="${categories}" var="category">
          <form:option value="${category.id}" label="${category.name}"/>
        </c:forEach>
      </form:select>
    </div>

    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="${valueButton}">
    </div>
  </form:form>
</div>

