package Model;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        //String fileName = args[0];
        Parser p=new Parser();
        //p.parse(fileName);
        p.parse("parser.txt");
        p.addCamera();
        p.addImage();
        System.out.println(p.getSpheres().get(0));
        IObjetScene ios=p.getSpheres().get(0);
        ArrayList<IObjetScene>listObjetScene=new ArrayList<>();
        listObjetScene.add(ios);
        Scene.SceneBuilder sb=new Scene.SceneBuilder().withCamera(p.getCameras().get(0)).withColors(p.getColors()).withObjets(listObjetScene).withImage(p.getImage().get(0));
        Scene scene= sb.build();
        RayThrower rt=new RayThrower(scene);
        rt.rayTracing();
    }

}
