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
      <form:input class="form-control" id="name" path="name"/>
    </div>

    <div class="form-group">
      <label for="price" class="control-label">Giá &nbsp</label>
      <form:input class="form-control" id="price" path="price"/>
    </div>

    <div class="form-group">
      <label for="description" class="control-label">Mô tả &nbsp</label>
      <form:input class="form-control" id="description" path="description"/>
    </div>

    <div class="form-group">
      <label for="tripid" class="control-label">Mã chuyến &nbsp</label>
      <form:input class="form-control" id="tripid" path="tripId"/>
    </div>

    <div class="form-group">
      <label for="durationid" class="control-label">Mã thời điểm &nbsp</label>
      <form:input class="form-control" id="durationid" path="durationId"/>
    </div>

    <div class="form-group">
      <label for="category" class="control-label">Thể loại &nbsp</label>
      <form:input class="form-control" id="category" path="category"/>
    </div>

    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="${valueButton}">
    </div>
  </form:form>
</div>

