package org.example;

import static java.lang.Math.sin;

public class Funkcije {
    private int broj;
    public static int factoriel(int n){
        int f=1;
        for(int i=2;i<=n;i++)f=f*i;
        return f;
    }
    public static double sinus(double n){
        return sin(n);
    }
}
