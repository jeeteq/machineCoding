package loggerLLD;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level, AbstractLogger nextLogger) {
        super(level, nextLogger);
    }

    @Override
    protected void display(String message, LogSubject subject) {
        String logMessage = "[" + getCurrentDateAndTime() + "] " + "[INFO]: " + message;
        subject.notifyAll(level, logMessage);
    }
}
