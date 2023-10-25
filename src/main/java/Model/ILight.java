package Model;

/**
 * The ILight interface defines the contract for all light providing a method to get the color of the light.
 */
public interface ILight {

    /**
     * Get the color of the light source
     *
     * @return The color of the light
     */
    Color getColor();
}

