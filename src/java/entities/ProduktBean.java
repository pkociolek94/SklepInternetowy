package org.primefaces.showcase.view.data.datatable;
 
import entities.Produkt;
import entities.ProduktModel;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
@ManagedBean(name="dtProduktBean")
@ViewScoped
public class ProduktBean implements Serializable {
     
    private List<ProduktModel> produktModels;
     
    @ManagedProperty("#{produktModel}")
    private ProduktModel produktModel;

    public ProduktModel getProduktModel() {
        return produktModel;
    }

    public void setProduktModels(List<ProduktModel> produktModels) {
        this.produktModels = produktModels;
    }

    public void setProduktModel(ProduktModel produktModel) {
        this.produktModel = produktModel;
    }
 
    @PostConstruct
    public void init() {
        try {
            produktModels = produktModel.createProdukt1();
        } catch (SQLException ex) {
            Logger.getLogger(ProduktBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public List<ProduktModel> getProduktModels() {
        return produktModels;
    }
 
    public void setService(ProduktModel produktModel) {
        this.produktModel = produktModel;
    }
}
