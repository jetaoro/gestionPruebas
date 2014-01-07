<%-- 
    Document   : listadoModulos
    Created on : 27/11/2013, 08:56:29 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" >
            function envia(destino){
                formulario.action=destino;
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
            <input type="button" value="Modificar" name="modificar" onClick="envia('modificarModulo.jsp')" />
            <input type="button" value="Agregar" name="agregar" onClick="envia('agregarModulo.jsp')" />
            <input type="button" value="Eliminar" name="eliminar" onClick="envia('eliminarModulo.jsp')" />
        </form>      
    </body>
</html>
