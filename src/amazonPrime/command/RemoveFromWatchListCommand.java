package amazonPrime.command;

import amazonPrime.observer.User;
import amazonPrime.video.Video;

public class RemoveFromWatchListCommand implements ICommand {
    Video video;
    User user;

    RemoveFromWatchListCommand(Video video, User user) {
        this.video = video;
        this.user = user;
    }

    @Override
    public void execute() {
        user.removeVideoFromWatchList(video);
    }
}
