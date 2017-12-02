<%-- 
    Document   : buscar
    Created on : 29-nov-2017, 17:01:19
    Author     : andres
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/buscar.css"/> ">
       
        <script type="text/javascript" src="<c:url value="/js/buscar.js" />"> </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar</title>
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
    		<img src="http://s9.postimg.org/ty7whgnnj/CYMERA_20150512_162628.Jpg" class="img-circle img-thumbnail">
                 <br /> <br /> 
    
          <h3>USUARIO ENCONTRADO!  ${nombre} </h3>
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