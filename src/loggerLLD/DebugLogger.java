package com.example.jeetendra.logger;

public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level, AbstractLogger nextLogger) {
        super(level, nextLogger);
    }

    @Override
    protected void display(String message, LogSubject subject) {
        String logMessage = "[" + getCurrentDateAndTime() + "] " + "[DEBUG]: " + message;
        subject.notifyAll(level, logMessage);
    }
}
