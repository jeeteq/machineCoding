package pubsub;

public class RetryImpl implements RetryStrategy {

    private final Integer maxRetriesAttempt;

    public RetryImpl(Integer maxRetriesAttempt) {
        this.maxRetriesAttempt = maxRetriesAttempt;
    }

    @Override
    public void performWithRetry(RetryOperation operation) throws Exception {
        int attempt = 0;
        while (attempt <= maxRetriesAttempt) {
            try {
                operation.execute();
            } catch (Exception e) {
                attempt++;
                System.out.println("Retrying operation");
            }
        }
        if (attempt >= maxRetriesAttempt) {
            System.out.println("Retrying attempt exceeded");
        }
    }
}
