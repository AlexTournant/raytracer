package Model;

public class RunParser {



    public static void main(String[] args) throws Exception{
        Parser parse = new Parser();
        String fileName = args[0];

        parse.parse("parser.txt");
    }

}
