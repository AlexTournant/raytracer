package Model;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;
import static java.lang.Math.max;

/**
 * The Normal class is responsible for performing ray tracing with a basic shading model.
 * It implements the ICalculStrategy interface and defines the ray tracing calculations needed
 * to render an image based on the normal shading model. This class can render images without
 * considering lights in the scene, making it suitable for scenes without illumination.
 */
public class Normal implements ICalculStrategy {
    private Scene scene;
    private int imgwidth, imgheight;

    /**
     * Constructs a Normal object for ray tracing with the specified scene.
     *
     * @param scene The Scene object containing the 3D scene and rendering parameters.
     */
    public Normal(Scene scene){
        this.scene = scene;
        this.imgwidth = scene.getImage().getImageWidth();
        this.imgheight = scene.getImage().getImageHeight();
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
     * Gets the Scene object associated with the Normal renderer.
     *
     * @return The Scene object containing the scene and rendering parameters.
     */
    public Scene getScene() {
        return scene;
    }
    //good
    public Vector orthonormalW(){
        Point lookFrom = getScene().getCamera().getLookFrom();
        Point lookAt = getScene().getCamera().getLookAt();
        return new Vector(lookFrom.subtract(lookAt).normalize().getTriplet());
    }

    /**
     * Calculates the orthonormal vector pointing to the right in camera space (U).
     *
     * @return The orthonormal vector pointing to the right in camera space.
     */
    public Vector orthonormalU(){
        Vector w = orthonormalW();
        Vector up = getScene().getCamera().getUp();
        return new Vector(w.multiplyVectorial(up).normalize().getTriplet());
    }

    /**
     * Calculates the orthonormal vector pointing upwards in camera space (V).
     *
     * @return The orthonormal vector pointing upwards in camera space.
     */
    public Vector orthonormalV(){
        Triplet w = orthonormalW().getTriplet();
        Triplet u=orthonormalU().getTriplet();
        return new Vector(w.multiplyVectorial(u).normalize());
    }


    /**
     * Gets the field of view in radians (FOVr) from the camera settings.
     *
     * @return The field of view in radians.
     */
    public double getFovr() {
        return (this.scene.getCamera().getFov() * Math.PI) / 180;
    }

    /**
     * Calculates the real height of the view window in camera space.
     *
     * @return The real height of the view window.
     */
    public double getRealHeight() {
        return 2 * Math.tan(getFovr() / 2);
    }

    /**
     * Calculates the height of a single pixel on the view window in camera space.
     *
     * @return The height of a single pixel on the view window.
     */
    public double getPixelHeight() {
        return getRealHeight() / this.imgheight;
    }

    /**
     * Calculates the real width of the view window in camera space.
     *
     * @return The real width of the view window.
     */
    public double getRealWidth() {
        return this.imgwidth * this.getPixelHeight();
    }

    /**
     * Calculates the width of a single pixel on the view window in camera space.
     *
     * @return The width of a single pixel on the view window.
     */
    public double getPixelWidth() {
        return getRealWidth() / this.imgwidth;
    }

    /**
     * Calculates the direction vector (D) for a pixel in camera space.
     *
     * @param i The horizontal pixel index.
     * @param j The vertical pixel index.
     * @return The direction vector (D) for the pixel at (i, j).
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
     * Performs the ray tracing process using the normal shading model.
     *
     * @throws Exception if an error occurs during ray tracing.
     */
    public void rayTracing() throws Exception {
        BufferedImage image = new BufferedImage(this.getImgwidth(), this.getImgheight(), BufferedImage.TYPE_INT_ARGB);
        Model.Color colorScene = new Model.Color(0, 0, 0);

        // Initialize the image with the background color.
        for (int i = 0; i < this.getScene().getImage().getImageWidth(); i++) {
            for (int j = 0; j < this.getScene().getImage().getImageHeight(); j++) {
                image.setRGB(i, j, convertModelColorToAwtColor(colorScene.getTriplet().getX(),
                        colorScene.getTriplet().getY(), colorScene.getTriplet().getZ()));
            }
        }

        // Ray tracing logic.
        for (int i = 1; i < this.getScene().getImage().getImageWidth(); i++) {
            for (int j = 1; j < this.getScene().getImage().getImageHeight(); j++) {
                Vector d = getD(i, j);
                for (IObjetScene objet : this.getScene().getObjets().keySet()) {
                    if (objet.intersection(this.getScene().getCamera().getLookFrom(), d) != -1.0) {
                        Model.Color col = getScene().getColors().get("ambient");
                        int rgb = convertModelColorToAwtColor(col.getTriplet().getX(),
                                col.getTriplet().getY(), col.getTriplet().getZ());
                        image.setRGB(this.getScene().getImage().getImageWidth() - i,
                                this.getScene().getImage().getImageHeight() - j, rgb);
                    }
                }
            }

            // Save the rendered image to a file.
            try {
                ImageIO.write(image, "png", new File(scene.getImage().getImageName()));
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
