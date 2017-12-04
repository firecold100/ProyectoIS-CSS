/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @file chat.js
 * @author Alan Moreno de la Rosa
 * @version 1.0 07/12/2017
 */

/**
 *  Función que carga cuando el DOM se encuentra completamente cargado y listo
 */
$(document).ready(function(){

//Función que agarra el texto tipeado u lo inserta en el chat localmente sin guardarlo en la base de datos.
$("#textoTipeado").keypress( function(e){
    console.log("chat-box-js.js");
    if (e.which === 13){
        var text = $(this).val();
        if (text !== ""){
            insertChat("me", text);              
            $(this).val('');
        }
    }
});
        
});

/**
 * Función que regresa la hora formateada para el mensaje.
 * @param {type} date El objeto que contiene la fecha de hoy
 * @return {String} Una cadena con la fecha formateada
 */
function formatAMPM(date) {
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var ampm = hours >= 12 ? 'PM' : 'AM';
    hours = hours % 12;
    hours = hours ? hours : 12; // the hour '0' should be '12'
    minutes = minutes < 10 ? '0'+minutes : minutes;
    var strTime = hours + ':' + minutes + ' ' + ampm;
    return strTime;
}            

//-- No use time. It is a javaScript effect.

function insertChat(who, text, idUl, time = 0){
    var control = "";
    var date = formatAMPM(new Date());
    var loc = $(location).attr('host');
    
    if (who === "me"){
        
        control = '<li style="width:100%">' +
                        '<div class="msj macro">' +
                        '<div class="avatar"><img class="img-circle" style="width:100%;" src="http://'+loc+'/gustosculposos/img/avatar.png" /></div>' +
                            '<div class="text text-l">' +
                                '<p>'+ text +'</p>' +
                                '<p><small>'+date+'</small></p>' +
                            '</div>' +
                        '</div>' +
                    '</li>';                    
    }else{
        control = '<li style="width:100%;">' +
                        '<div class="msj-rta macro">' +
                            '<div class="text text-r">' +
                                '<p>'+text+'</p>' +
                                '<p><small>'+date+'</small></p>' +
                            '</div>' +
                        '<div class="avatar" style="padding:0px 0px 0px 10px !important"><img class="img-circle" style="width:100%;" src="http://'+loc+'/gustosculposos/img/avatar.png" /></div>' +                                
                  '</li>';
    }
    setTimeout(
        function(){                        
            $("#"+idUl).append(control);

        }, time);
    
}

function resetChat(){
    $("ul").empty();
}



//-- Clear Chat
resetChat();

//-- Print Messages
/*
insertChat("me", "Hello Tom...", 0);  
insertChat("you", "Hi, Pablo", 1500);
insertChat("me", "What would you like to talk about today?", 3500);
insertChat("you", "Tell me a joke",7000);
insertChat("me", "Spaceman: Computer! Computer! Do we bring battery?!", 9500);
insertChat("you", "LOL", 12000);
*/

//-- NOTE: No use time on insertChat.


