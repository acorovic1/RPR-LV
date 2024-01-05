package ba.etf.unsa.lv1011;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.List;

public class GlavnaController {

    @FXML
    private TableColumn colGradId;
    @FXML
    private TableColumn colGradNaziv;
    @FXML
    private TableColumn colGradStanovnika;
    @FXML
    private TableColumn colGradDrzava;
    @FXML
    private Button btndodajGrad;
    @FXML
    private Button btndodajDrzavu;
    @FXML
    private Button btnizmijeniGrad;
    @FXML
    private Button btnobrisiGrad;
    @FXML
    private TableView tableViewGradovi;
    private List<grad> gradovi;

    private SimpleStringProperty id;
    private SimpleStringProperty naziv;
    private SimpleStringProperty stanovnika;
    private SimpleStringProperty drzava;
    public GlavnaController() {
        gradovi = new ArrayList<>();
        id = new SimpleStringProperty("");
        naziv = new SimpleStringProperty("");
        stanovnika = new SimpleStringProperty("");
        drzava = new SimpleStringProperty("");
    }

    public void initialize() {
        napuni();
        ObservableList<grad> listaGradova = FXCollections.observableList(gradovi);
        tableViewGradovi.setItems(listaGradova);

        colGradId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colGradNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        colGradStanovnika.setCellValueFactory(new PropertyValueFactory<>("broj_stanovnika"));
        colGradDrzava.setCellValueFactory(new PropertyValueFactory<>("drzava"));

        //bind();
        /*tableViewGradovi.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null) {
                grad selectedGrad = (grad) newSelection;
                id.set(String.valueOf(selectedGrad.getId()));
                naziv.set(selectedGrad.getNaziv());
                stanovnika.set(String.valueOf(selectedGrad.getBroj_stanovnika()));
                drzava.set(String.valueOf(selectedGrad.getDrzava()));
            } else {
                unbind();
                id.set("");
                naziv.set("");
                stanovnika.set("");
                drzava.set("");
            }

        });*/
    }

    private void bind() {
        colGradId.textProperty().bindBidirectional(id);
        colGradNaziv.textProperty().bindBidirectional(naziv);
        colGradStanovnika.textProperty().bindBidirectional(stanovnika);
        colGradDrzava.textProperty().bindBidirectional(drzava);
    }

    private void unbind() {
        colGradId.textProperty().unbindBidirectional(id);
        colGradNaziv.textProperty().unbindBidirectional(naziv);
        colGradStanovnika.textProperty().unbindBidirectional(stanovnika);
        colGradDrzava.textProperty().unbindBidirectional(drzava);
    }

    private void napuni() {
        gradovi.add(new grad(1, "Sarajevo", 500000, "BiH"));
        gradovi.add(new grad(2, "Tuzla", 200000, "BiH"));
        gradovi.add(new grad(3, "Mostar", 300000, "BiH"));
        gradovi.add(new grad(4, "Zagreb", 500000, "Hrvatska"));
        gradovi.add(new grad(5, "Split", 200000, "Hrvatska"));
        gradovi.add(new grad(6, "Rijeka", 300000, "Hrvatska"));
        gradovi.add(new grad(7, "Beograd", 500000, "Srbija"));
        gradovi.add(new grad(8, "Novi Sad", 200000, "Srbija"));
        gradovi.add(new grad(9, "Nis", 300000, "Srbija"));
    }

    @FXML
    private void btndodajGradAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("grad.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        GradController gradController = new GradController();
        stage.show();
    }
    @FXML
    private void btndodajDrzavuAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("drzava.fxml"));
        Parent root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root2));
        DrzavaController drzavaController = new DrzavaController();
        stage.show();
    }

    @FXML
    private void btnizmijeniGradAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("grad.fxml"));
        Parent root3 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root3));
        GradController gradController = new GradController();
        stage.show();
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public String getStanovnici() {
        return stanovnika.get();
    }

    public SimpleStringProperty stanovniciProperty() {
        return stanovnika;
    }

    public String getDrzava() {
        return drzava.get();
    }

    public SimpleStringProperty drzavaProperty() {
        return drzava;
    }
}