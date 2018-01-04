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
import javax.validation.constraints.Size;

/**
 *
 * @author Pawel
 */
@Entity
@Table(name = "KONTO")
@NamedQueries({
    @NamedQuery(name = "Konto.findAll", query = "SELECT k FROM Konto k")})
public class Konto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "UZYTKOWNIK")
    private String uzytkownik;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "HASLO")
    private String haslo;
    @JoinColumn(name = "ROLA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Rola rola;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "konto")
    private Collection<ListaZakupow> listaZakupowCollection;

    public Konto() {
    }

    public Konto(Integer id) {
        this.id = id;
    }

    public Konto(Integer id, String uzytkownik, String haslo) {
        this.id = id;
        this.uzytkownik = uzytkownik;
        this.haslo = haslo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(String uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Rola getRola() {
        return rola;
    }

    public void setRola(Rola rola) {
        this.rola = rola;
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
        if (!(object instanceof Konto)) {
            return false;
        }
        Konto other = (Konto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Konto[ id=" + id + " ]";
    }
    
}
