/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.gustosculposos.mapeobd;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hectorsama
 * @author Alan Moreno de la Rosa
 */

@Entity
@Table (name="usuario")

public class Usuario {
    
 @Id@GeneratedValue(strategy =GenerationType.IDENTITY )
 @Column(name="ID_USUARIO")
 private int ID_USUARIO;
 @Column (name="alias")
 private String alias;
 @Column (name="nombre")
 private String nombre;
 @Column (name="apellido_p")
 private String apellido_p;
 @Column (name="apellido_m")
 private String apellido_m;
 @Column(name="correo")
 private String correo;
 @Column (name="f_reg")
 private Date f_reg;
 @Column(name="sexo")
 private String  sexo;
 @Column(name="edad")
 private String edad;
 @Column (name="contrasenya")
 private String contrasenya;    
 @OneToMany(mappedBy="ID_USUARIO")
 private Set<GustosCulposos> gustosculposos; 

 /** Conjunto de mensajes del emisor .*/
@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario1")
private Set<Mensajes> mensajesCollectionEmisor; //Un usuario manda muchos mensajes.

/** Conjunto de mensajes del receptor.*/
@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario2")
private Set<Mensajes> mensajesCollectionReceptor; //un usuario recibe varios mensajes.
 
    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public Date getF_reg() {
        return f_reg;
    }

    public void setF_reg(Date f_reg) {
        this.f_reg = f_reg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    
    /**
     * Método getMensajesCollectionEmisor.
     * Método que regresa una colección de mensajes del usuario emisor.
     * @return Una colección de objetos de tipo mensaje del emisor.
     */
    public Set<Mensajes> getMensajesCollectioEmisor() {
        return mensajesCollectionEmisor;
    }

    /**
     * Método setMensajesCollectionEmisor.
     * Método que asigna una nueva colección de mensajes.
     * @param mensajesCollectionEmisor La nueva colección de mensajes a asignar.
     */
    public void setMensajesCollectionEmisor(Set<Mensajes> mensajesCollectionEmisor) {
        this.mensajesCollectionEmisor = mensajesCollectionEmisor;
    }

    /**
     * Método getMensajesCollectionReceptor.
     * Regresa los mensajes del usuario receptor.
     * @return Una colección de mensajes del usuario receptor
     */
    public Set<Mensajes> getMensajesCollectionReceptor() {
        return mensajesCollectionReceptor;
    }

    /**
     * Método setMensajesCollectionReceptor.
     * Asigna una nueva colección de mensajes del receptor.
     * @param mensajesCollectionReceptor La nueva colección de mensajes del receptor
     */
    public void setMensajesCollectionReceptor(Set<Mensajes> mensajesCollectionReceptor) {
        this.mensajesCollectionReceptor = mensajesCollectionReceptor;
    }
}