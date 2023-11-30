package org.example;

import java.util.ArrayList;

public class Predmet {
    String naziv,opis;
    ArrayList<Ocjena> ocjene;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
