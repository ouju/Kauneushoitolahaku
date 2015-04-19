<%-- 
    Document   : yritys
    Created on : 24.3.2015, 19:04:17
    Author     : Outi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %-->
<!DOCTYPE html>
<!--t:yrityspohja pageTitle="Kauneushoitolahaku"-->
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Kauneushoitolahaku</title>
        </head>
        <body>
            <a style ="margin-left: 84%;" href="Uloskirjautuminen" class="btn btn-primary">Kirjaudu ulos</a>
            
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
                    <th>Tarjonta</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <!-- Listataan hoitolat tähän -->

            <c:forEach var="yritys" items="${yritys}">

                <tr>

                    <td>
                        <a href="Esittely?id=${yritys.id}">${yritys.nimi}</a>
                            <!--a href="esittely.jsp">${yritys.nimi}</a-->
                    </td>
                    <td>${yritys.hintataso}</td>
                    <td>${yritys.sijainti}</td>
                    <td>${yritys.osoite}</td>
                    <td>Tarjontaaaaaa tähän</td>
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
