package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class LaptopDaoSerializableFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;

    public void setFile(File file) {
        this.file = file;
    }

    public LaptopDaoSerializableFile() {
        super();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws FileNotFoundException {
        try (FileOutputStream fileOut = new FileOutputStream(file, true);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(laptop);
            System.out.println("Laptop je uspjesno upisan");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi = new ArrayList<>(laptopi);
    }

    @Override
    public void vratiPodatkeIzDatoteke() {
        try(FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            laptopi = (ArrayList<Laptop>) objectIn.readObject();
            System.out.println("Laptop je procitan iz datoteke");
        } catch (IOException | ClassNotFoundException e) {
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

    public ArrayList<Laptop> getLaptopi() {
        return laptopi;
    }
}

