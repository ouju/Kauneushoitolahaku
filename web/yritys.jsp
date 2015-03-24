<%-- 
    Document   : yritys
    Created on : 24.3.2015, 19:04:17
    Author     : Outi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Yrityksesi</h1>
        
        <p>
            <a href="lisays.jsp" class="btn btn-success">Lisää yritys</a>
        </p>

        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Nimi</th>
                    <th>Hintaluokka</th>
                    <th>Sijainti</th>
                    <th>Osoite</th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <!-- Listataan hoitolat tähän -->
                <tr>
                    <td><a href="http://www.pyhakko.fi/">Pyhäkkö</a></td>
                    <td>Keskitaso</td>
                    <td>Helsinki</td>
                    <td>Mannerkuja 13</td>
                    <th><a class="btn btn-default btn-sm" href="muokkaus.jsp">Muokkaa</a></th>
                </tr>
            </tbody>
        </table>
    </body>
</html>
