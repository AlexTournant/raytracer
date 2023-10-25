package Model;

import java.util.ArrayList;

public class Scene {
    private Camera camera;
    private Image image;
    private ArrayList<Color> colors;
    private ArrayList<IObjetScene> objets = new ArrayList<>();
    public static class SceneBuilder {
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
            sc.camera=this.camera;
            sc.image=this.image;
            sc.colors=this.colors;
            sc.objets=this.objets;
            return sc;
        }
    }

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
}
