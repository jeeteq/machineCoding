package loggerLLD;

public class DatabaseObserver implements LogObserver {
    @Override
    public void consumeLog(String message) {
        System.out.println("Database: " + message);
    }
}
