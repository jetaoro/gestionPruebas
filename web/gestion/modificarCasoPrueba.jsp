<%-- 
    Document   : modificarCasoPrueba
    Created on : 7/01/2014, 11:10:10 AM
    Author     : Jennifer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificación de Módulos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
        
        <link href="../css/datepicker.css" rel="stylesheet">
	<style>
	.container {
		background: #fff;
	}
	#alert {
		display: none;
	}
	</style>
    <link href="../js/google-code-prettify/prettify.css" rel="stylesheet">
       
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
              <li><a href="#"><i class="icon-user"></i> Mi perfil </a></li>
              <li><a href="#"><i class="icon-info-sign"></i> Ayuda</a></li>
              <li><a href="salir.jsp"><i class="icon-off"></i> Salir</a></li>
            </ul>
          </div>
        </div>
        <div class="clearfix"></div>
       <!--profile box end-->
              
            </div>
        </div> 
        <!-- fin del header -->
        <div id="wrap">
            <!--BEGIN SIDEBAR-->
            <div id="menu" role="navigation">  
                <ul class="main-menu">
                     <li class="active"><a href="paginaBuscarPrueba.jsp"><i class="components"></i> Pruebas</a></li>
                     <li><a href="listadoModulos.jsp"><i class="modules"></i> Módulos</a></li>
                     <li><a href="listadoSitiosPrueba.jsp"><i class="general"></i> Sitio Prueba</a></li>
                </ul>
                <ul class="additional-menu">
                     <li><i class="icon-search"></i> Buscar</li>
                     <li><i class="icon-list"></i> Listar</a></li>
                     <li><i class="icon-plus-sign"></i> Agregar</a></li>
                     <li class="active" ><i class="icon-edit"></i><a href="#"> Modificar </a></li>
                     <li><i class="icon-remove"></i> Eliminar</li>
                </ul>
          
            </div>  
         <!-- inicio del contenido principal -->
         <div id="main" role="main">
          <div class="block">
   		  <div class="clearfix"></div>
              
              <!--comienzo del titulo-->    
              <div class="pagetitle">
                <h1>Modificar Caso de Prueba</h1>
              </div>
              
              
              <!-- Comienzo de la tabla -->
              <div class="grid">
                  
               <div class="grid-title">
                <div class="pull-left">
                  <div class="icon-title"><i class="icon-list"></i></div>
                  <span></span>
                  <div class="clearfix"></div>
                </div>
                <div class="pull-right"> 
                   <div class="icon-title"><a class="popover-left"  
                       title="Ayuda Modificar Caso de Prueba" data-content="Esta página permite actualizar la información 
                       de un caso de prueba existente. Cuando se tenga diligenciada la información correspondiente, 
                       basta con presionar el botón Registrar.">
                           <i class="icon-question-sign"></i></a></div>
                </div>
              <div class="clearfix"></div>   
              </div>
                  <div class="grid-content">             
                        <form name="modificar" action="actualizarCasoPrueba.jsp" method="post">
                            <% int idCasoPrueba=Integer.parseInt(request.getParameter("casoPrueba")); %>            
                            <jsp:useBean id="gestion" scope="page" class="FACADE.GestionPrueba" />        
                            <%=gestion.getUnCasoPrueba(idCasoPrueba)%>                   
                            <input class="btn btn-warning" type="submit" name="registrar" value="Registrar">
                        </form>
                        <form name="verPrueba" action="verPrueba.jsp">
                            <input class="btn btn-warning" type="submit" value="Volver" name="volver" />
                        </form>
                  </div>           
             </div>
             <!-- fin grid -->  
            
             
            
             
         </div>   
           <!--fin block -->             
         
           
           
        </div>
        <!-- fin contenido principal-->     
      
      </div>        
      <!-- fin wrap -->   
      
      <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../js/jquery.min.js"></script>
    <script src="../js/jquery-ui.min.js"></script>
   
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/google-code-prettify/prettify.js"></script>
    <script src="../js/fullcalendar.min.js"></script>
    <script src="../js/jquery.flot.orderBars.js"></script>
    <script src="../js/jquery.flot.resize.js"></script>
    <script src="../js/jquery.flot.categories.js"></script>
    <script src="../js/graphtable.js"></script>
    <script src="../js/chosen.jquery.min.js"></script>
    <script src="../js/autoresize.jquery.min.js"></script>
    <script src="../js/jquery.autotab.js"></script>
    <script src="../js/jquery.jgrowl_minimized.js"></script>
    <script src="../js/jquery.dataTables.min.js"></script>
    <script src="../js/jquery.stepy.min.js"></script>
    <script src="../js/jquery.validate.min.js"></script>
    <script src="../js/raphael.2.1.0.min.js"></script>
    <script src="../js/justgage.1.0.1.min.js"></script>
	<script src="../js/glisse.js"></script>
	<script src="../js/styleswitcher.js"></script>
	<script src="../js/moderniz.js"></script>
    <script src="../js/jquery.sparkline.min.js"></script>
    <script src="../js/slidernav-min.js"></script>
    <script type="text/javascript" src="../js/jquery.fancybox.js?v=2.1.4"></script>
    
	<script>
    Modernizr.load([
        {
         load: [
                '../js/main.js'
            ],
            complete: function()
            {
                $.fn.ready(function()
                {
                    window.App.init();
                });
            }
        }
    ]);
    </script>
	<script src="../js/application.js"></script>
     
            
    </body>
</html>