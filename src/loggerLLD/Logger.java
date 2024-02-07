package com.example.jeetendra.logger;

public class Logger {
    private static Logger INSTANCE;
    private static AbstractLogger abstractLogger;
    private static LogSubject logSubject;

    private Logger() {
    }

    public static Logger getInstance() {
        if (INSTANCE == null) {
            synchronized (Logger.class) {
                INSTANCE = new Logger();
                abstractLogger = LogManager.buildLogger();
                logSubject = LogManager.buildSubject();
            }
        }
        return INSTANCE;
    }

    private void logMessage(int level, String message) {
        abstractLogger.logMessage(level, message, logSubject);
    }

    public void info(String message) {
        logMessage(1, message);
    }

    public void error(String message) {
        logMessage(2, message);
    }

    public void debug(String message) {
        logMessage(3, message);
    }
}
