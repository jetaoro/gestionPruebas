<%-- 
    Document   : agregarModulo
    Created on : 27/11/2013, 07:25:06 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilo.css" rel="stylesheet" type="text/css" >
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar M&oacute;dulo</title>
    </head>
    <body>
        <form name="insertarModulo" action="insertarModulo.jsp">
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.agregarModulo()%>
            <input type="submit" value="Registrar" name="registrar" />
        </form>
                         
        <form name="volver" action="listadoModulos.jsp">
              <td align="right"><input type="submit" name="volver" value="Volver"></td>
        </form>                            
    </body>
</html>

