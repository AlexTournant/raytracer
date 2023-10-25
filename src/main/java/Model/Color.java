package Model;

/**
 * Repressents a color with an RGB triplet
 */
public class Color {
	//Initialize the attribute
	private Triplet triplet;

	/**
	 * Color's constructor wich generate a color object in RGB values
	 */
	public Color(double x, double y, double z) {
		this.triplet = new Triplet(x, y, z);
	}

	/**
	 * Constructor to create a Color object using a Triplet
	 *
	 * @param tri The Color to be added
	 */
	public Color(Triplet tri) {
		this.triplet = tri;
	}

	/**
	 * Method to get the Triplet
	 *
	 * @return the Triplet
	 */
	public Triplet getTriplet(){
		return this.triplet;
	}

	/**
	 * Method to add two colors
	 * Verify if the addition doesn't exceed 1
	 *
	 * @param tri The color to be added
	 * @return The result of the addition as a new Color
	 * @throws Exception if the RGB result exceed 1
	 */
	public Color add(Color tri) throws Exception{
		Triplet temp = triplet.add(tri.getTriplet());
		if (temp.getX() > 1 || temp.getY() > 1 || temp.getZ() > 1){
			throw new Exception("Entree incorrecte");
		}
		else return new Color(temp);
	}

	/**
	 * Method to multiply a color by a scalar value
	 *
	 * @param scalar
	 * @return The result of the multiplication as a new Color
	 */
	public Color multiply(double scalar) {
		return new Color(triplet.multiply(scalar));
	}

	/**
	 * Method to multiply a color by another color
	 *
	 * @param vec The Color to be multpilied
	 * @return The result of the multiplication as a new Color
	 */
	public Color multiply(Color vec) {
		return new Color(triplet.multiply(vec.getTriplet()));
	}
	
}
