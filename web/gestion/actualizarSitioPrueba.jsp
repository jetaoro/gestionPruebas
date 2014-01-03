<%-- 
    Document   : actualizarSitioPrueba
    Created on : 28/11/2013, 06:17:27 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Actualizar Sitio de Prueba</title>
    </head>
    <body>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="sitio" scope="page" class="DTO.SitioPruebaDTO" />
        <jsp:setProperty name="sitio" property="*" />        
        <%=gestion.modificarSitioPrueba(sitio)%>
    </body>
</html>
