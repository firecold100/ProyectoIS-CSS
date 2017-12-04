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

    @RequestMapping(value = "/editarperfil", method = RequestMethod.GET)
    public String ingresar(HttpServletRequest request, Principal principal) {
        String usuario = principal.getName();

        String name = request.getParameter("alias");
        String user = request.getParameter("nombre");
        String lastnameP = request.getParameter("apellido_p");
        String lastnameM = request.getParameter("apellido_m");
        String mail = request.getParameter("correo");
        String password = request.getParameter("contrasenya");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        String passwordConf = request.getParameter("confirm");
        Usuario u = Usuario_db.getUsuario(user);

        Usuario us = Usuario_db.getUsuario(usuario);

        if (password.equals(passwordConf)) {
            if (name != null) {
                us.setAlias(name);
            }
            if (user != null) {
                us.setNombre(user);
            }
            if (lastnameP != null) {
                us.setApellido_p(lastnameP);
            }
            if (lastnameM != null) {
                us.setApellido_m(lastnameM);
            }
            if (mail != null) {
                us.setCorreo(mail);
            }
            if (password != null) {
                us.setContrasenya(hashedPassword);
            }
            } else {
                return "redirect:/actualizarP";
            }

            Usuario_db.actualizar(us);

            return "redirect:/sesion/inicioU";

        }
    
}
