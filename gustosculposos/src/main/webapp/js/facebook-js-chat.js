/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Basado en el documento encontrado en:
 * http://qnimate.com/facebook-style-chat-box-popup-using-javascript-and-css/
 * @file facebook-js-chat.js
 * @author Alan Moreno de la Rosa
 * @version 1.0 07/12/2017
 */

/**
 *  Función que carga cuando el DOM se encuentra completamente cargado y listo
 */
$(document).ready(function(){
    //Recalculamos la variable total_popups cuando redimensiona 
    // y carga la ventana del navegador.
    window.addEventListener("resize", calculate_popups);
    window.addEventListener("load", calculate_popups);
});

/**
 * Función remove implementada de Array.
 * Remueve objetos almacenados en el arreglo
 * @param {Array} array El arreglo con el cual trabajamos
 * @param {Number} from Indice que indica de donde empieza el remover
 * @param {Number} to Indice que indica en donde acaba el remover
 * @return {Array} El arreglo con los nuevos elementos
 */
Array.remove = function(array, from, to){
    // La notación "||" se ocupa para cuando uno u otro entero no están 
    // definidos
    var rest = array.slice(( to || from) + 1 || array.length); //Partimos el arreglo en dos
    array.length = from < 0 ? array.length + from : from; //Redimensionamos el arreglo
    return array.push.apply(array,rest); //Regresamos el arreglo junto con el resto
};

// 
/**
 * Esta variable representa el número de popups (ventanas de chat)
 * que puede ser mostadas de acuerdo al ancho del viewport
 * @type {Number} Total de popups.
 */
var total_popups = 0;

/**
 * Arreglo de popups (ventanas de chat)
 * @type {Array} Arreglo con todos los popups
 */
var popups = [];

/**
 * Función que cierra un popup de acuerdo a su id
 * @param {Number} id El id del popup a cerrar.
 */
function close_popup(id){
    for(var i = 0; i < popups.length; i++){
        if(id === popups[i]){
            Array.remove(popups,i);
            document.getElementById(id).style.display = "none";
            calculate_popups();
            return;
        }
    }
}

/**
 * Función que muestra los popups basada en el número máximo de
 * pupups que pueden ser mostrados.
 */
function display_popups(){
    var right = 220;
    var i = 0;
    for(i; i < total_popups; i++){ //Mostramos a los que contienen algo
        if(popups[i] !== undefined){ //Si el i'esmo popup está definido entonces..
            var elemento = document.getElementById(popups[i]);
            elemento.style.right = right + "px";
            right = right + 320;
            elemento.style.display = "block";
        }
    }
    for(var j = i; j < popups.length; j++){ //Ocultamos a los demás
        var elemento = document.getElementById(popups[j]);
        elemento.style.display = "none";
    }
}

/**
 * Método que registra en el arreglo de popups un popup.
 * Inyecta código html al documento activo.
 * @param {type} id El id del popup
 * @param {type} name El nombre que aparecerá en el popup
 * @return {undefined}
 */
function register_popup(id, name){
    for(var i = 0; i < popups.length; i++){
        if(id === popups[i]){ //Si ya está registrado, lo traemos al frente
            Array.remove(popups,i); //Lo eliminamos del arreglo
            popups.unshift(id); //Lo agregamos al inicio del arreglo
            calculate_popups(); //Calculamos los popups
            return;
        }
    }
    // Si no está registrado, creamos un nuevo elemento.
    var element = '<div class="popup-box chat-popup" id="'+ id +'">';
                element += '<div class="popup-head">';
                element += '<div class="popup-head-left">'+ name +'</div>';
                element += '<div class="popup-head-right"><a href="javascript:close_popup(\''+ id +'\');">&#10005;</a></div>'; //El link es el tache
                element += '<div style="clear: both"></div></div><div class="popup-messages">'+getChatBox()+'</div></div>';
                
    
    //Ponemos el elementos la etiquega body. Esto no está tan bien en general pero es para probar
    document.getElementsByTagName("body")[0].innerHTML = document.getElementsByTagName("body")[0].innerHTML + element;
    assignFunction("textoTipeado");
    popups.unshift(id); //Ponemos el id al inicio del arreglo.
    calculate_popups(); //Calculamos los popups.
}

/**
 * Función que calcula el número de popups que caben y después
 * asigna la variable total_popups.
 */
function calculate_popups(){
    var width = window.innerWidth; //El ancho del interior de la ventana.
    if(width < 540){ //Si el ancho es menor a 540 entonces 0 popups se muestran.
        total_popups = 0;
    }else{
        width -= 200;
        //320 es el ancho de un popup solito
        total_popups = parseInt(width/320);
    }
    display_popups();
}

/**
 * Función que regresa un div chat-box (cadena html) para agregar dentro de 
 * popup-messages.
 * @return {String} Una cadena con el div
 */
function getChatBox(){
    var box ='<div id="chat-box" class="frame">'
            +'<div>'
                +'<ul id="mensajes"></ul><!--Lista desordenada de mensajes-->'
            +'</div>'
            +'<div>'
                +'<div class="msj-rta macro" style="margin:auto">'
                    +'<div class="text text-r" style="background:whitesmoke !important">'
                        +'<input id="textoTipeado" class="mytext" placeholder="Type a message"/>'
                    +'</div>'
                +'</div>'
            +'</div>'
        +'</div>';
    return box;
}

/**
 * Función que asigna al elemento con id determinado
 * un "escucha" para que pueda ingresar los mensajes a la ventana de chat.
 * Agarra el texto y "lo envía"
 * @param {type} id
 */
function assignFunction(id){
$("#"+id).keypress( function(e){
    if (e.which === 13){ //Si la tecla que presionó es "enter" entonces...
        var text = $(this).val(); //Obtenemos el texto
        if (text !== ""){ //Si el texto no es vacío
            insertChat("me", text);// Insertamos en el chat
            $(this).val(''); //Borramos lo que el usuario escribió
        }
    }
});
}