package org.example;

public enum Grad {
    TRAVNIK("030"),
    SARAJEVO("033"),
    ZENICA("032"),
    TUZLA("035"),
    MOSTAR("036"),
    BIHAC("037"),
    GORAZDE("038"),
    BRCKO("049"),
    BANJA_LUKA("051"),
    TREBINJE("059");


    private String pozivniBroj;

    Grad(String pozivniBroj) {
        this.pozivniBroj = pozivniBroj;
    }

    public String getPozivniBroj() {
        return pozivniBroj;
    }
}
