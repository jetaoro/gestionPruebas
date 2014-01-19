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
               
        <% int idPrueba=Integer.parseInt(request.getParameter("idPrueba")); %>
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="casoPrueba" scope="page" class="DTO.CasoPruebaDTO" />
        <jsp:setProperty name="casoPrueba" property="*" />
        <%
            String resultado=gestion.insertarCasoPrueba(casoPrueba, idPrueba);
            if(resultado.equals("La inserción falló")){
        %>
        <script type="text/javascript">
            alert("La inserción falló");
            location.href="verPrueba.jsp";
        </script>
        <%
            }
            if(resultado.equals("La inserción fue exitosa")){
        %>
        <script type="text/javascript">
            alert("La inserción fue exitosa");
            location.href="verPrueba.jsp";
        </script>
        <%
            }
        %>        
    </body>
</html>
