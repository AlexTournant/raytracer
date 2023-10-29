package Model;

/**
 * The DimensionPixel class represents the dimensions and pixel properties of an image.
 * It stores information about the image's width, height, and field of view (fov).
 */
public class DimensionPixel {
    private int imgwith;      // The width of the image
    private int imgheight;    // The height of the image
    private int fov;          // The field of view

    /**
     * Constructs a DimensionPixel object with the specified image dimensions and field of view.
     *
     * @param imgwith   The width of the image.
     * @param imgheight The height of the image.
     * @param fov       The field of view of the camera.
     */
    public DimensionPixel(int imgwith, int imgheight, int fov) {
        this.imgwith = imgwith;
        this.imgheight = imgheight;
        this.fov = fov;
    }

    // Additional code commented out, not included in the JavaDoc comment.
}
