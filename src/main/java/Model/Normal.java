package Model;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Normal implements ICalcul {
    private Scene scene;
    private int imgwidth, imgheight;
    public Normal(Scene scene){
        this.scene = scene;
        this.imgwidth = scene.getImage().getImageWidth();
        this.imgheight = scene.getImage().getImageHeight();
    }

    public int getImgwidth() {
        return imgwidth;
    }

    public int getImgheight() {
        return imgheight;
    }

    public Scene getScene() {
        return scene;
    }
    //good
    public Vector orthonormalW(){
        Triplet lookFrom = getScene().getCamera().getLookFrom();
        Triplet lookAt = getScene().getCamera().getLookAt();
        return new Vector(lookFrom.subtract(lookAt).normalize());
    }

    public Vector orthonormalU(){
        Triplet w = orthonormalW().getTriplet();
        Triplet up = getScene().getCamera().getUp();
        return new Vector(w.multiplyVectorial(up).normalize());
    }

    public Vector orthonormalV(){
        Triplet w = orthonormalW().getTriplet();
        Triplet u=orthonormalU().getTriplet();
        return new Vector(w.multiplyVectorial(u).normalize());
    }


    public double getFovr() {
        return (this.scene.getCamera().getFov() * Math.PI) / 180;
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

    public void rayTracing() throws Exception {
        Intersection intersection = new Intersection();
        BufferedImage image = new BufferedImage(this.getImgwidth(), this.getImgheight(), BufferedImage.TYPE_INT_ARGB);
        double t;
        java.awt.Color color = new java.awt.Color(0, 0, 0);
        int noir = color.getRGB();
        for (int i = 0; i < scene.getImage().getImageWidth(); i++) {
            for (int j = 0; j < scene.getImage().getImageHeight(); j++) {
                image.setRGB(i, j, noir);
            }
        }
        for (IObjetScene objet : scene.getObjets()) {
            intersection.setIos(objet);
            for (int i = 0; i < scene.getImage().getImageWidth(); i++) {
                for (int j = 0; j < scene.getImage().getImageHeight(); j++) {
                    Vector d = getD(i, j);
                    t = intersection.intersection(new Point(scene.getCamera().getLookFrom()), d);
                    if (t != -1.0) {
                        Model.Color c = scene.getColors().get("ambient");
                        int rgb = convertModelColorToAwtColor(c.getTriplet().getX(), c.getTriplet().getY(), c.getTriplet().getZ());
                        image.setRGB(scene.getImage().getImageWidth()-i,scene.getImage().getImageHeight()-j, rgb);
                    }
                }
            }
            try {
                ImageIO.write(image, "png", new File(scene.getImage().getImageName()));
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
