package objets;

import triplet.Color;
import triplet.Point;
import triplet.Vector;

/**
 * The `Sphere` class represents a 3D spherical object in a scene.
 */
public class Sphere implements IObjetScene {

    private Point origine;
    private double ray;
    private Color color;

    /**
     * Constructs a sphere with the specified origin and radius.
     *
     * @param origine The center point of the sphere.
     * @param ray     The radius of the sphere.
     */
    public Sphere(Point origine, double ray) {
        this.origine = origine;
        this.ray = ray;
    }

    /**
     * Gets the radius of the sphere.
     *
     * @return The radius of the sphere.
     */
    public double getRay() {
        return ray;
    }

    /**
     * Sets the radius of the sphere.
     *
     * @param ray The new radius of the sphere.
     */
    public void setRay(double ray) {
        this.ray = ray;
    }

    /**
     * Gets the color of the sphere.
     *
     * @return The color of the sphere.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the sphere.
     *
     * @param color The new color of the sphere.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the diameter of the sphere.
     *
     * @return The diameter of the sphere.
     */
    public double getDiameter() {
        return this.getRay() * 2;
    }

    /**
     * Gets the circumference of the sphere.
     *
     * @return The circumference of the sphere.
     */
    public double getCircumference() {
        return 2 * Math.PI * this.getRay();
    }

    /**
     * Gets the volume of the sphere.
     *
     * @return The volume of the sphere.
     */
    public double getVolume() {
        return (double) 4 / 3 * Math.PI * Math.pow(this.getRay(), 3);
    }

    /**
     * Gets the origin (center) of the sphere.
     *
     * @return The origin point of the sphere.
     */
    public Point getOrigine() {
        return origine;
    }

    /**
     * Sets the origin (center) of the sphere to the specified point.
     *
     * @param p The new origin point for the sphere.
     */
    public void setOrigine(Point p) {
        this.origine = p;
    }

    /**
     * Computes the intersection of a ray with the sphere.
     *
     * @param lookFrom The starting point of the ray.
     * @param d        The direction vector of the ray.
     * @return The intersection distance along the ray, or -1 if there is no intersection.
     */

    public double intersection(Point lookFrom, Vector d) {
        double a = 1;
        double b = ((lookFrom.subtract(getOrigine())).scalarProduct(d))*2;
        double c = (lookFrom.subtract(getOrigine()).scalarProduct(lookFrom.subtract(getOrigine())))-Math.pow(getRay(),2);
        double delta = Math.pow(b, 2) - (4 * a * c);
        if (delta < 0) {
            return -1;
        } else if (delta == 0) {
            double alpha = -b / (2 * a);
            if (alpha < 0) {
                return -1;
            } else {
                return alpha;
            }
        } else {
            double t1 = (-b + Math.sqrt(delta)) / (2 * a);
            double t2 = (-b - Math.sqrt(delta)) / (2 * a);
            if (t2 > 0) {
                return t2;
            } else if (t1 > 0) {
                return t1;
            } else {
                return -1;
            }
        }


    }

    /**
     * The normal vector at a given point on the surface of the sphere.
     *
     * @param p The point on the sphere's surface for which the normal vector is computed.
     * @return The normalized normal vector at the specified point on the sphere's surface.
     */
    @Override
    public Vector getN(Point p){
        return p.subtract(getOrigine()).normalize();
    }
}
