package Model;

import java.util.ArrayList;

public class Scene {
    private Camera camera;
    private Image image;
    private ArrayList<Color> colors;
    private ArrayList<IObjetScene> objets = new ArrayList<>();


    public Camera getCamera() {
        return camera;
    }

    public Image getImage() {
        return image;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public ArrayList<IObjetScene> getObjets() {
        return objets;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public void setObjets(ArrayList<IObjetScene> objets) {
        this.objets = objets;
    }
}
