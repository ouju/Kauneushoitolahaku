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
        <title>Kauneushoitolahaku</title>
    </head>
    <body>
        <h1>Muokkaa yrityksen tietoja</h1>

        <form action="tallennaMuokkaus" method="POST">
            <input type="hidden" name="id" value="${yritys.id}">
            <div class="form-group">
                <label>Nimi</label><br>
                <input type="text" name="nimi" class="form-control" value="${yritys.nimi}">
            </div>
            <div class="form-group">
                <label>Hintataso</label><br>
                <select data-selected="${yritys.hintataso}" name="hintataso" value="${yritys.hintataso}">
                    <option></option>
                    <option>Edullinen</option>
                    <option>Keskitaso</option>
                    <option>Hintavampi</option>
                </select>
            </div>
            <div class="form-group">
                <label>Sijainti</label><br>
                <input type="text" name="sijainti" class="form-control" value="${yritys.sijainti}">
            </div>
            <div class="form-group">
                <label>Osoite</label><br>
                <input type="text" name="osoite" class="form-control" value="${yritys.osoite}">
            </div>
            <div class="form-group">
                <label>Kuvaus</label><br>
                <textarea type="text" name="kuvaus" class="form-control">${yritys.kuvaus}</textarea>
            </div>
            <div class="form-group">
                <label>Tarjonta:</label>
                <br>
                <input type="checkbox" name="tarjonnat" value="hieronta">Hieronta
                <br>
                <input type="checkbox" name="tarjonnat" value="hiukset">Hiukset
                <br>
                <input type="checkbox" name="tarjonnat" value="kasvot">Kasvot
                <br>
                <input type="checkbox" name="tarjonnat" value="kynnet">Kynnet
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Tallenna</button>
            </div>
        </form>
    </body>
</html>
