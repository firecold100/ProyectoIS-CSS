<%-- 
    Document   : Profile
    Created on : 16-oct-2017, 14:40:56
    Author     : hectorsama
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
         <!-- Archivo jquery local-->
        <script type="text/javascript" 
                src="<c:url value="/jquery/jquery-3.2.1.min.js"/>" defer>
        </script>
        <!-- Archivo de bootstrap local-->
        <script type="text/javascript"
                src="<c:url value="/bootstrap-3.3.7/js/bootstrap.min.js"/>" defer>
        </script>
        <link rel="stylesheet" href="<c:url value="/bootstrap-3.3.7/css/bootstrap.min.css"/>"/>
        
        <!--font-awesome local-->
        <link rel="stylesheet" href="<c:url value="/css/font-awesome/css/font-awesome.min.css"/>"/>
        
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/profile.css"/> ">
        
        <!--Existe un problema con éste javascript. Da un error en consola!-->
        <script type="text/javascript" src="<c:url value="/js/profile.js" />" defer> </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GustosCulposos</title>
    </head>
    
    <body>
        
            <div class="icon-bar">
  <a class="active" href="#"><i class="fa fa-home"></i></a>
  <form action="${pageContext.request.contextPath}/buscarUsuario" method="get"  > 
      <a  ><button id="button"  class="fa fa-search"   > </button ></a>    
  </form>
    <a href="#"><i class="fa fa-telegram"></i></a>
   <form action="${pageContext.request.contextPath}/editarperfil" method="get"  > 
      <a  ><button id="button"  > <img height="42" width="42" src="https://cdn3.iconfinder.com/data/icons/glyph/227/Door-Open-512.png"/></button ></a>
  </form>
  <form action="${pageContext.request.contextPath}/cerrarsesion" method="get"  > 
      <a  ><button id="button"  > <img height="42" width="42" src="https://cdn3.iconfinder.com/data/icons/glyph/227/Door-Open-512.png"/></button ></a>
  </form>
    <form action="${pageContext.request.contextPath}/consultarPerfiles" method="get"  > 
      <a  ><button id="button"  > <img height="42" width="42" src="https://cdn3.iconfinder.com/data/icons/glyph/227/Door-Open-512.png"/></button ></a>
  </form>
  <form action="${pageContext.request.contextPath}/eliminarUsuario" method="get"  > 
      <a  ><button id="button"  class="fa fa-trash"   > </button ></a>    
  </form>
      
      





</div>






<div class="row destacados">  
    <div class="col-md-offset-4 col-md-4">
  		<div class="box1">
                <!--Imagen No disponible!!! :( -->
    		<img src="http://s9.postimg.org/ty7whgnnj/CYMERA_20150512_162628.Jpg" class="img-circle img-thumbnail">
                 <br /> <br /> 
    
          <h3>Bienvenido!  ${nombre} </h3>
        <h4 style="color:#A9ABA6"> ${correo}</h4>
		</div>
  	</div>
    <form >
                        <!--<form class="" method="post" action="#">-->
                        
                        
                        <div class="checkbox">
                        </div>


                    </form>
    
</div>  
    
</div>



        
    </body>
</html>
