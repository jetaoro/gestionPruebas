<%-- 
    Document   : actualizarCasoPrueba
    Created on : 7/01/2014, 11:29:15 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Caso de Prueba</title>
    </head>
    <body>
        
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="casoPrueba" scope="page" class="DTO.CasoPruebaDTO" />
        <jsp:setProperty name="casoPrueba" property="*" />
        <%
            String resultado=gestion.modificarCasoPrueba(casoPrueba);
            if(resultado.equals("La actualización falló")){
        %>
        <script type="text/javascript">
            alert("La actualización falló");
            location.href="verPrueba.jsp";
        </script>
        <%
            }
            if(resultado.equals("La actualización fue exitosa")){
        %>
        <script type="text/javascript">
            alert("La actualización fue exitosa");
            location.href="verPrueba.jsp";
        </script>
        <%
            }
        %>         
    </body>
</html>
