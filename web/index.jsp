<%-- 
    Document   : index
    Created on : 22/11/2013, 07:46:25 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
            <form action="login.jsp" method="post">
                    <table>
                            <tr>
                                    <td>Usuario: </td>
                                    <td><input name="user" /></td>
                            </tr>
                            <tr>
                                    <td>Contraseña: </td>
                                    <td><input name="password" /></td>
                            </tr>
                    </table>
                    <input type="submit" name="ingresar" value="Ingresar"/>
            </form>
    </body>
</html>
