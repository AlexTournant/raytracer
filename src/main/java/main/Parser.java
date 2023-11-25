package main;
import affichage.Camera;
import affichage.Image;
import light.DirectionalLight;
import light.ILight;
import light.PonctualLight;
import triplet.Color;
import objets.IObjetScene;
import objets.Plan;
import objets.Sphere;
import objets.Triangle;
import scene.SceneBuilder;
import triplet.Triplet;
import triplet.Point;
import triplet.Vector;
import color.*;
import java.io.*;
import java.util.*;

/**
 * The Parser class is responsible for parsing a scene description file and constructing
 * a scene with objects, lights, and camera configurations based on the file contents.
 */
public class Parser {
    private int occ = 0; // Counter for tracking occurrences
    private SceneBuilder sb = new SceneBuilder(); // SceneBuilder instance
    private int height; // Height of the scene
    private int width; // Width of the scene
    private boolean shadowOn; // Whether shadows are enabled
    private int taille; // Size
    private String nomImage; // Name of the output image

    private ColorDamier colorDamier; // Checker pattern colors
    private ArrayList<Triplet> TCamera = new ArrayList<>(); // Camera parameters

    private ArrayList<Camera> cameras = new ArrayList<>(); // List of cameras
    private int fov; // Field of view
    private Map<String, Color> colors = new LinkedHashMap<>(); // Colors

    private ArrayList<Image> image = new ArrayList<>(); // Images
    private int maxvert; // Maximum number of vertices
    private Point[] points; // Array of points
    private ArrayList<Triangle> triangles = new ArrayList<>(); // List of triangles

    private ArrayList<Sphere> spheres = new ArrayList<>(); // List of spheres
    private ArrayList<Plan> plans = new ArrayList<>(); // List of planes

    private Map<IObjetScene, IColorStrategy> diffuse = new LinkedHashMap<>(); // Objects and their colors

    private ArrayList<ILight> listLights = new ArrayList<>(); // List of lights
    private boolean check; // Flag for checker pattern

    /**
     * Get the SceneBuilder instance created by this parser.
     *
     * @return The SceneBuilder instance.
     */
    public SceneBuilder getSb() {
        return sb;
    }

    /**
     * Get the color configuration for the checker pattern (if used).
     *
     * @return The checker pattern colors.
     */
    public ColorDamier getColorDamier() {
        return colorDamier;
    }

    /**
     * Set the color configuration for the checker pattern.
     *
     * @param colorDamier The checker pattern colors to set.
     */
    public void setColorDamier(ColorDamier colorDamier) {
        this.colorDamier = colorDamier;
    }

    /**
     * Get the occurrence counter.
     *
     * @return The occurrence counter.
     */
    public int getOcc() {
        return occ;
    }

    /**
     * Increment the occurrence counter.
     */
    public void setOcc() {
        this.occ++;
    }

    /**
     * Get the size of the checker pattern.
     *
     * @return The checker pattern size.
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Check if the checker pattern is enabled.
     *
     * @return True if the checker pattern is enabled, false otherwise.
     */
    public boolean isCheck() {
        return check;
    }

    /**
     * Set whether the checker pattern is enabled.
     *
     * @param check True to enable the checker pattern, false to disable it.
     */
    public void setCheck(boolean check) {
        this.check = check;
    }

    /**
     * Set the size of the checker pattern.
     *
     * @param taille The checker pattern size to set.
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }

    /**
     * Get the list of lights in the scene.
     *
     * @return The list of lights.
     */
    public ArrayList<ILight> getListLights() {
        return listLights;
    }

    /**
     * Set the list of lights in the scene.
     *
     * @param listLights The list of lights to set.
     */
    public void setListLights(ArrayList<ILight> listLights) {
        this.listLights = listLights;
    }

    /**
     * Get the maximum number of vertices.
     *
     * @return The maximum number of vertices.
     */
    public int getMaxvert() {
        return maxvert;
    }

    /**
     * Set the maximum number of vertices.
     *
     * @param maxvert The maximum number of vertices to set.
     */
    public void setMaxvert(int maxvert) {
        this.maxvert = maxvert;
    }

    /**
     * Get the map of objects in the scene and their associated color strategies.
     *
     * @return The map of objects and their color strategies.
     */
    public Map<IObjetScene, IColorStrategy> getDiffuse() {
        return diffuse;
    }

    /**
     * Set the map of objects in the scene and their associated color strategies.
     *
     * @param diffuse The map of objects and their color strategies to set.
     */
    public void setDiffuse(Map<IObjetScene, IColorStrategy> diffuse) {
        this.diffuse = diffuse;
    }

