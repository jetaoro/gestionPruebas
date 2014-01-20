<%-- 
    Document   : agregarModulo
    Created on : 27/11/2013, 07:25:06 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    boolean var = true;
    if (sesion.getAttribute("valido") == null) {
        var = false;
    } else {
        var = (Boolean) session.getAttribute("valido");
    }
    if (!var) {
        response.sendRedirect("../index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilo.css" rel="stylesheet" type="text/css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Agregar M&oacute;dulo</title>
    </head>
    <body>
        <form name="formulario" method="post" action="insertarModulo.jsp">
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.agregarModulo()%>
            <input type="submit" value="Agregar" name="agregar" />
            
        </form>
        <form name="listado" action="listadoModulos.jsp">
            <input type="submit" value="Volver" name="volver" />
        </form>
    </body>
</html>

