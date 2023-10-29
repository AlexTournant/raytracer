package Shadow;

public class DeactivateShadows implements IShadowState {

    @Override
    public void activateShadows(Shadow s) {
        s.setState(new ActivateShadows());
    }
}
