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

            <h1>${yritys.nimi}</h1>
            <!-- Painikkeet tähän -->
            <p>
                <a href="http://www.kuvitteleyrityksenkotisivuttahan.fi/" class="btn btn-default">Kotisivuille</a>
            </p>
            <!-- Tiedot tulee listana tähän -->
            <ul>

                <li><strong>Hintataso:</strong> ${yritys.hintataso}</li>

                <li><strong>Sijainti:</strong> ${yritys.sijainti}</li>
                <li><strong>Osoite:</strong> ${yritys.osoite}</li>
                <li>
                    <strong>Tarjonta:</strong> ${tarjonnat}
                    <!--ul>
                        <c:forEach var="tarjonta" items="${tarjonnat}">
                            <li>${tarjonta.nimi}</li>
                        </c:foreach>
                    </ul-->

                </li>
            </ul>
            <!-- Kuvaus tulee tähän -->
            <p>
                ${yritys.kuvaus}
            </p>
        </form>
    </body>
</html>
