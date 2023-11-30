package org.example;

public class Ocjena {
    LicneInformacije osoba;
    int ocjena;

    public void setOcjena(int ocjena) throws Exception {
        if(ocjena>0 && ocjena<10) {
            this.ocjena = ocjena;
        }else throw new Exception("Nedobra ocjena");
    }

    public Ocjena(LicneInformacije osoba, int ocjena) {
        this.osoba = osoba;
        this.ocjena = ocjena;
    }
}
