/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pawel
 */
@Entity
@Table(name = "LISTA_ZAKUPOW")
@NamedQueries({
    @NamedQuery(name = "ListaZakupow.findAll", query = "SELECT l FROM ListaZakupow l")})
public class ListaZakupow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "KONTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Konto konto;
    @JoinColumn(name = "LISTA_P_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ListaPrzedmiotow listaPrzedmiotow;

    public ListaZakupow() {
    }

    public ListaZakupow(Integer id) {
        this.id = id;
    }

    public ListaZakupow(Integer id, Date data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public ListaPrzedmiotow getListaPrzedmiotow() {
        return listaPrzedmiotow;
    }

    public void setListaPrzedmiotow(ListaPrzedmiotow listaPrzedmiotow) {
        this.listaPrzedmiotow = listaPrzedmiotow;
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
        if (!(object instanceof ListaZakupow)) {
            return false;
        }
        ListaZakupow other = (ListaZakupow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ListaZakupow[ id=" + id + " ]";
    }
    
}
