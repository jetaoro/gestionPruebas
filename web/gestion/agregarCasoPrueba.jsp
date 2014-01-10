<%-- 
    Document   : agregarCasoPrueba
    Created on : 5/01/2014, 01:36:30 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Caso de Prueba</title>
    </head>
    <body>
        <h1>Agregar Caso de Prueba</h1>
        <form name="insertarCaso" action="insertarCasoPrueba.jsp">
            <% int idPrueba=Integer.parseInt(request.getParameter("idPrueba")); %>
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.agregarCasoPrueba(idPrueba)%>            
            <input type="submit" value="Registrar" name="registrar" />            
        </form>
            
        <form name="verPrueba" action="verPrueba.jsp">
            <input type="submit" value="Volver" name="volver" />
        </form>             
    </body>
</html>
