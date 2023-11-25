package triplet;

/**
 * The Color class represents a color using RGB values.
 */
public class Color {
	private Triplet triplet; // The RGB triplet representing the color

	/**
	 * Creates a Color object with the specified RGB values.
	 *
	 * @param x The red component (between 0 and 1).
	 * @param y The green component (between 0 and 1).
	 * @param z The blue component (between 0 and 1).
	 */
	public Color(double x, double y, double z) {
		this.triplet = new Triplet(x, y, z);
	}

	/**
	 * Creates a Color object from an existing RGB Triplet.
	 *
	 * @param tri The RGB triplet representing the color.
	 */
	public Color(Triplet tri) {
		this.triplet = tri;
	}

	/**
	 * Get the RGB triplet representing the color.
	 *
	 * @return The RGB triplet as a Triplet object.
	 */
	public Triplet getTriplet() {
		return this.triplet;
	}

	/**
	 * Adds another Color to this Color, clamping values to the range [0, 1].
	 *
	 * @param tri The Color to add.
	 * @return A new Color resulting from the addition.
	 * @throws Exception if clamping fails.
	 */
	public Color add(Color tri) throws Exception {
		Triplet temp = getTriplet().add(tri.getTriplet());
		if (temp.getX() > 1) {
			temp.setX(1);
		}
		if (temp.getY() > 1) {
			temp.setY(1);
		}
		if (temp.getZ() > 1) {
			temp.setZ(1);
		}
		return new Color(temp);
	}

	/**
	 * Scales the Color by a scalar factor.
	 *
	 * @param scalar The scalar factor to multiply the Color by.
	 * @return A new Color resulting from the scalar multiplication.
	 */
	public Color scalarMultiply(double scalar) {
		return new Color(getTriplet().scalarMultiply(scalar));
	}

	/**
	 * Performs a Schur product with another Color.
	 *
	 * @param vec The Color to perform the Schur product with.
	 * @return A new Color resulting from the Schur product.
	 */
	public Color shurProduct(Color vec) {
		return new Color(getTriplet().shurProduct(vec.getTriplet()));
	}
}
