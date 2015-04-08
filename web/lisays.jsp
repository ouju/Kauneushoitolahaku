<%-- 
    Document   : lisays
    Created on : 24.3.2015, 19:03:51
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
        <h1>Lisää yritys</h1>

        <form>
            <div class="form-group" name="nimi" placeholder="Yrityksen nimi" value="${yritys.nimi}">
                <label>Nimi</label>
                <input type="text" class="form-control">
                <c:out value="${kissa.nimi}"/>
            </div>
            <div class="form-group">
                <label>Hintaluokka</label>
                <select name="hintataso">
                    <option>Edullinen</option>
                    <option>Keskitaso</option>
                    <option>Hintavampi</option>
                </select>
            </div>
            <div class="form-group">
                <label>Sijainti</label>
                <input type="text" class="form-control">
            </div>
            <div class="form-group">
                <label>Osoite</label>
                <input type="text" class="form-control">
            </div>
            <div class="form-group">
                <label>Kotisivut</label>
                <input type="text" class="form-control">
            </div>
            <div class="form-group">
                <label>Kuvaus</label>
                <textarea class="form-control"></textarea>
            </div>
            <label>Tarjonta</label>
            <select name="tarjonta_id">
                <c:forEach var="tarjonta" items="${tarjonnat}">
                    <option value="${tarjonta.id}">${tarjonta.nimi}</option>
                </c:forEach>
            </select>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Tallenna</button>
            </div>
        </form>
    <c:if test="${ilmoitus != null}">
        <div class="alert alert-info">${ilmoitus}</div>
    </c:if>
</body>
</html>
