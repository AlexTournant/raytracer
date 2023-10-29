package Light;

import Triplet.Color;
import Triplet.Point;
import Triplet.Vector;

/**
 * Represents a point light source in the scene with a specified color and position.
 */
public class PonctualLight implements ILight {
    private Color color;
    private Point position;

    /**
     * Creates a point light source with the specified color and position.
     *
     * @param color The color of the light source.
     * @param position The position of the light source in 3D space.
     */
    public PonctualLight(Color color, Point position) {
        this.color = color;
        this.position = position;
    }

    /**
     * Get the position of the point light source.
     *
     * @return The 3D position of the light source.
     */
    @Override
    public Point getPosition() {
        return position;
    }

    /**
     * Get the color of the point light source.
     *
     * @return The color of the light source.
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Get the direction from the light source. (Not applicable for a point light source; returns null)
     *
     * @return Null since point light sources do not have a specific direction.
     */
    @Override
    public Vector getDirection() {
        return null;
    }
}
