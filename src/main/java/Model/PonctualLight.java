package Model;

public class PonctualLight implements ILight {
    private Color color;
    private Point position;

    public PonctualLight(Color color, Point position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public Point getPosition() {
        return position;
    }
}