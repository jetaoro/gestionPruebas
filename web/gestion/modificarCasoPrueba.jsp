<%-- 
    Document   : modificarCasoPrueba
    Created on : 7/01/2014, 11:10:10 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Caso de Prueba</title>
    </head>
    <body>
        <h1>Modificar Caso de Prueba</h1>
        <form name="modificar" action="actualizarCasoPrueba.jsp" method="post">
            <% int idCasoPrueba=Integer.parseInt(request.getParameter("casoPrueba")); %>            
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
            <%=gestion.getUnCasoPrueba(idCasoPrueba)%>                   
            <input type="submit" name="registrar" value="Registrar">
        </form>
        <form name="volver" action="listadoModulos.jsp">
            <input type="submit" name="volver" value="Volver">
        </form>
    </body>
</html>
