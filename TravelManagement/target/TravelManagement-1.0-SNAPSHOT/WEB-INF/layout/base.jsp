<%-- 
    Document   : base
    Created on : Mar 31, 2022, 8:56:58 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title"/></title>
    </head>
    <body>
        <!-- HEADER -->
        <tiles:insertAttribute name="header"/>
        
        <!-- CONTENT -->
        <tiles:insertAttribute name="content"/>
        
        <!-- FOOTER -->
        <tiles:insertAttribute name="footer"/>
    </body>
</html>
