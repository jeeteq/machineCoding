package loggerLLD;

public class LogManager {

    public static AbstractLogger buildLogger() {
        return new InfoLogger(1, new ErrorLogger(2, new DebugLogger(3, null)));
    }

    public static LogSubject buildSubject() {
        LogObserver fileObserver = new FileObserver();
        LogObserver commandLineObserver = new CommandLineObserver();
        LogObserver databaseObserver = new DatabaseObserver();

        LogSubject logSubject = new LogSubject();

        logSubject.addObserver(1, fileObserver);
        logSubject.addObserver(1, commandLineObserver);

        logSubject.addObserver(2, commandLineObserver);
        logSubject.addObserver(2, databaseObserver);

        logSubject.addObserver(3, fileObserver);
        logSubject.addObserver(3, commandLineObserver);
        logSubject.addObserver(3, databaseObserver);

        return logSubject;

    }
}
