package org.example;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LaptopDaoJSONFileTest {

    @Test
    void napuniListu() {
        LaptopDaoJSONFile objekt = new LaptopDaoJSONFile();
        ArrayList<Laptop> laptopi = new ArrayList<>();
        objekt.setLaptopi(laptopi);

        Laptop laptopToAdd = new Laptop();

        objekt.dodajLaptopUListu(laptopToAdd);

        assertEquals(1, objekt.getLaptopi().size());
        assertTrue(objekt.getLaptopi().contains(laptopToAdd));
    }
}