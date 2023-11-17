package org.example;
import java.util.ArrayList;
import java.io.*;
import java.util.Objects;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
public class LaptopDaoJSONFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public void setFile(File file) {
        this.file = file;
    }

    public LaptopDaoJSONFile() {
        super();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws FileNotFoundException {
        laptopi.add(laptop);
        try {
            ObjectMapper.writeLaptopsToFile(file, laptopi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            String procesorTrenutnog = laptop.getProcesor();
            if (Objects.equals(procesorTrenutnog, procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Laptop sa trazenim procesorom ne postoji!");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = new ArrayList<>(laptopi);
    }

    @Override
    public void vratiPodatkeIzDatoteke() {
        try {
            laptopi = ObjectMapper.readLaptopsFromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Laptop> getLaptopi() {
        return laptopi;
    }

    public void setLaptopi(ArrayList<Laptop> laptopi) {
        this.laptopi = laptopi;
    }
}