package Model;

/**
 * The IShadowState interface defines a method for managing the state of shadows.
 * Implementing classes are responsible for enabling or disabling shadows.
 */
public interface IShadowState {
    /**
     * Activates or deactivates shadows based on the provided Shadow object.
     *
     * @param s The Shadow object for which shadows need to be activated or deactivated.
     */
    void activateShadows(Shadow s);
}
