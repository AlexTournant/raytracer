package Model;

public class Image {
    private int largeurImage;
    private int hauteurImage;
    private String nomImage = "output.png";

    public Image(int largeurImage, int hauteurImage, String nomImage) {
        this.largeurImage = largeurImage;
        this.hauteurImage = hauteurImage;
        this.nomImage = nomImage;
    }

    public int getLargeurImage() {
        return largeurImage;
    }

    public void setLargeurImage(int largeurImage) {
        this.largeurImage = largeurImage;
    }

    public int getHauteurImage() {
        return hauteurImage;
    }

    public void setHauteurImage(int hauteurImage) {
        this.hauteurImage = hauteurImage;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }
}
