package calcul;

import objets.IObjetScene;
import triplet.Color;
import triplet.Point;
import triplet.Vector;

import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lambert implements ICalculStrategy {

    public void calcul(Image image, BufferedImage bufferedImage) throws Exception {
        for (int i = 1; i < image.getScene().getImage().getImageWidth(); i++) {
            for (int j = 1; j < image.getScene().getImage().getImageHeight(); j++) {
                Map<IObjetScene, Double> intersectionObjet = new LinkedHashMap<>();
                Vector d = image.getD(i, j);
                for (IObjetScene objet : image.getScene().getObjets().keySet()) {
                    if (objet.intersection(image.getScene().getCamera().getLookFrom(), d) != -1.0) {
                        double t = objet.intersection(image.getScene().getCamera().getLookFrom(), d);
                        intersectionObjet.put(objet,t);
                    }
                }
                Map<IObjetScene,Double> minDistance= image.plusProche(intersectionObjet);
                if (minDistance != null){
                    for(IObjetScene objet:minDistance.keySet()) {
                        Point p = new Point(d.scalarMultiply(minDistance.get(objet)).add(image.getScene().getCamera().getLookFrom()).getTriplet());
                        Color col = image.getCol(p, objet,i,j);
                        int rgb = image.convertModelColorToAwtColor(col.getTriplet().getX(), col.getTriplet().getY(), col.getTriplet().getZ());
                        bufferedImage.setRGB(image.getScene().getImage().getImageWidth() - i, image.getScene().getImage().getImageHeight() - j, rgb);
                    }
                }
            }
        }
    }

}
