package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

class LaptopDaoXMLFileTest {

    @Test
    void dodajLaptopUListu() {
        LaptopDaoXMLFile novi = new LaptopDaoXMLFile();
        ArrayList<Laptop> laptopi = new ArrayList<>();
        novi.setLaptopi(laptopi);

        Laptop laptopToAdd = new Laptop();

        novi.dodajLaptopUListu(laptopToAdd);

        assertEquals(1, novi.getLaptopi().size());
        assertTrue(novi.getLaptopi().contains(laptopToAdd));
    }

    @Test
    void dodajLaptopUFile() throws FileNotFoundException {

        LaptopDaoXMLFile novi;
        File fileMock;


        novi = new LaptopDaoXMLFile();
        fileMock = mock(File.class);


        @Test
        public void testDodajLaptopUFile() throws FileNotFoundException {
            Laptop laptopToAdd = new Laptop();
            novi.dodajLaptopUFile(laptopToAdd);
            assertEquals(1, novi.getLaptopi().size());
            assertTrue(novi.getLaptopi().contains(laptopToAdd));

            try {

                verify(XMLMapper.class).writeLaptopsToFile(eq(fileMock), eq(novi.getLaptopi()));
            } catch (IOException | JAXBException e) {
                fail("Unexpected exception during verification: " + e.getMessage());
            }
        }

    }
}