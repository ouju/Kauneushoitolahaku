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
        <title>Kauneushoitolahaku</title>
    </head>
    <body>
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
                    <th>Kuvaus</th>
                    <th>Tarjonta</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <!-- Listataan hoitolat tähän -->

                <c:forEach var="yritys" items="${y}">

                    <tr>

                        <td>
                            <form action="Esittely" method="post">
                                <input type="hidden" value="${yritys.nimi}" name="nimi"></input>
                                <input value="${yritys.nimi}" name="${yritys.nimi}" type="submit"></input>
                            </form>
                                <!--a href="esittely.jsp">${yritys.nimi}</a-->
                        </td>
                        <td>${yritys.hintataso}</td>
                        <td>${yritys.sijainti}</td>
                        <td>${yritys.osoite}</td>
                        <td>${yritys.kuvaus}</td>
                        <td>Tarjontaa</td>
                        <td>
                            <form action="muokkaus" method="post">
                                <input type="hidden" value="${yritys.nimi}" name="nimi"></input>
                                <input type="hidden" value="${yritys.hintataso}" name="hintataso"></input>
                                <input type="hidden" value="${yritys.sijainti}" name="sijainti"></input>
                                <input type="hidden" value="${yritys.osoite}" name="osoite"></input>
                                <input type="hidden" value="${yritys.kuvaus}" name="kuvaus"></input>
                                <input value="Muokkaa" name="Muokkaa" type="submit"></input>
                            </form>
                        </td>
                        <td>
                            <form action="poisto" method="post">
                                <input type="hidden" value="${yritys.nimi}" name="nimi"></input>
                                <input value="Poista" name="Poista" type="submit"></input>
                            </form>
                        </td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </body>
</html>
