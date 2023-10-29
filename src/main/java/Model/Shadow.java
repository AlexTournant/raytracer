package Model;

/**
 * The `Shadow` class represents a component responsible for managing shadow rendering in a 3D scene.
 * It uses different shadow states to control the behavior of shadows.
 */
public class Shadow {

    private IShadowState state;

    /**
     * Constructs a `Shadow` object with the default state, which is to deactivate shadows.
     */
    public Shadow() {
        state = new DeactivateShadows();
    }

    /**
     * Sets the current shadow state to the specified state.
     *
     * @param s The new shadow state to set.
     */
    public void setState(IShadowState s) {
        this.state = s;
    }

    /**
     * Handles the shadow rendering based on the current shadow state.
     * It activates or deactivates shadows as determined by the state.
     */
    public void handle() {
        state.activateShadows(this);
    }
}
