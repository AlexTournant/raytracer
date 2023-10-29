package Model;

import java.util.ArrayList;
import java.util.Map;

public interface Builder {
    void withCamera(Camera cam);
    void withImage(Image img);
    void withLights(ArrayList<ILight> lights);
    void withObjets(Map<IObjetScene, IColorStrategy> objets);
    void withColors(Map<String,Color> colors);
    Scene build();
}
