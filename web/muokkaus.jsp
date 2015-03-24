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

        <form>
            <div class="form-group">
                <label>Nimi</label>
                <input type="text" class="form-control" value="Pyhäkkö">
            </div>
            <div class="form-group">
                <label>Hintaluokka</label>
                <input type="text" class="form-control" value="Keskitaso">
            </div>
            <div class="form-group">
                <label>Sijainti</label>
                <input type="text" class="form-control" value="Helsinki">
            </div>
            <div class="form-group">
                <label>Osoite</label>
                <input type="text" class="form-control" value="Mannerkuja 13">
            </div>
            <div class="form-group">
                <label>Kuvaus</label>
                <textarea class="form-control">Tule Pyhäkköön osaaviin, ammattitaitoisiin käsiin, me pidämme sinusta huolen!.
                </textarea>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Tallenna</button>
            </div>
        </form>
    </body>
</html>
