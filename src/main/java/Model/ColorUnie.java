package Model;

import java.util.Map;

import static java.lang.Math.max;

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
