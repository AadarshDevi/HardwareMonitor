package org.aadarshdevi.hardwaremonitor.frontend;

import javafx.application.Application;
import javafx.stage.Stage;
import org.aadarshdevi.hardwaremonitor.backend.setup.ApplicationSetup;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        ApplicationSetup as = ApplicationSetup.getInstance();
        as.findOS();
        as.findRoots();
        as.findSettings();
        as.findLog();
        as.findComponents();


    }
}

//        URL resource = Main.class.getResource("/org/aadarshdevi/hardwaremonitor/frontend/controller/Home_v1.fxml");
//        System.out.println(resource);
//        FXMLLoader fxmlLoader = new FXMLLoader(resource);
//        BorderPane root = fxmlLoader.load();
//        HomeController controller = fxmlLoader.getController();
//
//        stage.setScene(new Scene(root));
//        stage.setTitle("Hardware Monitor 0.1.0");
//        stage.show();
