package loggerLLD;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AbstractLogger {
    private AbstractLogger nextLogger;
    protected int level;

    protected AbstractLogger(int level, AbstractLogger abstractLogger) {
        this.level = level;
        this.nextLogger = abstractLogger;
    }

    public void logMessage(int level, String message, LogSubject subject) {
        if (level == this.level) {
            display(message, subject);
        } else {
            nextLogger.logMessage(level, message, subject);
        }
    }

    protected String getCurrentDateAndTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
    protected abstract void display(String message, LogSubject subject);
}
