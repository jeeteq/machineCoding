package amazonPrime;

import amazonPrime.video.Video;
import java.util.ArrayList;
import java.util.List;

public class VideoCatalog {
    private static VideoCatalog instance;
    private final List<Video> videos;

    private VideoCatalog() {
        videos = new ArrayList<>();
    }

    public static VideoCatalog getInstance() {
        if (instance == null) {
            instance = new VideoCatalog();
        }
        return instance;
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public Video getVideo(Long videoId) {
        for (Video video : videos) {
            if (video.getId().equals(videoId)) {
                return video;
            }
        }
        return null;
    }
}

