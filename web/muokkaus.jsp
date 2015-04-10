<%-- 
    Document   : muokkaus
    Created on : 24.3.2015, 18:59:20
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
        <h1>Muokkaa yrityksen tietoja</h1>

        <form action="tallennaMuokkaus" method="POST">
            <div class="form-group">
                <label>Nimi</label>
                <input type="text" name="nimi" class="form-control" value="${yritys.nimi}">
            </div>
            <div class="form-group">
                <label>Hintataso</label>
                <select name="hintataso" value="${yritye.hintataso}">
                    <option>Edullinen</option>
                    <option>Keskitaso</option>
                    <option>Hintavampi</option>
                </select>
            </div>
            <div class="form-group">
                <label>Sijainti</label>
                <input type="text" name="sijainti" class="form-control" value="${yritys.sijainti}">
            </div>
            <div class="form-group">
                <label>Osoite</label>
                <input type="text" name="osoite" class="form-control" value="${yritys.osoite}">
            </div>
            <div class="form-group">
                <label>Kuvaus</label>
                <textarea class="form-control" type="text" name="kuvaus" value="${yritys.kuvaus}">
                </textarea>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Tallenna</button>
            </div>
        </form>
    </body>
</html>
