package Model;

public class Camera {
    private Point lookFrom;
    private Point lookAt;
    private Vector up;
    private int fov;

    public Camera(Point lookFrom, Point lookAt, Vector up, int fov) {
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
        this.up = up;
        this.fov = fov;
    }

    public Point getLookFrom() {
        return lookFrom;
    }

    public void setLookFrom(Point lookFrom) {
        this.lookFrom = lookFrom;
    }

    public Point getLookAt() {
        return lookAt;
    }

    public void setLookAt(Point lookAt) {
        this.lookAt = lookAt;
    }

    public Vector getUp() {
        return up;
    }

    public void setUp(Vector up) {
        this.up = up;
    }

    public int getFov() {
        return fov;
    }

    public void setFov(int fov) {
        this.fov = fov;
    }
}
