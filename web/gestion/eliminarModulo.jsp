<%-- 
    Document   : eliminarModulo
    Created on : 30/11/2013, 11:39:25 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Módulo</title>
    </head>
    <body>
        
        <% int idModulo=Integer.parseInt(request.getParameter("modulo")); %>       
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
        <%
            String resultado=gestion.eliminarModulo(idModulo);
            if(resultado.equals("La eliminación falló")){
        %>
        <script type="text/javascript">
            alert("La eliminación falló");
            location.href="listadoModulos.jsp";
        </script>
        <%
            }
            if(resultado.equals("La eliminación fue exitosa")){
        %>
        <script type="text/javascript">
            alert("La eliminación fue exitosa");
            location.href="listadoModulos.jsp";
        </script>
        <%
            }
        %>        
    </body>
</html>
