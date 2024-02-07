package battleship.model;

import battleship.boundry.IBoundary;
import battleship.exception.CoordinateOutOfBoundException;
import battleship.exception.DuplicateCoordinateHitException;
import java.util.List;

public class Board {
    List<BoardItem> ships;
    IBoundary boundary;
    List<Coordinate> allBombedLocation;

    public Board(IBoundary boundary, List<BoardItem> ships) {
        this.boundary = boundary;
        this.ships = ships;
    }

    public void takeHit(Coordinate coordinate) {
        if (!boundary.contains(coordinate)) {
            throw new CoordinateOutOfBoundException();
        }
        if (allBombedLocation.contains(coordinate)) {
            throw new DuplicateCoordinateHitException();
        }
        allBombedLocation.add(coordinate);
    }

    public boolean areAllShipsKilled() {
        for (BoardItem item : ships) {
            if (!item.isKilled(allBombedLocation)) {
                return false;
            }
        }
        return true;
    }


}
