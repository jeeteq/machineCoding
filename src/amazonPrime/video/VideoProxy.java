package amazonPrime.video;

import amazonPrime.observer.User;

public class VideoProxy {
    Video video;
    User user;

    public VideoProxy(Video video, User user) {
        this.video = video;
        this.user = user;
    }

    public void playVideo() {
        if (user.hasSubscription()) {
            video.play();
        }else{
            System.out.println("User " + user.getId() + " does not have a subscription.");
        }
    }
}
