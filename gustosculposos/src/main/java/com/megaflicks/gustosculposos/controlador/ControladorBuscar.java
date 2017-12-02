/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.gustosculposos.controlador;

import com.megaflicks.gustosculposos.mapeobd.Usuario;
import com.megaflicks.gustosculposos.modelo.UsuarioDAO;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author andres
 */
@Controller
public class ControladorBuscar {

    @Autowired
    UsuarioDAO Usuario_db;

    @RequestMapping(value = "/buscarUsuario", method = RequestMethod.GET)
    public String buscarUsuario(HttpServletRequest request, Principal principal) {
    

        return "buscar";

    }
    
    /*    @RequestMapping(value="/cancelarEliminar", method = RequestMethod.GET)
    public String cancelar(HttpServletRequest request, Principal principal){
        
        return "redirect:/sesion/inicioU";
}
    
        @RequestMapping(value="/confirmacionElimina", method = RequestMethod.GET)
    public String confirmacion(HttpServletRequest request, Principal principal){
        
        return "login";
}
    */
}
