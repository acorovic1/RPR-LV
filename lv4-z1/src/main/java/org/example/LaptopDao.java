package org.example;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public interface LaptopDao {
    public void dodajLaptopUListu(Laptop laptop);
    public void dodajLaptopUFile(Laptop laptop) throws FileNotFoundException;
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException;
    public void napuniListu(ArrayList<Laptop>laptopi);
    void vratiPodatkeIzDatoteke();
}
