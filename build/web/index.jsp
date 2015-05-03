<%-- 
    Document   : index
    Created on : 14.3.2015, 22:57:15
    Author     : Outi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<t:etupohja pageTitle ="Etusivu">     
    <div class = "keskiosa">
        <ul class="nav nav-tabs">
            <li role="presentation" class="active" style="outline-color: lavenderblush"><a href="index.jsp">Etusivu</a></li>
            <li role="presentation" class="middle"><a href="haku.jsp">Haku</a></li>
            <li role="presentation" class="right"><a href="kirjautuminen.jsp">Kirjautuminen</a></li>
        </ul>

        <div>
            <pre align = "leftF" style = "border:1px; border-top-style: solid;
                 border-bottom-style: solid; background-color: lavenderblush">

                <font size = "3">
                <h1>Tervetuloa kauneushoitoloiden hakusivustolle!</h1>
                Hakusivusto auttaa sinua löytämään juuri tarvitsemasi kauneushoitolan.<br>
                Voit hakea nimen, hintatason, sijainnin tai tarjonnan perusteella mieleisesi.
                <br>
                Kirjautumalla sisään pääset lisäämään yrityksesi sivustolle, <br>
                sekä muokkaamaan yritystesi tietoja.
                </font>
            </pre>
        </div>
    </div>
</t:etupohja>