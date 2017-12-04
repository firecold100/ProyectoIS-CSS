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

                <!--font-awesome local-->
                <link rel="stylesheet" href="<c:url value="/css/font-awesome/css/font-awesome.min.css"/>"/>
		
		<title>Login</title>
    </head>
    <body>
            <h1 class="welcome text-center">GustosCulposos<br> Donde lo que te avergüenza, te conecta.</h1>
            <script>try{Typekit.load({ async: true });}catch(e){}</script>
            
            <div class="container">

                <div class="card card-container">
                <h2 class='login_title text-center'>Ingresa</h2>
                <hr>

                  <!--   <form class="form-signin" action="${pageContext.request.contextPath}/iniciarsesion" method="GET" >
                        <span id="reauth-email" class="reauth-email"></span>
                        <p class="input_title">Correo</p>
                        <input type="text" id="correo" class="login_box" placeholder="tupapa@pornodegalletas.com" required autofocus>
                        <p class="input_title">Contraseña</p>
                        <input type="password" id="contrasenya" class="login_box" placeholder="******" required>
                        <div id="remember" class="checkbox">
                            <label>

                            </label>
                        </div>
                        <button class="btn btn-primary btn-lg btn-block" id="Login" type=""   >Login</button>
                </form>/form -->
                <div class="login">
                 <form action="${pageContext.request.contextPath}/login" method="POST" class="login-form">
              <p><input type="text" name="username" value="" placeholder="Correo"></p>
              <p><input type="password" name="password" value="" placeholder="Contraseña"></p>
              <p class="remember_me">
                <label>
                  <input type="checkbox" name="remember_me" id="remember_me">
                 ¡No me olvides!
                </label>

              </p>
              <button class="btn btn-primary tn-lg btn-block" id="Login" type="" style="width: 100%">       Login        </button>
              <!--<p class="submit"><input type="submit" name="commit" value="Login"></p>-->

            </form>
              </div>





                <form action="${pageContext.request.contextPath}/registro"   class="form-signin">
                         <button class="btn btn-secondary btn-lg btn-block" type="submit">Registrarse (si no tiene una cuenta)</button>
                    </form>


                </div><!-- /card-container -->
                <div id="word-cloud"></div>

            </div><!-- /container -->
            
    </body>
        
        	
</html>
<script>
    /*  ======================= SETUP ======================= */
    var config = {
        trace: true,
        spiralResolution: 1, //Lower = better resolution
        spiralLimit: 360 * 5,
        lineHeight: 0.8,
        xWordPadding: 0,
        yWordPadding: 3,
        font: "sans-serif"
    }

    var words = ["musica", "comer fritangas", "videojuegos", "deportes", "Películas", "Libros", "caligrafía", "buscar faltas de ortografía", "wikipediar", "zapatos", "correr en circulos", "drogas", "irle al america"].map(function(word) {
        return {
            word: word,
            freq: Math.floor(Math.random() * 50) + 10
        }
    })

    words.sort(function(a, b) {
        return -1 * (a.freq - b.freq);
    });

    var cloud = document.getElementById("word-cloud");
    cloud.style.position = "relative";
    cloud.style.fontFamily = config.font;

    var traceCanvas = document.createElement("canvas");
    traceCanvas.width = cloud.offsetWidth;
    traceCanvas.height = cloud.offsetHeight;
    var traceCanvasCtx = traceCanvas.getContext("2d");
    cloud.appendChild(traceCanvas);

    var startPoint = {
        x: cloud.offsetWidth / 2,
        y: cloud.offsetHeight / 2
    };

    var wordsDown = [];
    /* ======================= END SETUP ======================= */





    /* =======================  PLACEMENT FUNCTIONS =======================  */
    function createWordObject(word, freq) {
        var wordContainer = document.createElement("div");
        wordContainer.style.position = "absolute";
        wordContainer.style.fontSize = freq + "px";
        wordContainer.style.lineHeight = config.lineHeight;
    /*    wordContainer.style.transform = "translateX(-50%) translateY(-50%)";*/
        wordContainer.appendChild(document.createTextNode(word));

        return wordContainer;
    }

    function placeWord(word, x, y) {

        cloud.appendChild(word);
        word.style.left = x - word.offsetWidth/2 + "px";
        word.style.top = y - word.offsetHeight/2 + "px";

        wordsDown.push(word.getBoundingClientRect());
    }

    function trace(x, y) {
    //     traceCanvasCtx.lineTo(x, y);
    //     traceCanvasCtx.stroke();
        traceCanvasCtx.fillRect(x, y, 1, 1);
    }

    function spiral(i, callback) {
        angle = config.spiralResolution * i;
        x = (1 + angle) * Math.cos(angle);
        y = (1 + angle) * Math.sin(angle);
        return callback ? callback() : null;
    }

    function intersect(word, x, y) {
        cloud.appendChild(word);    

        word.style.left = x - word.offsetWidth/2 + "px";
        word.style.top = y - word.offsetHeight/2 + "px";

        var currentWord = word.getBoundingClientRect();

        cloud.removeChild(word);

        for(var i = 0; i < wordsDown.length; i+=1){
            var comparisonWord = wordsDown[i];

            if(!(currentWord.right + config.xWordPadding < comparisonWord.left - config.xWordPadding ||
                 currentWord.left - config.xWordPadding > comparisonWord.right + config.wXordPadding ||
                 currentWord.bottom + config.yWordPadding < comparisonWord.top - config.yWordPadding ||
                 currentWord.top - config.yWordPadding > comparisonWord.bottom + config.yWordPadding)){

                return true;
            }
        }

        return false;
    }
    /* =======================  END PLACEMENT FUNCTIONS =======================  */





    /* =======================  LETS GO! =======================  */
    (function placeWords() {
        for (var i = 0; i < words.length; i += 1) {

            var word = createWordObject(words[i].word, words[i].freq);

            for (var j = 0; j < config.spiralLimit; j++) {
                //If the spiral function returns true, we've placed the word down and can break from the j loop
                if (spiral(j, function() {
                        if (!intersect(word, startPoint.x + x, startPoint.y + y)) {
                            placeWord(word, startPoint.x + x, startPoint.y + y);
                            return true;
                        }
                    })) {
                    break;
                }
            }
        }
    })();
    /* ======================= WHEW. THAT WAS FUN. We should do that again sometime ... ======================= */



    /* =======================  Draw the placement spiral if trace lines is on ======================= */
    (function traceSpiral() {

        traceCanvasCtx.beginPath();

        if (config.trace) {
            var frame = 1;

            function animate() {
                spiral(frame, function() {
                    trace(startPoint.x + x, startPoint.y + y);
                });

                frame += 1;

                if (frame < config.spiralLimit) {
                    window.requestAnimationFrame(animate);
                }
            }

            animate();
        }
    })();
</script>