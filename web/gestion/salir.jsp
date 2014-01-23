<%-- 
    Document   : salir
    Created on : 19/01/2014, 11:02:02 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salir de Sesión</title>
    </head>
    <body>
        <%
         request.getSession().removeAttribute("valido");
         session.invalidate();
         response.sendRedirect("../index.jsp");
        %>  
    </body>
</html>
