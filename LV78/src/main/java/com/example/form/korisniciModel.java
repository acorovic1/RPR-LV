package com.example.form;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;

public class korisniciModel {

    ObservableList<korisnik> korisnici = FXCollections.observableArrayList();
    SimpleObjectProperty<korisnik>trenutniKorisnik = new SimpleObjectProperty<korisnik>(new korisnik("ime", "prezime", "korisnicko_ime", "lozinka", "email"));

    public ObservableList<korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty<korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    void napuni() {
        korisnici.add(new korisnik("ime1", "prezime1", "korisnicko_ime1", "lozinka1", "email1"));
        korisnici.add(new korisnik("ime2", "prezime2", "korisnicko_ime2", "lozinka2", "email2"));
        korisnici.add(new korisnik("ime3", "prezime3", "korisnicko_ime3", "lozinka3", "email3"));
        korisnici.add(new korisnik("ime4", "prezime4", "korisnicko_ime4", "lozinka4", "email4"));
    }
}