<%-- 
    Document   : kirjautuminen
    Created on : 24.3.2015, 15:23:58
    Author     : Outi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<t:etupohja pageTitle ="Kirjautuminen">     
    <div class = "keskiosa">
        <ul class="nav nav-tabs">
            <li role="presentation" ><a href="index.jsp">Etusivu</a></li>
            <li role="presentation" class="middle"><a href="haku.jsp">Haku</a></li>
            <li role="presentation" class="right active"><a href="kirjautuminen.jsp">Kirjautuminen</a></li>
        </ul>

        <div>
            <pre align = "leftF" style = "border:1px; border-top-style: solid;
                 border-bottom-style: solid; background-color: lavenderblush">

                <font size = "3">
                <h1>Kirjaudu sisään</h1>
                ${rekisteroity}
                <form action="kirjautuminen" method="post">
                    Käyttäjätunnus: <input type="text" name="tunnus" value="${kayttaja}" />
                    Salasana: <input type="password" name="salasana" /><br>
                    <button type="submit" class="btn-primary">Kirjaudu</button>
                    ${virheViesti}
                </form>

                <p>
                    <a href="rekisteroidy.jsp">Uusi käyttäjä? Rekisteröidy!</a>
                </p>
                </font>
            </pre>
        </div>
    </div>
</t:etupohja>