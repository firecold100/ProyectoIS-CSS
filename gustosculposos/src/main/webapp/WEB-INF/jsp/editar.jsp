<%-- 
    Document   : actualizacion
    Created on : Oct 16, 2017, 3:17:43 PM
    Author     : Hector
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
        <script type="text/javascript" src="<c:url value="/js/profile.js" />" defer></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizacion</title>
    </head>
    
        <body>
        <div class="container">
            <div class="col-md-5">
                <div class="form-area">  
                    <form action="${pageContext.request.contextPath}/editarUsuario" method="POST">
                        <br style="clear:both">
                        <h3 style="margin-bottom: 25px; text-align: center;">Actualiza tus datos</h3>

                        <div class="form-group">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Name" value=${nombre}>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="paterno" name="paterno" placeholder="Apellido Paterno" value=${paterno}>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="materno" name="materno" placeholder="Apellido Materno" value=${materno} >
                        </div>

                        <div class="form-group">
                            <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Nombre de Usuario" value=${usuario} >
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="contrasena" name="contrasena" placeholder="Contrasena">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="confirmacion" name="confirm" placeholder="Confirmacion Contrasena" required>
                        </div>


                        <button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">Aceptar</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>

        <script src="js/actualizacion.js"></script>
    </body>



</html>