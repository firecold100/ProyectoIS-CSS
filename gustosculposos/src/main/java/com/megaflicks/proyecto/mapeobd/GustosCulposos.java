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
    @Column(name = "id_gusto")
    private int id_gusto;
    @Column(name = "gusto")
    private String Gusto;
    //@ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario ID_USUARIO;

    public int getId_gusto() {
        return id_gusto;
    }

    public void setId_gusto(int id_gusto) {
        this.id_gusto = id_gusto;
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
}
