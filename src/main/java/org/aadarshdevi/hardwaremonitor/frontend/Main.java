package org.aadarshdevi.hardwaremonitor.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.aadarshdevi.hardwaremonitor.frontend.controller.HomeController;

import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL resource = Main.class.getResource("/org/aadarshdevi/hardwaremonitor/frontend/controller/Home_v1.fxml");
        System.out.println(resource);
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        BorderPane root = fxmlLoader.load();
        HomeController controller = fxmlLoader.getController();

        stage.setScene(new Scene(root));
        stage.setTitle("Hardware Monitor 0.1.0");
        stage.show();
    }
}
// /src/main/java
//