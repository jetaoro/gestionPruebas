<%-- 
    Document   : eliminarPrueba
    Created on : 4/01/2014, 05:46:06 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Prueba</title>
    </head>
    <body>
        <h1>Eliminación de la Prueba</h1>
        <% int idPrueba=Integer.parseInt(request.getParameter("prueba")); %>       
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
        <%=gestion.eliminarPrueba(idPrueba)%>
        <form name="listadoPruebas" action="listadoPruebas.jsp">
            <input type="submit" value="Volver" name="volver" />
        </form>
    </body>
</html>
