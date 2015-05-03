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
            <input type="checkbox" name="hieronta" value="hieronta">Hieronta
            <input type="checkbox" name="hiukset" value="hiukset">Hiukset
            <input type="checkbox" name="kasvot" value="kasvot">Kasvot
            <input type="checkbox" name="kynnet" value="kynnet">Kynnet

            <button type="submit" class="btn btn-primary">Hae</button>
        </form>
        ${lkm}<br>
        <c:forEach var="yritys" items="${listaus}">
            <a href="Esittely?id=${yritys.id}"><c:out value="${yritys.nimi}"/></a><br>
        </c:forEach>
        ${viesti}

        </font>
    </pre>


</t:etupohja>