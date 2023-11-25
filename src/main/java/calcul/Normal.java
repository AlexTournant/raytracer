package calcul;

import objets.IObjetScene;
import triplet.Color;
import triplet.Vector;

import java.awt.image.BufferedImage;

public class Normal implements ICalculStrategy {
    public void calcul(Image image, BufferedImage bufferedImage)   {
        for (int i = 1; i < image.getScene().getImage().getImageWidth(); i++) {
            for (int j = 1; j < image.getScene().getImage().getImageHeight(); j++) {
                Vector d = image.getD(i, j);
                for (IObjetScene objet : image.getScene().getObjets().keySet()) {
                    if (objet.intersection(image.getScene().getCamera().getLookFrom(), d) != -1.0) {
                        Color col = image.getScene().getColors().get("ambient");
                        int rgb = image.convertModelColorToAwtColor(col.getTriplet().getX(), col.getTriplet().getY(), col.getTriplet().getZ());
                        bufferedImage.setRGB(image.getScene().getImage().getImageWidth() - i, image.getScene().getImage().getImageHeight() - j, rgb);
                    }
                }
            }
        }
        }

}
