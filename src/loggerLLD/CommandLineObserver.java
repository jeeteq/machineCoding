package com.example.jeetendra.logger;

public class CommandLineObserver implements LogObserver {
    @Override
    public void consumeLog(String message) {
        System.out.println("CommandLine: " + message);
    }
}
