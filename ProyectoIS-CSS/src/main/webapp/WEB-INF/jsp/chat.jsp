<%-- 
    Document   : chat
    Created on : 30/10/2017, 03:12:24 PM
    Author     : alan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        
        <!--Archivos jquery locales (Para escribir menos)-->
        <script type="text/javascript" src="<c:url value="/js/jquery-3.2.1.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/js/scripts.min.js"/>"></script>

        <!-- Archivos de Bootstrap locales -->
        <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/css/bootstrap-theme.min.css"/>">
        <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
      
        <!--Archivos css y javascript del chat.-->
        <link rel="stylesheet" href="<c:url value="/css/chat.css"/>">
        <script type="text/javascript" src="<c:url value ="/js/chat.js"/>"></script>
        <title>CHAT</title>
    </head>
    <body>
        <div class="col-sm-3 frame">
            <div >
                <ul class="pre-scrollable"></ul>
            </div>
            <div>
                <div class="msj-rta macro" style="margin:auto">                        
                    <div class="text text-r" style="background:whitesmoke !important">
                        <input id="textoTipeado" class="mytext" placeholder="Type a message"/>
                    </div> 
                </div>
            </div>
        </div>   
    </body>
</html>