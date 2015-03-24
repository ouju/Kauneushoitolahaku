<%-- 
    Document   : haku
    Created on : 24.3.2015, 19:05:04
    Author     : Outi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Haku</h1>

        <!-- Kaikki lomakkeen elementit form-tagin sisään -->
        <form>
            <div class="form-group">
                <label>Hae nimellä:</label>
                <input type="text" class="form-control">
            </div>

            <div class="form-group">
                <label>Hae hintaluokka:</label>
                <input type="text" class="form-control">
            </div>
            
            <div class="form-group">
                <label>Hae sijainti:</label>
                <input type="text" class="form-control">
            </div>

            <button type="submit" class="btn btn-primary">Hae</button>
        </form>
    </body>
</html>
