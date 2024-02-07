package battleship;

import battleship.exception.CoordinateOutOfBoundException;
import battleship.model.Player;
import battleship.model.TargetPlayer;
import battleship.strategy.IPlayerPickingStrategy;
import battleship.strategy.IWinnerStrategy;
import java.util.List;

public class Game {
    List<Player> players;
    IWinnerStrategy winnerStrategy;

    IPlayerPickingStrategy playerPickingStrategy;

    public Game(List<Player> players, IWinnerStrategy winnerStrategy, IPlayerPickingStrategy playerPickingStrategy) {
        this.players = players;
        this.winnerStrategy = winnerStrategy;
        this.playerPickingStrategy = playerPickingStrategy;

    }

    public void start() {
        Player currentPlayer = playerPickingStrategy.getFirstPlayer(this.players);
        while (true) {
            TargetPlayer targetPlayer = currentPlayer.takeTarget(this.players);
            try {
                targetPlayer.getTargetPlayer().takeHit(targetPlayer.getTargetCoordinate());
            } catch (CoordinateOutOfBoundException exception) {
                System.out.println("Hit was out of bounds.");
            }

            Player winner = winnerStrategy.getWinner(this.players);
            if(winner != null){
                System.out.println("winner is "+ winner);
                break;
            }
            currentPlayer = playerPickingStrategy.nexPlayer(this.players);
        }
    }
}
