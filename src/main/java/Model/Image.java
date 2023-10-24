package Model;

public class Image {
    private int ImageWidth;
    private int ImageHeight;
    private String ImageName = "output.png";

    public Image(int ImageWidth, int ImageHeight, String ImageName) {
        this.ImageWidth = ImageWidth;
        this.ImageHeight = ImageHeight;
        this.ImageName = ImageName;
    }

    public int getImageWidth() {
        return ImageWidth;
    }

    public void setImageWidth(int ImageWidth) {
        this.ImageWidth = ImageWidth;
    }

    public int getImageHeight() {
        return ImageHeight;
    }

    public void setImageHeight(int ImageHeight) {
        this.ImageHeight = ImageHeight;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String ImageName) {
        this.ImageName = ImageName;
    }
}
