
<%-- 
    Document   : register
    Created on : 16-oct-2017, 15:38:07
    Author     : hectorsama
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
       <link rel="stylesheet" type="text/css" href="<c:url value="/css/eliminacion.css"/> ">
        <title>Confirmacion de Eliminacion</title>
    </head>
    <body>
        <div class="container">
	<div class="row">
     <h2 class="titulo">¿Estas seguro de borrar tu perfil?</h2>
     
    <ul class="ds-btn">
        <form action="/ProyectoIS-CSS/eliminarUsuario">
        <li>
          <button class="glyphicon glyphicon-user pull-left"><span>Si<br><small>¡Borraras tu perfil!</small></span></a> </button>
        </li>
        </form>
         <form action="/ProyectoIS-CSS/cancelarEliminar">
        <li>
            
         <button class="glyphicon glyphicon-dashboard pull-left"><span>No<br><small>¡Seguiras con nosotros!</small></span></a></button> 
            
        </li>
    </form>
    </ul>
    
	</div>
</div>
    </body>
</html>