<%-- 
    Document   : agregarSitioPrueba
    Created on : 28/11/2013, 05:54:36 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilo.css" rel="stylesheet" type="text/css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Agregar Sitio Prueba</title>
    </head>
    <body>
        <form name="formulario" method="post" action="insertarSitioPrueba.jsp">
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.agregarSitioPrueba()%>
            <input type="submit" value="Agregar" name="agregar" />            
        </form>
        <form name="listadoSitios" action="listadoSitiosPrueba.jsp">
            <input type="submit" value="Volver" name="volver" />
        </form>
        
    </body>
</html>
