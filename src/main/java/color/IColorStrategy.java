package color;

import triplet.Color;


/**
 * An interface for color strategies used to determine the color at a specific position (i, j).
 */
public interface IColorStrategy {
    /**
     * Get the color at the specified position (i, j).
     *
     * @param i The horizontal position.
     * @param j The vertical position.
     * @return The color at the specified position.
     */
    Color getColor(int i, int j);
}
