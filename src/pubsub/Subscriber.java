package pubsub;

import java.util.List;

public class Subscriber {
    String regex;
    Callback callback;
    boolean isProcessed;
    List<Subscriber> dependencies;

    public Subscriber(String regex, Callback callback, List<Subscriber> dependencies) {
        this.regex = regex;
        this.callback = callback;
        this.isProcessed = false;
        this.dependencies = dependencies;
    }


    public void processMessage(Message message) {
        processMessageForDependencies(message);
        if (this.regex.equals(message.regex)) {
            callback.handelMessage(message);
        }
        this.isProcessed = true;
    }

    private void processMessageForDependencies(Message message) {
        for (Subscriber dependency : dependencies) {
            dependency.processMessage(message);
        }
    }

    public boolean getIsProcessed() {
        return this.isProcessed;
    }

    public boolean setIsProcessed(boolean isProcessed) {
        return this.isProcessed = isProcessed;
    }
}
