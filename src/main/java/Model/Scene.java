package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scene {
    private final Camera camera;
    private final Image image;
    private final Map<String,Color> colors;
    private final Map<IObjetScene, Color> objets;
    private final ArrayList<ILight> lights;

    private final Map<IColorStrategy,IObjetScene> stratColor;

    public Scene(Camera camera, Image image, Map<String, Color> colors, Map<IObjetScene, Color> objets, ArrayList<ILight> lights, Map<IColorStrategy, IObjetScene> stratColor) {
        this.camera = camera;
        this.image = image;
        this.colors = colors;
        this.objets = objets;
        this.lights = lights;
        this.stratColor = stratColor;
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

    public Map<IObjetScene, Color> getObjets() {
        return objets;
    }

    public ArrayList<ILight> getLights() {
        return lights;
    }

    public Map<IColorStrategy,IObjetScene> getStratColor(){
        return stratColor;
    }
}
