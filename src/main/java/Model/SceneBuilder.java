package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SceneBuilder implements Builder{
    private Camera camera;
    private Image image;
    private Map<String, Color> colors;

    private Map<IObjetScene,IColorStrategy> objets=new LinkedHashMap<>();
    private ArrayList<ILight> lights;

    @Override
    public void withCamera(Camera cam) {
        this.camera = cam;
    }
    @Override
    public void withImage(Image img) {
        this.image = img;
    }
    @Override
    public void withColors(Map<String,Color> colors) {
        this.colors = colors;
    }

    @Override
    public void withObjets(Map<IObjetScene, IColorStrategy> objets) {
        this.objets = objets;
    }

    @Override
    public void withLights(ArrayList<ILight> lights){
        this.lights=lights;
    }
    @Override
    public Scene build() {
        return new Scene(this.camera,this.image,this.colors,this.objets,this.lights);
    }
}