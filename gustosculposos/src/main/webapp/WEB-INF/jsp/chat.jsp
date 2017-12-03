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
    <!--Inicia pegado de código -->
        <div class="chat-sidebar">
            <div class="sidebar-name">
                <!-- Pass username and display name to register popup -->
                <a href="javascript:register_popup('narayan-prusty', 'Narayan Prusty');">
                    <img width="30" height="30" src="<c:url value="/img/G_de_gustos_culposos.png" />" />
                    <span>Narayan Prusty</span>
                </a>
            </div>
            <div class="sidebar-name">
                <a href="javascript:register_popup('qnimate', 'QNimate');">
                    <img width="30" height="30" src="<c:url value="/img/G_de_gustos_culposos.png" />" />
                    <span>QNimate</span>
                </a>
            </div>
            <div class="sidebar-name">
                <a href="javascript:register_popup('qscutter', 'QScutter');">
                    <img width="30" height="30" src="<c:url value="/img/G_de_gustos_culposos.png" />" />
                    <span>QScutter</span>
                </a>
            </div>
            <div class="sidebar-name">
                <a href="javascript:register_popup('qidea', 'QIdea');">
                    <img width="30" height="30" src="<c:url value="/img/G_de_gustos_culposos.png" />" />
                    <span>QIdea</span>
                </a>
            </div>
            <div class="sidebar-name">
                <a href="javascript:register_popup('qazy', 'QAzy');">
                    <img width="30" height="30" src="<c:url value="/img/G_de_gustos_culposos.png" />" />
                    <span>QAzy</span>
                </a>
            </div>
            <div class="sidebar-name">
                <a href="javascript:register_popup('qblock', 'QBlock');">
                    <img width="30" height="30" src="<c:url value="/img/G_de_gustos_culposos.png" />"/>
                    <span>QBlock</span>
                </a>
            </div>
        </div>
    <!-- Termina pegado de código -->
    </body>
</html>
