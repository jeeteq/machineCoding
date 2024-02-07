package amazonPrime.decorator;

import amazonPrime.video.Video;

public class SubtitledVideo extends VideoDecorator {
    protected SubtitledVideo(Video video) {
        super(video);
    }

    public void play() {
        System.out.println("added subtitled");
        video.play();
    }
}
