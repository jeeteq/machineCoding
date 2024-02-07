package loggerLLD;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level, AbstractLogger nextLogger) {
        super(level, nextLogger);
    }

    @Override
    protected void display(String message, LogSubject subject) {
        String logMessage = "[" + getCurrentDateAndTime() + "] " + "[ERROR]: " + message;
        subject.notifyAll(level, logMessage);
    }
}
