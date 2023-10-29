package Model;

import java.util.ArrayList;
import java.util.Map;

/**
 * The Builder interface defines methods for constructing a Scene.
 * Implementations of this interface allow the step-by-step assembly of a Scene by setting
 * various components such as Camera, Image, Lights, Objects, and Colors.
 */
public interface Builder {

    /**
     * Set the Camera for the Scene being built.
     *
     * @param cam The Camera object to be used in the Scene.
     */
    void withCamera(Camera cam);

    /**
     * Set the Image for the Scene being built.
     *
     * @param img The Image object to be rendered in the Scene.
     */
    void withImage(Image img);

    /**
     * Set the lights for the Scene being built.
     *
     * @param lights A list of ILight objects representing the lights in the Scene.
     */
    void withLights(ArrayList<ILight> lights);

    /**
     * Set the objects and their color strategies for the Scene being built.
     *
     * @param objets A map associating IObjetScene objects with their corresponding IColorStrategy.
     */
    void withObjets(Map<IObjetScene, IColorStrategy> objets);

    /**
     * Set the color definitions for the Scene being built.
     *
     * @param colors A map associating color names with Color objects.
     */
    void withColors(Map<String, Color> colors);

    /**
     * Build and return the Scene based on the provided components.
     *
     * @return A fully constructed Scene object.
     */
    Scene build();
}
