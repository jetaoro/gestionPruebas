<%-- 
    Document   : listaSitioPrueba
    Created on : 27/11/2013, 05:36:28 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Sitios de Prueba</title>
    </head>
    <body>
        <h1>Sitios de Prueba</h1>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <%=gestion.getSitiosPrueba()%>
    </body>
</html>
