package light;

import triplet.Color;
import triplet.Point;
import triplet.Vector;

/**
 * The ILight interface defines methods for obtaining information about a light source,
 * including its color, direction, and position.
 */
public interface ILight {
    /**
     * Gets the color of the light source.
     *
     * @return The color of the light as a Color object.
     */
    Color getColor();

    /**
     * Gets the direction of the light source.
     *
     * @return The direction vector of the light as a Vector object.
     */
    Vector getDirection();

    /**
     * Gets the position of the light source. May return null for some types of lights.
     *
     * @return The position of the light as a Point object or null if not applicable.
     */
    Point getPosition();
}
