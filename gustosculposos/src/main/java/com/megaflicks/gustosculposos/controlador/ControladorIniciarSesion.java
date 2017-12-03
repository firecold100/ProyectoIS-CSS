/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.gustosculposos.controlador;
import com.megaflicks.gustosculposos.mapeobd.GustosCulposos;
import com.megaflicks.gustosculposos.mapeobd.Usuario;
import com.megaflicks.gustosculposos.modelo.GustosCulpososDAO;
import com.megaflicks.gustosculposos.modelo.UsuarioDAO;
import java.security.Principal;
import java.util.List;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ControladorIniciarSesion {

    @Autowired
    UsuarioDAO Usuario_db;
    @Autowired
    GustosCulpososDAO Gustos_db;
    /**
        @RequestMapping(value="/iniciarsesion", method = RequestMethod.GET)
        public ModelAndView inicioSesion(HttpServletRequest request,ModelMap model){
            String url = "login";
            String id = request.getParameter("correo");
            String contrasenya_ingresada = request.getParameter("contrasenya");
            String contrasenya_correcta = "";
            Usuario usuario_actual = null;
            usuario_actual = Usuario_db.getUsuario(id);
            boolean pasa = false;
            if(usuario_actual != null){
                    usuario_actual = Usuario_db.getUsuario(id);
                     contrasenya_correcta = usuario_actual.getContrasenya();
                     pasa = Objects.equals(contrasenya_ingresada, contrasenya_correcta);
                    }
            if(pasa){
                model.addAttribute(usuario_actual);
                model.addAttribute("correo", id);
                model.addAttribute("nombre",usuario_actual.getNombre());
                url = "profile";
            }
            return new ModelAndView(url,model);
        } **/
    
    /*FUNCIONA

               @RequestMapping(value="/ingresar", method = RequestMethod.POST)
        public ModelAndView ingresar(HttpServletRequest request,ModelMap model){

            String url = "login";
            String id = request.getParameter("username");
            String contrasenya_ingresada = request.getParameter("password");
            String contrasenya_correcta = "";
            Usuario usuario_actual = null;
            usuario_actual = Usuario_db.getUsuario(id);
            boolean pasa = false;
            if(usuario_actual != null){
                    usuario_actual = Usuario_db.getUsuario(id);
                     contrasenya_correcta = usuario_actual.getContrasenya();
                     pasa = Objects.equals(contrasenya_ingresada, contrasenya_correcta);
                    }
            if(pasa){
                model.addAttribute(usuario_actual);
                model.addAttribute("correo", id);
                model.addAttribute("nombre",usuario_actual.getNombre());
               
                url = "profile";
            }
            return new ModelAndView(url,model);
        }
        
       @RequestMapping(value="/cerrarsesion", method = RequestMethod.GET)
    public ModelAndView fin(){
        return new ModelAndView( "login",new ModelMap ());
    }

*/
      @RequestMapping(value="/")
    public String inicio(HttpServletRequest request){
        if(request.isUserInRole("ROLE_ADMIN"))
            return "redirect:/sesion/inicioU";
        
        return "inicio";
}
    
     @RequestMapping(value="/login_error")
    public ModelAndView fallo(HttpServletRequest request,ModelMap model){
        if(request.isUserInRole("ROLE_ADMIN"))
            return new ModelAndView("redirect:/sesion/inicioU");
        
        return new ModelAndView("inicio",model);
}
    
        @RequestMapping(value="/sesion/inicioU", method = RequestMethod.GET)
    public ModelAndView inicioU(HttpServletRequest request,ModelMap model ,Principal principal){
        
        String u = principal.getName();
Usuario usuario = Usuario_db.getUsuario(u);
 model.addAttribute("username", u);
  model.addAttribute("correo", usuario.getCorreo());
model.addAttribute("contrasenya", usuario.getContrasenya());
return new ModelAndView("profile",model);
    
    
}
}
    
    
    
    

    
