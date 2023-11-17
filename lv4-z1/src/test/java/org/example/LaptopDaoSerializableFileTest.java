package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoSerializableFileTest {

    @Test
    void napuniListu() {
        LaptopDaoSerializableFile novi = new LaptopDaoSerializableFile();
        ArrayList<Laptop> laptopi = new ArrayList<>();

        novi.napuniListu(laptopi);
        assertNotNull(novi.getLaptopi());
        assertEquals(laptopi.size(), novi.getLaptopi().size());
        assertTrue(novi.getLaptopi().containsAll(laptopi));
    }

    @Test
    void getLaptop() {
    }
}