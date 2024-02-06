package pubsub;

public interface Callback {

    void handelMessage(Message message);

    Boolean isProcessed();
}
