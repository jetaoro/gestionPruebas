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
         <table width="500" border="0" cellpadding="0" cellspacing="1" class="fondo_celda_03">
            <form id="frm" name="frm" action="insertarSitioPrueba.jsp" method="post">
                <tr>
                    <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="1" class="marco_01">
                            <tr>
                                <td class="fondo_celda_03">
                                    <table width="100%" border="0" cellpadding="1" cellspacing="1" class="text_negro">
                                        <tr class="fondo_celda_01">
                                            <td align="center">Agregar Sitio Prueba</td>
                                        </tr>
                                    </table>

                                    <table width="100%" border="0" cellpadding="1" cellspacing="1">
                                        <tr class="fondo_celda_04" align="center">
                                            <td>Número de puerto</td>
                                        </tr>
                                        <tr class="fondo_celda_03" align="center">
                                            <td>
                                                <input type="text" class="campo_texto" name="numero_puerto" maxlength="30" size="40"  required>
                                            </td>
                                        </tr>
                                    </table>
                                    <table width="100%" border="0" cellpadding="1" cellspacing="1">
                                        <tr class="fondo_celda_04" align="center">
                                            <td>Nombre</td>
                                        </tr>
                                        <tr class="fondo_celda_03" align="center">
                                            <td>
                                                <input type="text" class="campo_texto" name="nombre" maxlength="30" size="40"  required>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <table width="100%" border="0" cellpadding="2" cellspacing="1" class="text_negro">
                            <tr>
                                <td align="left"><input type="submit" name="registrar" value="Registrar"></td>
                            </form>
                            <form name="volver" action="listadoSitiosPrueba.jsp">
                                <td align="right"><input type="submit" name="volver" value="Volver"></td>
                            </form>
                            </tr>
                        </table>   
                    </td>
                </tr>
            </form>
      
        </table>
    </body>
</html>
