package Model;

/**
 * Represents a 3D vector with components x, y, and z.
 */
public class Triplet {
    /**
     * The x-coordinate of the vector.
     */
    private double x;

    /**
     * The y-coordinate of the vector.
     */
    private double y;

    /**
     * The z-coordinate of the vector.
     */
    private double z;

    /**
     * Constructs a Triplet with the specified x, y, and z coordinates.
     *
     * @param x The x-coordinate of the vector.
     * @param y The y-coordinate of the vector.
     * @param z The z-coordinate of the vector.
     */
    public Triplet(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Gets the x-coordinate of the vector.
     *
     * @return The x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the vector.
     *
     * @return The y-coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the z-coordinate of the vector.
     *
     * @return The z-coordinate.
     */
    public double getZ() {
        return z;
    }

    /**
     * Adds another Triplet to this Triplet and returns a new Triplet as the result.
     *
     * @param vec The Triplet to be added.
     * @return A new Triplet representing the sum of this and the provided Triplet.
     */
    public Triplet add(Triplet vec) {
        return new Triplet(getX() + vec.getX(), getY() + vec.getY(), getZ() + vec.getZ());
    }

    /**
     * Subtracts another Triplet from this Triplet and returns a new Triplet as the result.
     *
     * @param vec The Triplet to be subtracted.
     * @return A new Triplet representing the difference of this and the provided Triplet.
     */
    public Triplet subtract(Triplet vec) {
        return new Triplet(getX() - vec.getX(), getY() - vec.getY(), getZ() - vec.getZ());
    }

    /**
     * Multiplies the Triplet by a scalar value and returns a new Triplet as the result.
     *
     * @param scalar The scalar value for multiplication.
     * @return A new Triplet representing the result of scalar multiplication.
     */
    public Triplet scalarMultiply(double scalar){
            return new Triplet(getX() * scalar, getY() * scalar, getZ() * scalar);
    }

    /**
     * Calculates the scalar product of this Triplet and another Triplet.
     *
     * @param vec The other Triplet for the dot product.
     * @return The scalar product of the two Triplets.
     */
    public double scalarProduct(Triplet vec) {
        return getX() * vec.getX()+ getY() * vec.getY()+ getZ() * vec.getZ();
    }

    /**
     * Calculates the vector product of this Triplet and another Triplet.
     *
     * @param vec The other Triplet for the vector product.
     * @return A new Triplet representing the vector (cross) product of the two Triplets.
     */
    public Triplet multiplyVectorial(Triplet vec) { return new Triplet(getY()*vec.getZ()-getZ()* vec.getY(),getZ()*vec.getX()-getX()*vec.getZ(),getX()*vec.getY()-getY()*vec.getX()); }

    /**
     * Calculates the element-wise product of this Triplet and another Triplet.
     *
     * @param vec The other Triplet for the element-wise product.
     * @return A new Triplet representing the element-wise product of the two Triplets.
     */
    public Triplet shurProduct(Triplet vec){
            return new Triplet(getX()*vec.getX(),getY()*vec.getY(),getZ()*vec.getZ());
    }

    /**
     * Calculates the length of this Triplet.
     *
     * @return The length of the Triplet.
     */
    public double length() {
        return Math.sqrt(x*x+y*y+z*z);
    }

    /**
     * Normalizes the Triplet.
     *
     * @return A new Triplet that is the normalized version of this Triplet.
     */
    public Triplet normalize() {
        double length = length();
        return new Triplet(getX() / length, getY() / length, getZ() / length);
    }

    /**
     * Sets the x-coordinate of the vector.
     *
     * @param x The new x-coordinate.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the vector.
     *
     * @param y The new y-coordinate.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets the z-coordinate of the vector.
     *
     * @param z The new z-coordinate.
     */
    public void setZ(double z) {
        this.z = z;
    }
}