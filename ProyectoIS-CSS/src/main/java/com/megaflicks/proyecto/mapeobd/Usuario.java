/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megaflicks.proyecto.mapeobd;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hectorsama
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

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }
 @Column (name="contrasenya")
 private String contrasenya;    

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
 
 
    
}