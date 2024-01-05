package ba.etf.unsa.lv1011;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GeografijaDAO {
    private static GeografijaDAO instance = null;
    private static final String gradoviQuery =
            "SELECT g.id, g.naziv, g.broj_stanovnika, g.drzava FROM grad_rpr g ORDER BY g.broj_stanovnika DESC";

    private static final String provjera =
            "SELECT COUNT(*) FROM grad_rpr";

    private static final String[] podaci = {
            "1, Paris, 10000, 1",
            "2, London, 100000, 2",
            "3, Bec, 5000, 3",
    };
    private PreparedStatement gradoviStatement;
    private Connection conn;

    private GeografijaDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:/Users/nedimbecic/IdeaProjects/RPR-vjezbe/lv9DB");
        if (!provjeraTabele()) {
            napuniTabelu();
        }
        gradoviStatement = conn.prepareStatement(gradoviQuery);
    }

    private boolean provjeraTabele() throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(provjera);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        return count > 0;
    }

    private void napuniTabelu() throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO grad_rpr (id, naziv, broj_stanovnika, drzava) VALUES (?, ?, ?, ?)");
        for (String podatak : podaci) {
            StringTokenizer tokenizer = new StringTokenizer(podatak, ",");
            int id = Integer.parseInt(tokenizer.nextToken().trim());
            String grad = tokenizer.nextToken().trim();
            int broj_stanovnika = Integer.parseInt(tokenizer.nextToken().trim());
            int drzava = Integer.parseInt(tokenizer.nextToken().trim());
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, grad);
            preparedStatement.setInt(3, broj_stanovnika);
            preparedStatement.setInt(4, drzava);
            preparedStatement.executeUpdate();
        }
    }

    public static GeografijaDAO getInstance() throws SQLException {
        if (instance == null) instance = new GeografijaDAO();
        return instance;
    }

    public ArrayList<ba.etf.unsa.lv1011.grad> gradovi() {
        ArrayList<ba.etf.unsa.lv1011.grad> gradovi = new ArrayList<>();
        try (ResultSet resultSet = gradoviStatement.executeQuery()) {
            while (resultSet.next()) {
                ba.etf.unsa.lv1011.grad grad = new ba.etf.unsa.lv1011.grad(
                        resultSet.getInt("id"),
                        resultSet.getString("naziv"),
                        resultSet.getInt("broj_stanovnika"),
                        resultSet.getInt("drzava")
                );
                gradovi.add(grad);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return gradovi;
    }

    ba.etf.unsa.lv1011.grad glavniGrad(String drzava) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT g.id, g.naziv, g.broj_stanovnika, g.drzava FROM grad_rpr g, drzava_rpr d WHERE g.id = d.glavni_grad AND d.naziv = ?");
            preparedStatement.setString(1, drzava);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) return null;
            return new ba.etf.unsa.lv1011.grad(
                    resultSet.getInt("id"),
                    resultSet.getString("naziv"),
                    resultSet.getInt("broj_stanovnika"),
                    resultSet.getInt("drzava")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void obrisiDrzavu(String drzava) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM drzava_rpr WHERE naziv = ?");
            preparedStatement.setString(1, drzava);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void dodajGrad(ba.etf.unsa.lv1011.grad grad) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO grad_rpr (id, naziv, broj_stanovnika, drzava) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, grad.getId());
            preparedStatement.setString(2, grad.getNaziv());
            preparedStatement.setInt(3, grad.getBroj_stanovnika());
            preparedStatement.setInt(4, grad.getDrzava());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void dodajDrzavu(ba.etf.unsa.lv1011.drzava drzava) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO drzava_rpr (id, naziv, glavni_grad) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, drzava.getId());
            preparedStatement.setString(2, drzava.getNaziv());
            preparedStatement.setInt(3, drzava.getGlavni_grad());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    void izmijeniGrad(ba.etf.unsa.lv1011.grad grad) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE grad_rpr SET naziv = ?, broj_stanovnika = ?, drzava = ? WHERE id = ?");
            preparedStatement.setString(1, grad.getNaziv());
            preparedStatement.setInt(2, grad.getBroj_stanovnika());
            preparedStatement.setInt(3, grad.getDrzava());
            preparedStatement.setInt(4, grad.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ba.etf.unsa.lv1011.drzava nadjiDrzavu(String drzava) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, naziv, glavni_grad FROM drzava_rpr WHERE naziv = ?");
            preparedStatement.setString(1, drzava);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) return null;
            return new ba.etf.unsa.lv1011.drzava(
                    resultSet.getInt("id"),
                    resultSet.getString("naziv"),
                    resultSet.getInt("glavni_grad")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
