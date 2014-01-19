<%-- 
    Document   : validar
    Created on : 19/01/2014, 08:46:48 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
<%@page session="true"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validación de Sesión</title>
    </head>
    <body>        
        <%
            HttpSession sesion=request.getSession();
            String usuario=request.getParameter("usuario");
            String contrasena=request.getParameter("contrasena");            
            boolean esValido=gestion.esValido(usuario, contrasena);
            session.setAttribute("valido", esValido);
            if(!esValido){
        %>
            <script type="text/javascript">
                alert("Usuario o contraseña inválida.");
                location.href="index.jsp";
            </script>            
        <%
            }
            else {
        %>
            <script type="text/javascript">                
                location.href="gestion/paginaBuscarPrueba.jsp";
            </script>
        <%
            }
         %>
    </body>
</html>
