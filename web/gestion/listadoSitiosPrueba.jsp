<%-- 
    Document   : listaSitioPrueba
    Created on : 27/11/2013, 05:36:28 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                if (!validarRadio('formulario', 'sitio_prueba')) {
                    alert("Debe seleccionar un Sitio de Prueba a modificar");
                    return;
                }

                formulario.action = destino;
                formulario.submit();
            }
            
            function elimina(destino) {                
                if (!validarRadio('formulario', 'sitio_prueba')) {
                    alert("Debe seleccionar un Sitio de Prueba a eliminar");
                    return;
                }

                formulario.action = destino;
                formulario.submit();
            }
        </script>
        <title>Listado de Sitios de Prueba</title>
    </head>
    <body>
        <h1>Sitios de Prueba</h1>
        <form name="formulario" method="post"> 
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.getListadoSitios()%>
            <input type="button" value="Agregar" name="agregar" onClick="envia('agregarSitioPrueba.jsp')" />  
            <input type="button" value="Modificar" name="modificar" onClick="modifica('modificarSitioPrueba.jsp')" />
            <input type="button" value="Eliminar" name="eliminar" onClick="elimina('eliminarSitioPrueba.jsp')" />
        </form> 
    </body>
</html>
