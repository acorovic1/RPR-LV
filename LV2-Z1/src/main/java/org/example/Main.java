package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        if(args.length!=2){
            System.err.println("Nedovoljan broj argumenata");
        }else if(!args[0].equals("sinus")&&!args[0].equals("factoriel")){
            System.err.println("Nevalidna funkcija");
        }else{
            String funkcija=args[0];
            double input=Double.parseDouble(args[1]);
            switch(funkcija){
                case "sinus":
                    System.out.println("Sinus("+input+")=" + Funkcije.sinus(input));
                    break;
                case "factoriel":
                    System.out.println("Factoriel("+input+")=" + Funkcije.factoriel((int)input));

            }
        }



    }
}