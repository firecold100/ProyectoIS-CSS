<%-- 
    Document   : chat
    Created on : 2/12/2017, 01:37:41 AM
    Author     : alan
--%>

<!--Codificación de la página (default)-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Librería de etiquetas para manejar formularios(?)-->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!--Librería de etiquetas para manejar los "path's" de la aplicación.-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página del chat</title>
        <!-- Archivo jquery local-->
        <script type="text/javascript" 
                src="<c:url value="/jquery/jquery-3.2.1.min.js"/>" defer>
        </script>
        <!-- Archivo de bootstrap local-->
        <script type="text/javascript"
                src="<c:url value="/bootstrap-3.3.7/js/bootstrap.min.js"/>" defer>
        </script>
    </head>
    <body>
        <h1>Página del chat</h1>
    </body>
</html>
