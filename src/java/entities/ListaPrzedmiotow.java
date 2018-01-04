/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pawel
 */
@Entity
@Table(name = "LISTA_PRZEDMIOTOW")
@NamedQueries({
    @NamedQuery(name = "ListaPrzedmiotow.findAll", query = "SELECT l FROM ListaPrzedmiotow l")})
public class ListaPrzedmiotow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "KATEGORIA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Kategoria kategoria;
    @JoinColumn(name = "PRODUKT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Produkt produkt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaPrzedmiotow")
    private Collection<ListaZakupow> listaZakupowCollection;

    public ListaPrzedmiotow() {
    }

    public ListaPrzedmiotow(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public Collection<ListaZakupow> getListaZakupowCollection() {
        return listaZakupowCollection;
    }

    public void setListaZakupowCollection(Collection<ListaZakupow> listaZakupowCollection) {
        this.listaZakupowCollection = listaZakupowCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaPrzedmiotow)) {
            return false;
        }
        ListaPrzedmiotow other = (ListaPrzedmiotow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ListaPrzedmiotow[ id=" + id + " ]";
    }
    
}
