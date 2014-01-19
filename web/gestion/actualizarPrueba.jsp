<%-- 
    Document   : actualizarPrueba
    Created on : 7/01/2014, 02:55:16 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Prueba</title>
    </head>
    <body>
        
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="prueba" scope="page" class="DTO.PruebaDTO" />
        <%
            String idPrueba = request.getParameter("identificador");
            String fechaInicio = request.getParameter("fecha_inicio");
            String fechaFin = request.getParameter("fecha_fin");            
            String nombre = request.getParameter("nombre");
            String numero_requerimiento = request.getParameter("numero_requerimiento");
            String fechaEjecucion = request.getParameter("fecha_ejecucion");
            String elementoPrueba = request.getParameter("elemento_prueba");            
            String descripcion = request.getParameter("descripcion");
            String casoExito = request.getParameter("caso_exito");
            String casoFallo = request.getParameter("caso_fallo");
            int idPrueba2 = 0;
            if(idPrueba!=null)
                idPrueba2 = Integer.parseInt(idPrueba);
        %>        
        <%
            String resultado=gestion.modificarPrueba(idPrueba2, fechaInicio, fechaFin, nombre, numero_requerimiento, fechaEjecucion, elementoPrueba, descripcion, casoExito, casoFallo);
            if(resultado.equals("La actualización falló")){
        %>
        <script type="text/javascript">
            alert("La actualización falló");
            location.href="listadoPruebas.jsp";
        </script>
        <%
            }
            if(resultado.equals("La actualización fue exitosa")){
        %>
        <script type="text/javascript">
            alert("La actualización fue exitosa");
            location.href="listadoPruebas.jsp";
        </script>
        <%
            }
        %>        
    </body>
</html>
