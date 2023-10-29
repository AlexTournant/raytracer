package Model;

/**
 * Represents a 3D point in space with coordinates (x, y, z).
 */
public class Point {
	private Triplet triplet;

	/**
	 * Creates a Point object with the specified x, y, and z coordinates.
	 *
	 * @param x The x-coordinate of the point.
	 * @param y The y-coordinate of the point.
	 * @param z The z-coordinate of the point.
	 */
	public Point(double x, double y, double z) {
		triplet = new Triplet(x, y, z);
	}

	/**
	 * Creates a Point object from a Triplet object.
	 *
	 * @param tri The Triplet containing the x, y, and z coordinates.
	 */
	public Point(Triplet tri) {
		this.triplet = tri;
	}

	/**
	 * Get the Triplet containing the x, y, and z coordinates of the point.
	 *
	 * @return The Triplet representing the coordinates of the point.
	 */
	public Triplet getTriplet() {
		return this.triplet;
	}

	/**
	 * Calculate the vector between this point and another point.
	 *
	 * @param tri The other point.
	 * @return The vector from this point to the other point.
	 */
	public Vector subtract(Point tri) {
		return new Vector(getTriplet().subtract(tri.getTriplet()));
	}

	/**
	 * Multiply the coordinates of this point by a scalar value.
	 *
	 * @param scalar The scalar value by which to multiply the point's coordinates.
	 * @return A new Point with scaled coordinates.
	 */
	public Point scalarMultiply(double scalar) {
		return new Point(getTriplet().scalarMultiply(scalar));
	}
}
