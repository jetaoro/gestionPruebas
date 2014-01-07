<%-- 
    Document   : actualizarCasoPrueba
    Created on : 7/01/2014, 11:29:15 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Caso de Prueba</title>
    </head>
    <body>
        <h1>Actualizar Caso de Prueba</h1>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="casoPrueba" scope="page" class="DTO.CasoPruebaDTO" />
        <jsp:setProperty name="casoPrueba" property="*" />
        <%=gestion.modificarCasoPrueba(casoPrueba)%>
    </body>
</html>
