package Model;

/**
 * The Camera class represents the viewpoint and configuration of a camera.
 * It defines the camera's position (lookFrom), the point it's looking at (lookAt), the up vector,
 * and the field of view (fov) for rendering scenes.
 */
public class Camera {
    private Point lookFrom; // Camera position
    private Point lookAt;   // The point the camera is looking at
    private Vector up;      // The up vector defining the camera's orientation
    private int fov;        // The camera's field of view

    /**
     * Constructs a Camera object with the specified parameters.
     *
     * @param lookFrom The camera's position.
     * @param lookAt The point the camera is looking at.
     * @param up The up vector defining the camera's orientation.
     * @param fov The camera's field of view in degrees.
     */
    public Camera(Point lookFrom, Point lookAt, Vector up, int fov) {
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
        this.up = up;
        this.fov = fov;
    }

    /**
     * Get the camera's position.
     *
     * @return The camera's position as a Point.
     */
    public Point getLookFrom() {
        return lookFrom;
    }

    /**
     * Set the camera's position.
     *
     * @param lookFrom The new camera position as a Point.
     */
    public void setLookFrom(Point lookFrom) {
        this.lookFrom = lookFrom;
    }

    /**
     * Get the point the camera is looking at.
     *
     * @return The point the camera is looking at as a Point.
     */
    public Point getLookAt() {
        return lookAt;
    }

    /**
     * Set the point the camera is looking at.
     *
     * @param lookAt The new point the camera is looking at as a Point.
     */
    public void setLookAt(Point lookAt) {
        this.lookAt = lookAt;
    }

    /**
     * Get the up vector defining the camera's orientation.
     *
     * @return The up vector as a Vector.
     */
    public Vector getUp() {
        return up;
    }

    /**
     * Set the up vector defining the camera's orientation.
     *
     * @param up The new up vector as a Vector.
     */
    public void setUp(Vector up) {
        this.up = up;
    }

    /**
     * Get the camera's field of view.
     *
     * @return The camera's field of view in degrees.
     */
    public int getFov() {
        return fov;
    }

    /**
     * Set the camera's field of view.
     *
     * @param fov The new field of view in degrees.
     */
    public void setFov(int fov) {
        this.fov = fov;
    }
}
