/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.gustosculposos.modelo;

import com.megaflicks.gustosculposos.mapeobd.Usuario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author hectorsama
 */
public class UsuarioDAO {
    
    /*Sesion para conectarnos a la base de datos*/
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void guardar(Usuario usuario) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el usuario
            session.persist(usuario);
           
            tx.commit();
        }
        catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx!=null){ 
                tx.rollback();
            }
            e.printStackTrace(); 
        } finally {
            //cerramos simpre la sesion
            session.close();
        }
    }
        
        
            /**
     * Elimina el usuario de la base de datos
     * @param usuario el usuario a eliminar
     */
    public void eliminar(Usuario usuario) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //eliminamos el usuario
            session.delete(usuario);
           
            tx.commit();
        }
        catch (Exception e) {
            //Se regresa a un estado consistente 
            if (tx!=null){ 
                tx.rollback();
            }
            e.printStackTrace(); 
        }
        finally {
            //cerramos simpre la sesion
            session.close();
        }
    }
    
    
        /**
     * Regresa la lista de todos los usuarios en la base de datos
     * @return la lista que contiene a todos los usuarios de la base de datos
     */
    public List<Usuario> getUsuarios(){
        List<Usuario> result= null;
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            String hql= "FROM Usuario";
            Query query =session.createQuery(hql);
            result=(List<Usuario>)query.list();
            tx.commit();
        }catch (Exception e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();      
        }finally{
            session.close();
        }
        return result;
    }
    
    
       public Usuario getUsuario(String correo) {
        Usuario result = null;
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String hql = "FROM Usuario WHERE correo = :correo";                  
            Query query = s.createQuery(hql);
            query.setParameter("correo",correo);
            result = (Usuario)query.uniqueResult();
            tx.commit();
        }catch(Exception e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            s.close();
        }
        return result;
    }
       
     public Usuario loginUsuario(String correo, String contrasenya) {
        //correo.replace("'", "");
        //correo.replace("-", "");
        //correo.replace("/", "");
        //contrasenya.replace("'", "");
        //contrasenya.replace("-", "");
        //contrasenya.replace("/", "");
        Usuario result = null;
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String hql = "FROM Usuario WHERE correo = :correo AND  contrasenya = :contrasenya ";                  
            Query query = s.createQuery(hql);
            query.setParameter("correo",correo);
            query.setParameter("contrasenya",contrasenya);
            result = (Usuario)query.uniqueResult();
            tx.commit();
        }catch(Exception e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            s.close();
        }
        return result;
    }
         public boolean loginUsuarioBoolean(String correo, String contrasenya) {
        //correo.replace("'", "");
        //correo.replace("-", "");
        //correo.replace("/", "");
        //contrasenya.replace("'", "");
        //contrasenya.replace("-", "");
        //contrasenya.replace("/", "");
        boolean result = false;
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String hql = "FROM Usuario WHERE correo = :correo AND  contrasenya = :contrasenya ";                  
            Query query = s.createQuery(hql);
            query.setParameter("correo",correo);
            query.setParameter("contrasenya",contrasenya);
            Usuario u = (Usuario)query.uniqueResult();
            if(u.getCorreo().equalsIgnoreCase(correo))
                result = true;
            tx.commit();
        }catch(Exception e){
            if(tx != null)
                tx.rollback();
            e.printStackTrace();
        }finally{
            s.close();
        }
        return result;
    }
          
    
}
