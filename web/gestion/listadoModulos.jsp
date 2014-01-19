<%-- 
    Document   : listadoModulos
    Created on : 27/11/2013, 08:56:29 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    boolean var = true;
    if (sesion.getAttribute("valido") == null) {
        var = false;
    } else {
        var = (Boolean) session.getAttribute("valido");
    }
    if (!var) {
        response.sendRedirect("../index.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="../js/validar.js"></script>
        <script type="text/javascript" >
            function envia(destino){
                formulario.action=destino;
                formulario.submit();
            }           
            
            function modifica(destino) {                
                if (!validarRadio('formulario', 'modulo')) {
                    alert("Debe seleccionar un Módulo a modificar");
                    return;
                }

                formulario.action = destino;
                formulario.submit();
            }
            
            function elimina(destino) {                
                if (!validarRadio('formulario', 'modulo')) {
                    alert("Debe seleccionar un Módulo a eliminar");
                    return;
                }

                formulario.action = destino;
                formulario.submit();
            }
        </script>

        <title>P&aacute;gina principal de M&oacute;dulos</title>
    </head>
    <body>
        <h1>M&oacute;dulos</h1>              
        <form name="formulario" method="post"> 
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.getListadoModulos()%>
            <input type="button" value="Agregar" name="agregar" onClick="envia('agregarModulo.jsp')" />
            <input type="button" value="Modificar" name="modificar" onClick="modifica('modificarModulo.jsp')" />            
            <input type="button" value="Eliminar" name="eliminar" onClick="elimina('eliminarModulo.jsp')" />
        </form>      
    </body>
</html>
