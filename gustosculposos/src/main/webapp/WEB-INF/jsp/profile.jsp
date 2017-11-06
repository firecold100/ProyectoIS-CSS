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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/profile.css"/> ">
       
        <script type="text/javascript" src="<c:url value="/js/profile.js" />"> </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GustosCulposos</title>
    </head>
    
    <body>
        
            <div class="icon-bar">
  <a class="active" href="#"><i class="fa fa-home"></i></a>
  <a href="#"><i class="fa fa-search"></i></a>
  
  <a href="#"><i class="fa fa-globe"></i></a>
  <a href="#"><i class="fa fa-telegram"></i></a>

 
  <form action="${pageContext.request.contextPath}/eliminarUsuario" method="get"  > 
      <a  ><button id="button"  class="fa fa-trash"   > </button ></a>
      
  </form>
      
      





</div>






<div class="row destacados">  
    <div class="col-md-offset-4 col-md-4">
  		<div class="box1">
    		<img src="http://s9.postimg.org/ty7whgnnj/CYMERA_20150512_162628.Jpg" class="img-circle img-thumbnail">
                 <br /> <br /> 
    
          <h3>Bienvenido!  </h2>
        <h4 style="color:#A9ABA6">{ Web Designer }</h4>
		</div>
  	</div>
</div>  
    
</div>



        
    </body>
</html>
