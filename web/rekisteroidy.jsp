<%-- 
    Document   : rekisteroidy
    Created on : 21.4.2015, 0:11:23
    Author     : Outi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" rel="stylesheet">
        <!--link href="css/bootstrap-theme.css" rel="stylesheet"-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rekisteröityminen</title>
    </head>
    <body>
            <form class="form-horizontal" action = "Rekisteroityminen" align = "center" style = "margin-top: 3%">
            <fieldset>
            <legend>Rekisteröidy</legend>

            <!-- Uuden käyttäjän käyttäjätunnus-->
            <div class="control-group">
              <p>${tunnusEiKaytossa}</p>
              <label class="control-label" for="tunnus">Käyttäjätunnus</label>
              <div class="controls">
                <input id="textinput" name="tunnus" maxlength="20" type="text" placeholder="" class="input-xlarge">
              </div>
            </div>

            <!-- Salasana-->
            <div class="control-group">
                <p>${salasanatTasmaa}</p>
              <label class="control-label" for="salasana">Salasana</label>
              <div class="controls">
                <input id="Salasana" name="salasana" maxlength="20" type="password" placeholder="" class="input-xlarge">
              </div>
            </div>

            <!-- Salasanan varmistus-->
            <div class="control-group">
              <label class="control-label" for="salasanaUudestaan">Salasana uudestaan</label>
              <div class="controls">
                <input id="Salasana uudestaan" name="salasanaUudestaan" maxlength="20" type="password" placeholder="" class="input-xlarge">
              </div>
            </div>

            <!-- rekisteroityminen -->
            <div class="control-group">
              <label class="control-label" for="Rekisteröidy"></label>
              <div class="controls">
                <button id="Rekisteröidy" name="Rekisteröidy" class="btn btn-success">Rekisteröidy</button>
              </div>
            </div>
            ${virheet}
            </fieldset>
            </form>
    </body>
</html>
