package amazonPrime.video;

import amazonPrime.video.Video;

public class Movie extends Video {

    public Movie(String title) {
        super(title);
    }

    @Override
    public void play() {
        System.out.println("Movie " + getId() + " playing");
    }
}
