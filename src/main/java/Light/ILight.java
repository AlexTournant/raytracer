package Light;

import Triplet.Color;
import Triplet.Point;
import Triplet.Vector;

public interface ILight {
    Color getColor();

    Vector getDirection();

    Point getPosition();
}

