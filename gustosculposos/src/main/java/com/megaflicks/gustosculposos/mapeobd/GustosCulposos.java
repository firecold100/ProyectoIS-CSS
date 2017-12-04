package com.megaflicks.gustosculposos.mapeobd;

import com.megaflicks.gustosculposos.mapeobd.Usuario;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author hectorsama
 */
@Entity
@Table(name = "gustosculposos")
public class GustosCulposos {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GUSTO")
    private int  ID_GUSTO;
    @Column(name = "gusto")
    private String gustoCulposos;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario ID_USUARIO;

    public int getID_GUSTO() {
        return ID_GUSTO;
    }

    public String getGustoCulposos() {
        return gustoCulposos;
    }

    public void setGustoCulposos(String gustoCulposos) {
        this.gustoCulposos = gustoCulposos;
    }
    
    

    public void setID_GUSTO(int ID_GUSTO) {
        this.ID_GUSTO = ID_GUSTO;
    }


    public int getID_USUARIO() {
         return this.ID_USUARIO.getID_USUARIO();
    }

    public void setID_USUARIO(Usuario ID_USUARIO) {
         this.ID_USUARIO = ID_USUARIO;
    }

}
