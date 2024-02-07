package amazonPrime.state;

public class StopState implements VideoState {
    @Override
    public void play() {
        System.out.println("Video is playing...");
    }

    @Override
    public void pause() {
        System.out.println("Cannot pause. Video is stopped.");
    }

    @Override
    public void stop() {
        System.out.println("Video is already stopped");
    }
}
