package Model;

import java.util.ArrayList;
import java.util.List;

public class SceneBuilder {

    private Camera camera;
    private Image image;
    private ArrayList<Color> colors;
    private List<IObjetScene> objets = new ArrayList<IObjetScene>();

    private SceneBuilder(){
        build();
    }

    public static SceneBuilder newInstance() {
        return new SceneBuilder();
    }

    public void withCamera(Camera cam) {
        this.camera = cam;
    }

    public Camera getCamera() {
        return this.camera;
    }

    public void withImage(Image img) {
        this.image = img;
    }

    public Image getImage() {
        return this.image;
    }

    public void withColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    public ArrayList<Color> getColors() {
        return this.colors;
    }

    public void withObjets(List<IObjetScene> objets) {
        this.objets = objets;
    }

    public List<Model.IObjetScene> getObjets() {
        return this.objets;
    }

    public Scene build() {
        var builder = newInstance();
        builder.withCamera(this.camera);
        builder.withImage(this.image);
        builder.withColors(this.colors);
        builder.withObjets(this.objets);
        return new Scene(builder);
    }


}
