package Model;

public interface ILight {
    Color getColor();
}

public class positionalLight implements ILight {
    private Color color;
    private Triplet position;

    public positionalLight(Color color, Triplet position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public Triplet getposition() {
        return position;
    }
}
