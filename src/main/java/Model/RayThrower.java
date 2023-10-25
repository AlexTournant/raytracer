package Model;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;

import static java.lang.Math.abs;

public class RayThrower {
    private Scene scene;
    private int imgwidth, imgheight;
    public RayThrower(Scene scene){
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

    public static Scene getScene() {
        return scene;
    }

    public Vector orthonormalW(){
        Triplet temp = getScene().getCamera().getLookFrom();

        Triplet temp2 = getScene().getCamera().getLookAt();

        Vector w1 = new Vector(getScene().getCamera().getLookFrom().subtract(getScene().getCamera().getLookAt()));
        Vector w2 = new Vector(temp.subtract(temp2));
        Vector w = new Vector((temp.divide(temp2)).normalize());
        return w;
    }

    public Vector orthonormalU(){
        Triplet tmp = orthonormalW().getTriplet();
        Triplet u1 = getScene().getCamera().getUp().multiply(tmp);

        Triplet upTemp = getScene().getCamera().getUp();

        Triplet TempW = orthonormalW().getTriplet();


        Triplet u2 = upTemp.multiply(TempW).normalize();

        Vector y = new Vector(u1.divide(u2));
        return y;
    }

    public Vector orthonormalV(){
        Vector v1 = orthonormalW().multiply(orthonormalU());
        Vector v2 = orthonormalW().multiply(orthonormalU()).normalize();
        Vector v = new Vector(v1.getTriplet().divide(v2.getTriplet()));
        return v;
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
        double a = -getRealWidth() / 2 + (i + 0.5) * getPixelWidth();
        double b = getRealHeight() / 2 - (j + 0.5) * getPixelHeight();
        Vector u = orthonormalU();
        Vector v = orthonormalV();
        Vector w = orthonormalW();
        Vector tmp1 = new Vector(u.getTriplet().multiply(a));
        Vector tmp2 = new Vector(v.getTriplet().multiply(b));

        Vector numerator = tmp1.add(tmp2).subtract(w);
        Vector denominator = numerator.normalize();
        return new Vector(numerator.getTriplet().divide(denominator.getTriplet()));
    }

    public BufferedImage getMyImage(){
        BufferedImage image = new BufferedImage(this.getImgwidth(), this.getImgheight(), BufferedImage.TYPE_INT_ARGB);
        for (int x=0; x<getImgwidth(); x++){
            for (int y=0; y<getImgheight(); y++){
                java.awt.Color color = new java.awt.Color(0, 0, 0);
                int rgb = color.getRGB();
                image.setRGB(x, y, rgb);
            }
        }
        return image;
    }

    public void SaveImage() throws Exception{
        try {
            // Retrieve image
            BufferedImage image = getMyImage();
            File outputfile = new File(getScene().getImage().getImageName());
            ImageIO.write(image, "png", outputfile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void rayTracing() {
        Scene scene = this.scene;
        double t = 0;
        for (int i = 0; i < scene.getImage().getImageWidth();i++) {
            for (int j = 0; j < scene.getImage().getImageHeight(); j++) {
                Vector d = getD(i, j);
                double t = 0;
                for (IObjetScene objets : scene.getObjets()) {
                    t = objets.intersection(new Point(scene.getCamera().getLookFrom()), d);
                    Point p = new Point(scene.getCamera().getLookFrom().add((d.getTriplet().multiply(t))));
                }
                if (t != -1.0) {

                }

            }
        }
    }

}
