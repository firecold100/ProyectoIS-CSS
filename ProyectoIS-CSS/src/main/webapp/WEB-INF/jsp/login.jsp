<%-- 
    Document   : newjsp
    Created on : 18-oct-2017, 18:10:50
    Author     : hectorsama
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
    <head> 
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/> ">
        
           
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">


		<!-- Website CSS style -->
		<link href="css/bootstrap.min.css" rel="stylesheet">

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

		<title>Login</title>
	</head>
        <body>
            
                <script src="https://use.typekit.net/ayg4pcz.js"></script>
    <script>try{Typekit.load({ async: true });}catch(e){}</script>

    <div class="container">
    <h1 class="welcome text-center">GustosCulposos<br> Donde lo que te avergüenza, te conecta.</h1>
        <div class="card card-container">
        <h2 class='login_title text-center'>Ingresa</h2>
        <hr>

            <form class="form-signin" action="${pageContext.request.contextPath}/ingresar" method="post" >
                <span id="reauth-email" class="reauth-email"></span>
                <p class="input_title">Correo</p>
                <input type="text" id="cred" class="login_box" placeholder="user01@IceCode.com" required autofocus>
                <p class="input_title">Contraseña</p>
                <input type="password" id="contra" class="login_box" placeholder="******" required>
                <div id="remember" class="checkbox">
                    <label>
                        
                    </label>
                </div>
                <button class="btn btn-primary btn-lg btn-block" id="Login" type=""   >Login</button>
        </form><!-- /form -->
        <form action="${pageContext.request.contextPath}/registro" method="get" class="form-signin">
                 <button class="btn btn-secondary btn-lg btn-block" type="submit">Registrarse (si no tiene una cuenta)</button>
            </form>
                    
        

           
        </div><!-- /card-container -->
    </div><!-- /container -->
            
        </body>
        
        	
</html>
