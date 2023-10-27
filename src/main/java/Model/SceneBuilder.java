package Model;

import java.util.ArrayList;

public class SceneBuilder {
    private Camera camera=new Camera(null,null,null,0);
    private Image image=new Image(600,600,"image.png");
    private ArrayList<Color> colors=new ArrayList<>();

    private ArrayList<IObjetScene> objets = new ArrayList<>();

    public SceneBuilder withCamera(Camera cam) {
        this.camera = cam;
        return this;
    }

    public SceneBuilder withImage(Image img) {
        this.image = img;
        return this;
    }

    public SceneBuilder withColors(ArrayList<Color> colors) {
        this.colors = colors;
        return this;
    }

    public SceneBuilder withObjets(ArrayList<IObjetScene> objets) {
        this.objets = objets;
        return this;
    }

    public Scene build() {
        Scene sc=new Scene();
        sc.setCamera(this.camera);
        sc.setImage(this.image);
        sc.setColors(this.colors);
        sc.setObjets(this.objets);
        return sc;
    }
}
