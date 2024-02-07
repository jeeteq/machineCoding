package amazonPrime.decorator;

import amazonPrime.video.Video;

public class HDVideo extends VideoDecorator {
    protected HDVideo(Video video) {
        super(video);
    }

    public void play() {
        System.out.println("HD video converted");
        video.play();
    }
}
