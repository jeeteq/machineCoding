package amazonPrime.video;

public class TvShow extends Video {

    public TvShow(String title) {
        super(title);
    }

    @Override
    public void play() {
        System.out.println("TvShow " + getId() + " playing");
    }
}