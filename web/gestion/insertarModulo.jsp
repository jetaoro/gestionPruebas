<%-- 
    Document   : insertarModulo
    Created on : 27/11/2013, 07:45:21 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar M&oacute;</title>
    </head>
    <body>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="modulo" scope="page" class="DTO.ModuloDTO" />
        <jsp:setProperty name="modulo" property="*" />
        <%
            String resultado=gestion.insertarModulo(modulo);
            if(resultado.equals("La inserción falló")){
        %>
        <script type="text/javascript">
            alert("La inserción falló");
            location.href="listadoModulos.jsp";
        </script>
        <%
            }
            if(resultado.equals("La inserción fue exitosa")){
        %>
        <script type="text/javascript">
            alert("La inserción fue exitosa");
            location.href="listadoModulos.jsp";
        </script>
        <%
            }
        %>        
    </body>
</html>
