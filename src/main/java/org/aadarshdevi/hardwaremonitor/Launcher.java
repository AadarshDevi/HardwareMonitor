package org.aadarshdevi.hardwaremonitor;

import javafx.application.Application;
import org.aadarshdevi.hardwaremonitor.frontend.Main;

public class Launcher {
    static void main(String[] args) {
//        SerialPort[] serialPorts = SerialPort.getCommPorts();
//        for (SerialPort serialPort : serialPorts) {
//            System.out.println(serialPort.getSystemPortName() + " :: " + serialPort);
//        }
//        String serialPort = "COM7";
//        SerialCommunicator serialCommunicator = new SerialCommunicator(SerialPort.getCommPort(serialPort));
//        Thread serialCommThread = new Thread(serialCommunicator);
//        serialCommThread.start();
        Application.launch(Main.class, args);
    }
}
