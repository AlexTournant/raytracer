package Model;

/**
 * A directional light source, implementing the ILight interface
 */
    public class DirectionalLight implements ILight {
    /**
     * Initialize the attributes
     */
    private Color color;
        private Vector direction;

    /**
     *Constructor of a directional light with using a color and direction
     *
     * @param color The color of the directional light
     * @param direction The direction of the light
     */
    public DirectionalLight(Color color, Vector direction) {
            this.color = color;
            this.direction = direction;
        }

    /**
     * Get the color of the directional light
     *
     * @return the color of the light
     */
    @Override
        public Color getColor() {
            return color;
        }

    /**
     * Get the direction of the light
     *
     * @return the direction vector of the light source
     */
    public Vector getPosition() {

            return direction;
        }
    }