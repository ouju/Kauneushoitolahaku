<%-- 
    Document   : omatTiedot
    Created on : 2.5.2015, 22:00:14
    Author     : Outi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Omat tietoni</title>
    </head>
    <body>
        <form class="form-horizontal" action = "TunnustenMuokkaus" align = "center" style = "margin-top: 3%">
            <fieldset>
                <a style ="margin-left: 84%;" href="TunnustenPoisto" class="btn btn-danger">Poista tunnukset</a>

                <legend>Käyttäjän ${tunnus} tiedot</legend>

                <div class="control-group">
                    <label class="control-label" for="tunnus">Käyttäjätunnus</label>
                    <div class="controls">
                        <input id="textinput" name="tunnus" maxlength="20" type="text" value="${tunnus}" class="input-xlarge">
                    </div>
                </div>

                <!-- Salasana-->
                <div class="control-group">
                    <label class="control-label" for="salasana">Salasana</label>
                    <div class="controls">
                        <input id="Salasana" name="salasana" maxlength="20" type="password" placeholder="" class="input-xlarge">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="Tallenna"></label>
                    <div class="controls">
                        <button id="Tallenna" name="Tallenna" class="btn btn-success">Tallenna</button>
                    </div>
                </div>
                ${virheet}
            </fieldset>
        </form>
    </body>
</html>