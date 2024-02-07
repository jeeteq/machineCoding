package com.example.jeetendra.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileObserver implements LogObserver {

    private static final String fileName = "log.txt";

    @Override
    public void consumeLog(String message) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error writing to the log file: " + e.getMessage());
        }
    }
}
