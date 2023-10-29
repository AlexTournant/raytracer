package Color;

import Triplet.Color;

public class ColorDamier implements IColorStrategy{
    private Color color1;
    private Color color2;
    private int taille;

    public ColorDamier(Color color1, Color color2, int taille) {
        this.color1 = color1;
        this.color2 = color2;
        this.taille = taille;
    }

    @Override
    public Color getColor(int i,int j) {
        int x=i/this.taille;
        int z=j/this.taille;
        if((x+z)%2==0){
            return color1;
        }
        else{
            return color2;
        }
    }
}
