package amazonPrime.decorator;

import amazonPrime.video.Video;

public abstract class VideoDecorator {
    Video video;
    protected VideoDecorator(Video video) {
        this.video = video;
    }

    public void play() {
        video.play();
    }
}
