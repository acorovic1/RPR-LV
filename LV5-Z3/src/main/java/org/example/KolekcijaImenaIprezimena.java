package org.example;

import java.util.ArrayList;

public class KolekcijaImenaIprezimena {
    ArrayList<String> imena;
    ArrayList<String> prezimena;

    public int getIndexNajduzegPara(){
        int najduzi=0;
            for(int i=1;i<imena.size();i++){
                if((imena.get(i)+prezimena.get(i)).length()>(imena.get(najduzi)+prezimena.get(najduzi)).length())najduzi=i;
            }
            return najduzi;
    }
    public String getImeIprezime(int i){
        return imena.get(i)+prezimena.get(i);
    }
}
