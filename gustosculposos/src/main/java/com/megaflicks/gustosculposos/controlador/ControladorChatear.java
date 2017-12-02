/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.gustosculposos.controlador;

import com.megaflicks.gustosculposos.modelo.MensajesDAO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Clase ControladorChatear.java.
 * Clase que se comunica con la base de datos (MensajesDAO) y que recibe las peticiones
 * del Usuario.
 * @author Alan Moreno de la Rosa
 * @version 29/noviembre/2017 1.0
 */
@Controller
public class ControladorChatear {
    /** Objeto que nos sirve para comunicarnos con la base de datos. Declarado en applicationContext.xml */
    @Autowired
    MensajesDAO mensajes_db;
    
    /**
     * Método chat.
     * Método que hace un mapeo para mostrar la página de chatear en la
     * ruta especificada.
     * @param request La petición enviada al servidor.
     * @return Un objeto ModelAndView con el nombre del jsp y el modelo.
     */
    @RequestMapping(value="/chat", method = RequestMethod.GET)
    public ModelAndView chat(HttpServletRequest request){
        ModelMap model = new ModelMap(); 
        return new ModelAndView("chat",model);
    }
    
    /**
     *  Método guardaMensaje.
     *  Método que registra guarda el mensaje de un usuario en la base de datos.
     * Se comunica a través de un JSON.
     * @param request Solicitud http mandada por el usuario desde el navegador.
     */
    @RequestMapping(value="/guardaMensaje", method = RequestMethod.POST,
                                        produces = MediaType.APPLICATION_JSON_VALUE, 
                                        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView guardaMensaje(HttpServletRequest request){
        return null;
    }
    
}
