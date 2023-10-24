package Model;

import java.io.*;
import java.util.*;

class Parser {
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

    public ArrayList<Triplet> getCamera() {
        return camera;
    }

    public void setCamera(ArrayList<Triplet> camera) {
        this.camera = camera;
    }

    public int getFov() {
        return fov;
    }

    public void setFov(int fov) {
        this.fov = fov;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public DirectionalLight getDl() {
        return dl;
    }

    public void setDl(DirectionalLight dl) {
        this.dl = dl;
    }

    public PonctualLight getPl() {
        return pl;
    }

    public void setPl(PonctualLight pl) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public String toString() {
        return "Parser{" +
                "height=" + getHeight() +
                ", width=" + getWidth() +
                ", image='" + getImage() + '\'' +
                ", camera=" + getCamera() +
                ", fov=" + getFov() +
                ", colors=" + getColors() +
                ", dl=" + getDl() +
                ", pl=" + getPl() +
                ", triangles=" + getTriangles() +
                ", spheres=" + getSpheres() +
                ", plans=" + getPlans() +
                getMaxvert()+
                '}';
    }

    public static void main(String[] arg) throws java.io.IOException {
        Parser p=new Parser();
        p.parse("parser.txt");
        System.out.println(p);
    }
}