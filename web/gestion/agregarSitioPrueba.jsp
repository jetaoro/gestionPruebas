<%-- 
    Document   : agregarSitioPrueba
    Created on : 28/11/2013, 05:54:36 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilo.css" rel="stylesheet" type="text/css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Sitio Prueba</title>
    </head>
    <body>
         <form name="insertarSitio" action="insertarSitioPrueba.jsp">
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.agregarSitioPrueba()%>
            <input type="submit" value="Registrar" name="registrar" />
        </form>
                         
        <form name="volver" action="listadoSitiosPrueba.jsp">
              <td align="right"><input type="submit" name="volver" value="Volver"></td>
        </form> 
    </body>
</html>
