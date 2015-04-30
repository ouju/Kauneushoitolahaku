<%-- 
    Document   : haku
    Created on : 24.3.2015, 19:05:04
    Author     : Outi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:etupohja pageTitle ="Haku">     
    
        <ul class="nav nav-tabs">
            <li role="presentation" ><a href="index.jsp">Etusivu</a></li>
            <li role="presentation" class="middle active"><a href="haku.jsp">Haku</a></li>
            <li role="presentation" class="right"><a href="kirjautuminen.jsp">Kirjautuminen</a></li>
        </ul>
        
            <pre align = "leftF" style = "border:1px; border-top-style: solid;
                 border-bottom-style: solid; background-color: lavenderblush">
                <font size = "3">
                <h1>Haku</h1>
                Jättämällä kentät tyhjiksi ja valitsemalla Hae, näet listan kaikista sivuston yrityksistä.<br>
                <!-- Kaikki lomakkeen elementit form-tagin sisään -->
                <form action="haku" method="post">
                        <label>Hae nimellä:</label>
                        <input type="text" name="haeNimella">
                    
                        <label>Hae hintataso:</label>
                        <select name="haeHintataso">
                            <option></option>
                            <option>Edullinen</option>
                            <option>Keskitaso</option>
                            <option>Hintavampi</option>
                        </select>
                    
                        <label>Hae sijainti:</label>
                        <input type="text" name="haeSijainti">
                    
                        <label>Hae tarjontaa:</label>
                        <input type="checkbox" name="tarjonnat" value="hieronta">Hieronta
                        <input type="checkbox" name="tarjonnat" value="hiukset">Hiukset
                        <input type="checkbox" name="tarjonnat" value="kasvot">Kasvot
                        <input type="checkbox" name="tarjonnat" value="kynnet">Kynnet
                    
                    <button type="submit" class="btn btn-primary">Hae</button>
                </form>
                ${lkm}<br>
                <c:forEach var="yritys" items="${listaus}">
                    <a href="Esittely?id=${yritys.id}">${yritys.nimi}</a><br>
                </c:forEach>
                ${viesti}

                </font>
            </pre>
        
    
</t:etupohja>
<!--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kauneushoitolahaku</title>
    </head>
    <body>
        <h1>Haku</h1>
        Jättämällä kentät tyhjiksi ja valitsemalla Hae, näet listan kaikista sivuston yrityksistä.<br>
<!-- Kaikki lomakkeen elementit form-tagin sisään >
<form action="haku" method="post">
    <div class="form-group">
        <label>Hae nimellä:</label><br>
        <input type="text" name="haeNimella" class="form-control">
    </div>

    <div class="form-group">
        <label>Hae hintataso:</label><br>
        <select name="haeHintataso">
            <option></option>
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
    <a href="Esittely?id=${kirjaus.id}">${kirjaus.nimi}</a><br>
</c:forEach>
${viesti}

</body>
</html-->
