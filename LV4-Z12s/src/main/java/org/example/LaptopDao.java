package org.example;

import java.util.ArrayList;

public interface LaptopDao {
     void dodajLaptopUListu(Laptop laptop);
     void dodajLaptopUFile(Laptop laptop);
     void getLaptop(String procesor);
     void napuniListu(ArrayList<Laptop>laptopi);
     void vratiPodatkeIzDatoteke();
}
