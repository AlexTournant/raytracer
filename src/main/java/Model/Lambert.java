package Model;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Lambert implements ICalcul{
    private Scene scene;
    private int imgwidth, imgheight;
    public Lambert(Scene scene){
        this.scene = scene;
        this.imgwidth = this.getScene().getImage().getImageWidth();
        this.imgheight = this.getScene().getImage().getImageHeight();
    }

    public int getImgwidth() {
        return imgwidth;
    }

    public int getImgheight() {
        return imgheight;
    }

    public Scene getScene() {
        return this.scene;
    }
    //good
    public Vector orthonormalW(){
        Point lookFrom = getScene().getCamera().getLookFrom();
        Point lookAt = getScene().getCamera().getLookAt();
        return lookFrom.subtract(lookAt).normalize();
    }

    public Vector orthonormalU(){
        Vector w = orthonormalW();
        Vector up = getScene().getCamera().getUp();
        return new Vector(w.multiplyVectorial(up).normalize().getTriplet());
    }

    public Vector orthonormalV(){
        Vector w = orthonormalW();
        Vector u=orthonormalU();
        return w.multiplyVectorial(u).normalize();
    }


    public double getFovr() {
        return (this.getScene().getCamera().getFov() * Math.PI) / 180;
    }

    public double getRealHeight() {
        return 2 * Math.tan(getFovr() / 2);
    }

    public double getPixelHeight() {
        return getRealHeight() / this.imgheight;
    }

    public double getRealWidth() {
        return this.imgwidth * this.getPixelHeight();
    }

    public double getPixelWidth() {
        return getRealWidth() / this.imgwidth;
    }

    public Vector getD(int i, int j) {
        double a = -(getRealWidth() / 2) + (i + 0.5) * getPixelWidth();
        double b = getRealHeight() / 2 - (j + 0.5) * getPixelHeight();
        Vector u = orthonormalU();
        Vector v = orthonormalV();
        Vector w = orthonormalW();
        Vector tmp1 = new Vector(u.getTriplet().scalarMultiply(a));
        Vector tmp2 = new Vector(v.getTriplet().scalarMultiply(b));
        Vector numerator = tmp1.add(tmp2).subtract(w);
        return new Vector(numerator.getTriplet().normalize());
    }

    public Model.Color getCol(Point p,IObjetScene objetScene,int i,int j) throws Exception {
        if (getScene().getObjets().get(objetScene).getClass()==(ColorUnie.class)) {
            return new Model.Color((getScene().getColors().get("ambient").add(sumColor(objetScene, p).shurProduct(getScene().getObjets().get(objetScene).getColor(i, j)))).getTriplet());
        }
        else{
            return getScene().getObjets().get(objetScene).getColor(i,j);
        }
    }

    public Model.Color sumColor(IObjetScene objetScene,Point p) throws Exception {
        Model.Color sum = new Model.Color(0,0,0);
        for (ILight light:getScene().getLights()) {
            if (light.getPosition() == null){
                double d = max(light.getDirection().normalize().scalarProduct(objetScene.getN(p)), 0);
                sum = sum.add(light.getColor().scalarMultiply(d));
            }
            else{
                double d = max(light.getPosition().subtract(p).normalize().scalarProduct(objetScene.getN(p)), 0);
                sum = sum.add(light.getColor().scalarMultiply(d));
            }
        }
        return sum;
    }

    public Map<IObjetScene,Double> plusProche(Map<IObjetScene,Double> listObjets){
        if (!listObjets.isEmpty()) {
            IObjetScene min=listObjets.keySet().stream().toList().get(0);
            for (IObjetScene objetScene : listObjets.keySet()) {
                if (listObjets.get(objetScene)<listObjets.get(min)) {
                    min = objetScene;
                }
            }
            Map<IObjetScene,Double>minDistance=new LinkedHashMap<>();
            minDistance.put(min,listObjets.get(min));
            return minDistance;
        }
        return null;
    }

    public void rayTracing() throws Exception {
        BufferedImage image = new BufferedImage(this.getImgwidth(), this.getImgheight(), BufferedImage.TYPE_INT_ARGB);
        Model.Color colorScene=new Model.Color(0,0,0);
        for (int i = 0; i < this.getScene().getImage().getImageWidth(); i++) {
            for (int j = 0; j < this.getScene().getImage().getImageHeight(); j++) {
                image.setRGB(i, j, convertModelColorToAwtColor(colorScene.getTriplet().getX(),colorScene.getTriplet().getY(),colorScene.getTriplet().getZ()));
            }
        }
        for (int i = 1; i < this.getScene().getImage().getImageWidth(); i++) {
            for (int j = 1; j < this.getScene().getImage().getImageHeight(); j++) {
                Map<IObjetScene, Double> intersectionObjet = new LinkedHashMap<>();
                Vector d = getD(i, j);
                for (IObjetScene objet : this.getScene().getObjets().keySet()) {
                    if (objet.intersection(this.getScene().getCamera().getLookFrom(), d) != -1.0) {
                        double t = objet.intersection(this.getScene().getCamera().getLookFrom(), d);
                        intersectionObjet.put(objet,t);
                    }
                }
                Map<IObjetScene,Double> minDistance= plusProche(intersectionObjet);
                if (minDistance != null){
                    for(IObjetScene objet:minDistance.keySet()) {
                        Point p = new Point(d.scalarMultiply(minDistance.get(objet)).add(this.getScene().getCamera().getLookFrom()).getTriplet());
                        Model.Color col = getCol(p, objet,i,j);
                        int rgb = convertModelColorToAwtColor(col.getTriplet().getX(), col.getTriplet().getY(), col.getTriplet().getZ());
                        image.setRGB(this.getScene().getImage().getImageWidth() - i, this.getScene().getImage().getImageHeight() - j, rgb);
                    }
                }
            }
            try {
                ImageIO.write(image, "png", new File(this.getScene().getImage().getImageName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public int convertModelColorToAwtColor(double r, double g, double b) {
        int red = (int) (r * 255);
        int green = (int) (g * 255);
        int blue = (int) (b * 255);

        return new java.awt.Color(red, green, blue).getRGB();
    }

}
