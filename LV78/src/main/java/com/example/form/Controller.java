package com.example.form;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private korisniciModel model;
    @FXML
    private ListView<korisnik> listKorisnici;
    @FXML
    private TextField fldIme;
    @FXML
    private TextField fldPrezime;
    @FXML
    private TextField fldKorisnickoIme;
    @FXML
    private TextField fldLozinka;
    @FXML
    private TextField fldEmail;

    public Controller(korisniciModel model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        listKorisnici.setItems(model.getKorisnici());
        listKorisnici.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if (oldKorisnik != null) {
                unBind();
            }
            if (newKorisnik == null) {
                fldIme.setText("");
                fldPrezime.setText("");
                fldKorisnickoIme.setText("");
                fldLozinka.setText("");
                fldEmail.setText("");
            } else {
                bind();
            }
        });
    }

    public void bind() {
        fldIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        fldPrezime.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        fldKorisnickoIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().korisnicko_imeProperty());
        fldLozinka.textProperty().bindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
        fldEmail.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
    }

    public void unBind() {
        fldIme.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
        fldPrezime.textProperty().unbindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        fldKorisnickoIme.textProperty().unbindBidirectional(model.getTrenutniKorisnik().korisnicko_imeProperty());
        fldLozinka.textProperty().unbindBidirectional(model.getTrenutniKorisnik().lozinkaProperty());
        fldEmail.textProperty().unbindBidirectional(model.getTrenutniKorisnik().emailProperty());
    }
    public void dodajKorisnika(ActionEvent actionEvent) {
        korisnik noviKorisnik = new korisnik(fldIme.getText(), fldPrezime.getText(), fldKorisnickoIme.getText(), fldLozinka.getText(), fldEmail.getText());
        unBind();
        model.getKorisnici().add(new korisnik(fldIme.getText(), fldPrezime.getText(), fldKorisnickoIme.getText(), fldLozinka.getText(), fldEmail.getText()));
        model.trenutniKorisnikProperty().set(noviKorisnik);
        listKorisnici.refresh();
        listKorisnici.getSelectionModel().select(noviKorisnik);

    }

    public void kraj(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }

    public void setModel(korisniciModel model) {
        this.model = model;
    }
}