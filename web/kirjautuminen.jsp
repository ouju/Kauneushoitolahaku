<%-- 
    Document   : kirjautuminen
    Created on : 24.3.2015, 15:23:58
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
        <h1>Kirjaudu sisään</h1>

        <form action="kirjautuminen" method="post">
            Käyttäjänimi: <input type="text" name="tunnus" value="${kayttaja}" />
            Salasana: <input type="password" name="salasana" />
            <button type="submit">Kirjaudu</button>
            
        </form>
        ${virheViesti}
    </body>
</html>