    /**
     * Get the height of the scene.
     *
     * @return The scene's height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the height of the scene.
     *
     * @param height The scene's height to set.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get the width of the scene.
     *
     * @return The scene's width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set the width of the scene.
     *
     * @param width The scene's width to set.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get the list of camera configurations for the scene.
     *
     * @return The list of camera configurations.
     */
    public ArrayList<Triplet> getTCamera() {
        return TCamera;
    }

    /**
     * Get the list of image configurations for the scene.
     *
     * @return The list of image configurations.
     */
    public ArrayList<Image> getImage() {
        return image;
    }

    /**
     * Set the list of image configurations for the scene.
     *
     * @param image The list of image configurations to set.
     */
    public void setImage(ArrayList<Image> image) {
        this.image = image;
    }

    /**
     * Get the field of view (FOV) for the camera.
     *
     * @return The camera's field of view (FOV).
     */
    public int getFov() {
        return fov;
    }

    /**
     * Set the field of view (FOV) for the camera.
     *
     * @param fov The camera's field of view (FOV) to set.
     */
    public void setFov(int fov) {
        this.fov = fov;
    }

    /**
     * Get the map of named colors in the scene.
     *
     * @return The map of named colors.
     */
    public Map<String, Color> getColors() {
        return colors;
    }

    /**
     * Set the map of named colors in the scene.
     *
     * @param colors The map of named colors to set.
     */
    public void setColors(Map<String, Color> colors) {
        this.colors = colors;
    }

    /**
     * Set the array of Point objects for vertices in the scene.
     *
     * @param column The number of columns for the array.
     */
    public void setPoints(int column) {
        points = new Point[column];
    }

    /**
     * Get the array of Point objects representing vertices in the scene.
     *
     * @return The array of Point objects.
     */
    public Point[] getPoints() {
        return points;
    }

    /**
     * Get the list of Triangle objects in the scene.
     *
     * @return The list of Triangle objects.
     */
    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    /**
     * Get the list of Sphere objects in the scene.
     *
     * @return The list of Sphere objects.
     */
    public ArrayList<Sphere> getSpheres() {
        return spheres;
    }

    /**
     * Get the list of Plan objects in the scene.
     *
     * @return The list of Plan objects.
     */
    public ArrayList<Plan> getPlans() {
        return plans;
    }

    /**
     * Get the name of the output image file.
     *
     * @return The name of the output image file.
     */
    public String getNomImage() {
        return nomImage;
    }

    /**
     * Set the name of the output image file.
     *
     * @param nomImage The name of the output image file to set.
     */
    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    /**
     * Set the list of camera configurations based on Triplets.
     *
     * @param TCamera The list of camera configurations to set.
     */
    public void setTCamera(ArrayList<Triplet> TCamera) {
        this.TCamera = TCamera;
    }

    /**
     * Get the list of Camera objects created based on Triplets.
     *
     * @return The list of Camera objects.
     */
    public ArrayList<Camera> getCameras() {
        return cameras;
    }

    /**
     * Set the list of Camera objects created based on Triplets.
     *
     * @param cameras The list of Camera objects to set.
     */
    public void setCameras(ArrayList<Camera> cameras) {
        this.cameras = cameras;
    }

    /**
     * Set the array of Point objects representing vertices in the scene.
     *
     * @param points The array of Point objects to set.
     */
    public void setPoints(Point[] points) {
        this.points = points;
    }

    /**
     * Set the list of Triangle objects in the scene.
     *
     * @param triangles The list of Triangle objects to set.
     */
    public void setTriangles(ArrayList<Triangle> triangles) {
        this.triangles = triangles;
    }

    /**
     * Set the list of Sphere objects in the scene.
     *
     * @param spheres The list of Sphere objects to set.
     */
    public void setSpheres(ArrayList<Sphere> spheres) {
        this.spheres = spheres;
    }

