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
import static java.util.Collections.list;
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
@ManagedBean(name = "produktModel")
@ApplicationScoped
public class ProduktModel {
    private int cena;
    private String nazwa;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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
    private String zdjecie;
    private String szczegoly;
    private int sztuk;

    public ProduktModel() {
    }

    /**
     *
     * @param nazwa
     * @param cena
     * @param zdjecie
     * @param szczegoly
     * @param sztuk
     */
    public ProduktModel(int id, String nazwa, int cena, String zdjecie, String szczegoly, int sztuk) {
        this.nazwa = nazwa;
        this.id = id;
        this.cena = cena;
        this.zdjecie = zdjecie;
        this.szczegoly = szczegoly;
        this.sztuk = sztuk;
    }

    public List<ProduktModel> createProdukt1() throws SQLException {
        ArrayList<ProduktModel> list = new ArrayList<>();
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
            String pass = "select id, nazwa,cena,zdjecie,szczegoly,sztuk from produkt";
            ResultSet rs = stm.executeQuery(pass);
            while (rs.next()) {
                list.add(new ProduktModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }
            
        } catch (SQLDataException e) {
        }

        
        
        return list;
    }
    
    
    
}
