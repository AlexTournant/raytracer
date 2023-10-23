import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Parser {
    public static void main(String[] arg) throws java.io.IOException {

        try {
            // Le fichier d'entrée
            File file = new File("src\\main\\resources\\parser.txt");
            // Créer l'objet File Reader
            FileReader fr = new FileReader(file);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                // ajoute la ligne au buffer
                String[]str=(line.split("\n"));
                if(!str[0].equals("#")) {
                    sb.append(line);
                    sb.append("\n");
                }
            }
            fr.close();
            // Convert the StringBuffer to a String
            String str = sb.toString();
            // Split the string into an array of words using space as the delimiter
            String[] words = str.split("\n");
            Map<String, ArrayList<Object>> tableauAssociatif = new HashMap<>();
            // Iterate and print each word in the array
            int occ=0;
            for (String word : words) {
                String[] a = word.split(" ");
                ArrayList<Object> tabs=new ArrayList<>();
                if (a.length>1) {
                    String mot = a[0];
                    for (int i = 1; i < a.length; i++) {
                        tabs.add(a[i]);
                    }
                    if (!tableauAssociatif.containsKey(mot)) {
                        tableauAssociatif.put(mot+occ, tabs);
                        occ=0;
                    }
                    else{
                        tableauAssociatif.put(mot+occ,tabs);
                        occ+=1;
                    }
                }
            }
            for (String key:tableauAssociatif.keySet()){
                switch (key){
                    case "size":

                        break;
                    case "output":

                        break;
                    case "camera":

                        break;
                    case "ambient":

                        break;
                    case "diffuse":

                        break;
                    case "specular":

                        break;
                    case "shininess":

                        break;
                    case "directional":

                        break;
                    case "point":

                        break;
                    case "maxverts":

                        break;
                    case "vertex":
                        break;
                    case "tri":

                        break;
                    case "sphere":

                        break;
                    case "plane":

                        break;
                }
            }
            System.out.println(tableauAssociatif.toString());
        } finally {

        }
    }
}