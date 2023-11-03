package org.example;

import java.lang.reflect.Array;
import java.util.List;

public class FiksniBroj extends TelefonskiBroj{


    enum Grad{SARAJEVO,TUZLA,ZENICA,BRCKO,VOGOSCA};
    private List<String> brojevi[];{"033","035","032","049","033"};
    private Grad grad;
    private String broj;

    FiksniBroj(Grad grad,String broj){
        this.grad=grad;
        this.broj=broj;
    }


    @Override
    String ispisi() {
        return null;
    }
}
