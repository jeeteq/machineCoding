package pubsub;

import java.util.ArrayList;
import java.util.List;

public class PubSubService {
    MessagingQueue<Message> messagingQueue;

    RetryStrategy retryStrategy;
    List<Subscriber> subscribers;

    public PubSubService() {
        this.messagingQueue = new MessagingQueue<>();
        this.subscribers = new ArrayList<>();
        this.retryStrategy = new RetryImpl(3);
    }

    public void addSubscriber(String regex, Callback callback, List<Subscriber> dependencies) {
        subscribers.add(new Subscriber(regex, callback, dependencies));
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishMessage(Message message) {
        try {
            System.out.println("publishing message "+ message);
            retryStrategy.performWithRetry(() -> {
                messagingQueue.addMessage(message);
                notifyAllSubscribers();
            });
        } catch (Exception e) {
            System.out.println("Retrying attempt exceeded for the message " + message);
        }
    }


    private void notifyAllSubscribers() {
        Message message = messagingQueue.getFront();
        for (Subscriber subscriber : subscribers) {
            if (message != null && !subscriber.getIsProcessed()) {
                subscriber.processMessage(message);
            }
        }
        messagingQueue.removeMessage();
        for (Subscriber subscriber : subscribers) {
            subscriber.setIsProcessed(false);
        }
        messagingQueue.removeMessage();
    }
}
