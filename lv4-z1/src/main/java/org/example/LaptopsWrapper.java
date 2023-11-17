package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "laptops")
public class LaptopsWrapper {

    private ArrayList<Laptop> laptops;

    @XmlElement(name = "laptop")
    public ArrayList<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(ArrayList<Laptop> laptops) {
        this.laptops = laptops;
    }
}