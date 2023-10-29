package Objets;

import Triplet.Point;
import Triplet.Vector;

/**
 * The IObjetScene interface defines methods for objects in a scene.
 * Implementing classes are responsible for providing information about intersections
 * and object origins within a scene.
 */
public interface IObjetScene {
    /**
     * Calculates the intersection between the object and a ray defined by the lookFrom point
     * and direction vector (d).
     *
     * @param lookFrom The starting point of the ray.
     * @param d The direction vector of the ray.
     * @return The distance to the intersection point or a sentinel value if no intersection occurs.
     */
    double intersection(Point lookFrom, Vector d);

    /**
     * Gets the vector at a given point on the object's surface.
     *
     * @param p The point on the object's surface.
     * @return The vector at the specified point.
     */
    Vector getN(Point p);

    /**
     * Gets the origin point of the object.
     *
     * @return The origin point of the object.
     */
    Point getOrigine();
}
