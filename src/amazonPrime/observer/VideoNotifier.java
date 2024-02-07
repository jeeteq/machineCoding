package amazonPrime.observer;

import java.util.ArrayList;
import java.util.List;

public class VideoNotifier {

    List<User> observers;

    public VideoNotifier() {
        observers = new ArrayList<>();
    }

    public void addObserver(User user) {
        observers.add(user);
    }

    public void removeObserver(User user) {
        observers.remove(user);
    }

    public void notifyObservers(String message) {
        for (User observer : observers) {
            observer.update(message);
        }
    }
}
