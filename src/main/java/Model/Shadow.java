package Model;

public class Shadow {

    private IShadowState state;

    public Shadow() {
        state = new DeactivateShadows();
    }

    public void setState(IShadowState s) {
        this.state = s;
    }

    public void handle() {
        state.activateShadows(this);
    }


}
