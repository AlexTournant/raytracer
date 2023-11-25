package main;

import calcul.ICalculStrategy;
import calcul.Image;
import calcul.Lambert;
import calcul.Normal;
import scene.Scene;

import java.util.ArrayList;

/**
 * The Main class serves as the entry point for the ray tracing.
 * It processes input file names, parses scene descriptions, and initiates the
 * ray tracing process using different rendering strategies based on the presence
 * of lights in the scene.
 */
public class Main {

    /**
     * The main method, which is the entry point.
     *
     * @param args An array of input file names containing scene descriptions.
     * @throws Exception if an error occurs during parsing or ray tracing.
     */
    public static void main(String[] args) throws Exception {
        // Iterate through the input files and process each scene.
        System.out.println(args);
        for (String file : args) {
            // Parse the scene description from the input file.
            Parser parser = new Parser();
            parser.parse(file);
            Scene scene = parser.getSb().build();

            // Choose a rendering strategy based on the presence of lights.
            Image image;
            if (!scene.getLights().isEmpty()) {
                image=new Image(scene,new Lambert());
            } else {
                image=new Image(scene,new Normal());
            }
            // Initiate the ray tracing process with the selected strategy.
            image.rayTracing();
        }
    }
}
