package Model;

/**
 * The ColorDamier class is an implementation of the IColorStrategy interface that
 * provides a checkerboard pattern of colors. It alternates
 * between two specified colors based on a given grid size.
 */
public class ColorDamier implements IColorStrategy {
    private Color color1;   // The first color in the checkerboard pattern
    private Color color2;   // The second color in the checkerboard pattern
    private int taille;     // The size of the grid for checkerboard pattern

    /**
     * Constructs a ColorDamier object with the specified colors and grid size.
     *
     * @param color1 The first color in the checkerboard pattern.
     * @param color2 The second color in the checkerboard pattern.
     * @param taille The size of the grid for the checkerboard pattern.
     */
    public ColorDamier(Color color1, Color color2, int taille) {
        this.color1 = color1;
        this.color2 = color2;
        this.taille = taille;
    }

    /**
     * Gets the color at the specified position (i, j) in the checkerboard pattern.
     *
     * @param i The horizontal position.
     * @param j The vertical position.
     * @return The color at the given position in the checkerboard pattern.
     */
    @Override
    public Color getColor(int i, int j) {
        int x = i / this.taille;
        int z = j / this.taille;
        if ((x + z) % 2 == 0) {
            return color1;
        } else {
            return color2;
        }
    }
}
