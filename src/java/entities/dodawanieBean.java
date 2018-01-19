/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Pawel
 */
@ManagedBean(name = "dodawanieBean")
@ViewScoped
public class dodawanieBean implements Serializable{
    
    private List<dodawanieModel> dodawanieModels;

    public List<dodawanieModel> getDodawanieModels() {
        return dodawanieModels;
    }

    public void setDodawanieModels(List<dodawanieModel> dodawanieModels) {
        this.dodawanieModels = dodawanieModels;
    }
    
    

    public dodawanieModel getDodawanieModel() {
        return dodawanieModel;
    }

    public void setDodawanieModel(dodawanieModel DodawanieModel) {
        this.dodawanieModel = DodawanieModel;
    }
    
    
     
    @ManagedProperty("#{dodawanieModel}")
    private dodawanieModel dodawanieModel;

        public void init(String ss) {
            String cos = ss;
        try {
             
            dodawanieModels = dodawanieModel.dodaj(cos);
        } catch (SQLException ex) {
            Logger.getLogger(ProduktBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
}
