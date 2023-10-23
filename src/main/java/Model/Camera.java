package Model;

public class Camera {
    private Triplet lookFrom;
    private Triplet lookAt;
    private Triplet up;
    private int fov;

    public Camera(Triplet lookFrom, Triplet lookAt, Triplet up, int fov) {
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
        this.up = up;
        this.fov = fov;
    }



}
