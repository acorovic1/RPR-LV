module ba.etf.unsa.lv1011 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens ba.etf.unsa.lv1011 to javafx.fxml;
    exports ba.etf.unsa.lv1011;
}