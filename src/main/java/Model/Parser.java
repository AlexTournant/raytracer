package Model;

import java.io.*;
import java.util.*;

/**
 * The Parser class is responsible for parsing a file and storing its contents
 * It extracts information like the image dimensions, camera settings, lights, objects, and more from the file
 */
public class Parser {
    /**
     * Initialize attributes
     */
    private int height;
    private int width;
    private String image;
    private  ArrayList<Triplet> camera=new ArrayList<>();
    private int fov;
    private ArrayList<Color> colors=new ArrayList<>();
    private DirectionalLight dl;
    private PonctualLight pl;
    private int maxvert;
    private  Point[] points;
    private ArrayList<Triangle> triangles=new ArrayList<>();

    private ArrayList<Sphere> spheres=new ArrayList<>();
    private ArrayList<Plan> plans=new ArrayList<>();

    /**
     * Get the height of the image
     *
     * @return The height of the image
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the height of the image
     *
     * @param height The new height of the image
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get the width of the image
     *
     * @return The width of the image
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set the width of the image
     *
     * @param width The new width of the image
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get the list of camera parameters
     *
     * @return The list of camera parameters
     */
    public ArrayList<Triplet> getCamera() {
        return camera;
    }

    /**
     * Set the list of camera parameters
     *
     * @param camera The new list of camera parameters
     */
    public void setCamera(ArrayList<Triplet> camera) {
        this.camera = camera;
    }

    /**
     * Get the camera's field of view
     *
     * @return The camera's Field of view
     */
    public int getFov() {
        return fov;
    }

    /**
     * Set the camera's field of view
     *
     * @param fov The new Field of view of the camera.
     */
    public void setFov(int fov) {
        this.fov = fov;
    }

    /**
     * Get the list of color values
     *
     * @return The list of color values
     */
    public ArrayList<Color> getColors() {
        return colors;
    }

    /**
     * Set the list of color values
     *
     * @param colors The new list of color values
     */
    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    /**
     * Get the directional light source
     *
     * @return The directional light source
     */
    public DirectionalLight getDl() {
        return dl;
    }

    /**
     * Set the directional light source
     *
     * @param dl The new directional light source
     */
    public void setDl(DirectionalLight dl) {
        this.dl = dl;
    }

    /**
     * Get the point light source
     *
     * @return The point light source
     */
    public PonctualLight getPl() {
        return pl;
    }

    /**
     * Set the point light source
     *
     * @param pl The new point light source
     */
    public void setPl(PonctualLight pl) {
        this.pl = pl;
    }

    /**
     * Get the maximum number of vertex
     *
     * @return The maximum number of vertex
     */
    public int getMaxvert() {
        return maxvert;
    }

    /**
     * Set the maximum number of vertex
     *
     * @param m The new maximum number of vertex
     */
    public void setMaxvert(int m) {
        maxvert = m;
    }

    /**
     * Set the array to store Points
     *
     * @param column The number of Points to store in the array.
     */
    public void setPoints(int column) {
        points=new Point[column];
    }

    /**
     * Get the array of Points
     *
     * @return The array of Points
     */
    public Point[] getPoints(){
        return points;
    }

    /**
     * Get the list of triangles
     *
     * @return The list of triangles
     */
    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    /**
     * Get the list of spheres
     *
     * @return The list of spheres
     */
    public ArrayList<Sphere> getSpheres() {
        return spheres;
    }

    /**
     * Get the list of planes
     *
     * @return The list of planes
     */
    public ArrayList<Plan> getPlans() {
        return plans;
    }

    /**
     * Get the name of the output image
     *
     * @return The name of the output image
     */
    public String getImage() {
        return image;
    }

    /**
     * Set the name of the output image
     *
     * @param image The new name of the output image
     */
    public void setImage(String image) {
        this.image = image;
    }


