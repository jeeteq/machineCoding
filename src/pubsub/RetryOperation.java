package pubsub;

@FunctionalInterface
public interface RetryOperation {
    void execute();
}
