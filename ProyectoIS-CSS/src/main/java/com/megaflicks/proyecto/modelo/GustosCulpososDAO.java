/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.proyecto.modelo;

import com.megaflicks.proyecto.mapeobd.GustosCulposos;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author hectorsama
 */
public class GustosCulpososDAO {
        private SessionFactory sessionFactory;
    
     public void guardar(GustosCulposos gusto) {
        //se inicia la sesion
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //guardamos el gusto
            session.persist(gusto);
           
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
     * Elimina el Gusto de la base de datos
     * @parammensaje el gusto a eliminar
     */
    public void eliminar(GustosCulposos gusto) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //eliminamos el gusto
            session.delete(gusto);
           
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
     * Actualiza el Gusto en la base de datos
     * @param gusto con los nuevos valores 
     */
    public void actualizar(GustosCulposos gusto) {
        Session session = sessionFactory.openSession();
        //la transaccion a relizar
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //actualizar el gusto
            session.update(gusto);
           
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
     * Regresa la lista de todos los Gustos en la base de datos
     * @return la lista que contiene a todos los gustos de la base de datos
     */
    public List<GustosCulposos> getGustos(){
        List<GustosCulposos> result= null;
        Session session = sessionFactory.openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            String hql= "FROM gustos";
            Query query =session.createQuery(hql);
            result=(List<GustosCulposos>)query.list();
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
    
    /**
     * Regresa el gusto con el id dado
     * @param id del gusto 
     * @return el gusto con ese id
     */
    public GustosCulposos getGusto(int id) {
        GustosCulposos result = null;
        Session s = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = s.beginTransaction();
            String hql = "FROM Gustos WHERE gustos_id = :id";                  
            Query query = s.createQuery(hql);
            query.setParameter("id",id);
            result = (GustosCulposos)query.uniqueResult();
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
