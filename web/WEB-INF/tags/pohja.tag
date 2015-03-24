<%-- 
    Document   : pohja
    Created on : 23.3.2015, 21:25:28
    Author     : Outi
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>

<link href="css/main.css" rel="stylesheet">

<c:if test="${virheViesti != null}">
    <div class="alert alert-danger">Virhe! ${virheViesti}</div>
</c:if>