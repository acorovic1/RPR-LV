package org.example;

import java.util.ArrayList;

public class KolekcijaImena {
    ArrayList<String> imenaIprezimena;

    String getNajduzeIme(){
        String najduzi=imenaIprezimena.get(0);
        for(String x:imenaIprezimena){
            if(x.length()>najduzi.length()) {
                najduzi=x;
            }
        }
        return najduzi;
    }
}
