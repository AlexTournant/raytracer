package Model;

public class Point {
	Triplet triplet;
	public Point(int x, int y, int z) {
		triplet = new Triplet(x, y, z);
	}

	public Point(Triplet tri){
		this.triplet = tri;
	}

	public Triplet getTriplet(){
		return this.triplet;
	}

	public Vector subtract(Point tri) {
		Triplet temp = this.getTriplet().subtract(tri.getTriplet());
		return new Vector(temp);
	}
	
	public Point multiply(float scalar) {
		return new Point(triplet.multiply(scalar));
	}

	
}
