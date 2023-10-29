package Model;

/**
 * The IColorStrategy interface defines a method for determining the color of a pixel
 * at a specified position. Implementing classes are responsible
 * for providing color calculations based on pixel coordinates.
 */
public interface IColorStrategy {
    /**
     * Gets the color of a pixel at the specified position (i, j).
     *
     * @param i The horizontal position of the pixel.
     * @param j The vertical position of the pixel.
     * @return The color of the pixel at the given position as a Color object.
     */
    Color getColor(int i, int j);
}
