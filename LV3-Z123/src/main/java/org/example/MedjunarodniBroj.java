import org.example.TelefonskiBroj;

import java.util.Objects;
public class MedjunarodniBroj extends TelefonskiBroj {

    private String drzava;
    private String broj;

    public MedjunarodniBroj(String drzava, String broj) {
        this.drzava = drzava;
        this.broj = broj;
    }

    @Override
    public String ispisi(){
        if(drzava == null || broj==null){
            return null;
        }else{
            return drzava+broj;
        }
    }

    @Override
    public int hashCode(){return Objects.hash(drzava,broj);}
}