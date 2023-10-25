package Model;

import java.util.ArrayList;
import java.util.List;


/**
 * The SceneBuilder class is responsible for constructing a Scene by setting its properties, with the camera, image settings, colors, and objects in the scene
 */
public class SceneBuilder {

    /**
     * Initialize attribute
     */
    private Camera camera;
    private Image image;
    private ArrayList<Color> colors;
    private List<IObjetScene> objets = new ArrayList<IObjetScene>();

    /**
     * Constructor to initialize a SceneBuilder
     */
    private SceneBuilder(){
        build();
    }

    /**
     * Create a new instance of SceneBuilder
     *
     * @return A new SceneBuilder instance
     */
    public static SceneBuilder newInstance() {
        return new SceneBuilder();
    }

    /**
     * Set the camera for the scene
     *
     * @param cam The camera to be used in the scene
     */
    public void withCamera(Camera cam) {
        this.camera = cam;
    }

    /**
     * Get the camera set for the scene
     *
     * @return The camera for the scene
     */
    public Camera getCamera() {
        return this.camera;
    }

    /**
     * Set the image settings for rendering the scene
     *
     * @param img The image settings for the scene
     */
    public void withImage(Image img) {
        this.image = img;
    }

    /**
     * Get the image settings for rendering the scene
     *
     * @return The image settings for the scene
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Set the list of color values used in the scene
     *
     * @param colors The list of color values to be used in the scene
     */
    public void withColors(ArrayList<Color> colors) {
        this.colors = colors;
    }

    /**
     * Get the list of color values set for the scene
     *
     * @return The list of color values for the scene
     */
    public ArrayList<Color> getColors() {
        return this.colors;
    }

    /**
     * Set the list of objects in the scene
     *
     * @param objets The list of objects to be included in the scene
     */
    public void withObjets(List<IObjetScene> objets) {
        this.objets = objets;
    }

    /**
     * Get the list of objects set for the scene
     *
     * @return The list of objects for the scene
     */
    public List<Model.IObjetScene> getObjets() {
        return this.objets;
    }

    /**
     * Build a Scene using the configured properties
     *
     * @return A new Scene object unsing the properties
     */
    public Scene build() {
        var builder = newInstance();
        builder.withCamera(this.camera);
        builder.withImage(this.image);
        builder.withColors(this.colors);
        builder.withObjets(this.objets);
        return new Scene(builder);
    }


}
