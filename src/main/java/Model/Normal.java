package Model;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Normal implements ICalculStrategy {
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
        Point lookFrom = getScene().getCamera().getLookFrom();
        Point lookAt = getScene().getCamera().getLookAt();
        return new Vector(lookFrom.subtract(lookAt).normalize().getTriplet());
    }

    public Vector orthonormalU(){
        Vector w = orthonormalW();
        Vector up = getScene().getCamera().getUp();
        return new Vector(w.multiplyVectorial(up).normalize().getTriplet());
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
        BufferedImage image = new BufferedImage(this.getImgwidth(), this.getImgheight(), BufferedImage.TYPE_INT_ARGB);
        Model.Color colorScene=new Model.Color(0,0,0);
        for (int i = 0; i < this.getScene().getImage().getImageWidth(); i++) {
            for (int j = 0; j < this.getScene().getImage().getImageHeight(); j++) {
                image.setRGB(i, j, convertModelColorToAwtColor(colorScene.getTriplet().getX(),colorScene.getTriplet().getY(),colorScene.getTriplet().getZ()));
            }
        }
        for (int i = 1; i < this.getScene().getImage().getImageWidth(); i++) {
            for (int j = 1; j < this.getScene().getImage().getImageHeight(); j++) {
                Vector d = getD(i, j);
                for (IObjetScene objet : this.getScene().getObjets().keySet()) {
                    if (objet.intersection(this.getScene().getCamera().getLookFrom(), d) != -1.0) {
                        System.out.println(objet.intersection(this.getScene().getCamera().getLookFrom(), d));
                        Model.Color col = getScene().getColors().get("ambient");
                        int rgb = convertModelColorToAwtColor(col.getTriplet().getX(), col.getTriplet().getY(), col.getTriplet().getZ());
                        image.setRGB(this.getScene().getImage().getImageWidth() - i, this.getScene().getImage().getImageHeight() - j, rgb);
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
