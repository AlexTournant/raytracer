package calcul;

import color.ColorUnie;
import light.ILight;
import objets.IObjetScene;
import scene.Scene;
import triplet.Color;
import triplet.Point;
import triplet.Vector;
import triplet.Triplet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Math.max;

public class Image {
    private Scene scene;
    private int imgwidth, imgheight;

    private ICalculStrategy iCalculStrategy;
    public Image(Scene scene, ICalculStrategy iCalculStrategy){
        this.scene = scene;
        this.imgwidth = this.getScene().getImage().getImageWidth();
        this.imgheight = this.getScene().getImage().getImageHeight();
        this.iCalculStrategy=iCalculStrategy;
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

    public ICalculStrategy getiCalculStrategy() {
        return iCalculStrategy;
    }

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
    public Color getCol(Point p, IObjetScene objetScene, int i, int j) throws Exception {
        if (getScene().getObjets().get(objetScene).getClass()==(ColorUnie.class)) {
            return new Color((getScene().getColors().get("ambient").add(sumColor(objetScene, p).shurProduct(getScene().getObjets().get(objetScene).getColor(i, j)))).getTriplet());
        }
        else{
            return getScene().getObjets().get(objetScene).getColor(i,j);
        }
    }

    public Color sumColor(IObjetScene objetScene, Point p) throws Exception {
        Color sum = new Color(0,0,0);
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
        Color colorScene = new Color(0, 0, 0);
        for (int i = 0; i < this.getScene().getImage().getImageWidth(); i++) {
            for (int j = 0; j < this.getScene().getImage().getImageHeight(); j++) {
                image.setRGB(i, j, convertModelColorToAwtColor(colorScene.getTriplet().getX(), colorScene.getTriplet().getY(), colorScene.getTriplet().getZ()));
            }
        }
        iCalculStrategy.calcul(this,image);
        ImageIO.write(image, "png", new File(this.getScene().getImage().getImageName()));
        JFrame f = new JFrame("Ajouter une image dans JFrame");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(getScene().getImage().getImageName());
            byte[] imageData = new byte[fileInputStream.available()];
            fileInputStream.read(imageData);
            ImageIcon icon = new ImageIcon(imageData);
            f.add(new JLabel(icon));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(f, "Error reading image: " + e.getMessage(), "Image Reading Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace(); // Handle or log the exception
                }
            }
        }

        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public int convertModelColorToAwtColor(double r, double g, double b) {
        int red = (int) (r * 255);
        int green = (int) (g * 255);
        int blue = (int) (b * 255);


        return new java.awt.Color(red, green, blue).getRGB();
    }
}
