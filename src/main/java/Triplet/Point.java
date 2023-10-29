package Triplet;

public class Point {
	Triplet triplet;
	public Point(double x, double y, double z) {
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
	public Point scalarMultiply(double scalar) {
		return new Point(getTriplet().scalarMultiply(scalar));
	}

}
