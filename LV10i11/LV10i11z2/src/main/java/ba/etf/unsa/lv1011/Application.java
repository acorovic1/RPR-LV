package ba.etf.unsa.lv1011;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("glavna.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        GlavnaController controller = fxmlLoader.getController();
        stage.setTitle("Gradovi svijeta!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}