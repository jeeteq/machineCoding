package amazonPrime.state;

public class PauseState implements VideoState{
    @Override
    public void play() {
        System.out.println("Resuming video...");
    }

    @Override
    public void pause() {
        System.out.println("Video is already paused.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping video...");
    }
}
