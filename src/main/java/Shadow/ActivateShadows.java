package Shadow;

public class ActivateShadows implements IShadowState {

    public void activateShadows(Shadow s) {
        s.setState(new DeactivateShadows());
    }

}
