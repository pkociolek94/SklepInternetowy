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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Pawel
 */
@Entity
@Table(name = "PRODUKT")
@NamedQueries({
    @NamedQuery(name = "Produkt.findAll", query = "SELECT p FROM Produkt p")})
public class Produkt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAZWA")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CENA")
    private int cena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ZDJECIE")
    private String zdjecie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "SZCZEGOLY")
    private String szczegoly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SZTUK")
    private int sztuk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produkt")
    private Collection<ListaPrzedmiotow> listaPrzedmiotowCollection;

    public Produkt() {
    }

    public Produkt(Integer id) {
        this.id = id;
    }

    public Produkt(Integer id, String nazwa, int cena, String zdjecie, String szczegoly, int sztuk) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
        this.zdjecie = zdjecie;
        this.szczegoly = szczegoly;
        this.sztuk = sztuk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getZdjecie() {
        return zdjecie;
    }

    public void setZdjecie(String zdjecie) {
        this.zdjecie = zdjecie;
    }

    public String getSzczegoly() {
        return szczegoly;
    }

    public void setSzczegoly(String szczegoly) {
        this.szczegoly = szczegoly;
    }

    public int getSztuk() {
        return sztuk;
    }

    public void setSztuk(int sztuk) {
        this.sztuk = sztuk;
    }

    public Collection<ListaPrzedmiotow> getListaPrzedmiotowCollection() {
        return listaPrzedmiotowCollection;
    }

    public void setListaPrzedmiotowCollection(Collection<ListaPrzedmiotow> listaPrzedmiotowCollection) {
        this.listaPrzedmiotowCollection = listaPrzedmiotowCollection;
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
        if (!(object instanceof Produkt)) {
            return false;
        }
        Produkt other = (Produkt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Produkt[ id=" + id + " ]";
    }
    
}
