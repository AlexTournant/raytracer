package affichage;

/**
 * The Image class represents an image with width, height, and a name.
 * It gives information about the dimensions of the image and the output file name.
 */
public class Image {
    private int imageWidth;    // The width of the image
    private int imageHeight;   // The height of the image
    private String imageName;  // The name of the image file

    /**
     * Constructs an Image object with the specified width, height, and image name.
     *
     * @param imageWidth  The width of the image.
     * @param imageHeight The height of the image.
     * @param imageName   The name of the image file.
     */
    public Image(int imageWidth, int imageHeight, String imageName) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.imageName = imageName;
    }

    /**
     * Gets the width of the image.
     *
     * @return The width of the image.
     */
    public int getImageWidth() {
        return imageWidth;
    }

    /**
     * Sets the width of the image.
     *
     * @param imageWidth The new width of the image.
     */
    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    /**
     * Gets the height of the image.
     *
     * @return The height of the image.
     */
    public int getImageHeight() {
        return imageHeight;
    }

    /**
     * Sets the height of the image.
     *
     * @param imageHeight The new height of the image.
     */
    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    /**
     * Gets the name of the image file.
     *
     * @return The name of the image file.
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Sets the name of the image file.
     *
     * @param imageName The new name for the image file.
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
