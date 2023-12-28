package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.SQLException;
public class Main {

    public static void main(String[] args) {
        System.out.println(ispisiGradove());
        glavniGrad();
    }

    public static String ispisiGradove() {
        try {
            ArrayList<grad> gradovi = GeografijaDAO.getInstance().gradovi();
            StringBuilder izlaz = new StringBuilder();
            for (grad Grad : gradovi) {
                izlaz.append(String.format("- %s (%s) - %d stanovnika\n", Grad.getNaziv(), Grad.getDrzava(), Grad.getBroj_stanovnika()));
            }
            return izlaz.toString();
        } catch (SQLException e) {
            System.err.println("Greška pri preuzimanju podataka iz baze: " + e.getMessage());
            return "";
        }
    }

    public static void glavniGrad() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Unesite naziv države: ");
        String drzava= scanner.nextLine();

        try {
            grad glavni = GeografijaDAO.getInstance().glavniGrad(drzava);
            if (glavni == null) {
                System.out.println("Nepostojeća država.");
            } else {
                System.out.println("Glavni grad države " + drzava + " je " + glavni.getNaziv());
            }
        } catch (SQLException e) {
            System.err.println("Greška pri preuzimanju podataka iz baze: " + e.getMessage());
        }
    }
}