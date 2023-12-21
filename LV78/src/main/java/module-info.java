module com.example.form {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.form to javafx.fxml;
    exports com.example.form;
}