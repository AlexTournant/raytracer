package light;

import triplet.Color;
import triplet.Point;
import triplet.Vector;

/**
 * The DirectionalLight class represents a directional light source.
 * It emits light in a specified direction and has a color associated with it.
 */
public class DirectionalLight implements ILight {
    private Color color;      // The color of the directional light
    private Vector direction; // The direction of the light

    /**
     * Constructs a DirectionalLight object with the specified color and direction.
     *
     * @param color The color of the directional light.
     * @param direction The direction in which the light is emitted.
     */
    public DirectionalLight(Color color, Vector direction) {
        this.color = color;
        this.direction = direction;
    }

    /**
     * Gets the color of the directional light.
     *
     * @return The color of the light as a Color object.
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Gets the direction in which the light is emitted.
     *
     * @return The direction vector of the light as a Vector object.
     */
    @Override
    public Vector getDirection() {
        return direction;
    }

    /**
     * Gets the position of the light (always null for a directional light).
     *
     * @return Always null, as directional lights have no specific position.
     */
    @Override
    public Point getPosition() {
        return null;
    }
}
