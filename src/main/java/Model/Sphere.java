package Model;

public class Sphere implements IObjetScene {

    private Point origine;
    private double ray;

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

    public double getDiameter() {
        return this.getRay() * 2;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.getRay();
    }

    public double getVolume() {
        return (double) 4 / 3 * Math.PI * Math.pow(this.getRay(), 3);
    }

}
