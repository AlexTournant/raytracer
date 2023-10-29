package Model;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        //String fileName = args[0];
        ArrayList<String> files=new ArrayList<>();
        files.add("mystere3.txt");
        //p.parse(fileName);
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
