package org.example;

import java.util.Objects;
public class FiksniBroj extends TelefonskiBroj{

    private Grad grad;
    private String broj;
    public FiksniBroj(Grad grad, String broj) {
        if(grad==null)throw new Exception("Pozivni nije korektan");
        this.grad=grad;
        this.broj=broj;
    }

    public Grad getGrad() {
        return grad;
    }

    public String getBroj() {
        return broj;
    }

    @Override
    public String ispisi(){
        if(grad!=null && broj!=null){
            return grad.getPozivniBroj()+"/"+broj;
        }else{
            return null;
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(grad,broj);
    }

}