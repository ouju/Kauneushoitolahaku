<%-- 
    Document   : esittely
    Created on : 24.3.2015, 18:56:42
    Author     : Outi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kauneushoitolahaku</title>
    </head>
    <body>
        <form action="Esittely" method="POST">

            <h1><c:out value="${yritys.nimi}"/></h1>
            <!-- Painikkeet tähän -->
            <p>
                <a href="${yritys.kotisivut}" class="btn btn-default">Kotisivuille</a>
            </p>
            <!-- Tiedot tulee listana tähän -->
            <ul>

                <li><strong>Hintataso:</strong> <c:out value="${yritys.hintataso}"/></li>

                <li><strong>Sijainti:</strong> <c:out value="${yritys.sijainti}"/></li>
                <li><strong>Osoite:</strong> <c:out value="${yritys.osoite}"/></li>
                <li>
                    <strong>Tarjonta:</strong>
                    <ul>
                        <c:forEach var="tarjonta" items="${tarjonnat}">
                            <li>${tarjonta}</li>
                        </c:forEach>
                    </ul>

                </li>
            </ul>
            <!-- Kuvaus tulee tähän -->
            <p>
                <c:out value="${yritys.kuvaus}"/>
            </p>
        </form>
    </body>
</html>
