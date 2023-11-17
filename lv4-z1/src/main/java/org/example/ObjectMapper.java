package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ObjectMapper {

    private static final Gson gson = new Gson();
    private static final Type LAPTOP_LIST_TYPE = new TypeToken<ArrayList<Laptop>>(){}.getType();

    public static void writeLaptopsToFile(File file, ArrayList<Laptop> laptops) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(laptops, writer);
        }
    }

    public static ArrayList<Laptop> readLaptopsFromFile(File file) throws IOException {
        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, LAPTOP_LIST_TYPE);
        }
    }
}