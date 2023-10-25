package Model;


/**
*Represents a camera with attributes, the position, the orientation, direction and field of view
 */
public class Camera {

    /**
     * Initialize all the attributes
     */
    private Triplet lookFrom;
    private Triplet lookAt;
    private Triplet up;
    private int fov;

    /**
     * The camera's constructor
     *
     * @param lookFrom The position of the camera.
     * @param lookAt   The point the camera is facing.
     * @param up       The camera's upward direction.
     * @param fov      The Field of View of the camera.
     */
    public Camera(Triplet lookFrom, Triplet lookAt, Triplet up, int fov) {
        this.lookFrom = lookFrom;
        this.lookAt = lookAt;
        this.up = up;
        this.fov = fov;
    }

    /**
     * Method to get the current position
     *
     * @return The position of the camera
     */
    public Triplet getLookFrom() {
        return lookFrom;
    }

    /**
     * Method to set the position
     *
     * @param lookFrom The new position of the camera
     */
    public void setLookFrom(Triplet lookFrom) {
        this.lookFrom = lookFrom;
    }

    /**
     * Method to get the orientation of the camera is facing
     *
     * @return The orientation the camera is facing
     */
    public Triplet getLookAt() {
        return lookAt;
    }

    /**
     * Method to set the orientation of the camera is facing
     *
     * @param lookAt The new orientation the camera will face
     */
    public void setLookAt(Triplet lookAt) {
        this.lookAt = lookAt;
    }

    /**
     * Method to get the upward direction of the camera
     *
     * @return The camera's current upward direction
     */
    public Triplet getUp() {
        return up;
    }

    /**
     * Method to set the upward direction of the camera
     *
     * @param up The new upward direction of the camera
     */
    public void setUp(Triplet up) {
        this.up = up;
    }

    /**
     * Method to get the current Field of view
     *
     * @return The current Field of view
     */
    public int getFov() {
        return fov;
    }

    /**
     * Method to set the Field of view
     *
     * @param fov The new Field of view of the camera
     */
    public void setFov(int fov) {
        this.fov = fov;

    }
}