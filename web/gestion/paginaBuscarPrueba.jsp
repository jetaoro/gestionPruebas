<%-- 
    Document   : buscarPrueba
    Created on : 2/01/2014, 09:17:18 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar prueba</title>
        <!-- Le styles -->
        <link href="../css/style.css" rel="stylesheet">
        <link href="../css/bootstrap.css" rel="stylesheet">


        <link rel="stylesheet" href="../css/jquery-ui-1.8.16.custom.css" media="screen"  />
        <link rel="stylesheet" href="../css/fullcalendar.css" media="screen"  />
        <link rel="stylesheet" href="../css/chosen.css" media="screen"  />
        <link rel="stylesheet" href="../css/glisse.css?1.css">
        <link rel="stylesheet" href="../css/jquery.jgrowl.css">
        <link rel="stylesheet" href="../css/demo_table.css" >
        <link rel="stylesheet" href="../css/jquery.fancybox.css?v=2.1.4" media="screen" />

            <link rel="stylesheet" href="../css/icon/font-awesome.css">    
        <link rel="stylesheet" href="../css/bootstrap-responsive.css">

        <link rel="alternate stylesheet" type="text/css" media="screen" title="green-theme" href="../css/color/green.css" />
            <link rel="alternate stylesheet" type="text/css" media="screen" title="red-theme" href="../css/color/red.css" />
            <link rel="alternate stylesheet" type="text/css" media="screen" title="blue-theme" href="../css/color/blue.css" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="orange-theme" href="../css/color/orange.css" />
        <link rel="alternate stylesheet" type="text/css" media="screen" title="purple-theme" href="../css/color/purple.css" />

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
         <script language="JavaScript">
            Firefox = navigator.userAgent.indexOf("Firefox") >= 0;
            if(Firefox) document.write("<link rel='stylesheet' href='../css/moz.css' type='text/css'>"); 
            </script>

        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="../images/favicon.ico">

    </head>
    <body>
        <!-- comienzo del header -->
        <div id="header" role="banner">
            <a id="menu-link" class="head-button-link menu-hide" href="#menu"><span>Menu</span></a>
            <!--Logo--><a href="#" class="logo"><h1></h1></a><!--Logo END-->
            
            <div class="right">
               <!--config box-->
                 <div class="dropdown left">
                  <a class="dropdown-toggle head-button-link config" data-toggle="dropdown" href="#"></a>
                  <div class="dropdown-menu pull-right settings-box">
                  <div class="triangle-2"></div>

                    <a href="javascript:chooseStyle('none', 30)" class="settings-link"></a>
                    <a href="javascript:chooseStyle('blue-theme', 30)" class="settings-link blue"></a>
                    <a href="javascript:chooseStyle('green-theme', 30)" class="settings-link green"></a>
                    <a href="javascript:chooseStyle('purple-theme', 30)" class="settings-link purple"></a>
                    <a href="javascript:chooseStyle('orange-theme', 30)" class="settings-link yellow"></a>
                    <a href="javascript:chooseStyle('red-theme', 30)" class="settings-link red"></a>
                    <div class="clearfix"></div>
                  </div>
                </div>
               <!-- fin config box--> 
               <!--profile box-->
                 <div class="dropdown left profile">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <span class="double-spacer"></span>
                    <div class="profile-avatar"><img src="../images/avatar.png" alt=""></div>
                    <div class="profile-username"><span>Bienvenido,</span> Usuario</div>
                    <div class="profile-caret"> <span class="caret"></span></div>
                    <span class="double-spacer"></span>
                  </a>
                  <div class="dropdown-menu pull-right profile-box">
                  <div class="triangle-3"></div>

                    <ul class="profile-navigation">
                      <li><a href="#"><i class="icon-user"></i> Mi perfil</a></li>
                      <li><a href="#"><i class="icon-cog"></i> Configuración</a></li>
                      <li><a href="#"><i class="icon-info-sign"></i> Ayuda</a></li>
                      <li><a href="../index.jsp"><i class="icon-off"></i> Salir</a></li>
                    </ul>
                  </div>
                </div>
                <div class="clearfix"></div>
              <!--profile box end-->
            </div>
        </div> 
        <!-- fin del header -->
        <div id="wrap">
            <form name="buscarPrueba" action="listadoPruebas.jsp">
            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />
            <%=gestion.paginaBuscarPruebas()%>
            <input type="submit" value="Buscar" name="buscar" />
        </form>  
        </div>
              
    </body>
</html>
