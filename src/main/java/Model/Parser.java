package Model;

import java.io.*;
import java.util.*;

public class Parser {
    private int occ=0;
    private SceneBuilder sb=new SceneBuilder();
    private int height;
    private int width;
    private boolean shadowOn;
    private int taille;
    private String nomImage;

    private ColorDamier colorDamier ;
    private  ArrayList<Triplet> TCamera=new ArrayList<>();

    private ArrayList<Camera> cameras=new ArrayList<>();
    private int fov;
    private Map<String,Color> colors=new LinkedHashMap<>();

    private ArrayList<Image> image=new ArrayList<>();
    private int maxvert;
    private  Point[] points;
    private ArrayList<Triangle> triangles=new ArrayList<>();

    private ArrayList<Sphere> spheres=new ArrayList<>();
    private ArrayList<Plan> plans=new ArrayList<>();

    private Map<IObjetScene,IColorStrategy> diffuse=new LinkedHashMap<>();

    private ArrayList<ILight> listLights=new ArrayList<>();
    private boolean check;

    public SceneBuilder getSb() {
        return sb;
    }

    public ColorDamier getColorDamier() {
        return colorDamier;
    }

    public void setColorDamier(ColorDamier colorDamier) {
        this.colorDamier = colorDamier;
    }

    public void setSb(SceneBuilder sb) {
        this.sb = sb;
    }

    public int getOcc() {
        return occ;
    }

    public void setOcc() {
        this.occ++;
    }

    public int getTaille() {
        return taille;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public ArrayList<ILight> getListLights() {
        return listLights;
    }

    public void setListLights(ArrayList<ILight> listLights) {
        this.listLights = listLights;
    }

    public int getMaxvert() {
        return maxvert;
    }

    public void setMaxvert(int maxvert) {
        this.maxvert = maxvert;
    }

    public Map<IObjetScene, IColorStrategy> getDiffuse() {
        return diffuse;
    }

    public void setDiffuse(Map<IObjetScene, IColorStrategy> diffuse) {
        this.diffuse = diffuse;
    }

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

    public boolean isShadowOn() {
        return shadowOn;
    }

    public void setShadowOn(boolean shadowOn) {
        this.shadowOn = shadowOn;
    }

    public void init(){
        setWidth(680);
        setHeight(480);
        getColors().put("ambient", new Color(0, 0, 0));
        getColors().put("diffuse", new Color(0, 0, 0));
    }

    public void parse(String nomFile) throws java.io.IOException {
        init();
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
            for (String word : words) {
                String[] a = word.split(" ");
                ArrayList<Object> tab=new ArrayList<>();
                if (a.length>1) {
                    String mot = a[0];
                    for (int i = 1; i < a.length; i++) {
                        tab.add(a[i]);
                    }
                    switch (mot) {
                        case "shadow"->
                            setShadowOn(Boolean.parseBoolean(tab.get(0).toString()));
                        case "checker"-> {
                            setCheck(true);
                            setColorDamier(new ColorDamier(new Color(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString())), new Color(Double.parseDouble(tab.get(3).toString()), Double.parseDouble(tab.get(4).toString()), Double.parseDouble(tab.get(5).toString())),Integer.parseInt(tab.get(6).toString())));
                        }
                        case "size" -> {
                            setWidth(Integer.parseInt(tab.get(0).toString()));
                            setHeight(Integer.parseInt(tab.get(1).toString()));
                        }
                        case "output" -> setNomImage((String) tab.get(0));
                        case "camera" -> {
                            getTCamera().add(new Triplet(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString())));
                            getTCamera().add(new Triplet(Double.parseDouble(tab.get(3).toString()), Double.parseDouble(tab.get(4).toString()), Double.parseDouble(tab.get(5).toString())));
                            getTCamera().add(new Triplet(Double.parseDouble(tab.get(6).toString()), Double.parseDouble(tab.get(7).toString()), Double.parseDouble(tab.get(7).toString())));
                            setFov(Integer.parseInt(tab.get(9).toString()));
                        }
                        case "ambient" ->
                                getColors().put(mot,new Color(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString())));
                        case "diffuse" -> {
                            if (getColors().containsKey(mot)) {
                                getColors().replace(mot, new Color(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString())));
                            }
                            else {
                                getColors().put(mot, new Color(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString())));
                            }
                        }
                        case "specular" -> {
                            if(getColors().containsKey(mot)) {
                                getColors().replace(mot, new Color(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString())));
                            }
                            else{
                                getColors().put(mot, new Color(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString())));
                            }
                        }
                        case "shininess" ->System.out.println("la");
                        //getColors().get("specular").scalarMultiply(Integer.parseInt(tab.get(0).toString()));
                        case "directional" ->
                                getListLights().add(new DirectionalLight(new Color(Double.parseDouble(tab.get(3).toString()), Double.parseDouble(tab.get(4).toString()), Double.parseDouble(tab.get(5).toString())), new Vector(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString()))));
                        case "point" ->
                                getListLights().add(new PonctualLight(new Color(Double.parseDouble(tab.get(3).toString()), Double.parseDouble(tab.get(4).toString()), Double.parseDouble(tab.get(5).toString())), new Point(Double.parseDouble(tab.get(0).toString()),Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString()))));
                        case "maxverts" ->
                                setPoints(Integer.parseInt(tab.get(0).toString()));
                        case "vertex" -> {
                            getPoints()[getOcc()] = new Point(Double.parseDouble(tab.get(0).toString()),Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString()));
                            setOcc();

                        }
                        case "tri" ->
                            diffuse.put( new Triangle(getPoints()[Integer.parseInt(tab.get(0).toString())], getPoints()[Integer.parseInt(tab.get(1).toString())], getPoints()[Integer.parseInt(tab.get(2).toString())]), new ColorUnie(colors.get("diffuse")));
                        case "sphere" ->
                            diffuse.put(new Sphere(new Point(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString())), Double.parseDouble(tab.get(3).toString())),new ColorUnie(colors.get("diffuse")));
                        case "plane" -> {
                            if(isCheck()) {
                                diffuse.put(new Plan(new Point(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString())), new Vector(Integer.parseInt(tab.get(3).toString()), Integer.parseInt(tab.get(4).toString()), Integer.parseInt(tab.get(5).toString()))),getColorDamier());
                                setCheck(false);
                            }
                            else {
                                diffuse.put(new Plan(new Point(Double.parseDouble(tab.get(0).toString()), Double.parseDouble(tab.get(1).toString()), Double.parseDouble(tab.get(2).toString())), new Vector(Integer.parseInt(tab.get(3).toString()), Integer.parseInt(tab.get(4).toString()), Integer.parseInt(tab.get(5).toString()))),new ColorUnie(colors.get("diffuse")));
                            }
                        }
                    }
                }
            }
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

    public Camera getCamera() {
        if(getTCamera().size()>2){
            return new Camera(new Point(getTCamera().get(0)),new Point(getTCamera().get(1)),new Vector(getTCamera().get(2)),getFov());
        }
        return null;
    }
}
