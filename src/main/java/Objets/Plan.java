package Objets;

import Triplet.Point;
import Triplet.Vector;

/**
 * Represents a plan object in the 3D scene.
 */
public class Plan implements IObjetScene {
    private Point origine;
    private Vector normal;

    /**
     * Creates a Plan object with the specified origin point and normal vector.
     *
     * @param origine The origin point of the plan.
     * @param normal  The normal vector to the plan (should be normalized).
     */
    public Plan(Point origine, Vector normal) {
        this.origine = origine;
        this.normal = normal.normalize();
    }

    /**
     * Set the origin point of the plan.
     *
     * @param origine The origin point to set.
     */
    public void setOrigine(Point origine) {
        this.origine = origine;
    }

    /**
     * Set the normal vector of the plan.
     *
     * @param normal The normal vector to set (should be normalized).
     */
    public void setNormal(Vector normal) {
        this.normal = normal;
    }

    /**
     * Get the origin point of the plan.
     *
     * @return The origin point of the plan.
     */
    @Override
    public Point getOrigine() {
        return origine;
    }

    /**
     * Get the radius of the plan. Since it's a plan, the radius is always 0.
     *
     * @return The radius of the plan (always 0).
     */
    public double getRayon() {
        return 0;
    }

    /**
     * Calculate the intersection of a ray with the plan.
     *
     * @param lookFrom The starting point of the ray.
     * @param d        The direction vector of the ray.
     * @return The parameter 't' at which the ray intersects the plan, or -1 if there is no intersection.
     */
    @Override
    public double intersection(Point lookFrom, Vector d) {
        double t;
        if (d.scalarProduct(this.normal) != 0) {
            t = -(lookFrom.subtract(origine).scalarProduct(normal)) / (d.scalarProduct(normal));
            return t;
        }
        return -1;
    }

    /**
     * Get the normal vector to the plan at a given point.
     *
     * @param p The point at which to calculate the normal vector.
     * @return The normal vector to the plan.
     */
    @Override
    public Vector getN(Point p) {
        return new Vector(this.normal.getTriplet());
    }
}
