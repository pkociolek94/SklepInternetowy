/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Pawel
 */
@ManagedBean
@SessionScoped
public class Potwierdzenie {

    /**
     * Creates a new instance of Potwierdzenie
     */
    private String nazwa;
    private int cena;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getNr_bloku() {
        return nr_bloku;
    }

    public void setNr_bloku(String nr_bloku) {
        this.nr_bloku = nr_bloku;
    }

    public String getNr_mieszkania() {
        return nr_mieszkania;
    }

    public void setNr_mieszkania(String nr_mieszkania) {
        this.nr_mieszkania = nr_mieszkania;
    }
    private String imie;
    private String nazwisko;
    private String numer_telefonu;
    private String miasto;
    private String nr_bloku;
    private String nr_mieszkania;
    private String e_mail;

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

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

    public Potwierdzenie() {
    }

    public String potwierdz(String nazwa, int cena) {
        this.nazwa = nazwa;
        this.cena = cena;

        return "potwierdzenie.xhtml";
    }

    public String generujzamowienie(String nazwa1, int cena1, String imie1, String nazwisko1, String nrtel, String mail, String miasto1, String nr_b, String nr_m) throws FileNotFoundException, DocumentException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String FILE = "C:\\Users\\Pawel\\Documents\\NetBeansProjects\\Slepiczek\\web\\plikipdf\\" + nazwa1 + dateFormat.format(date) + ".pdf";
        
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        
        document.open();
        
        document.addTitle("Potwierdzenie zamówienia: ");
        Paragraph preface = new Paragraph();
        
        preface.add(new Paragraph(
                "Raport wygenerowny: " + new Date()));
        
        preface.add(new Paragraph("Nazwa: " + nazwa1));
        preface.add(new Paragraph("Cena: " + cena1));
        preface.add(new Paragraph("Imie kupującego: " + imie1));
        preface.add(new Paragraph("Nazwisko kupującego: " + nazwisko1));
        preface.add(new Paragraph("Numer telefonu: " + nrtel));
        preface.add(new Paragraph("E-mail: " + mail));
        preface.add(new Paragraph("Miasto: " + miasto1));
        preface.add(new Paragraph("Numer budynku: " + nr_b));
        preface.add(new Paragraph("Numer mieszkania: " + nr_m));
        preface.add(new Paragraph("Raport wygenerowany automatycznie dnia :" + new Date()));
        
        document.add(preface);
        document.close();
        
        return "index.xhtml";
    }

}
