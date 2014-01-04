<%-- 
    Document   : index
    Created on : 22/11/2013, 07:46:25 PM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="body-error">
<head>
    <meta charset="utf-8">
    <title>Sistema de Gestión de Pruebas - Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/login.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">


    <link rel="stylesheet" href="css/icon/font-awesome.css">    
    <link rel="stylesheet" href="css/bootstrap-responsive.css">
    
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="/images/icons/favicon.ico">
    
  </head>
    <body>
        <div id="wrapper">
         <div id="login" class="animate form position">
            <form action="gestion/paginaBuscarPrueba.jsp" method="post">
                 <div class="content-login">
                  <div class="header">Logueate con tu cuenta</div>
                    <div class="inputs">
                        <input name="user" type="text" placeholder="Usuario" />
                        <input name="pass" type="password"  placeholder="Contraseña" />
                    </div>
                    <div class="button-login"><input type="submit" name="ingresar" value="Ingresar"/></div>
                 </div>   
            </form>
         </div>
        </div> 
    </body>
</html>
