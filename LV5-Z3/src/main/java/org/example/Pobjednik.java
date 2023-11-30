package org.example;

public class Pobjednik {
    String ime,prezime;
    int brojZnakova;

    KolekcijaImena kolekcija;

    Pobjednik(){
      String winner=  kolekcija.getNajduzeIme();
        int counter=0;
        brojZnakova=0;
      while(winner.charAt(counter)!=' '){
          ime=ime+winner.charAt(counter);
          counter++;
          brojZnakova++;
      }
      counter++;
      prezime=winner.substring(counter);

    }

}
