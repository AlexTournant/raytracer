package Model;

public class Sphere {

    private Triplet origine;
    private double ray;

    public Sphere(Triplet origine, double ray) {
        this.origine = origine;
        this.ray = ray;
    }

    public Triplet getOrigine() {
        return origine;
    }

    public void setOrigine(Triplet origine) {
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
