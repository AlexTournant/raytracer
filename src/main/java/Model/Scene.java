package Model;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private Camera camera;
    private Image image;
    private ArrayList<Couleur> couleurs;
    private List<IObjetScene> objets = new ArrayList<IObjetScene>();


    public Scene(Camera camera, Image image, ArrayList<Couleur> couleurs, List<IObjetScene> objets) {
        this.camera = camera;
        this.image = image;
        this.couleurs = couleurs;
        this.objets = objets;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ArrayList<Couleur> getCouleurs() {
        return couleurs.toString();
    }

    public void setCouleurs(ArrayList<Couleur> couleurs) {
        this.couleurs = couleurs;
    }

    public List<IObjetScene> getObjets() {
        return objets;
    }

    public void setObjets(List<IObjetScene> objets) {
        this.objets = objets;
    }
}
