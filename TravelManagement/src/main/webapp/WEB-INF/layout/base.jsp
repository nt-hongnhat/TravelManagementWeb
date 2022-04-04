<%-- 
    Document   : base
    Created on : Mar 31, 2022, 8:56:58 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title"/></title>
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
          integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
        <link rel="stylesheet" href="<c:url value='resources/css/style.css'/>"/>
    </head>
    <body>
        <div class="container-fluid main-page">
            <!-- HEADER -->
            <tiles:insertAttribute name="header"/>
        </div>
        <!-- CONTENT -->
        <tiles:insertAttribute name="content"/>
        
        <!-- FOOTER -->
        <tiles:insertAttribute name="footer"/>
    </body>

    <!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</html>
