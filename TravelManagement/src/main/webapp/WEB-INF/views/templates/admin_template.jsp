
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/20/2022
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title><tiles:insertAttribute name="title"/></title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="<c:url value="/resources/css/admin/styles.css"/>" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<%--NAVIGATION--%>
<tiles:insertAttribute name="navbar"/>

<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <%--SIDENAV--%>
        <tiles:insertAttribute name="sidenav"/>
    </div>
    <div id="layoutSidenav_content">
        <%--CONTENT--%>
        <tiles:insertAttribute name="content"/>
        <%--FOOTER--%>
        <tiles:insertAttribute name="footer"/>
    </div>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="<c:url value="/resources/js/admin/scripts.js"/>"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="<c:url value="/resources/js/admin/datatables-simple-demo.js"/>"></script>
</body>
</html>

