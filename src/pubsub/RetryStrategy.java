package pubsub;

public interface RetryStrategy {

    void performWithRetry(RetryOperation operation) throws Exception;
}
