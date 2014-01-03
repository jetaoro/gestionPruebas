<%-- 
    Document   : agregarPrueba
    Created on : 2/01/2014, 04:14:38 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Agregar Prueba</title>
    </head>
    <body>
        <h1>Agregar Prueba</h1>
        <form name="insertarPrueba" action="insertarPrueba.jsp">
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <%=gestion.agregarPruebaFormulario()%>        
            <input type="submit" value="Registrar" name="registrar" />
        </form>
            <%--
        <form name="volver" action="listadoPruebas.jsp">
            <input type="submit" value="Volver" name="volver" />
        </form> 
            --%>          
    </body>    
</html>
