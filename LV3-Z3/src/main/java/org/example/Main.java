package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        List<Double>numbers=new ArrayList<Double>();

        while(true){
            String line=scanner.nextLine();
            if("stop".equalsIgnoreCase(line.trim())){
                break;
            }
            try{
                Double number=Double.parseDouble(line);
                numbers.add(number);
            }catch(Exception e){
                System.out.println("uneseni string nije broj");
                continue;
            }
        }
        System.out.println("MIN: "+VIS.min(numbers));
        System.out.println("MAX: "+VIS.max(numbers));
        System.out.println("MEAN: "+VIS.mean(numbers));
        System.out.println("STDEV: "+VIS.stdev(numbers));
    }
}