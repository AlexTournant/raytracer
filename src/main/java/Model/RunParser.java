package Model;

import java.io.IOException;

public class RunParser {

    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        Parser p=new Parser();
        p.parse(fileName);
    }

}
