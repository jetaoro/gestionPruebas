<%-- 
    Document   : listadoPruebas
    Created on : 2/01/2014, 10:16:42 AM
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
        <title>Listado de Pruebas</title>
    </head>
    <body>
        <h1>Listado de Pruebas</h1>
        <form name="formulario" method="post">
            <% 
               String idModulo=request.getParameter("modulo")==null?(String)session.getAttribute("modulo"):request.getParameter("modulo");
               String idSitio=request.getParameter("sitio")==null?(String)session.getAttribute("sitio"):request.getParameter("sitio");
               String idResponsable=request.getParameter("responsable")==null?(String)session.getAttribute("responsable"):request.getParameter("responsable");
               int idModulo2=0;
               int idSitio2=0;                  
               int idResponsable2=0;
               if (idModulo!="")
                   idModulo2=Integer.parseInt(idModulo);               
               if (idSitio!="")
                   idSitio2=Integer.parseInt(idSitio);
               if (idResponsable!="")         
                   idResponsable2=Integer.parseInt(idResponsable);        

               String numero_requerimiento = request.getParameter("numero_requerimiento")==null?(String)session.getAttribute("numero_requerimiento"):request.getParameter("numero_requerimiento");
               String nombre_prueba = request.getParameter("nombre_prueba")==null?(String)session.getAttribute("nombre_prueba"):request.getParameter("nombre_prueba");
               
               session.setAttribute("modulo", idModulo);
               session.setAttribute("sitio", idSitio);
               session.setAttribute("responsable", idResponsable);
               session.setAttribute("numero_requerimiento", numero_requerimiento);
               session.setAttribute("nombre_prueba", nombre_prueba);
            %>
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.buscarPruebas(nombre_prueba, numero_requerimiento, idModulo2, idResponsable2, idSitio2)%>

            <input type="button" value="Ver" name="ver" onClick="envia('verPrueba.jsp')" />
            <input type="button" value="Agregar" name="agregar" onClick="envia('agregarPrueba.jsp')" />
            <input type="button" value="Modificar" name="modificar" onClick="envia('modificarPrueba.jsp')" />            
            <input type="button" value="Eliminar" name="eliminar" onClick="envia('eliminarPrueba.jsp')" />
            <input type="button" value="Volver" name="volver" onClick="envia('paginaBuscarPrueba.jsp')" />            
        </form> 
    </body>
</html>
