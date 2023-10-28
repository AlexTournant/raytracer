package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scene {
    private final Camera camera;
    private final Image image;
    private final Map<String,Color> colors;
    private final Map<IObjetScene, IColorStrategy> objets;
    private final ArrayList<ILight> lights;

    public Scene(Camera camera, Image image, Map<String, Color> colors, Map<IObjetScene, IColorStrategy> objets, ArrayList<ILight> lights) {
        this.camera = camera;
        this.image = image;
        this.colors = colors;
        this.objets = objets;
        this.lights = lights;
    }

    public Camera getCamera() {
        return camera;
    }

    public Image getImage() {
        return image;
    }

    public Map<String,Color> getColors() {
        return colors;
    }

    public Map<IObjetScene, IColorStrategy> getObjets() {
        return objets;
    }

    public ArrayList<ILight> getLights() {
        return lights;
    }
}
