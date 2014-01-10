<%-- 
    Document   : insertarCasoPrueba
    Created on : 5/01/2014, 01:55:47 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Caso Prueba</title>
    </head>
    <body>
        <h1>Insertar Caso de Prueba</h1>         
        <% int idPrueba=Integer.parseInt(request.getParameter("idPrueba")); %>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="casoPrueba" scope="page" class="DTO.CasoPruebaDTO" />
        <jsp:setProperty name="casoPrueba" property="*" />
        <%=gestion.insertarCasoPrueba(casoPrueba, idPrueba)%>
        
        <form name="verPrueba" action="verPrueba.jsp">
            <input type="submit" value="Volver" name="volver" />
        </form>
    </body>
</html>
