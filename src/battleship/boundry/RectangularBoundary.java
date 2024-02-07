package battleship.boundry;

import battleship.model.Coordinate;
import java.util.ArrayList;
import java.util.List;

public class RectangularBoundary implements IBoundary {

    Coordinate topLeft;
    Coordinate bottomRight;

    public RectangularBoundary(Coordinate topLeft, Coordinate bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    @Override
    public List<Coordinate> allLocations() {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int x = topLeft.getX(); x <= bottomRight.getX(); x++) {
            for (int y = topLeft.getY(); y <= bottomRight.getY(); y++) {
                coordinates.add(new Coordinate(x, y));
            }
        }
        return coordinates;
    }

    @Override
    public boolean contains(Coordinate coordinate) {
        return (coordinate.getX() >= topLeft.getX() && coordinate.getX() <= bottomRight.getX())
            && (coordinate.getY() >= topLeft.getY() && coordinate.getY() <= bottomRight.getY());
    }
}
