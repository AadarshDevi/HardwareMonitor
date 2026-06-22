package org.aadarshdevi.hardwaremonitor.backend.serial;

import com.fazecast.jSerialComm.SerialPort;
import org.aadarshdevi.hardwaremonitor.backend.processor.DataProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Sends data to microcontroller. Receives data to microcontroller. data received from microcontroller will be sent to DataProcessor
 */
public class SerialCommunicator implements Runnable {
    private final SerialPort serialPort;
    private final DataProcessor dataProcessor = DataProcessor.getInstance();

    public SerialCommunicator(SerialPort serialPort) {
        this.serialPort = serialPort;
        this.serialPort.setComPortParameters(115200, 8, 1, 0);
        this.serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 1000, 0);
    }

    @Override
    public void run() {
        serialPort.openPort();
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(serialPort.getInputStream()))
        ) {
            while (!Thread.interrupted()) {
                String line = in.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
