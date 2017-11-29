/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.gustosculposos.mapeobd;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Clase que representa a la tabla mensajes en la base de datos.
 * @author Alan Moreno de la Rosa
 * @version  28/noviembre/2017 1.0
 */
@Entity
@Table(name= "mensajes")
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m")
    , @NamedQuery(name = "Mensajes.findByIdMensaje", query = "SELECT m FROM Mensajes m WHERE m.idMensaje = :idMensaje")
    , @NamedQuery(name = "Mensajes.findByMensaje", query = "SELECT m FROM Mensajes m WHERE m.mensaje = :mensaje")
    , @NamedQuery(name = "Mensajes.findByFEnvio", query = "SELECT m FROM Mensajes m WHERE m.fEnvio = :fEnvio")})
public class Mensajes implements Serializable, Comparable<Mensajes> {
    
    private static final long serialVersionUID = 1L;
    
    /** Entero que representa el Id del mensaje */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID_MENSAJE")
    private Integer idMensaje;
    
    /** Cadena que representa el mensaje escrito*/
    @NotNull
    @Size(min = 1, max = 250)
    @Column( name = "mensaje")
    private String mensaje;
    
    /** Fecha en la que fue enviado el mensaje */
    @Basic(optional = false)
    @NotNull
    @Column(name= "f_envio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fEnvio;
    
    /** Id del usuario emisor del mensaje */
    @JoinColumn(name = "ID_USUARIO1", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false) 
    private Usuario idUsuario1;
    
    /** Id del usuario receptor del mensaje */
    @JoinColumn(name = "ID_USUARIO2", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false) 
    private Usuario idUsuario2;
    
    /**
     *  Constructor por omisión.
     *  Construye un objeto mensajes vacío.
     */
    public Mensajes() {
    }

    /**
     * Constructor de clase.
     * Construye un objeto Mensajes con el id asignado.
     * @param idMensaje El id del mensaje
     */
    public Mensajes(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    /**
     * Constructor de clase.
     * Construye un mensaje con el id, el mensaje y la fecha de envío.
     * @param idMensaje El id del mensaje.
     * @param mensaje Cadena que contiene el mensaje.
     * @param fEnvio Objeto Date que representa la fecha de envio del mensaje.
     */
    public Mensajes(Integer idMensaje, String mensaje, Date fEnvio) {
        this.idMensaje = idMensaje;
        this.mensaje = mensaje;
        this.fEnvio = fEnvio;
    }
    
    /**
     *  Método getIdMensaje.
     *  Método que regresa el id del mensaje.
     * @return  El id del mensaje
     */
    public Integer getIdMensaje() {
        return idMensaje;
    }

    /**
     * Método setIdMensaje.
     * Método que asigna un nuevo id al mensaje.
     * @param idMensaje  El nuevo id del mensaje.
     */
    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    /**
     * Método getMensaje.
     * Método que regresa la cadena del mensaje.
     * @return Una cadena con la información
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Método set Mensaje.
     * Método que asigna una nueva cadena de mensaje al mensaje mismo.
     * @param mensaje El nuevo mensaje.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * Método getFEnvio.
     * Método que regresa un objeto tipo Date que contiene la fecha del envío del mensaje.
     * @return Un objeto tipo Date de la fecha del envío
     */
    public Date getFEnvio() {
        return fEnvio;
    }
    
    /**
     * Método setFEnvio.
     * Método que asigna una nueva fecha de envío.
     * @param fEnvio La nueva fecha del envío.
     */
    public void setFEnvio(Date fEnvio) {
        this.fEnvio = fEnvio;
    }

    /**
     * Método getIdUsuario1.
     * Método que regresa el id del usuario emisor del mensaje.
     * @return  El id del usuario emisor del mensaje.
     */
    public Usuario getIdUsuario1() {
        return idUsuario1;
    }

    /**
     *  Método setIdUSuario1.
     *  Método que asigna un nuevo id de usuario emisor.
     * @param idUsuario1 El id de nuevo usuario emisor.
     */
    public void setIdUsuario1(Usuario idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    /**
     * Método getIDUsuario2.
     * Método que regresa el ID del usuario receptor.
     * @return El id de usuario receptor.
     */
    public Usuario getIdUsuario2() {
        return idUsuario2;
    }

    /**
     * Método setIdUsuario2.
     * Método que asigna un id de un nuevo usuario receptor.
     * @param idUsuario2 El nuevo id del usuario receptor.
     */
    public void setIdUsuario2(Usuario idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    /**
     *  Método hashCode.
     *  Regresa el código hash del objeto.
     * @return Un entero con la información.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensaje != null ? idMensaje.hashCode() : 0);
        return hash;
    }

    /**
     * Método equals.
     * Método que compara el objeto actual con otro para verificar si son iguales.
     * @param object El objeto a verificar  si es igual o no.
     * @return Un booleano. True si son iguales los objetos, false en otro caso.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.idMensaje == null && other.idMensaje != null) || (this.idMensaje != null && !this.idMensaje.equals(other.idMensaje))) {
            return false;
        }
        return true;
    }

    /**
     * Método toString.
     * Método que regresa al objeto representado como cadena.
     * @return Una cadena con la información.
     */
    @Override
    public String toString() {
        return "com.megaflicks.gustosculposos.mapeobd.Mensajes[ idMensaje=" + idMensaje + " ]";
    }

    /**
     * Método compareTo.
     * Método implementado de la clase Comparable.
     * Nos sirve para comparar mensajes por la fecha en la que se enviaron.
     * @param o Objeto mensaje a comparar
     * @return Un entero con la información.
     */
    @Override
    public int compareTo(Mensajes o) {
        return fEnvio.compareTo(o.getFEnvio());
    }
    
}
