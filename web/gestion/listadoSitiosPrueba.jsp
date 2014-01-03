<%-- 
    Document   : listadoSitiosPrueba
    Created on : 28/11/2013, 05:47:31 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Sitios de Prueba</title>
    </head>
    <body>
        <h1>Sitios de Prueba</h1>
        <form name="modificarModulo" action="modificarSitioPrueba.jsp">
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.getListadoSitios()%>
            <input type="submit" value="Modificar" name="modificar" />
        </form>
        <form name="agregarModulo" action="agregarSitioPrueba.jsp">
            <input type="submit" value="Agregar" name="agregar" />
        </form>
    </body>
</html>
