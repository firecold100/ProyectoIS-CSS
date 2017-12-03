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
        <!--Script para hacer que se parezca al chat de facebook-->
        <script type="text/javascript"
                src="<c:url value="/js/facebook-js-chat.js" />" defer>
        </script>
        <!-- Archivo CSS -->
        <link rel="stylesheet" href="<c:url value="/css/chat.css"/>"/>
        <!-- CSS de bootstrap -->
        <link rel="stylesheet" href="<c:url value="/bootstrap-3.3.7/css/bootstrap.min.css"/>"/>
        <!--font-awesome local-->
        <link rel="stylesheet" href="<c:url value="/css/font-awesome/css/font-awesome.min.css"/>"/>
    </head>
    <body>
        <h1>Página del chat</h1>
        <div class="chat-sidebar">
            <c:forEach var="usuario" items="${usuarios}">
                <div class="sidebar-name">
                    <!-- Pasa el id del usuario y el nombre a mostrar  -->
                    <a href="javascript:register_popup('${usuario.ID_USUARIO}', '${usuario.alias}');" >
                        <img width="30" height="30" src="<c:url value="/img/G_de_gustos_culposos.png" />" />
                        <span>${usuario.alias}</span>
                    </a>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
