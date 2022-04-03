<%-- 
    Document   : index
    Created on : Mar 28, 2022, 2:58:57 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <c:forEach var="tour" items="${tours}">
        <div class="card" style="width: 18rem;">
            <img class="card-img-top" src="" alt="Card image cap">
            <div class="card-body">
              <h5 class="card-title">${tour.name}</h5>
              <p class="card-text">${tour.price}</p>
              <a href="#" class="btn btn-primary">Go somewhere</a>
            </div>
          </div>
    </c:forEach>
</div>
