/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Student
 */
@ManagedBean(name = "kategoriaBean")
@ViewScoped
public class kategoriaBean implements Serializable
{
    
    private List<KategoriaModel> kategoriaModels;

    public List<KategoriaModel> getKategoriaModels() {
        return kategoriaModels;
    }

    public void setKategoriaModels(List<KategoriaModel> kategoriaModels) {
        this.kategoriaModels = kategoriaModels;
    }

    public KategoriaModel getKategoriaModel() {
        return kategoriaModel;
    }

    public void setKategoriaModel(KategoriaModel kategoriaModel) {
        this.kategoriaModel = kategoriaModel;
    }

    @ManagedProperty("#{kategoriaModel}")
    private KategoriaModel kategoriaModel;

    /**
     *
     */
    @PostConstruct
    public void init() {
        try {
            kategoriaModels = kategoriaModel.createKategoria();
        } catch (SQLException ex) {
            Logger.getLogger(kategoriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Creates a new instance of kategoriaBean
     */
    public kategoriaBean() {
    }
    
    public String test(){
        return "logowanie.xhtml";
    }
    
}
