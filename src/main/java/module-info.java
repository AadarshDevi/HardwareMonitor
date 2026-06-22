module org.aadarshdevi.hardwaremonitor {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.fazecast.jSerialComm;


    opens org.aadarshdevi.hardwaremonitor to javafx.fxml;
    opens org.aadarshdevi.hardwaremonitor.frontend to javafx.fxml, javafx.graphics, java.desktop;
    exports org.aadarshdevi.hardwaremonitor;
}