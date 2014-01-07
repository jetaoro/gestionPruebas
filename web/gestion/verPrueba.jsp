<%-- 
    Document   : verPrueba
    Created on : 7/01/2014, 09:31:02 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver contenido de prueba</title>
    </head>
    <body>
        <h1>Contenido de la Prueba</h1>
        <%int idPrueba = Integer.parseInt(request.getParameter("prueba")); %>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <%=gestion.getPrueba(idPrueba)%>
                
    </body>
</html>
