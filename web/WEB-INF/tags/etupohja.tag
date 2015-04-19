<%-- 
    Document   : etupohja
    Created on : 19.4.2015, 22:38:41
    Author     : Outi
--%>

<%@tag description="Näkymä ilman sisäänkirjautumista" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="tunnus"%>
<%@attribute name="pageTitle"%>

<%-- any content can be specified here e.g.: --%>
<!DOCTYPE html>
<html>
    <head>
        <title>${pageTitle}</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class = "päädiv">
            <!--div class="container">
                <!--div class="row">
                    <div class="col-sm-6 col-sm-offset-3">
                        <!--div id="imaginary_container">
                        </div>
                    </div>
                </div>
            </div-->
            <jsp:doBody/>
        </div>
    </body>
</html>