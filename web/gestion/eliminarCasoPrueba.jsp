<%-- 
    Document   : eliminarCasoPrueba
    Created on : 7/01/2014, 06:28:52 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Caso de Prueba</title>
    </head>
    <body>
        <h1>Eliminación del Caso de Prueba</h1>
        <% int idCaso=Integer.parseInt(request.getParameter("casoPrueba")); %>       
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
        <%=gestion.eliminarCasoPrueba(idCaso)%>
        <form name="verPrueba" action="verPrueba.jsp">
            <input type="submit" value="Volver" name="volver" />
        </form>
    </body>
</html>
