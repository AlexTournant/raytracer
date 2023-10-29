package Color;

import Triplet.Color;

public class ColorUnie implements IColorStrategy{
    private Color color;

    public ColorUnie(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor(int i, int j) {
        return color;
    }
}
