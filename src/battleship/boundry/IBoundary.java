package battleship.boundry;

import battleship.model.Coordinate;
import java.util.List;

public interface IBoundary {
    List<Coordinate> allLocations();

    boolean contains(Coordinate coordinate);
}
