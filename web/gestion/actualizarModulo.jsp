<%-- 
    Document   : actualizarModulo
    Created on : 28/11/2013, 06:17:15 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Módulo</title>
    </head>
    <body>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="modulo" scope="page" class="DTO.ModuloDTO" />
        <jsp:setProperty name="modulo" property="*" />        
        <%=gestion.modificarModulo(modulo)%>
    </body>
</html>
