package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scene {
    private Camera camera;
    private Image image;
    private Map<String,Color> colors;
    private ArrayList<IObjetScene> objets ;
    private ArrayList<ILight> lights;
    private ArrayList<DirectionalLight>Dlights;
    public static class SceneBuilder {
        private Camera camera=new Camera(null,null,null,0);
        private Image image=new Image(600,600,"image.png");
        private Map<String,Color> colors=new HashMap<>();
        private ArrayList<DirectionalLight>Dlights=new ArrayList<>();

        private ArrayList<IObjetScene> objets = new ArrayList<>();

        private ArrayList<ILight> lights=new ArrayList<>();

        public SceneBuilder withCamera(Camera cam) {
            this.camera = cam;
            return this;
        }

        public SceneBuilder withImage(Image img) {
            this.image = img;
            return this;
        }

        public SceneBuilder withColors(Map<String,Color> colors) {
            this.colors = colors;
            return this;
        }

        public SceneBuilder withObjets(ArrayList<IObjetScene> objets) {
            this.objets = objets;
            return this;
        }

        public SceneBuilder withLights(ArrayList<ILight> lights){
            this.lights=lights;
            return this;
        }

        public SceneBuilder withDLights(ArrayList<DirectionalLight> Dlights){
            this.Dlights=Dlights;
            return this;
        }

        public Scene build() {
            Scene sc=new Scene();
            sc.camera=this.camera;
            sc.image=this.image;
            sc.colors=this.colors;
            sc.objets=this.objets;
            sc.lights=this.lights;
            sc.Dlights=this.Dlights;
            return sc;
        }
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

    public ArrayList<IObjetScene> getObjets() {
        return objets;
    }

    public ArrayList<ILight> getLights() {
        return lights;
    }

    public ArrayList<DirectionalLight> getDlights() {
        return Dlights;
    }
}