    /**
     * Set the list of Plan objects in the scene.
     *
     * @param plans The list of Plan objects to set.
     */
    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
    }

    /**
     * Check if shadows are enabled in the scene.
     *
     * @return True if shadows are enabled, false otherwise.
     */
    public boolean isShadowOn() {
        return shadowOn;
    }

    /**
     * Set whether shadows are enabled in the scene.
     *
     * @param shadowOn True to enable shadows, false to disable them.
     */
    public void setShadowOn(boolean shadowOn) {
        this.shadowOn = shadowOn;
    }

    /**
     * Initialize default values for scene dimensions and colors.
     */
    public void init(){
        setWidth(680);
        setHeight(480);
        getColors().put("ambient", new Color(0, 0, 0));
        getColors().put("diffuse", new Color(0, 0, 0));
    }

    /**
     * Parse the scene description file and create a scene configuration based on the file contents.
     *
     * @param nomFile The name of the scene description file to parse.
     * @throws java.io.IOException If an error occurs during file parsing.
     */
    public void parse(String nomFile) throws java.io.IOException {
        init();
        try {
            // entry file
            File file = new File("src\\main\\resources\\"+nomFile);
            // Create the File Reader
            FileReader fr = new FileReader(file);
            // Create the BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] ligne=line.split(" ");
                switch (ligne[0]) {
                    case "shadow"->
                            setShadowOn(Boolean.parseBoolean(ligne[1]));
                    case "checker"-> {
                        setCheck(true);
                        setColorDamier(new ColorDamier(new Color(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])), new Color(Double.parseDouble(ligne[4]), Double.parseDouble(ligne[5]), Double.parseDouble(ligne[6])),Integer.parseInt(ligne[7])));
                    }
                    case "size" -> {
                        setWidth(Integer.parseInt(ligne[1]));
                        setHeight(Integer.parseInt(ligne[2]));
                    }
                    case "output" -> setNomImage((ligne[1]));
                    case "camera" -> {
                        getTCamera().add(new Triplet(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])));
                        getTCamera().add(new Triplet(Double.parseDouble(ligne[4]), Double.parseDouble(ligne[5]), Double.parseDouble(ligne[6])));
                        getTCamera().add(new Triplet(Double.parseDouble(ligne[7]), Double.parseDouble(ligne[8]), Double.parseDouble(ligne[9])));
                        setFov(Integer.parseInt(ligne[10]));
                    }
                    case "ambient" ->
                            getColors().put(ligne[0],new Color(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])));
                    case "diffuse" -> {
                        if (getColors().containsKey(ligne[0])) {
                            getColors().replace(ligne[0], new Color(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])));
                        }
                        else {
                            getColors().put(ligne[0], new Color(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])));
                        }
                    }
                    case "specular" -> {
                        if(getColors().containsKey(ligne[0])) {
                            getColors().replace(ligne[0], new Color(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])));
                        }
                        else{
                            getColors().put(ligne[0], new Color(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])));
                        }
                    }
                    case "shininess" ->System.out.println("la");
                    //getColors().get("specular").scalarMultiply(Integer.parseInt(ligne[0.);
                    case "directional" ->
                            getListLights().add(new DirectionalLight(new Color(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])), new Vector(Double.parseDouble(ligne[4]), Double.parseDouble(ligne[5]), Double.parseDouble(ligne[6]))));
                    case "point" ->
                            getListLights().add(new PonctualLight(new Color(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])), new Point(Double.parseDouble(ligne[4]),Double.parseDouble(ligne[5]), Double.parseDouble(ligne[6]))));
                    case "maxverts" ->
                            setPoints(Integer.parseInt(ligne[1]));
                    case "vertex" -> {
                        getPoints()[getOcc()] = new Point(Double.parseDouble(ligne[1]),Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3]));
                        setOcc();

                    }
                    case "tri" ->
                            diffuse.put( new Triangle(getPoints()[Integer.parseInt(ligne[1])], getPoints()[Integer.parseInt(ligne[2])], getPoints()[Integer.parseInt(ligne[3])]), new ColorUnie(colors.get("diffuse")));
                    case "sphere" ->
                            diffuse.put(new Sphere(new Point(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])), Double.parseDouble(ligne[4])),new ColorUnie(colors.get("diffuse")));
                    case "plane" -> {
                        if(isCheck()) {
                            diffuse.put(new Plan(new Point(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])), new Vector(Integer.parseInt(ligne[4]), Integer.parseInt(ligne[5]), Integer.parseInt(ligne[6]))),getColorDamier());
                            setCheck(false);
                        }
                        else {
                            diffuse.put(new Plan(new Point(Double.parseDouble(ligne[1]), Double.parseDouble(ligne[2]), Double.parseDouble(ligne[3])), new Vector(Integer.parseInt(ligne[4]), Integer.parseInt(ligne[5]), Integer.parseInt(ligne[6]))),new ColorUnie(colors.get("diffuse")));
                        }
                    }
                }

            }
            fr.close();
            br.close();
            getSb().withLights(getListLights());
            getSb().withCamera(getCamera());
            getSb().withColors(getColors());
            getSb().withImage(new Image(getWidth(),getHeight(),getNomImage()));
            getSb().withObjets(getDiffuse());
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("erreur");

        }
    }

    /**
     * Get the Camera configuration based on parsed camera parameters.
     *
     * @return The Camera configuration or null if insufficient parameters are provided.
     */
    public Camera getCamera() {
        if(getTCamera().size()>2){
            return new Camera(new Point(getTCamera().get(0)),new Point(getTCamera().get(1)),new Vector(getTCamera().get(2)),getFov());
        }
        return null;
    }
}
