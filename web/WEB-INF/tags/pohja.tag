<%-- 
    Document   : pohja
    Created on : 23.3.2015, 21:25:28
    Author     : Outi
--%>

<%@tag description="Generic template for Kauneushoitolahaku pages" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="pageTitle"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>

<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">

<c:if test="${virheViesti != null}">
    <div class="alert alert-danger">Virhe! ${virheViesti}</div>
</c:if>



<!DOCTYPE html>
<html>
    <head>
        <title>${pageTitle}</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="navbar navbar-default">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="Lista">Lista</a></li>
                    <li><a href="Logout">Kirjaudu ulos</a></li>
                </ul>
            </div>
        </div>

        <div class="container">
            <c:if test="${pageError != null}">
                <div class="alert alert-danger">${pageError}</div>
            </c:if>
            <jsp:doBody/>
        </div>
    </body>
</html>