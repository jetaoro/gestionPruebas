<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : insertarSitioPrueba
    Created on : 28/11/2013, 05:55:53 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Sitio de Prueba</title>
    </head>
    <body>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="sitio_prueba" scope="page" class="DTO.SitioPruebaDTO" />
        <jsp:setProperty name="sitio_prueba" property="*" />
        <%if (sitio_prueba!=null)%>
        <%=gestion.insertarSitioPrueba(sitio_prueba)%>
        <form name="listadoPruebas" action="listadoSitiosPrueba.jsp">
            <input type="submit" value="Volver" name="volver" />
        </form>
    </body>
</html>
