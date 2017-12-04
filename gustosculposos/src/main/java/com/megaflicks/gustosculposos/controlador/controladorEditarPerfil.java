/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.gustosculposos.controlador;

import com.megaflicks.gustosculposos.mapeobd.Usuario;
import com.megaflicks.gustosculposos.modelo.GustosCulpososDAO;
import com.megaflicks.gustosculposos.modelo.UsuarioDAO;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hectorsama
 */
@Controller
public class controladorEditarPerfil {

    @Autowired
    UsuarioDAO Usuario_db;
    @Autowired
    GustosCulpososDAO Gustos_db;

   

    @RequestMapping(value = "/editar", method = RequestMethod.GET)
    public ModelAndView confirmacion(HttpServletRequest request, Principal principal, ModelMap model) {
        String usuario = principal.getName();
        Usuario us = Usuario_db.getUsuario(usuario);

        model.addAttribute("nombre_", us.getNombre());
        model.addAttribute("paterno", us.getApellido_p());
        model.addAttribute("materno", us.getApellido_m());
        model.addAttribute("alias_", us.getAlias());
        return new ModelAndView("editar", model);

    }
    
    
    
     @RequestMapping(value = "/editarUsuario", method = RequestMethod.POST)
    public String ingresar(HttpServletRequest request, Principal principal) {
        String usuario = principal.getName();

        String name = request.getParameter("usuario");
        String user = request.getParameter("name");
        String apellido_paterno = request.getParameter("paterno");
        String apellido_materno = request.getParameter("materno");
        String contrasenya = request.getParameter("contrasena");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(contrasenya);
        String passwordConf = request.getParameter("confirm");
        Usuario u = Usuario_db.getUsuario(user);

        Usuario us = Usuario_db.getUsuario(usuario);

        if (contrasenya.equals(passwordConf)) {
            if (name != null) {
                us.setAlias(name);
            }
            if (user != null) {
                us.setNombre(user);
            }
            if (apellido_paterno != null) {
                us.setApellido_p(apellido_paterno);
            }
            if (apellido_materno != null) {
                us.setApellido_m(apellido_materno);
            }
            if (contrasenya != null) {
                us.setContrasenya(hashedPassword);
            }
        } else {
            return "redirect:/editar";
        }

        Usuario_db.actualizar(us);

        return "redirect:/sesion/inicioU";

    }
}
