/**
 * Enables shadows in a ray tracing system by changing the state of a provided shadow object.
 */
package Model;

/**
 * The ActivateShadows class is responsible for enabling shadows.
 * It implements the IShadowState interface, defining the method to manage shadow states.
 */
public class ActivateShadows implements IShadowState {

    /**
     * Activates shadows by setting the state of the given Shadow object to enable shadows.
     *
     * @param s The Shadow object to enable shadows for.
     */
    public void activateShadows(Shadow s) {
        s.setState(new DeactivateShadows());
    }

}
