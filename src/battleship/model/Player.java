package battleship.model;

import battleship.strategy.ITargetStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    int id;
    Board board;
    ITargetStrategy targetStrategy;

    public Player(int id, Board board, ITargetStrategy targetStrategy) {
        this.id = id;
        this.board = board;
        this.targetStrategy = targetStrategy;
    }

    public int getId() {
        return this.id;
    }

    public TargetPlayer takeTarget(List<Player> players) {
        List<Player> opponents =
            players.stream().filter((player) -> player.getId() != this.id).collect(Collectors.toList());
        return targetStrategy.getTargetPlayer(opponents);
    }

    public void takeHit(Coordinate coordinate) {
        board.takeHit(coordinate);
    }

    public boolean areAllShipsKilled() {
        return board.areAllShipsKilled();
    }
}
