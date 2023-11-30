package org.example;

import java.util.ArrayList;

public class KolekcijaPoruka {
    ArrayList<String>poruke;

    public ArrayList<String> getPoruke() {
        return poruke;
    }

    public KolekcijaPoruka(ArrayList<preTstavi> poruke) {
        this.poruke = new ArrayList<>();

        for(preTstavi x: poruke)
            this.poruke.add(x.predstavi());
    }
}
