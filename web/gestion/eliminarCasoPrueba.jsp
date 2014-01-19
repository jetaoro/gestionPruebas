<%-- 
    Document   : eliminarCasoPrueba
    Created on : 7/01/2014, 06:28:52 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Caso de Prueba</title>
    </head>
    <body>
        
        <% int idCaso=Integer.parseInt(request.getParameter("casoPrueba")); %>       
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
        <%
            String resultado=gestion.eliminarCasoPrueba(idCaso);
            if(resultado.equals("La eliminación falló")){
        %>
        <script type="text/javascript">
            alert("La eliminación falló");
            location.href="verPrueba.jsp";
        </script>
        <%
            }
            if(resultado.equals("La eliminación fue exitosa")){
        %>
        <script type="text/javascript">
            alert("La eliminación fue exitosa");
            location.href="verPrueba.jsp";
        </script>
        <%
            }
        %>       
    </body>
</html>
