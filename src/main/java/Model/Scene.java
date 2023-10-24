package Model;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private Camera camera;
    private Image image;
    private ArrayList<Color> colors;
    private List<IObjetScene> objets = new ArrayList<IObjetScene>();


    public Scene(Camera camera, Image image, ArrayList<Color> colors, List<IObjetScene> objets) {
        this.camera = camera;
        this.image = image;
        this.colors = colors;
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

    public ArrayList<Color> getcolors() {
        return this.colors;
    }

    public void setcolors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public List<IObjetScene> getObjets() {
        return objets;
    }

    public void setObjets(List<IObjetScene> objets) {
        this.objets = objets;
    }
}
