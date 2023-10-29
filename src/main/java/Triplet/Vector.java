package Triplet;

/**
 * Represents a 3D vector with components x, y, and z.
 */
public class Vector {
    /**
     * The underlying Triplet that stores the vector's components.
     */
    private Triplet triplet;

    /**
     * Constructs a Vector with the specified x, y, and z components.
     *
     * @param x The x-component of the vector.
     * @param y The y-component of the vector.
     * @param z The z-component of the vector.
     */
    public Vector(double x, double y, double z) {
        this.triplet = new Triplet(x, y, z);
    }

    /**
     * Constructs a Vector using an existing Triplet.
     *
     * @param tri The Triplet to create the vector from.
     */
    public Vector(Triplet tri) {
        this.triplet = tri;
    }

    /**
     * Gets the underlying Triplet representing this vector.
     *
     * @return The Triplet representation of the vector.
     */
    public Triplet getTriplet() {
        return this.triplet;
    }

    /**
     * Adds another Vector to this Vector and returns a new Vector as the result.
     *
     * @param tri The Vector to be added.
     * @return A new Vector representing the sum of this and the provided Vector.
     */
    public Vector add(Vector tri) {
        return new Vector(getTriplet().add(tri.getTriplet()));
    }

    /**
     * Adds a Point to this Vector and returns a new Point as the result.
     *
     * @param tri The Point to be added.
     * @return A new Point representing the result of adding this Vector and the Point.
     */
    public Point add(Point tri) {
        return new Point(getTriplet().add(tri.getTriplet()));
    }

    /**
     * Subtracts another Vector from this Vector and returns a new Vector as the result.
     *
     * @param tri The Vector to be subtracted.
     * @return A new Vector representing the difference of this and the provided Vector.
     */
    public Vector subtract(Vector tri) {
        return new Vector(getTriplet().subtract(tri.getTriplet()));
    }

    /**
     * Multiplies the Vector by a scalar value and returns a new Vector as the result.
     *
     * @param scalar The scalar value for multiplication.
     * @return A new Vector representing the result of scalar multiplication.
     */
    public Vector scalarMultiply(double scalar) {
        return new Vector(getTriplet().scalarMultiply(scalar));
    }

    /**
     * Calculates the scalar product of this Vector and another Vector.
     *
     * @param vec The other Vector for the dot product.
     * @return The scalar product of the two Vectors.
     */
    public double scalarProduct(Vector vec){return getTriplet().scalarProduct(vec.getTriplet());}

    /**
     * Calculates the vector product of this Vector and another Vector.
     *
     * @param vec The other Vector for the vector product.
     * @return A new Vector representing the vector product of the two Vectors.
     */
    public Vector multiplyVectorial(Vector vec){
        return new Vector(getTriplet().multiplyVectorial(vec.getTriplet()));
    }

    /**
     * Calculates the length of this Vector.
     *
     * @return The length of the Vector.
     */
    public double length(){
        return this.getTriplet().length();
    }

    /**
     * Normalizes the Vector.
     *
     * @return A new Vector that is the normalized version of this Vector.
     */
    public Vector normalize(){
        return new Vector(this.getTriplet().normalize());
    }

}