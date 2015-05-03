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
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kauneushoitolahaku</title>
    </head>
    <body>
        <a style ="margin-left: 84%;" href="Uloskirjautuminen" class="btn btn-primary">Kirjaudu ulos</a>
        <a style ="margin-left: 84%;" href="omatTiedot.jsp" class="btn btn-primary">Omat tietoni</a>

        <h1>Tunnuksella ${tunnus} hallitsemasi yritykset:</h1>
        <c:if test="${ilmoitus != null}">
            <div class="alert alert-info">${ilmoitus}</div>
        </c:if>
        <p>
            <a href="lisays.jsp" class="btn btn-success">Lisää yritys</a>
        </p>

        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Nimi</th>
                    <th>Hintataso</th>
                    <th>Sijainti</th>
                    <th>Osoite</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <!-- Listataan hoitolat tähän -->

                <c:forEach var="yritys" items="${yritykset}">

                    <tr>

                        <td>
                            <a href="Esittely?id=${yritys.id}"><c:out value="${yritys.nimi}"/></a>
                        </td>
                        <td>${yritys.hintataso}</td>
                        <td><c:out value="${yritys.sijainti}"/></td>
                        <td><c:out value="${yritys.osoite}"/></td>
                        <td>
                            <form action="muokkaus" method="post">
                                <input type="hidden" value="${yritys.id}" name="id"></input>
                                <input type="hidden" value="${yritys.nimi}" name="nimi"></input>
                                <input type="hidden" value="${yritys.hintataso}" name="hintataso"></input>
                                <input type="hidden" value="${yritys.sijainti}" name="sijainti"></input>
                                <input type="hidden" value="${yritys.osoite}" name="osoite"></input>
                                <input type="hidden" value="${yritys.kotisivut}" name="kotisivut"></input>
                                <input type="hidden" value="${yritys.kuvaus}" name="kuvaus"></input>

                                <input value="Muokkaa" name="Muokkaa" type="submit"></input>
                            </form>
                        </td>
                        <td>
                            <form action="poisto" method="post">
                                <input type="hidden" value="${yritys.id}" name="id"></input>
                                <input class="btn-danger"value="Poista" name="Poista" type="submit"></input>
                            </form>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </body>
</html>
