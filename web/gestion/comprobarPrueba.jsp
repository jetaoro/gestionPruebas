<%-- 
    Document   : comprobarPrueba
    Created on : 27/11/2013, 06:18:08 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba para verificar</title>
    </head>
    <body>
        <h1>Verificación</h1>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <%=gestion.getPruebas()%>
    </body>
</html>
