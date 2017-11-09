/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.gustosculposos.controlador;
import com.megaflicks.gustosculposos.mapeobd.Usuario;
import com.megaflicks.gustosculposos.modelo.GustosCulpososDAO;
import com.megaflicks.gustosculposos.modelo.UsuarioDAO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author unjordi
 */
@Controller
public class controladorEditarPerfil {
     @Autowired
    UsuarioDAO Usuario_db;
    @Autowired
    GustosCulpososDAO Gustos_db;
    
       @RequestMapping(value="/editarperfil", method = RequestMethod.POST)
        public ModelAndView ingresar(HttpServletRequest request,ModelMap model){
            String id = (String) model.get("correo");
         Usuario usuario_actual = Usuario_db.getUsuario(id);
            boolean pasa = false;
            if(usuario_actual != null){
                model.addAttribute(usuario_actual);
                model.addAttribute("correo", id);
                model.addAttribute("nombre",usuario_actual.getNombre());
            }
            return new ModelAndView("editar",model);
        }
}
