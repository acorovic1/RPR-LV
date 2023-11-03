package org.example;

public class Racun {
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private double stanjeRacuna;
    private double prekoracenje;

    public Racun(Long brojRacuna, Osoba korisnikRacuna) {
        this.brojRacuna = brojRacuna;
        this.korisnikRacuna = korisnikRacuna;
    }
    public boolean provjeriOdobrenjaPrekoracenja(Double iznos) {
        return this.prekoracenje>iznos;
    }
    public boolean izvrsiUplatu(Double iznos){
        this.stanjeRacuna+=iznos;
        return true;
    }
    public boolean izvrsiIsplatu(Double iznos){
        if(this.stanjeRacuna+this.prekoracenje<iznos)return false;
        else {
            this.stanjeRacuna-=iznos;
            return true;
        }
    }
    public void odobriPrekoracenje(Double iznos){this.prekoracenje=iznos;}
}
