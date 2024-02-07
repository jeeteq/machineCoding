package amazonPrime.observer;

import amazonPrime.ObjectDto;
import amazonPrime.video.Video;
import java.util.ArrayList;
import java.util.List;

public class User extends ObjectDto implements Observer {
    String name;
    List<Video> watchList;

    public User(String name) {
        super();
        this.name = name;
        this.watchList = new ArrayList<>();
    }

    public Long getId() {
        return getId();
    }

    public void addVideoToWatchList(Video video) {
        watchList.add(video);
    }

    public void removeVideoFromWatchList(Video video) {
        watchList.remove(video);
    }

    public boolean hasSubscription() {
        return true;
    }


    @Override
    public void update(String message) {
        System.out.println("User " + getId() + " received update: " + message);
    }
}
