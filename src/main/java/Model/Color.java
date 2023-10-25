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

	public Color add(Color tri) throws Exception{
		Triplet temp = getTriplet().add(tri.getTriplet());
		if (temp.getX() > 1 || temp.getY() > 1 || temp.getZ() > 1){
			throw new Exception("Entree incorrecte");
		}
		else return new Color(temp);
	}
	
	public Color scalarMultiply(double scalar) {
		return new Color(getTriplet().scalarMultiply(scalar));
	}
	
	public Color shurProduct(Color vec) {
		return new Color(getTriplet().shurProduct(vec.getTriplet()));
	}
	
}
