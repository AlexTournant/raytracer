package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a 3D scene, with camera settings, image dimensions, colors, and objects in the scene
 */
public class Scene {

    /**
     * Initialize attributes
     */
    private Camera camera;
    private Image image;
    private ArrayList<Color> colors;
    private List<IObjetScene> objets = new ArrayList<IObjetScene>();


    /**
     * Constructs a Scene using a SceneBuilder to set its properties
     *
     * @param b The SceneBuilder containing the scene's configuration
     */
    public Scene(SceneBuilder b) {
        this.camera = b.getCamera();
        this.image = b.getImage();
        this.colors = b.getColors();
        this.objets = b.getObjets();
    }


}
