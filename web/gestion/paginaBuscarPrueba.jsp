<%-- 
    Document   : buscarPrueba
    Created on : 2/01/2014, 09:17:18 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar prueba</title>
    </head>
    <body>
        <form name="buscarPrueba" action="listadoPruebas.jsp">
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.paginaBuscarPruebas()%>
            <input type="submit" value="Buscar" name="buscar" />
        </form>        
    </body>
</html>
