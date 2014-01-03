<%-- 
    Document   : listaModulo
    Created on : 26/11/2013, 06:11:44 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Módulos</title>
    </head>
    <body>
        <h1>Listado de Módulos</h1>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <%=gestion.getModulos()%>
    </body>
</html>
