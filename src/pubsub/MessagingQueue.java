package pubsub;

public class MessagingQueue<T> {
    Node<T> front;
    Node<T> rear;
    int size;

    public MessagingQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public T getFront() {
        return front == null ? null : front.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean addMessage(T message) {
        Node<T> temp = new Node<>(message);
        if (front == null) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        size++;
        return true;
    }

    public boolean removeMessage() {
        if (size == 0) {
            return false;
        }
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
        }
        size--;
        return true;
    }
}
