<%-- 
    Document   : esittely
    Created on : 24.3.2015, 18:56:42
    Author     : Outi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kauneushoitolahaku</title>
    </head>
    <body>
        <form action="Esittely" method="POST">
            <c:forEach var="yritys" items="${yritys}">
                <td>${sijainti}</td>
            </c:forEach>

            <h1>${nimi}</h1>
            <!-- Painikkeet tähän -->
            <p>
                <a href="http://www.kuvitteleyrityksennettisivuttahan.fi/" class="btn btn-default">Kotisivuille</a>
            </p>
            <!-- Tiedot tulee listana tähän -->
            <ul>

                <li><strong>Hintataso:</strong> ${hintataso}</li>

                <li><strong>Sijainti:</strong> ${sijainti}</li>
                <li><strong>Osoite:</strong> ${osoite}</li>
                <li><strong>Tarjonta:</strong> tarjontaaa</li>

            </ul>
            <!-- Kuvaus tulee tähän -->
            <p>
                ${kuvaus}
            </p>
        </form>
    </body>
</html>
