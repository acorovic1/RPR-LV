package com.example.form;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableArray;

public class korisnik {

    private SimpleStringProperty ime;
    private SimpleStringProperty prezime;
    private SimpleStringProperty korisnicko_ime;
    private SimpleStringProperty lozinka;
    private SimpleStringProperty email;

    public korisnik() {
        this.ime = new SimpleStringProperty("");
        this.prezime = new SimpleStringProperty("");
        this.korisnicko_ime = new SimpleStringProperty("");
        this.lozinka = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
    }

    public korisnik(String ime, String prezime, String korisnicko_ime, String lozinka, String email) {
        this.ime = new SimpleStringProperty(ime);
        this.prezime = new SimpleStringProperty(prezime);
        this.korisnicko_ime = new SimpleStringProperty(korisnicko_ime);
        this.lozinka = new SimpleStringProperty(lozinka);
        this.email = new SimpleStringProperty(email);
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime.get();
    }

    public SimpleStringProperty korisnicko_imeProperty() {
        return korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka.get();
    }

    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime.set(korisnicko_ime);
    }

    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String toString() {
        return this.ime.get() + " " + this.prezime.get();
    }
}