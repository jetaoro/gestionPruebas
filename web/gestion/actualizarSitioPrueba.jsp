<%-- 
    Document   : actualizarSitioPrueba
    Created on : 28/11/2013, 06:17:27 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Sitio de Prueba</title>
    </head>
    <body>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="sitio" scope="page" class="DTO.SitioPruebaDTO" />
        <jsp:setProperty name="sitio" property="*" />        
        <%
        String resultado=gestion.modificarSitioPrueba(sitio);
            if(resultado.equals("La actualización falló")){
        %>
        <script type="text/javascript">
            alert("La actualización falló");
            location.href="listadoSitiosPrueba.jsp";
        </script>
        <%
            }
            if(resultado.equals("La actualización fue exitosa")){
        %>
        <script type="text/javascript">
            alert("La actualización fue exitosa");
            location.href="listadoSitiosPrueba.jsp";
        </script>
        <%
            }
        %>        
    </body>
</html>
