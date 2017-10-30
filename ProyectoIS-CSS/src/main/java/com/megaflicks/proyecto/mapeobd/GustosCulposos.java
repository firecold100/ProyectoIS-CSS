package com.megaflicks.proyecto.mapeobd;

import com.megaflicks.proyecto.mapeobd.Usuario;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gustos")
    private int id_gustos;
    @Column(name = "gusto")
    private String Gusto;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario ID_USUARIO;

    public int getId_gustos() {
        return id_gustos;
    }

    public void setId_gustos(int id_gustos) {
        this.id_gustos = id_gustos;
    }

    public String getGusto() {
        return Gusto;
    }

    public void setGusto(String Gusto) {
        this.Gusto = Gusto;
    }

    public Usuario getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(Usuario ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

}
