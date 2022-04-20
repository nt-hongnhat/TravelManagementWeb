<%-- 
    Document   : index
    Created on : Mar 28, 2022, 2:58:57 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

<div>
    <c:forEach var="tour" items="${tours}">
        <div class="card" style="width: 18rem;">
            <img class="card-img-top" src="${pageContext.request.contextPath}/resources/images/bg-main-page.jpg" alt="Card image cap">
            <div class="card-body">
              <h5 class="card-title">${tour.name}123</h5>
              <p class="card-text">${tour.price}</p>
              <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
          </div>
    </c:forEach>
</div>
