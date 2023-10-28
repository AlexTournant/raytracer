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

    public Model.Color getCol(Point p,IObjetScene objetScene) throws Exception {
        return new Model.Color((getScene().getColors().get("ambient").add(sumColor(objetScene,p).shurProduct(getScene().getObjets().get(objetScene)))).getTriplet());
    }

    public Model.Color sumColor(IObjetScene objetScene,Point p) throws Exception {
        Model.Color sum = new Model.Color(getScene().getObjets().get(objetScene).getTriplet());
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

    public void rayTracing() throws Exception {
        BufferedImage image = new BufferedImage(this.getImgwidth(), this.getImgheight(), BufferedImage.TYPE_INT_ARGB);
        double t;
        Model.Color colorScene=getScene().getColors().get("ambient");
        for (int i = 0; i < this.getScene().getImage().getImageWidth(); i++) {
            for (int j = 0; j < this.getScene().getImage().getImageHeight(); j++) {
                image.setRGB(i, j, convertModelColorToAwtColor(colorScene.getTriplet().getX(),colorScene.getTriplet().getY(),colorScene.getTriplet().getZ()));
            }
        }
        for (IObjetScene objet: this.getScene().getObjets().keySet()) {
                for (int i = 1; i < this.getScene().getImage().getImageWidth(); i++) {
                    for (int j = 1; j < this.getScene().getImage().getImageHeight(); j++) {
                        Vector d = getD(i, j);
                        t = objet.intersection(new Point(this.getScene().getCamera().getLookFrom()), d);
                        if (t != -1.0) {
                            Point p = new Point(this.getScene().getCamera().getLookFrom().add((d.getTriplet().scalarMultiply(t))));
                            Model.Color col = getCol(p, objet);
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
