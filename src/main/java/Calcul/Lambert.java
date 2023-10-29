package Calcul;

import Light.ILight;
import Triplet.Color;
import Triplet.Point;
import Triplet.Vector;
import Objets.IObjetScene;
import Color.ColorUnie;
import Scene.Scene;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.*;

import static java.lang.Math.max;

/**
 * The Lambert class is responsible for performing Lambert shading.
 * It implements the ICalculStrategy interface and defines the ray tracing calculations needed
 * to render an image using Lambert reflection. The class also handles image creation and
 * saving as a PNG file.
 */
public class Lambert implements ICalculStrategy {
    private Scene scene;
    private int imgwidth, imgheight;

    /**
     * Constructs a Lambert object with the specified scene for ray tracing.
     *
     * @param scene The Scene object containing the 3D scene and rendering parameters.
     */
    public Lambert(Scene scene){
        this.scene = scene;
        this.imgwidth = this.getScene().getImage().getImageWidth();
        this.imgheight = this.getScene().getImage().getImageHeight();
    }

    /**
     * Gets the width of the image being rendered.
     *
     * @return The width of the image in pixels.
     */
    public int getImgwidth() {
        return imgwidth;
    }

    /**
     * Gets the height of the image being rendered.
     *
     * @return The height of the image in pixels.
     */
    public int getImgheight() {
        return imgheight;
    }

    /**
     * Gets the Scene object associated with the Lambert renderer.
     *
     * @return The Scene object containing the scene and rendering parameters.
     */
    public Scene getScene() {
        return this.scene;
    }

    /**
     * Calculates the orthonormal vector pointing towards the view direction (W).
     *
     * @return The orthonormal vector pointing towards the view direction.
     */
    public Vector orthonormalW(){
        Point lookFrom = getScene().getCamera().getLookFrom();
        Point lookAt = getScene().getCamera().getLookAt();
        return lookFrom.subtract(lookAt).normalize();
    }

    /**
     * Calculates the orthonormal vector pointing right (U) in the camera space.
     *
     * @return The orthonormal vector pointing right (U).
     */
    public Vector orthonormalU(){
        Vector w = orthonormalW();
        Vector up = getScene().getCamera().getUp();
        return new Vector(w.multiplyVectorial(up).normalize().getTriplet());
    }

    /**
     * Calculates the orthonormal vector pointing up (V) in the camera space.
     *
     * @return The orthonormal vector pointing up (V).
     */
    public Vector orthonormalV(){
        Vector w = orthonormalW();
        Vector u=orthonormalU();
        return w.multiplyVectorial(u).normalize();
    }


    /**
     * Gets the field of view angle in radians.
     *
     * @return The field of view angle in radians.
     */
    public double getFovr() {
        return (this.getScene().getCamera().getFov() * Math.PI) / 180;
    }

    /**
     * Calculates the actual height of the image based on the field of view.
     *
     * @return The actual height of the image.
     */
    public double getRealHeight() {
        return 2 * Math.tan(getFovr() / 2);
    }

    /**
     * Calculates the height of a single pixel in the image.
     *
     * @return The height of a single pixel in the image.
     */
    public double getPixelHeight() {
        return getRealHeight() / this.imgheight;
    }

    /**
     * Calculates the actual width of the image based on the pixel height and width.
     *
     * @return The actual width of the image.
     */
    public double getRealWidth() {
        return this.imgwidth * this.getPixelHeight();
    }

    /**
     * Calculates the width of a single pixel in the image.
     *
     * @return The width of a single pixel in the image.
     */
    public double getPixelWidth() {
        return getRealWidth() / this.imgwidth;
    }

    /**
     * Calculates the direction vector for a given pixel in the image.
     *
     * @param i The horizontal position of the pixel.
     * @param j The vertical position of the pixel.
     * @return The direction vector for the specified pixel.
     */
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


    /**
     * Determines the color of a pixel for a given object in the scene.
     *
     * @param p         The intersection point between the ray and the object.
     * @param objetScene The object in the scene.
     * @param i         The horizontal position of the pixel.
     * @param j         The vertical position of the pixel.
     * @return The color of the pixel.
     * @throws Exception if an error occurs during color calculation.
     */
    public Color getCol(Point p, IObjetScene objetScene, int i, int j) throws Exception {
        if (getScene().getObjets().get(objetScene).getClass()==(ColorUnie.class)) {
            return new Color((getScene().getColors().get("ambient").add(sumColor(objetScene, p).shurProduct(getScene().getObjets().get(objetScene).getColor(i, j)))).getTriplet());
        }
        else{
            return getScene().getObjets().get(objetScene).getColor(i,j);
        }
    }


    /**
     * Sums up the colors contributed by all lights in the scene.
     *
     * @param objetScene The object in the scene.
     * @param p         The intersection point between the ray and the object.
     * @return The sum of colors contributed by lights.
     * @throws Exception if an error occurs during color summation.
     */
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

    /**
     * Finds the closest object to the camera among a list of intersecting objects.
     *
     * @param listObjets A map of intersecting objects and their distances.
     * @return A map containing the closest object and its distance.
     */
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

    /**
     * Performs ray tracing calculations for rendering the scene and saves the result as an image.
     *
     * @throws Exception if an error occurs during ray tracing or image saving.
     */
    public void rayTracing() throws Exception {
        BufferedImage image = new BufferedImage(this.getImgwidth(), this.getImgheight(), BufferedImage.TYPE_INT_ARGB);
        Color colorScene=new Color(0,0,0);
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
                        Color col = getCol(p, objet,i,j);
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

    /**
     * Converts a color in the Model.Color format to an AWT color representation.
     *
     * @param r The red component of the color.
     * @param g The green component of the color.
     * @param b The blue component of the color.
     * @return An AWT color in integer format.
     */
    public int convertModelColorToAwtColor(double r, double g, double b) {
        int red = (int) (r * 255);
        int green = (int) (g * 255);
        int blue = (int) (b * 255);

        return new java.awt.Color(red, green, blue).getRGB();
    }

}
