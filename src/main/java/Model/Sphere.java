package Model;

public class Sphere implements IObjetScene {

    private Point origine;
    private double ray;
    private Color color;

    public Sphere(Point origine, double ray) {
        this.origine = origine;
        this.ray = ray;
    }

    public Point getOrigine() {
        return origine;
    }

    public void setOrigine(Point origine) {
        this.origine = origine;
    }

    public double getRay() {
        return ray;
    }

    public void setRay(double ray) {
        this.ray = ray;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getDiameter() {
        return this.getRay() * 2;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.getRay();
    }

    public double getVolume() {
        return (double) 4 / 3 * Math.PI * Math.pow(this.getRay(), 3);
    }

    @Override
    public void getObjet() {

    }

}
