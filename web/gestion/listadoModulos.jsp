<%-- 
    Document   : listadoModulos
    Created on : 27/11/2013, 08:56:29 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <title>P&aacute;gina principal de M&oacute;dulos</title>
    </head>
    <body>
        <h1>M&oacute;dulos</h1>
                
        <form name="modificarModulo" action="modificarModulo.jsp">
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.getListadoModulos()%>
            <input type="submit" value="Modificar" name="modificar" />
        </form>
            
        <form name="agregarModulo" action="agregarModulo.jsp">
            <input type="submit" value="Agregar" name="agregar" />
        </form>
            
        <form name="eliminarModulo" action="eliminarModulo.jsp">
            <input type="submit" value="Eliminar" name="eliminar" />
        </form>
    </body>
</html>
