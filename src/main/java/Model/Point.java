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
		return new Vector(getTriplet().subtract(tri.getTriplet()));
	}
	public Point scalarMultiply(float scalar) {
		return new Point(getTriplet().scalarMultiply(scalar));
	}

	
}
