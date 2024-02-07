package com.example.jeetendra.logger;

public class DatabaseObserver implements LogObserver {
    @Override
    public void consumeLog(String message) {
        System.out.println("Database: " + message);
    }
}
