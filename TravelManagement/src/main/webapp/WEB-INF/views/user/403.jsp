<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/20/2022
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="container-fluid">
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>${pageContext.request.userPrincipal.name} - Không có quyền truy cập</h2>
</c:if>
</section>
