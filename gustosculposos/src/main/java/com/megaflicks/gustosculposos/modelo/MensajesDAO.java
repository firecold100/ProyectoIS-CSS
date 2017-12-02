/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.gustosculposos.modelo;

import com.megaflicks.gustosculposos.mapeobd.Mensajes;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Clase Mensajes DAO.
 * Clase que se comunica con la base de datos implementada en MySQL
 * utilizando los objetos de la clase Mensajes.java 
 * @author Alan Moreno de la Rosa.
 */
public class MensajesDAO {
    
    /** Objeto que crea una sesión para conectarse con la base de datos.*/
    private SessionFactory sessionFactory;
    
    /**
     * Método getSessionFactory.
     * Método que regresa al objeto de tipo SessionFactory.
     * ***Necesario que el nombre sea tal cual getSessionFactory***
     * @return Un objeto de tipo SessionFactory con la información.
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    /**
     * Método setSessionFactory.
     * Método que asigna una nueva sesión con la base de datos.
     * ***Necesario que el nombre sea tal cual setSessionFactory***
     * @param sessionFactory La nueva sesión a ser asignada.
     */
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    /**
     * Método guardar.
     * Método que guarda un mensaje en la base de datos.
     * @param mensaje El mensaje a guardar en la base de datos.
     */
    public void guardar(Mensajes mensaje){
        Session session = sessionFactory.openSession(); //Creamos una nueva sesión con la base de datos.
        Transaction tx = null; // La transacción a realizar.
        try{
            tx = session.beginTransaction(); //Empezamos la transacción
            session.persist(mensaje); //Guardamos el mensaje
            tx.commit(); // Acabamos "commieteandolo".
        } catch(Exception e){
            //Si no se pudo actualizar, se hace un rollback
            if(tx != null){
                    tx.rollback(); //Regresamos a un estádo consistente la base de datos.
            }
            e.printStackTrace(); //Pintamos el error en terminal.
        } finally {
            session.close(); //Si acabamos con éxito, cerramos sesión.
        }
    }
    
    /**
     * Método eliminar.
     * Método que elimina un mensaje de la base de datos.
     * @param mensaje El mensaje que se desea eliminar.
     */
    public void eliminar(Mensajes mensaje){
        Session session = sessionFactory.openSession(); //Abrimos la sessión con la base de datos.
        Transaction tx = null; //La transacción a realizar.
        try{
            tx = session.beginTransaction(); //Iniciamos la transacción
            session.delete(mensaje); //Borramos el mensaje.
            tx.commit();// Commiteamos en la base de datos.
        } catch(Exception e){
            if(tx !=  null){ //La transacción no es nula pero se creo una excepción!
                tx.rollback(); //Hacemos un rollback, y regresamos a un estádo consistente.
            } 
        } finally {
            //Cerramos la sesión con la base de datos.
            session.close();
        }
    }
    
    /**
     * Método getMensajes.
     * Método que regresa la lista de todos los mensajes
     * contenidos en la base de datos.
     * @return Una lista de mensajes con la información.
     */
    public List<Mensajes> getMensajes(){
        List<Mensajes> resultado = null; //Lista de mensajes a regresar.
        Session session = sessionFactory.openSession(); //Abrimos la sesión con la base de datos.
        Transaction tx = null; //Nuestra transacción.
        try{
            tx = session.beginTransaction(); //Iniciamos la transacción
            String hql = "FROM Mensajes"; //Obtenemos todo mediante una consulta con el dialecto de hibernate
            Query query = session.createQuery(hql);
            resultado = (List<Mensajes>) query.list();
            tx.commit();
        } catch(Exception e){
                if(tx != null){
                        tx.rollback();
                        e.printStackTrace();
                }
        } finally{
            session.close();
        }
        return resultado;
    }
    
    /**
     *  Método getMensajes(idUsuarioEmisor, idUsuarioReceptor).
     *  Método que regresa los mensajes tales que el id emisor y receptor
     *  coincidan.
     *  @param idUsuarioEmisor El id del usuario que emitió el mensaje.
     *  @param idUsuarioReceptor El id del usuario que recibió el mensaje.
     *  @return Una lista con los mensajes enviados
     */
    public List<Mensajes> getMensajes(int idUsuarioEmisor, int idUsuarioReceptor){
        List<Mensajes> resultado = null;
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM Mensajes WHERE idUsuario1.ID_USUARIO = :emisor AND idUsuario2.ID_USUARIO = :receptor ";
            Query query = session.createQuery(hql);
            query.setParameter("emisor",idUsuarioEmisor);
            query.setParameter("receptor",idUsuarioReceptor);
            resultado = (List<Mensajes>)query.list();
            tx.commit();
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
                e.printStackTrace();
            } 
        } finally {
                session.close();
         }
        return resultado;
    }
    
    /**
     * Método getConversation.
     * Método que regresa todos los mensajes de una conversación entre dos usuarios ordenados
     * de manera cronológica.
     * @param usuario1 El primer usuario.
     * @param usuario2 El segundo usuario.
     * @return Una lista de mensajes con la información
     */
    public List<Mensajes> getConversation(int usuario1, int usuario2){
        List<Mensajes> enviadosPorU1 = getMensajes(usuario1,usuario2);
        List<Mensajes> enviadosPorU2 = getMensajes(usuario2,usuario1);
        enviadosPorU1.addAll(enviadosPorU2);
        Collections.sort(enviadosPorU1);
        return enviadosPorU1;
    }
    
}
