package org.example;

import org.example.FiksniBroj;
import org.example.TelefonskiBroj;

import java.util.*;


public class Imenik {

    private Map<String, TelefonskiBroj>brojevi;

    public Imenik() {
        this.brojevi = new HashMap<String, TelefonskiBroj>();
    }

    public Map<String , TelefonskiBroj>getBrojevi(){
        return brojevi;
    }

    public void setBrojevi(Map<String, TelefonskiBroj> brojevi) {
        this.brojevi = brojevi;
    }

    public void dodaj(String ime, TelefonskiBroj broj){
        this.brojevi.put(ime,broj);
    }

    public String dajBroj(String ime){
        TelefonskiBroj broj = this.brojevi.get(ime);
        if(broj != null){
            return broj.ispisi();
        }else{
            return null;
        }
    }

    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> x : this.brojevi.entrySet()) {
            if (x.getValue().ispisi().equals(broj.ispisi())) {
                return x.getKey();
            }
        }
        return null;
    }



    public String naSlovo(char c){
        StringBuilder ispis = new StringBuilder();
        int p=1;
        for(Map.Entry<String, TelefonskiBroj>x : this.brojevi.entrySet()){
            if(x.getKey().startsWith(String.valueOf(c))){
                ispis.append(p).append(".").append(x.getKey()).append(" - ").append(x.getValue().ispisi()).append("\n");
            }
            p++;
        }
        return ispis.toString();
    }


    private boolean provjeraGrada(TelefonskiBroj broj, Grad g){
        if(broj instanceof FiksniBroj){
            return g.equals(((FiksniBroj)broj).getGrad());
        }else{
            return false;
        }
    }
    public Set<String> izGrada(Grad g){
        Set<String>r = new TreeSet<String>();
        for(Map.Entry<String, TelefonskiBroj>x : this.brojevi.entrySet()){
            if(provjeraGrada(x.getValue(),g)){
                r.add(x.getKey());
            }
        }
        return r;
    }


    public Set<TelefonskiBroj> izGradaBrojevi(Grad g){
        Set<TelefonskiBroj>r = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>(){
            @Override
            public int compare(TelefonskiBroj a, TelefonskiBroj b){return a.ispisi().compareTo(b.ispisi());}
        });


        for(Map.Entry<String, TelefonskiBroj>x : this.brojevi.entrySet()){
            if(provjeraGrada(x.getValue(),g)){
                r.add(x.getValue());
            }
        }
        return r;

    }

    @Override
    public String toString(){
        StringBuilder ispis = new StringBuilder();
        int p=0;
        for(Map.Entry<String, TelefonskiBroj>x : this.brojevi.entrySet()){
            ispis.append(p).append(". ").append(x.getKey()).append(" - ").append(x.getValue().ispisi()).append("\n");
            p++;
        }
        return ispis.toString();
    }



}