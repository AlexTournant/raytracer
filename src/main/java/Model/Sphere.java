package Model;

/**
 * Represents a sphere defined by its origin point and radius
 */
public class Sphere {

    /**
     * Initialize attributes
     */
    private Triplet origine;
    private double ray;

    /**
     * Constructs a Sphere object using the origin and radius
     *
     * @param origine The origin point of the sphere
     * @param ray     The radius of the sphere
     */
    public Sphere(Triplet origine, double ray) {
        this.origine = origine;
        this.ray = ray;
    }

    /**
     * Get the origin point of the sphere
     *
     * @return The origin point
     */
    public Triplet getOrigine() {
        return origine;
    }

    /**
     * Set the origin point of the sphere
     *
     * @param origine The new origin point
     */
    public void setOrigine(Triplet origine) {
        this.origine = origine;
    }

    /**
     * Get the radius of the sphere
     *
     * @return The radius
     */
    public double getRay() {
        return ray;
    }

    /**
     * Set the radius of the sphere
     *
     * @param ray The new radius
     */
    public void setRay(double ray) {
        this.ray = ray;
    }

    /**
     * Calculate the diameter of the sphere
     *
     * @return The diameter of the sphere
     */
    public double getDiameter() {
        return this.getRay() * 2;
    }

    /**
     * Calculate the circumference of the sphere
     *
     * @return The circumference of the sphere
     */
    public double getCircumference() {
        return 2 * Math.PI * this.getRay();
    }

    /**
     * Calculate the volume of the sphere
     *
     * @return The volume of the sphere
     */
    public double getVolume() {
        return (double) 4 / 3 * Math.PI * Math.pow(this.getRay(), 3);
    }

}
