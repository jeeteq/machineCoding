package battleship.model;

public class TargetPlayer {
    Player targetPlayer;
    Coordinate targetCoordinate;

    TargetPlayer(Player targetPlayer, Coordinate targetCoordinate) {
        this.targetPlayer = targetPlayer;
        this.targetCoordinate = targetCoordinate;
    }

    public Player getTargetPlayer() {
        return targetPlayer;
    }

    public Coordinate getTargetCoordinate() {
        return targetCoordinate;
    }
}
