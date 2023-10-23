package Model;

public class Color {
	Triplet triplet;
	
	public Color(double x, double y, double z) {
		this.triplet = new Triplet(x, y, z);
	}

	public Color(Triplet tri) {
		this.triplet = tri;
	}

	public Triplet getTriplet(){
		return this.triplet;
	}

	public Color add(Color tri) {
		Triplet temp = triplet.add(tri.getTriplet());
		return new Color(temp);
	}
	
	public Color multiply(double scalar) {
		return new Color(triplet.multiply(scalar));
	}
	
	public Color multiply(Color vec) {
		return new Color(triplet.multiply(vec.getTriplet()));
	}
	
}
