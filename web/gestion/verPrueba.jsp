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
        <script type="text/javascript" src="../js/validar.js"></script>
        <script type="text/javascript" >
            function envia(destino){                
                formulario.action=destino;
                formulario.submit();
            }
            
            function modifica(destino) {                
                if (!validarRadio('formulario', 'casoPrueba')) {
                    alert("Debe seleccionar un Caso de Prueba a modificar");
                    return;
                }

                formulario.action = destino;
                formulario.submit();
            }
            
            function elimina(destino) {                
                if (!validarRadio('formulario', 'casoPrueba')) {
                    alert("Debe seleccionar un Caso de Prueba a eliminar");
                    return;
                }

                formulario.action = destino;
                formulario.submit();
            }
        </script>
        <title>Ver contenido de prueba</title>
    </head>
    <body>
        <h1>Contenido de la Prueba</h1>
        <form name="formulario" method="post">
            <%  int idPrueba = 0;
                if(request.getParameter("prueba")!=null)
                    idPrueba = Integer.parseInt(request.getParameter("prueba")); %>
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.getPrueba(idPrueba)%>
            <input type="button" value="Agregar" name="agregar" onClick="envia('agregarCasoPrueba.jsp')" />
            <input type="button" value="Modificar" name="modificar" onClick="modifica('modificarCasoPrueba.jsp')" />            
            <input type="button" value="Eliminar" name="eliminar" onClick="elimina('eliminarCasoPrueba.jsp')" />
            <input type="button" value="Volver" name="volver" onClick="envia('listadoPruebas.jsp')"/>
        </form>
        
        
    </body>
</html>
