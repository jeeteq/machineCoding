package amazonPrime.video;

import amazonPrime.ObjectDto;

public abstract class Video extends ObjectDto {
    String title;

    protected Video(String title) {
        super();
        this.title = title;
    }

    public Long getId() {
        return getId();
    }

    public abstract void play();
}
