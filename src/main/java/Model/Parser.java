package Model;

import java.io.*;
import java.util.*;

public class Parser {
    private int height;
    private int width;
    private String nomImage;
    private  ArrayList<Triplet> TCamera=new ArrayList<>();

    private ArrayList<Camera> cameras=new ArrayList<>();
    private int fov;
    private Map<String,Color> colors=new HashMap<>();

    private ArrayList<Image> image=new ArrayList<>();
    private ArrayList<DirectionalLight> dl=new ArrayList<>();
    private ArrayList<PonctualLight> pl=new ArrayList<>();
    private int maxvert;
    private  Point[] points;
    private ArrayList<Triangle> triangles=new ArrayList<>();

    private ArrayList<Sphere> spheres=new ArrayList<>();
    private ArrayList<Plan> plans=new ArrayList<>();

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ArrayList<Triplet> getTCamera() {
        return TCamera;
    }

    public ArrayList<Image> getImage() {
        return image;
    }

    public void setImage(ArrayList<Image> image) {
        this.image = image;
    }

    public int getFov() {
        return fov;
    }

    public void setFov(int fov) {
        this.fov = fov;
    }

    public Map<String, Color> getColors() {
        return colors;
    }

    public void setColors(Map<String, Color> colors) {
        this.colors = colors;
    }

    public ArrayList<DirectionalLight> getDl() {
        return dl;
    }

    public void setDl(ArrayList<DirectionalLight> dl) {
        this.dl = dl;
    }

    public ArrayList<PonctualLight> getPl() {
        return pl;
    }

    public void setPl(ArrayList<PonctualLight> pl) {
        this.pl = pl;
    }

    public int getMaxvert() {
        return maxvert;
    }

    public void setMaxvert(int m) {
        maxvert = m;
    }

    public void setPoints(int column) {
        points=new Point[column];
    }

    public Point[] getPoints(){
        return points;
    }

    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }

    public ArrayList<Sphere> getSpheres() {
        return spheres;
    }

    public ArrayList<Plan> getPlans() {
        return plans;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    public void setTCamera(ArrayList<Triplet> TCamera) {
        this.TCamera = TCamera;
    }

    public ArrayList<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(ArrayList<Camera> cameras) {
        this.cameras = cameras;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public void setTriangles(ArrayList<Triangle> triangles) {
        this.triangles = triangles;
    }

    public void setSpheres(ArrayList<Sphere> spheres) {
        this.spheres = spheres;
    }

    public void setPlans(ArrayList<Plan> plans) {
        this.plans = plans;
    }

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
                switch (key) {
                    case "size" -> {
                        setWidth(Integer.parseInt(tableauAssociatif.get(key).get(0).get(0).toString()));
                        setHeight(Integer.parseInt(tableauAssociatif.get(key).get(0).get(1).toString()));
                    }
                    case "output" -> setNomImage((String) tableauAssociatif.get(key).get(0).get(0));
                    case "camera" -> {
                        getTCamera().add(new Triplet(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())));
                        getTCamera().add(new Triplet(Double.parseDouble(tableauAssociatif.get(key).get(0).get(3).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(4).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(5).toString())));
                        getTCamera().add(new Triplet(Double.parseDouble(tableauAssociatif.get(key).get(0).get(6).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(7).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(7).toString())));
                        setFov(Integer.parseInt(tableauAssociatif.get(key).get(0).get(9).toString()));
                    }
                    case "ambient" ->
                            getColors().put(key,new Color(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())));
                    case "diffuse" ->
                            getColors().put(key,new Color(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())));
                    case "specular" ->
                            getColors().put(key,new Color(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())));
                    case "shininess" ->
                            getColors().get("specular").scalarMultiply(Integer.parseInt(tableauAssociatif.get(key).get(0).get(0).toString()));
                    case "directional" ->
                            getDl().add(new DirectionalLight(new Color(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())), new Vector(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString()))));
                    case "point" ->
                            getPl().add(new PonctualLight(new Color(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())), new Point(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()),Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString()))));
                    case "maxverts" ->
                            setPoints(Integer.parseInt(tableauAssociatif.get("maxverts").get(0).get(0).toString()));
                    case "vertex" -> {
                        for (int i=0;i < getPoints().length;i++) {
                            getPoints()[i] = new Point(Double.parseDouble(tableauAssociatif.get(key).get(i).get(0).toString()),Double.parseDouble(tableauAssociatif.get(key).get(i).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(i).get(2).toString()));
                        }
                    }
                    case "tri" -> {
                        for (int i = 0; i <tableauAssociatif.get(key).size(); i++) {
                            getTriangles().add(new Triangle(getPoints()[Integer.parseInt(tableauAssociatif.get(key).get(i).get(0).toString())], getPoints()[Integer.parseInt(tableauAssociatif.get(key).get(i).get(1).toString())], getPoints()[Integer.parseInt(tableauAssociatif.get(key).get(i).get(2).toString())]));
                        }
                    }
                    case "sphere" -> {
                        for (int i = 0; i < tableauAssociatif.get(key).size(); i++) {
                            getSpheres().add(new Sphere(new Point(Double.parseDouble(tableauAssociatif.get(key).get(i).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(i).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(i).get(2).toString())), Double.parseDouble(tableauAssociatif.get(key).get(i).get(3).toString())));
                        }
                    }
                    case "plane" -> getPlans().add(new Plan(new Point(Double.parseDouble(tableauAssociatif.get(key).get(0).get(0).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(1).toString()), Double.parseDouble(tableauAssociatif.get(key).get(0).get(2).toString())),new Vector(Integer.parseInt(tableauAssociatif.get(key).get(0).get(3).toString()), Integer.parseInt(tableauAssociatif.get(key).get(0).get(4).toString()), Integer.parseInt(tableauAssociatif.get(key).get(0).get(5).toString()))));
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("erreur");

        }
    }
    public void addImage(){
        getImage().add(new Image(getWidth(),getHeight(),getNomImage()));
    }

    public void addCamera() {
        if(getTCamera().size()>2){
            getCameras().add(new Camera(getTCamera().get(0),getTCamera().get(1),getTCamera().get(2),getFov()));
            for(int i=0;i<3;i++) {
                getTCamera().remove(0);
            }
        }
    }
}
