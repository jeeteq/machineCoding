package battleship.model;

import battleship.boundry.IBoundary;
import java.util.List;

public class BoardItem {
    String name;
    IBoundary boundary;

    public BoardItem(String name, IBoundary boundary) {
        this.name = name;
        this.boundary = boundary;
    }

    public boolean isKilled(List<Coordinate> hitLocations) {
        List<Coordinate> shipCoordinates = boundary.allLocations();
        for (Coordinate coordinate : shipCoordinates) {
            if (!hitLocations.contains(coordinate)) {
                return false;
            }
        }
        return true;
    }

}
