package Shadow;

/**
 * The DeactivateShadows class is responsible for disabling shadows.
 * It implements the IShadowState interface, defining the method to manage shadow states.
 */
public class DeactivateShadows implements IShadowState {

    /**
     * Deactivates shadows by changing the state of the provided shadow object to disable shadows.
     * This method sets the state of the shadow to ActivateShadows, preventing shadow casting
     * in the ray tracing system.
     *
     * @param s The Shadow object for which shadows need to be deactivated.
     */
    @Override
    public void activateShadows(Shadow s) {
        s.setState(new ActivateShadows());
    }
}
