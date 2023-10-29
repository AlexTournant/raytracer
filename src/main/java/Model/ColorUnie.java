package Model;

/**
 * The ColorUnie class is an implementation of the IColorStrategy interface that provides
 * a uniform color across all pixels.
 */
public class ColorUnie implements IColorStrategy {
    private Color color; // The constant color to be used for all pixels

    /**
     * Constructs a ColorUnie object with the specified constant color.
     *
     * @param color The color to be used uniformly across all pixels.
     */
    public ColorUnie(Color color) {
        this.color = color;
    }

    /**
     * Gets the constant color for all pixels in the image.
     *
     * @param i The horizontal position (not used).
     * @param j The vertical position (not used).
     * @return The constant color defined for the entire image.
     */
    @Override
    public Color getColor(int i, int j) {
        return color;
    }
}
