package Model;

import java.io.IOException;

/**
 * The RunParser use the parser to read and parse a configuration file
 */
public class RunParser {

    /**
     * Main method to run the parser and read a configuration file
     *
     * @param args Expects the name of the configuration file as the first argument
     * @throws IOException if an IO exception occurs during file reading
     */
    public static void main(String[] args) throws IOException {
        Parser parse = new Parser();
        String fileName = args[0];

        parse.parse("parser.txt");
    }

}
