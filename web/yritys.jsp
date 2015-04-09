<%-- 
    Document   : yritys
    Created on : 24.3.2015, 19:04:17
    Author     : Outi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Tunnuksella ${tunnus} hallitsemasi yritykset:</h1>

        <p>
            <a href="lisays.jsp" class="btn btn-success">Lisää yritys</a>
        </p>

        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Nimi    </th>
                    <th>Tunnus    </th>
                    <th>Hintaluokka    </th>
                    <th>Sijainti    </th>
                    <th>Osoite    </th>
                    <th>    </th>
                    <th>    </th>
                </tr>
            </thead>

            <tbody>
                <!-- Listataan hoitolat tähän -->
                <c:forEach var="yritys" items="${y}">
                    <tr>
                        <td><a href="esittely.jsp">${yritys.nimi}</a></td>
                        <td>${yritys.tunnus}</td>
                        <td>${yritys.hintataso}</td>
                        <td>${yritys.sijainti}</td>
                        <td>${yritys.osoite}</td>
                        <th><a class="btn btn-default btn-sm" href="muokkaus.jsp">Muokkaa</a></th>
                        <th><a class="btn btn-default btn-sm" href="muokkaus.jsp">Poista</a></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
