package Main;

import Calcul.ICalculStrategy;
import Calcul.Lambert;
import Calcul.Normal;
import Scene.Scene;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] fileName = args;
        ArrayList<String> files=new ArrayList<>();
        files.add("mystere1.txt");
        files.add("mystere2.txt");
        files.add("mystere3.txt");
        //for (String file:fileName){
        for (String file:files){
            Parser p=new Parser();
            p.parse(file);
            Scene scene = p.getSb().build();
            if(!scene.getLights().isEmpty()) {
                ICalculStrategy IC=new Lambert(scene);
                IC.rayTracing();
            }
            else{
                ICalculStrategy IC=new Normal(scene);
                IC.rayTracing();
            }
        }
    }

}
