package battleship.strategy;

import battleship.model.Player;
import battleship.model.TargetPlayer;
import java.util.List;

public interface ITargetStrategy {

    TargetPlayer getTargetPlayer(List<Player> opponets);
}
