package org.example;

import java.util.*;

import java.util.*;

public class Program {
    public static Scanner ulaz = new Scanner(System.in);
    public static Imenik imenik = new Imenik();

    public static void main(String[] args) {


        while (true) {
            System.out.println("""
                    Unesite broj za zeljenu komandu:
                    1. dodaj
                    2. dajBroj
                    3. dajIme,
                    4. naSlovo
                    5. izGrada
                    6. izGradaBrojevi
                    7. ispisi imenik
                    8. zavrsi
                    """);

            int a = ulaz.nextInt();
//            switch (a) {
//                case 1:
//                    dajBroj();
//            }
//        }
//
        }
    }


//    private static  TelefonskiBroj unesiBrTelefona(){
//        System.out.println("""
//        Odaberite za unos odredjenog tipa broja:
//        1. fiksni
//        2. mobilni
//        3.medjunarodni
//        """);
//        //int a = ulaz.nextInt();
////        switch(a){
////            case 1:
////                System.out.println("Unesite pozivni");
////                String pozivni = ulaz.nextLine();
////                System.out.println("Unesite sada broj");
////                String broj = ulaz.nextLine();
////                return new FiksniBroj(Grad.)
////        }
//    }

//    private static void dodajBr() {
//        System.out.println("Unesite ime");
//        String ime = ulaz.nextLine();
//        TelefonskiBroj br = unesiBrTelefona();
//        imenik.dodaj(ime, br);
//    }

    private static void dajBr() {
        System.out.println("Unesite ime");
        String ime = ulaz.nextLine();
        String r = imenik.dajBroj(ime);
        if (r == null) {
            System.out.println("Ne postoji u imeniku");
        } else {
            System.out.println(r);
        }
    }

//    private static void dajIme(){
//        TelefonskiBroj br= unesiBrTelefona();
//        String ime= imenik.dajIme(br);
//        if(ime == null){
//            System.out.println("Ne postoji u imeniku ");
//        }else{
//            System.out.println("Broj pripada"+ime);
//        }
//    }

    private static void naSlovo(){
        System.out.println("Unesite pocetno slovo imena");
        String s= ulaz.nextLine();
        String r= imenik.naSlovo(s.toCharArray()[0]);
        System.out.println(r);
    }

    private static void izGrada(){
        System.out.println("Unesite grad");
        String g = ulaz.nextLine();
        Grad grad= Grad.valueOf(g);
        Set<String>r = imenik.izGrada(grad);
        System.out.println(r);
    }

    private static void izGradaBr(){
        System.out.println("Unesite grad");
        String g = ulaz.nextLine();
        Grad grad = Grad.valueOf(g);
        Set<TelefonskiBroj>r=imenik.izGradaBrojevi(grad);
        for(TelefonskiBroj x: r){
            System.out.println(x.ispisi());
        }

    }
}