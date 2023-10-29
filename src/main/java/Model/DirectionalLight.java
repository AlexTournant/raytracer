package Model;

import javax.annotation.processing.Generated;

public class DirectionalLight implements ILight {
    private Color color;
    private Vector direction;

    /**
     * @param color
     * @param direction
     */
    public DirectionalLight(Color color, Vector direction) {
        this.color = color;
        this.direction = direction;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Vector getDirection() {
        return direction;
    }

    @Override
    public Point getPosition() {
        return null;
    }
}
