<%-- 
    Document   : insertarPrueba
    Created on : 3/01/2014, 08:44:27 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertar Prueba</title>
    </head>
    <body>        
        <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
        <jsp:useBean id="prueba" scope="page" class="DTO.PruebaDTO" />
        <%
            String idModulo = request.getParameter("modulo");
            String idSitio = request.getParameter("sitio");
            String fechaInicio = request.getParameter("fecha_inicio");
            String fechaFin = request.getParameter("fecha_fin");
            String idResponsable = request.getParameter("responsable");
            String nombre = request.getParameter("nombre");
            String numero_requerimiento = request.getParameter("numero_requerimiento");
            String fechaEjecucion = request.getParameter("fecha_ejecucion");
            String elementoPrueba = request.getParameter("elemento_prueba");
            String idTipoPrueba = request.getParameter("tipoPrueba");
            String [] modosEjecucion = request.getParameterValues("modoEjecucion");
            String descripcion = request.getParameter("descripcion");
            String casoExito = request.getParameter("caso_exito");
            String casoFallo = request.getParameter("caso_fallo");
            int idModulo2 = 0;
            int idSitio2 = 0;
            int idResponsable2 = 0;
            int idTipoPrueba2 = 0;
            if (idModulo!="")
                idModulo2 = Integer.parseInt(idModulo);
            if (idSitio!="")
                idSitio2 = Integer.parseInt(idSitio);
            if (idResponsable!="")
                idResponsable2 = Integer.parseInt(idResponsable);
            if (idTipoPrueba!="")
                idTipoPrueba2 = Integer.parseInt(idTipoPrueba);
            
            String resultado=gestion.insertarUnaPrueba(idModulo2, idSitio2, idResponsable2, fechaInicio, fechaFin, nombre, numero_requerimiento, fechaEjecucion, elementoPrueba, idTipoPrueba2, modosEjecucion, descripcion, casoExito, casoFallo);
            if(resultado.equals("La inserción falló")){
        %>
        
        <script type="text/javascript">
            alert("La inserción falló");
            location.href="listadoPruebas.jsp";
        </script>
        <%
            }
            if(resultado.equals("La inserción fue exitosa")){
        %>
        <script type="text/javascript">
            alert("La inserción fue exitosa");
            location.href="listadoPruebas.jsp";
        </script>
        <%
            }
        %>

    </body>
</html>
