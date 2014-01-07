<%-- 
    Document   : verPrueba
    Created on : 7/01/2014, 09:31:02 AM
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
        <title>Ver contenido de prueba</title>
    </head>
    <body>
        <h1>Contenido de la Prueba</h1>
        <form name="formulario" method="post">
            <%int idPrueba = Integer.parseInt(request.getParameter("prueba")); %>
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.getPrueba(idPrueba)%>
            <input type="button" value="Agregar" name="agregar" onClick="envia('agregarCasoPrueba.jsp')" />
            <input type="button" value="Modificar" name="modificar" onClick="envia('modificarCasoPrueba.jsp')" />            
            <input type="button" value="Eliminar" name="eliminar" onClick="envia('eliminarCasoPrueba.jsp')" />            
        </form>
                
    </body>
</html>
