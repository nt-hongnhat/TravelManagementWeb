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

<c:url value="/admin/news/save" var="action"/>

<c:if test="${message != null}">
    <div class="alert alert-danger">
            ${message}
    </div>
</c:if>

<div class="container">
    <form:form cssClass="admin-form" method="post" action="${action}" modelAttribute="pieceOfNews" >
        <div class="form-group">
            <label for="title" class="control-label">Tiêu đề &nbsp</label>
            <form:input class="form-control" id="title" path="title"/>
        </div>

        <div class="form-group">
            <label for="content" class="control-label">Nội dung &nbsp</label>
            <form:input class="form-control" id="content" path="content"/>
        </div>

        <div class="form-group">
            <label for="userid" class="control-label">Người đăng &nbsp</label>
            <form:input class="form-control" id="userid" path="userId"/>
        </div>


        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="${valueButton}">
        </div>
    </form:form>
</div>

