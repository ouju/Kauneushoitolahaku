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
                <label>Hae nimellä:</label><br>
                <input type="text" name="haeNimella" class="form-control">
            </div>

            <div class="form-group">
                <label>Hae hintataso:</label><br>
                <select name="hintataso">
                    <option>Edullinen</option>
                    <option>Keskitaso</option>
                    <option>Hintavampi</option>
                </select>
            </div>

            <div class="form-group">
                <label>Hae sijainti:</label><br>
                <input type="text" name="haeSijainti" class="form-control">
            </div>
            <div class="form-group">
                <label>Hae tarjontaa:</label>
                <br>
                <input type="checkbox" name="tarjonnat" value="hieronta">Hieronta
                <br>
                <input type="checkbox" name="tarjonnat" value="hiukset">Hiukset
                <br>
                <input type="checkbox" name="tarjonnat" value="kasvot">Kasvot
                <br>
                <input type="checkbox" name="tarjonnat" value="kynnet">Kynnet
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
