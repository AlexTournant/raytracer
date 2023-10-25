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

    public Triplet getLookFrom() {
        return lookFrom;
    }

    public void setLookFrom(Triplet lookFrom) {
        this.lookFrom = lookFrom;
    }

    public Triplet getLookAt() {
        return lookAt;
    }

    public void setLookAt(Triplet lookAt) {
        this.lookAt = lookAt;
    }

    public Triplet getUp() {
        return up;
    }

    public void setUp(Triplet up) {
        this.up = up;
    }

    public int getFov() {
        return fov;
    }

    public void setFov(int fov) {
        this.fov = fov;
    }
}
