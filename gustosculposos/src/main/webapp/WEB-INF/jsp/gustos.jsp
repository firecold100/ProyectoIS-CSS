<%-- 
    Document   : register
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
        <!-- Archivo de bootstrap local-->
        <script type="text/javascript"
                src="<c:url value="/bootstrap-3.3.7/js/bootstrap.min.js"/>" defer>
        </script>
        <!--Archivo bootstrap.css local-->
        <link rel="stylesheet" href="<c:url value="/bootstrap-3.3.7/css/bootstrap.min.css"/>" />

        <!--font-awesome local-->
        <link rel="stylesheet" href="<c:url value="/css/font-awesome/css/font-awesome.min.css"/>"/>

        <title>Gustos</title>
    </head>
    <body>
        <div class="container">
            <div class="row main">
                <div class="main-login main-center">
                    <h5>Tus gustos culposos son:</h5>
                    <form action="${pageContext.request.contextPath}/registrarGustos"  method="POST">
                        <!--<form class="" method="post" action="#">-->
                        <input type="text" value="${correo } " name="correo" />
                        <tag type="text" value="${correo } " name="correo" /> 
                        <div class="checkbox">
                            <label><input type="checkbox"  name="musica">Música</label>
                        </div>

                        <div class="checkbox">
                            <label><input type="checkbox" name="libros">Libros</label>
                        </div>

                        <div class="checkbox">
                            <label><input type="checkbox" name="peliculas">Películas</label>
                        </div>
                                              <div class="checkbox">
  <label><input type="checkbox" name="video">Video Juegos</label>
</div>
                        
                                                                      <div class="checkbox">
  <label><input type="checkbox" name="deportes">Deportes</label>
</div>



                        <div class="form-group ">
                            <button id="button"  class="btn btn-primary btn-lg btn-block login-button">Guardalos</button>
                        </div>


                    </form>
                </div>
            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>