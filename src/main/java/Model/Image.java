package Model;

/**
 * Represents an image with width, height, and a name
 */
public class Image {
    /**
     * Initialize the attributes
     */
    private int ImageWidth;
    private int ImageHeight;
    private String ImageName = "output.png";

    /**
     * Constructs an Image using width, height, and name
     *
     * @param ImageWidth The width of the image
     * @param ImageHeight The height of the image
     * @param ImageName The name of the image
     */
    public Image(int ImageWidth, int ImageHeight, String ImageName) {
        this.ImageWidth = ImageWidth;
        this.ImageHeight = ImageHeight;
        this.ImageName = ImageName;
    }

    /**
     * Get the width of the image
     *
     * @return The width of the image
     */
    public int getImageWidth() {
        return ImageWidth;
    }

    /**
     * Set the width of the image
     *
     * @param ImageWidth The new width of the image
     */
    public void setImageWidth(int ImageWidth) {
        this.ImageWidth = ImageWidth;
    }

    /**
     * Get the height of the image
     *
     * @return The height of the image
     */
    public int getImageHeight() {
        return ImageHeight;
    }

    /**
     * Set the height of the image
     *
     * @param ImageHeight The new height of the image
     */
    public void setImageHeight(int ImageHeight) {
        this.ImageHeight = ImageHeight;
    }

    /**
     * Get the name of the image
     *
     * @return The name of the image
     */
    public String getImageName() {
        return ImageName;
    }

    /**
     * Set the name of the image
     *
     * @param ImageName The new name of the image
     */
    public void setImageName(String ImageName) {
        this.ImageName = ImageName;
    }
}
