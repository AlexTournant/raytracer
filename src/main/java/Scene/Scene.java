package Scene;

import Triplet.Color;
import Affichage.Camera;
import Light.ILight;
import Objets.IObjetScene;
import Affichage.Image;
import Color.IColorStrategy;

import java.util.ArrayList;
import java.util.Map;

/**
 * Represents a 3D scene with a camera, image, colors, objects, and lights.
 */
public class Scene {
    private final Camera camera;
    private final Image image;
    private final Map<String, Color> colors;
    private final Map<IObjetScene, IColorStrategy> objets;
    private final ArrayList<ILight> lights;

    /**
     * Creates a 3D scene with the specified camera, image, colors, objects, and lights.
     *
     * @param camera The camera defining the viewpoint and perspective of the scene.
     * @param image The image where the rendered scene will be displayed.
     * @param colors A mapping of color names to their corresponding values used in the scene.
     * @param objets A collection of 3D objects in the scene and their associated color strategies.
     * @param lights A list of light sources in the scene.
     */
    public Scene(Camera camera, Image image, Map<String, Color> colors, Map<IObjetScene, IColorStrategy> objets, ArrayList<ILight> lights) {
        this.camera = camera;
        this.image = image;
        this.colors = colors;
        this.objets = objets;
        this.lights = lights;
    }

    /**
     * Get the camera of the scene.
     *
     * @return The camera object that defines the viewpoint and perspective of the scene.
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * Get the image where the scene will be displayed.
     *
     * @return The image object representing the rendering surface.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Get the mapping of color names to their values used in the scene.
     *
     * @return A map of color names and their corresponding RGB values.
     */
    public Map<String, Color> getColors() {
        return colors;
    }

    /**
     * Get the collection of 3D objects in the scene and their associated color strategies.
     *
     * @return A map of 3D objects in the scene and their color strategies.
     */
    public Map<IObjetScene, IColorStrategy> getObjets() {
        return objets;
    }

    /**
     * Get the list of light sources in the scene.
     *
     * @return An array list containing the light sources used in the scene.
     */
    public ArrayList<ILight> getLights() {
        return lights;
    }
}
