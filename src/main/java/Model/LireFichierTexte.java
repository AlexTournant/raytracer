package Model;

class LireFichierTexte {
    public static void main(String[] arg)  throws java.io.IOException {
        java.util.Scanner lecteur ;

        java.io.File fichier = new java.io.File(arg[0]);
        lecteur = new java.util.Scanner(fichier);

	/* ou bien
	   java.io.InputStream entree =
	   LireFichierTexteBis.class.getResourceAsStream((arg[0]));
	   lecteur = new java.util.Scanner(entree);
	*/

        int somme = 0;
        while (lecteur.hasNextInt()) somme += lecteur.nextInt();
        System.out.println(somme);
    }
}