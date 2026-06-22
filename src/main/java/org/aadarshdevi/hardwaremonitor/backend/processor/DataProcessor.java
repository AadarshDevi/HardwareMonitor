package org.aadarshdevi.hardwaremonitor.backend.processor;

import java.util.concurrent.LinkedBlockingQueue;

public class DataProcessor implements Runnable {

    private static DataProcessor instance;
    LinkedBlockingQueue<String> rawData = new LinkedBlockingQueue<>();
    LinkedBlockingQueue<Double[]> processedData = new LinkedBlockingQueue<>();

    public static DataProcessor getInstance() {
        if (instance == null) instance = new DataProcessor();
        return instance;
    }

    @Override
    public void run() {

    }
}
