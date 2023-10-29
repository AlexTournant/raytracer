package main;

import calcul.ICalculStrategy;
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
        // Define a list of input file names.
        ArrayList<String> files = new ArrayList<>();
        files.add("mystere1.txt");
        files.add("mystere2.txt");
        files.add("mystere3.txt");

        // Iterate through the input files and process each scene.
        for (String file : files) {
            // Parse the scene description from the input file.
            Parser parser = new Parser();
            parser.parse(file);
            Scene scene = parser.getSb().build();

            // Choose a rendering strategy based on the presence of lights.
            ICalculStrategy renderingStrategy;
            if (!scene.getLights().isEmpty()) {
                renderingStrategy = new Lambert(scene);
            } else {
                renderingStrategy = new Normal(scene);
            }

            // Initiate the ray tracing process with the selected strategy.
            renderingStrategy.rayTracing();
        }
    }
}