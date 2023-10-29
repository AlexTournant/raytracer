package Affichage;

public class Image {
    private int ImageWidth;
    private int ImageHeight;
    private String ImageName ;

    public Image(int ImageWidth, int ImageHeight, String ImageName) {
        this.ImageWidth = ImageWidth;
        this.ImageHeight = ImageHeight;
        this.ImageName = ImageName;
    }

    public int getImageWidth() {
        return ImageWidth;
    }

    public int getImageHeight() {
        return ImageHeight;
    }

    public String getImageName() {
        return ImageName;
    }
}
