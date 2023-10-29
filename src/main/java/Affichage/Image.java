package Affichage;

/**
 * The Image class represents an image with width, height, and a name.
 * It gives information about the dimensions of the image and the output file name.
 */
public class Image {
    private int ImageWidth;    // The width of the image
    private int ImageHeight;   // The height of the image
    private String ImageName;  // The name of the image file

    /**
     * Constructs an Image object with the specified width, height, and image name.
     *
     * @param ImageWidth  The width of the image.
     * @param ImageHeight The height of the image.
     * @param ImageName   The name of the image file.
     */
    public Image(int ImageWidth, int ImageHeight, String ImageName) {
        this.ImageWidth = ImageWidth;
        this.ImageHeight = ImageHeight;
        this.ImageName = ImageName;
    }

    /**
     * Gets the width of the image.
     *
     * @return The width of the image.
     */
    public int getImageWidth() {
        return ImageWidth;
    }

    /**
     * Sets the width of the image.
     *
     * @param ImageWidth The new width of the image.
     */
    public void setImageWidth(int ImageWidth) {
        this.ImageWidth = ImageWidth;
    }

    /**
     * Gets the height of the image.
     *
     * @return The height of the image.
     */
    public int getImageHeight() {
        return ImageHeight;
    }

    /**
     * Sets the height of the image.
     *
     * @param ImageHeight The new height of the image.
     */
    public void setImageHeight(int ImageHeight) {
        this.ImageHeight = ImageHeight;
    }

    /**
     * Gets the name of the image file.
     *
     * @return The name of the image file.
     */
    public String getImageName() {
        return ImageName;
    }

    /**
     * Sets the name of the image file.
     *
     * @param ImageName The new name for the image file.
     */
    public void setImageName(String ImageName) {
        this.ImageName = ImageName;
    }
}
