/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Pawel
 */
@ManagedBean
@SessionScoped
public class logowanieBean {

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }
    
    public String getWiadomosc() {
        return wiadomosc;
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }
    
    private String login;
    private String haslo;
    private String rola;
    private String wiadomosc;


    
    /**
     * Creates a new instance of logowanieBean
     */
    public logowanieBean() {
    }
    public String logowanie() throws SQLException, InterruptedException{
        String test ="";
        String sterownik = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/Shop";
        try {
            Class.forName(sterownik);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (Connection conn = DriverManager.getConnection(url,"Shop","Shop")) {
            java.sql.Statement stm = conn.createStatement(); //uwaga na import - ma być z pakietu java.sql
            String pass = "select * from konto";
            ResultSet rs = stm.executeQuery(pass);
            while(rs.next()){
                if(login.equalsIgnoreCase(rs.getString(2))&& haslo.equalsIgnoreCase(rs.getString(3))){
                    
                    wiadomosc = "Udało ci się zalogować....";
                    Thread.sleep(1000);
                    wiadomosc = "Udało ci się zalogować....";
                    Thread.sleep(1000);
                    return "index";
                }
                else wiadomosc = "Nieprawidłowy login lub hasło";
                return "logowanie";
            }
        }
        return "logowanie";
        //uwaga na import - ma być z pakietu java.sql

    }
    
}