    /**
     * Parses the configuration file to extract and store the scene parameters and objects.
     *
     * @param nomFile The name of the input configuration file.
     * @throws java.io.IOException if an IO exception occurs during file reading.
     */
    public void parse(String nomFile) throws java.io.IOException {
        try {
            // Le fichier d'entrée
            File file = new File("src\\main\\resources\\"+nomFile);
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                // ajoute la ligne au buffer
                String[]str=(line.split("\n"));
                if(!str[0].equals("#")) {
                    sb.append(line);
                    sb.append("\n");
                }
            }
            fr.close();
            // Convert the StringBuffer to a String
            String str = sb.toString();
            // Split the string into an array of words using space as the delimiter
            String[] words = str.split("\n");
            Map<String, ArrayList<ArrayList<Object>>> tableauAssociatif = new LinkedHashMap<>();
            // Iterate and print each word in the array
            ArrayList<ArrayList<Object>> tabs=new ArrayList<>();
            for (String word : words) {
                String[] a = word.split(" ");
                ArrayList<Object> tab=new ArrayList<>();
                if (a.length>1) {
                    String mot = a[0];
                    for (int i = 1; i < a.length; i++) {
                        tab.add(a[i]);
                    }
                    if (!tableauAssociatif.containsKey(mot)) {
                        tabs.add(tab);
                        tableauAssociatif.put(mot, tabs);
                        tabs=new ArrayList<>();
                    }
                    else{
                        tableauAssociatif.get(mot).add(tab);
                    }
                }
            }
            for (String key:tableauAssociatif.keySet()){
                System.out.println(key);
                switch (key) {
                    case "size" -> {
                        setHeight(Integer.parseInt(tableauAssociatif.get(key).get(0).get(0).toString()));
                        setWidth(Integer.parseInt(tableauAssociatif.get(key).get(0).get(1).toString()));
                    }
                    case "output" -> setImage((String) tableauAssociatif.get(key).get(0).get(0));
                    case "camera" -> {
                        getCamera().add(new Triplet(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())));
                        getCamera().add(new Triplet(Double.parseDouble(tableauAssociatif.get(key).get(0).get(3).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(4).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(5).toString())));
                        getCamera().add(new Triplet(Double.parseDouble(tableauAssociatif.get(key).get(0).get(6).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(7).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(7).toString())));
                        setFov(Integer.parseInt(tableauAssociatif.get(key).get(0).get(9).toString()));
                    }
                    case "ambient" ->
                            getColors().add(new Color(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())));
                    case "diffuse" ->
                            getColors().add(new Color(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())));
                    case "specular" ->
                            getColors().add(new Color(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())));
                    case "shininess" ->
                            getColors().get(2).multiply(Integer.parseInt(tableauAssociatif.get(key).get(0).get(0).toString()));
                    case "directional" ->
                            setDl(new DirectionalLight(new Color(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())), new Vector(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString()))));
                    case "point" ->
                            setPl(new PonctualLight(new Color(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())), new Point(Integer.parseInt(tableauAssociatif.get(key).get(0).get(0).toString()), Integer.parseInt(tableauAssociatif.get(key).get(0).get(1).toString()), Integer.parseInt(tableauAssociatif.get(key).get(0).get(2).toString()))));
                    case "maxverts" ->
                            setPoints(Integer.parseInt(tableauAssociatif.get("maxverts").get(0).get(0).toString()));
                    case "vertex" -> {
                        for (int i=0;i < getPoints().length;i++) {
                            getPoints()[i] = new Point(Integer.parseInt(tableauAssociatif.get(key).get(i).get(0).toString()),Integer.parseInt(tableauAssociatif.get(key).get(i).get(1).toString()), Integer.parseInt(tableauAssociatif.get(key).get(i).get(2).toString()));
                        }
                    }
                    case "tri" -> {
                        for (int i = 0; i <tableauAssociatif.get(key).size(); i++) {
                            System.out.println(Integer.parseInt(tableauAssociatif.get(key).get(i).get(0).toString()));
                            getTriangles().add(new Triangle(getPoints()[Integer.parseInt(tableauAssociatif.get(key).get(i).get(0).toString())], getPoints()[Integer.parseInt(tableauAssociatif.get(key).get(i).get(1).toString())], getPoints()[Integer.parseInt(tableauAssociatif.get(key).get(i).get(2).toString())]));
                        }
                    }
                    case "sphere" ->
                            getSpheres().add(new Sphere(new Triplet(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())), Double.parseDouble(tableauAssociatif.get(key).get(0).get(3).toString())));
                    case "plane" -> getPlans().add(new Plan());
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}