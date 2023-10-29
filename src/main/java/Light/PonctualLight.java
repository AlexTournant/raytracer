package Light;

import Triplet.Color;
import Triplet.Point;
import Triplet.Vector;

public class PonctualLight implements ILight {
    private Color color;
    private Point position;

    public PonctualLight(Color color, Point position) {
        this.color = color;
        this.position = position;
    }
    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Vector getDirection() {
        return null;
    }
}
