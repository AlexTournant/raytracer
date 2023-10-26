package Model;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        //String fileName = args[0];
        ArrayList<String> files=new ArrayList<>();
        files.add("mickey.txt");
        files.add("2SphereDiff.txt");
        files.add("2Sphere.txt");
        //p.parse(fileName);
        for (String file:files){
            Parser p=new Parser();
            p.parse(file);
            p.addCamera();
            p.addImage();
            ArrayList<IObjetScene> listObjetScene = new ArrayList<>();
            listObjetScene.addAll(p.getSpheres());
            listObjetScene.addAll(p.getTriangles());
            listObjetScene.addAll(p.getPlans());
            ArrayList<ILight> listILight = new ArrayList<>();
            listILight.addAll(p.getPl());
            listILight.addAll(p.getDl());
            Scene.SceneBuilder sb = new Scene.SceneBuilder().withCamera(p.getCameras().get(0)).withColors(p.getColors()).withObjets(listObjetScene).withImage(p.getImage().get(0)).withLights(listILight).withDLights(p.getDl());
            Scene scene = sb.build();
            ICalcul IC=new Lambert(scene);
            IC.rayTracing();
        }
    }

}
