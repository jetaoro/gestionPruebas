<%-- 
    Document   : eliminarPrueba
    Created on : 4/01/2014, 05:46:06 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Prueba</title>
    </head>
    <body>
        
        <% int idPrueba=Integer.parseInt(request.getParameter("prueba")); %>       
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
        <%
            String resultado=gestion.eliminarPrueba(idPrueba);
            if(resultado.equals("La eliminación de la prueba falló")){
        %>
        <script type="text/javascript">
            alert("La eliminación de la prueba falló");
            location.href="listadoPruebas.jsp";
        </script>
        <%
            }
            if(resultado.equals("La eliminación de los casos de prueba de la prueba seleccionada, falló")){
        %>
        <script type="text/javascript">
            alert("La eliminación de los casos de prueba de la prueba seleccionada, falló");
            location.href="listadoPruebas.jsp";
        </script>
        <%
            }
            if(resultado.equals("La eliminación de los modos de ejecución de la prueba seleccionada, falló")){
        %>
        <script type="text/javascript">
            alert("La eliminación de los modos de ejecución de la prueba seleccionada, falló");
            location.href="listadoPruebas.jsp";
        </script>
        <%
            }
            if(resultado.equals("La eliminación de la prueba fue exitosa")){
        %>
        <script type="text/javascript">
            alert("La eliminación de la prueba fue exitosa");
            location.href="listadoPruebas.jsp";
        </script>
        <%
            }
        %>
    </body>
</html>
