package Model;

/**
 * Represents a point light source with color and position
 */
public class PonctualLight implements ILight {

    /**
     * Initialize attribute
     */
    private Color color;
    private Point position;

    /**
     * Constructs a PonctualLightusing a color and a position
     *
     * @param color The color of the light source
     * @param position The position of the light source
     */
    public PonctualLight(Color color, Point position) {
        this.color = color;
        this.position = position;
    }

    /**
     * Get the color of the ponctual light source
     *
     * @return The color of the light source
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Get the position of the ponctual light source
     *
     * @return The position of the light source
     */
    public Point getPosition() {
        return position;
    }
}
