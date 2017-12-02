<%-- 
    Document   : eliminar
    Created on : 16-oct-2017, 15:38:07
    Author     : hectorsama
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
    <head> 
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/register.css"/> ">  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Archivo jquery local-->
        <script type="text/javascript" 
                src="<c:url value="/jquery/jquery-3.2.1.min.js"/>" defer>
        </script>
        <!-- Archivo bootstrap.js local-->
        <script type="text/javascript" 
                src="<c:url value="/bootstrap-3.3.7/js/bootstrap.min.js"/>" defer>
        </script>
        <!--Archivo bootstrap.css local-->
        <link rel="stylesheet" href="<c:url value="/bootstrap-3.3.7/css/bootstrap.min.css"/>" />
        
        <!--font-awesome local-->
        <link rel="stylesheet" href="<c:url value="/css/font-awesome/css/font-awesome.min.css"/>"/>


        <title>Eliminar Perfil</title>
    </head>
    <body>
        
                <div class="container">
	<div class="row">
     <h2 class="titulo">¿Estas seguro de borrar tu perfil?</h2>
     
    <ul class="ds-btn">
        <form action="${pageContext.request.contextPath}/eliminarUsuario">
        <li>
          <button class="glyphicon glyphicon-user pull-left"><span>Si<br><small>¡Borraras tu perfil!</small></span></a> </button>
        </li>
        </form>
         <form action="${pageContext.request.contextPath}/cancelarEliminar">
        <li>
            
         <button class="glyphicon glyphicon-dashboard pull-left"><span>No<br><small>¡Seguiras con nosotros!</small></span></a></button> 
            
        </li>
    </form>
    </ul>
    
	</div>
</div>
    </body>
</html>










