<%-- 
    Document   : haku
    Created on : 24.3.2015, 19:05:04
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
        <h1>Haku</h1>
        Jättämällä kentät tyhjiksi ja valitsemalla Hae, näet listan kaikista sivuston yrityksistä.
        <!-- Kaikki lomakkeen elementit form-tagin sisään -->
        <form action="haku" method="post">
            <div class="form-group">
                <label>Hae nimellä:</label>
                <input type="text" name="haeNimella" class="form-control">
            </div>

            <div class="form-group">
                <label>Hae hintaluokka:</label>
                <input type="text" class="form-control">
            </div>
            
            <div class="form-group">
                <label>Hae sijainti:</label>
                <input type="text" class="form-control">
            </div>

            <button type="submit" class="btn btn-primary">Hae</button>
            
        </form>
        ${lkm}<br>
        <c:forEach var="kirjaus" items="${listaus}">
            ${kirjaus.nimi}<br>
        </c:forEach>
        ${viesti}
        
    </body>
</html>
