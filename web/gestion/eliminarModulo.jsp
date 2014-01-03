<%-- 
    Document   : eliminarModulo
    Created on : 30/11/2013, 11:39:25 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Módulo</title>
    </head>
    <body>
        <h1>Eliminación del Módulo</h1>
        <% int idModulo=Integer.parseInt(request.getParameter("modulo")); %>         
        <jsp:useBean id="modulo" scope="page" class="DTO.ModuloDTO" />
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
        <%=gestion.eliminarModulo(idModulo)%>
    </body>
</html>
