<%-- 
    Document   : eliminarSitioPrueba
    Created on : 4/01/2014, 04:38:32 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Sitio de Prueba</title>
    </head>
    <body>
        <h1>Eliminación del Sitio Prueba</h1>
        <% int idSitio=Integer.parseInt(request.getParameter("sitio_prueba")); %>       
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
        <%=gestion.eliminarSitioPrueba(idSitio)%>
        <form name="listadoPruebas" action="listadoSitiosPrueba.jsp">
            <input type="submit" value="Volver" name="volver" />
        </form>
    </body>
</html>
