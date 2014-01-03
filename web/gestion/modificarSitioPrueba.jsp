<%-- 
    Document   : modificarSitioPrueba
    Created on : 28/11/2013, 06:16:57 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilo.css" rel="stylesheet" type="text/css" >
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>Modificar M&oacute;dulo</title>
    </head>
    <body>
        <% int idSitio=Integer.parseInt(request.getParameter("sitio_prueba")); %>         
        <jsp:useBean id="sitio" scope="page" class="DTO.SitioPruebaDTO" />
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
        <%=gestion.getUnSitioPrueba(idSitio)%>
        
        <form name="registrar" action="actualizarSitioPrueba.jsp">            
            <td><input type="submit" name="registrar" value="Registrar"></td>
        </form>
        <form name="volver" action="listadoSitiosPrueba.jsp">
            <td><input type="submit" name="volver" value="Volver"></td>
        </form>
    </body>
</html>
