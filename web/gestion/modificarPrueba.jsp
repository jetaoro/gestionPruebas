<%-- 
    Document   : modificarPrueba
    Created on : 4/01/2014, 05:45:10 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Prueba</title>
    </head>
    <body>
        <form name="modificar" action="actualizarPrueba.jsp" method="post">
            <% int idPrueba=Integer.parseInt(request.getParameter("prueba")); %>         
            <jsp:useBean id="prueba" scope="page" class="DTO.PruebaDTO" />
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
            <%=gestion.getUnaPrueba(idPrueba)%>                   
            <input type="submit" name="registrar" value="Registrar">
        </form>
        <form name="formulario" action="listadoPruebas.jsp">
            <input type="submit" name="volver" value="Volver">
        </form>
    </body>
</html>
