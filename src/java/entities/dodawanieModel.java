/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Pawel
 */
@ManagedBean(name="dodawanieModel")
@SessionScoped
public class dodawanieModel {
    private String nazwa;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    private int cena;
    private String data;
    private ArrayList<dodawanieModel> list = new ArrayList<>();

    public ArrayList<dodawanieModel> getList() {
        return list;
    }

    public void setList(ArrayList<dodawanieModel> list) {
        this.list = list;
    }
    /**
     * Creates a new instance of dodawanieModel
     */
    public dodawanieModel() {
    }

    public dodawanieModel(String nazwa, int cena, String data) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.data = data;
    }
    public List<dodawanieModel> dodaj(String ss) throws SQLException {
        String sterownik = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/Shop";
        
        try {
            Class.forName(sterownik);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Exception blad = null;
        try (Connection conn = DriverManager.getConnection(url, "Shop", "Shop")) {
            java.sql.Statement stm = conn.createStatement();
            //uwaga na import - ma być z pakietu java.sql
            String pass = "select id, nazwa,cena,zdjecie,szczegoly,sztuk from produkt";
            ResultSet rs = stm.executeQuery(pass);
            String p = ss;
            while (rs.next()) {
                if(p.equals(rs.getString(2))){
                list.add(new dodawanieModel( rs.getString(2), rs.getInt(3), rs.getString(4)));}
            }conn.close();
            
        } catch (SQLDataException e) {
        }
         
        
        
        return list;
    }
    
    
}
