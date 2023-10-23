package Model;

public class Sphere {

    private Triplet origine;
    private double rayon;

    public Sphere(Triplet origine, double rayon) {
        this.origine = origine;
        this.rayon = rayon;
    }

    public Triplet getOrigine() {
        return origine;
    }

    public void setOrigine(Triplet origine) {
        this.origine = origine;
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public double getDiametre() {
        return this.getRayon() * 2;
    }

    public double getCirconference() {
        return 2 * Math.PI * this.getRayon();
    }

    public double getVolume() {
        return (double) 4 / 3 * Math.PI * Math.pow(this.getRayon(), 3);
    }

}
