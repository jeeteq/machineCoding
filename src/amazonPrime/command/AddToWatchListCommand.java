package amazonPrime.command;

import amazonPrime.observer.User;
import amazonPrime.video.Video;

public class AddToWatchListCommand implements ICommand {

    Video video;
    User user;

    AddToWatchListCommand(Video video, User user) {
        this.video = video;
        this.user = user;
    }

    @Override
    public void execute() {
        user.addVideoToWatchList(video);
    }
}
