<%-- 
    Document   : eliminarSitioPrueba
    Created on : 4/01/2014, 04:38:32 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Sitio de Prueba</title>
    </head>
    <body>        
        <% int idSitio=Integer.parseInt(request.getParameter("sitio_prueba")); %>       
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
        <%
            String resultado=gestion.eliminarSitioPrueba(idSitio);
            if(resultado.equals("La eliminación falló")){
        %>
        <script type="text/javascript">
            alert("La eliminación falló");
            location.href="listadoSitiosPrueba.jsp";
        </script>
        <%
            }
            if(resultado.equals("La eliminación fue exitosa")){
        %>
        <script type="text/javascript">
            alert("La eliminación fue exitosa");
            location.href="listadoSitiosPrueba.jsp";
        </script>
        <%
            }
        %>
        <form name="listadoPruebas" action="listadoSitiosPrueba.jsp">
            <input type="submit" value="Volver" name="volver" />
        </form>
    </body>
</html>
