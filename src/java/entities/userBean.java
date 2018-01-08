/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Pawel
 */
@Named(value = "userBean")
@ManagedBean
@SessionScoped
public class userBean {

    /**
     * Creates a new instance of userBean
     */
    private String przyklad;
    private String rezultat;

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public String getRezultat() {
        return rezultat;
    }

    

    public String getPrzyklad() {
        return przyklad;
    }

    public void setPrzyklad(String przyklad) {
        this.przyklad = przyklad;
    }
    public userBean() {
    }
    public String logIn(){
        return "admin";
    }
    public void testujemyBaze() throws SQLException {
        String test ="";
        String sterownik = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/Shop";
        try {
            Class.forName(sterownik);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("sterownik OK");
        Connection conn = DriverManager.getConnection(url,"Shop","Shop");
        System.out.println("baza OK");
        java.sql.Statement stm = conn.createStatement(); //uwaga na import - ma być z pakietu java.sql
        String sql = "select * from kategoria";
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            test +=rs.getString(2);
        }
        conn.close();
        rezultat = test;
        
}
}
