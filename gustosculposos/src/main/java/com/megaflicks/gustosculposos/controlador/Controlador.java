/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.gustosculposos.controlador;



import com.megaflicks.gustosculposos.mapeobd.Usuario;
import com.megaflicks.gustosculposos.mapeobd.GustosCulposos;
import com.megaflicks.gustosculposos.modelo.GustosCulpososDAO;
import com.megaflicks.gustosculposos.modelo.UsuarioDAO;
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
       @Autowired
    GustosCulpososDAO Gustos_db;
  
     
    @RequestMapping(value="/registrar", method = RequestMethod.POST)   
    public ModelAndView guardarUsuario(HttpServletRequest request) {
    //System.out.println(request.getParameter("ID_USUARIO"));

        //int id= Integer.parseInt(request.getParameter("ID_USUARIO"));
        //System.out.println(id);
        String alias = request.getParameter("alias");
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String apellido_p = request.getParameter("apellido_p");
        String apellido_m = request.getParameter("apellido_m");
        String contrasenya = request.getParameter("contrasenya");
        String sexo = request.getParameter("sexo");
        // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // String hashedPassword = passwordEncoder.encode(contrasenya);

        Usuario u = null;
        // u = usuario_bd.getUsuario(id);
        if (u == null) {
            u = new Usuario();
            u.setAlias(alias);
            u.setNombre(nombre);
            u.setApellido_p(apellido_p);
            u.setApellido_m(apellido_m);
            u.setContrasenya(contrasenya);
            u.setCorreo(correo);
            u.setSexo(sexo);

            usuario_bd.guardar(u);
        }
       ModelMap model = new ModelMap(); 
       model.addAttribute("correo", u.getCorreo());
       
       model.addAttribute("correo", correo);
        // return "profile";
        return new ModelAndView("gustos", model);
    }
    
    @RequestMapping(value = "/registrarGustos", method = RequestMethod.POST)
    public ModelAndView registraGustos(HttpServletRequest request,ModelMap model) {
        String id = request.getParameter("correo");
        System.out.println(id);
        Usuario us = usuario_bd.getUsuario(id);
        String musica = request.getParameter("musica");
        String libro = request.getParameter("libros");
        String pelicula = request.getParameter("peliculas");
        String videojuegos = request.getParameter("video");
        String sports = request.getParameter("deportes");
       
        if (musica != null && musica.equals("on")) {
            GustosCulposos  g = new GustosCulposos();
            g.setGusto("Musica");
            g.setID_USUARIO(us);
            Gustos_db.guardar(g);
        }
        
          if (libro != null && libro.equals("on")) {
            GustosCulposos  g2 = new GustosCulposos();
            g2.setGusto("Libros");
            g2.setID_USUARIO(us);
            Gustos_db.guardar(g2);
        }
          
          if (pelicula != null && pelicula.equals("on")) {
            GustosCulposos  g3= new GustosCulposos();
            g3.setGusto("Peliculas");
            g3.setID_USUARIO(us);
            Gustos_db.guardar(g3);
        }
          if (videojuegos != null && videojuegos.equals("on")) {
            GustosCulposos  g4= new GustosCulposos();
            g4.setGusto("Videojuegos");
            g4.setID_USUARIO(us);
            Gustos_db.guardar(g4);
        }
          if (sports != null && sports.equals("on")) {
            GustosCulposos  g5= new GustosCulposos();
            g5.setGusto("Deportes");
            g5.setID_USUARIO(us);
            Gustos_db.guardar(g5);
        }



        return new ModelAndView("profile", model);
    }
    
     //punto de inicio de la aplicación en general
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String inicio(){
        return "login";
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
