/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.proyecto.controlador;



import com.megaflicks.proyecto.mapeobd.Usuario;
import com.megaflicks.proyecto.modelo.UsuarioDAO;
import java.util.Date;
import java.util.List;
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
 
@Controller
public class Controlador {
    
     @RequestMapping(value="/", method = RequestMethod.GET)
    public String usuario(ModelMap model){
        return "profile"; 
    
    }
     */
    
    
     /*Injectamos el modelo del usuario se autoinicializa*/
    
        /**
     * Regresa la pagina principal con los usuarios de la base de datos
     * @param model 
     * @return regresa el modelo 
     */
@Controller
public class Controlador {
     @Autowired
    private UsuarioDAO usuario_bd;
     
    @RequestMapping(value="/registrar", method = RequestMethod.GET)   
    public String guardarUsuario(HttpServletRequest request){
    String alias=request.getParameter("alias");
    String nombre=request.getParameter("nombre");
    String correo=request.getParameter("correo");
    String apellido_p=request.getParameter("apellido_p");
    String apellido_m =request.getParameter("apellido_m");
    String contrasenya=request.getParameter("contrasenya");
    String sexo = request.getParameter("sexo");
    Usuario u = null;
    u=usuario_bd.getUsuario(correo);
    if(u==null){
    u= new Usuario();
    u.setAlias(alias);
    u.setNombre(nombre);
    u.setApellido_p(apellido_p);
    u.setApellido_m(apellido_m);
    u.setContrasenya(contrasenya);
    u.setCorreo(correo);
    u.setSexo(sexo);
   
    usuario_bd.guardar(u);
    }
    return "login";
    }
    
    
    @RequestMapping(value="/delete", method = RequestMethod.POST)   
    public String eliminarUsuario(HttpServletRequest request){
    
        //usuario_bd.eliminar(usuario);
        return "register";
    }
    

     //punto de inicio de la aplicación en general
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String inicio(){
    return "login";
    }
    
    @RequestMapping(value="/ingresar", method = RequestMethod.POST)
    public String ingresoPOST(HttpServletRequest request){
        String url = "";
         String cred=request.getParameter("cred");
         String contra=request.getParameter("contra");
        //if(usuario_bd.loginUsuarioBoolean(cred, contra)) {
         if(1==1){
             url= "profile";
            }else{
             url = "login";
            }
         return url;
    }
    
    @RequestMapping(value="/perfil", method = RequestMethod.GET)
    public String perfilGet(){
    return "profile";
    }
    
    @RequestMapping(value="/registro", method = RequestMethod.GET)
    public String registroGET(){
    return "register";
    }
    @RequestMapping(value="/inicioregister", method = RequestMethod.GET)
    public ModelAndView usuario(ModelMap model){
        List<Usuario> user = usuario_bd.getUsuarios();
          
        model.addAttribute("usuarios", user);
        
        return new ModelAndView("register",model);
    }
  
   
}
