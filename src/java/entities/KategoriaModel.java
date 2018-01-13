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
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;


/**
 *
 * @author Student
 */
@ManagedBean(name = "kategoriaModel")
@ApplicationScoped
public class KategoriaModel {

    private List<Kategoria> kategoria;

    public void setKategoria(List<Kategoria> kategoria) {
        this.kategoria = kategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    private int id;
    private String nazwa;

    public List<Kategoria> getKategoria() {
        return kategoria;
    }
    
    public KategoriaModel() {
    }
    public KategoriaModel(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }
    
   

        
  
    
    public List<KategoriaModel> createKategoria() throws SQLException {
        ArrayList<KategoriaModel> kategoria = new ArrayList<>();
        String sterownik = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/Shop";
        
        try {
            Class.forName(sterownik);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Exception blad = null;
        try (Connection conn = DriverManager.getConnection(url, "Shop", "Shop")) {
            java.sql.Statement stm = conn.createStatement(); //uwaga na import - ma być z pakietu java.sql
            String pass = "select id, nazwa from kategoria";
            ResultSet rs = stm.executeQuery(pass);
            while (rs.next()) {
                kategoria.add(new KategoriaModel(rs.getInt(1), rs.getString(2)));
            }
            
        } catch (SQLDataException e) {
        }

        
        
        return kategoria;
    }
    }


