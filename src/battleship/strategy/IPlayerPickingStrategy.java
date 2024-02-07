package battleship.strategy;

import battleship.model.Player;
import java.util.List;

public interface IPlayerPickingStrategy {
    Player getFirstPlayer(List<Player> player);

    Player nexPlayer(List<Player> players);
}
