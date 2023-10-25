package Model;

/**
 * Represents a point in space with coordinates using a Triplet.
 */
public class Point {

	/**
	 * Initialize attribute
	 */
	Triplet triplet;

	/**
	 * Constructs a Point using coordinates
	 *
	 * @param x The x coordinate of the point
	 * @param y The y coordinate of the point
	 * @param z The z coordinate of the point
	 */
	public Point(int x, int y, int z) {
		triplet = new Triplet(x, y, z);
	}

	/**
	 * Constructs a Point using a Triplet for its coordinates
	 *
	 * @param tri The Triplet containing the coordinates of the point
	 */
	public Point(Triplet tri){
		this.triplet = tri;
	}

	/**
	 * Get the Triplet containing the coordinates of the point
	 *
	 * @return The Triplet containing the point's coordinates
	 */
	public Triplet getTriplet(){
		return this.triplet;
	}

	/**
	 * Calculate the vector difference between this point and another point
	 *
	 * @param tri The other point to subtract from this point
	 * @return A Vector representing the difference between the two points
	 */
	public Vector subtract(Point tri) {
		Triplet temp = this.getTriplet().subtract(tri.getTriplet());
		return new Vector(temp);
	}

	/**
	 * Multiply the point's coordinates by a scalar value
	 *
	 * @param scalar The scalar value to multiply the point's coordinates by
	 * @return The result of the multiplication as a new Point with coordinates
	 */
	public Point multiply(float scalar) {
		return new Point(triplet.multiply(scalar));
	}
}
