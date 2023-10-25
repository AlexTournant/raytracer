package Model;

/**
 * Represents a vector with three coordinates: x, y, and z
 */
public class Vector {

    /**
     * Initialize attribute
     */
    private Triplet triplet;

    /**
     * Constructs a Vector object with the specified x, y, and z coordinates
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param z The z-coordinate
     */
    public Vector(double x, double y, double z){
        this.triplet = new Triplet(x, y, z);
    }

    /**
     * Constructs a Vector from an existing Triplet.
     *
     * @param tri The Triplet to create the Vector from
     */
    public Vector(Triplet tri){
        this.triplet = tri;
    }

    /**
     * Get the Triplet representation of this Vector
     *
     * @return The Triplet representing this Vector
     */
    public Triplet getTriplet(){
        return this.triplet;
    }

    /**
     * Add another Vector to this Vector
     *
     * @param tri The Vector to add
     * @return A new Vector representing the sum
     */
    public Vector add(Vector tri) {
        return new Vector(triplet.add(tri.getTriplet()));
    }

    /**
     * Add a Point to this Vector
     *
     * @param tri The Point to add
     * @return A new Point representing the result
     */
    public Point add(Point tri) {
        return new Point(triplet.add(tri.getTriplet()));
    }

    /**
     * Subtract another Vector from this Vector
     *
     * @param tri The Vector to subtract
     * @return A new Vector representing the difference
     */
    public Vector subtract(Vector tri) {
        return new Vector(triplet.subtract(tri.getTriplet()));
    }

    /**
     * Multiply this Vector by a scalar value
     *
     * @param scalar The scalar value to multiply by
     * @return A new Vector representing the result
     */
    public Vector multiply(float scalar) {
        return new Vector(triplet.multiply(scalar));
    }

    /**
     * Multiply this Vector by another Vector
     *
     * @param vec The Vector to multiply with
     * @return A new Vector representing the result
     */
    public Vector multiply(Vector vec){
        return new Vector(triplet.multiply(vec.getTriplet()));
    }

    /**
     * Calculate the vectorial product of this Vector and another Vecto.
     *
     * @param vec The Vector to calculate the vectorial product with
     * @return A new Vector representing the vectorial product
     */
    public Vector multiplyVectorial(Vector vec){
        return new Vector(triplet.multiplyVectorial(vec.getTriplet()));
    }

    /**
     * Calculate the length of this Vector
     *
     * @return The length of the Vector
     */
    public double length(){
        return this.triplet.length();
    }

    /**
     * Normalize this Vector
     *
     * @return A new Vector representing the normalized vector
     */
    public Vector normalize(){
        return new Vector(this.triplet.normalize());
    }

}
