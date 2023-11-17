package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XMLMapper {
    public static void writeLaptopsToFile(File file, ArrayList<Laptop> laptops) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(LaptopsWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Wrapping the laptop list
        LaptopsWrapper wrapper = new LaptopsWrapper();
        wrapper.setLaptops(laptops);

        // Writing XML to the file
        try (FileWriter writer = new FileWriter(file)) {
            marshaller.marshal(wrapper, writer);
        }
    }

    public static ArrayList<Laptop> readLaptopsFromFile(File file) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(LaptopsWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // Reading XML from the file
        try (FileReader reader = new FileReader(file)) {
            LaptopsWrapper wrapper = (LaptopsWrapper) unmarshaller.unmarshal(reader);
            return wrapper.getLaptops();
        }
    }
}
