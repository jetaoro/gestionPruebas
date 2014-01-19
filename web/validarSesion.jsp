<%-- 
    Document   : validarSesion
    Created on : 19/01/2014, 11:06:18 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validar Sesión</title>
    </head>
    <body>
        <%--
        <%
            HttpSession sesion = request.getSession();
            boolean var = true;
            if (sesion.getAttribute("valido") == null) {
                var = false;
            } else {
                var = (Boolean) session.getAttribute("valido");
            }
            if (!var) {
        %>
            <script type="text/javascript">
                alert("Error, no se ha logueado en el sistema");
                location.href="index.jsp";
            </script>
        <%
            }
        %>
        --%>
        <%
            HttpSession sesion = request.getSession(true);
            if (sesion.isNew()){
                response.sendRedirect("index.jsp");
                return;
            }
           
            if(sesion == null){
                response.sendRedirect("index.jsp");
                return;
            }else{
                if(sesion.getAttribute("valido")==null){
                    response.sendRedirect("index.jsp");
                    return;
                }
            }
        %>
    </body>
</html>
