package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A builder class for constructing a 3D scene with a camera, image, colors, objects, and lights.
 */
public class SceneBuilder implements Builder{
    private Camera camera;
    private Image image;
    private Map<String, Color> colors;

    private Map<IObjetScene,IColorStrategy> objets=new LinkedHashMap<>();
    private ArrayList<ILight> lights;

    /**
     * Set the camera for the scene being built.
     *
     * @param cam The camera object defining the viewpoint and perspective of the scene.
     */
    @Override
    public void withCamera(Camera cam) {
        this.camera = cam;
    }

    /**
     * Set the image where the scene will be displayed.
     *
     * @param img The image object representing the rendering surface.
     */
    @Override
    public void withImage(Image img) {
        this.image = img;
    }

    /**
     * Set the mapping of color names to their values used in the scene.
     *
     * @param colors A map of color names and their corresponding RGB values.
     */
    @Override
    public void withColors(Map<String, Color> colors) {
        this.colors = colors;
    }

    /**
     * Set the collection of 3D objects in the scene and their associated color strategies.
     *
     * @param objets A map of 3D objects in the scene and their color strategies.
     */
    @Override
    public void withObjets(Map<IObjetScene, IColorStrategy> objets) {
        this.objets = objets;
    }

    /**
     * Set the list of light sources used in the scene.
     *
     * @param lights An array list containing the light sources used in the scene.
     */
    @Override
    public void withLights(ArrayList<ILight> lights) {
        this.lights = lights;
    }

    /**
     * Build and return a 3D scene with the specified components.
     *
     * @return A 3D scene containing a camera, image, colors, objects, and lights.
     */
    @Override
    public Scene build() {
        return new Scene(this.camera, this.image, this.colors, this.objets, this.lights);
    }
}