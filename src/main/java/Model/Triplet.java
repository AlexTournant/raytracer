package Model;

/**
 * Represents a vector with three coordinates: x, y, and z
 */
public class Triplet {

    /**
     * Initialize attributes
     */
    private double x, y, z;

    /**
     * Constructs a Triplet using x, y, and z coordinates
     *
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param z The z-coordinate
     */
        public Triplet(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Get the x-coordinate of the triplet
     *
     * @return The x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Get the y-coordinate of the triplet
     *
     * @return The y-coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Get the z-coordinate of the triplet
     *
     * @return The z-coordinate
     */
    public double getZ() {
        return z;
    }

    /**
     * Set the x-coordinate of the triplet
     *
     * @param x The new x-coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Set the y-coordinate of the triplet
     *
     * @param y The new y-coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Set the z-coordinate of the triplet
     *
     * @param z The new z-coordinate
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Add another Triplet to this Triplet
     *
     * @param vec The Triplet to add
     * @return A new Triplet representing the addition
     */
    public Triplet add(Triplet vec) {
        return new Triplet(this.x + vec.x, this.y + vec.y, this.z + vec.z);
    }

    /**
     * Subtract another Triplet from this Triplet
     *
     * @param vec The Triplet to subtract
     * @return A new Triplet representing the difference
     */
    public Triplet subtract(Triplet vec) {
        return new Triplet(this.x - vec.x, this.y - vec.y, this.z - vec.z);
    }

    /**
     * Multiply this Triplet by a scalar value
     *
     * @param scalar The scalar value to multiply by
     * @return A new Triplet representing the result
     */
    public Triplet multiply(double scalar) {
        return new Triplet(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    /**
     * Multiply this Triplet by another Triplet
     *
     * @param vec The Triplet to multiply with
     * @return A new Triplet representing the result
     */
    public Triplet multiply(Triplet vec) {
        return new Triplet(this.x * vec.x, this.y * vec.y, this.z * vec.z);
    }

    /**
     * Calculate the vectorial product of this Triplet and another Triplet
     *
     * @param vec The Triplet to calculate the vectorial product with
     * @return A new Triplet representing the vectorial product
     */
    public Triplet multiplyVectorial(Triplet vec) { return new Triplet(this.y*vec.z-this.z* vec.y,this.z*vec.x-this.x*vec.z,this.x*vec.y-this.y*vec.x); }


    /**
     * Divide this Triplet by another Triplet
     *
     * @param vec The Triplet to divide by
     * @return A new Triplet representing the result
     */
    public Triplet divide(Triplet vec) {
        return new Triplet(this.x / vec.x, this.y / vec.y, this.z / vec.z);
    }

    /**
     * Calculate the length of this Triplet
     *
     * @return The length of the Triplet
     */
    public double length() {
        return (double) Math.sqrt(x*x+y*y+z*z);
    }

    /**
     * Normalize this Triplet
     *
     * @return A new Triplet representing the normalized vector
     */
    public Triplet normalize() {
        double length = length();
        return new Triplet(this.x / length, this.y / length, this.z / length);
    }

}