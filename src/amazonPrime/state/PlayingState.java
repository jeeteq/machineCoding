package amazonPrime.state;

public class PlayingState implements VideoState{
    @Override
    public void play() {
        System.out.println("video is already playing");
    }

    @Override
    public void pause() {
        System.out.println("Pausing video...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping video...");
    }
}
