<%-- 
    Document   : modificarModulo
    Created on : 28/11/2013, 06:16:17 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilo.css" rel="stylesheet" type="text/css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar M&oacute;dulo</title>
    </head>
    <body>
        <form name="modificar" action="actualizarModulo.jsp" method="post">
            <% int idModulo=Integer.parseInt(request.getParameter("modulo")); %>         
            <jsp:useBean id="modulo" scope="page" class="DTO.ModuloDTO" />
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
            <%=gestion.getUnModulo(idModulo)%>                   
            <input type="submit" name="registrar" value="Registrar">
        </form>
        <form name="volver" action="listadoModulos.jsp">
            <input type="submit" name="volver" value="Volver">
        </form>
    </body>
</html>
