package Model;

public class Vector {
    Triplet triplet;

    public Vector(double x, double y, double z){
        this.triplet = new Triplet(x, y, z);
    }

    public Vector(Triplet tri){
        this.triplet = tri;
    }

    public Triplet getTriplet(){
        return this.triplet;
    }

    public Vector add(Vector tri) {
        return new Vector(triplet.add(tri.getTriplet()));
    }

    public Point add(Point tri) {
        return new Point(triplet.add(tri.getTriplet()));
    }

    public Vector subtract(Vector tri) {
        return new Vector(triplet.subtract(tri.getTriplet()));
    }

    public Vector multiply(float scalar) {
        return new Vector(triplet.multiply(scalar));
    }

    public double multiply(Vector vec){
        return (triplet.multiply(vec.getTriplet()));
    }

    public Vector multiplyVectorial(Vector vec){
        return new Vector(triplet.multiplyVectorial(vec.getTriplet()));
    }

    public double length(){
        return this.triplet.length();
    }

    public Vector normalize(){
        return new Vector(this.triplet.normalize());
    }

}
