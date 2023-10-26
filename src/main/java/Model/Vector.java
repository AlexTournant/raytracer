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
        return new Vector(getTriplet().add(tri.getTriplet()));
    }

    public Point add(Point tri) {
        return new Point(getTriplet().add(tri.getTriplet()));
    }

    public Vector subtract(Vector tri) {
        return new Vector(getTriplet().subtract(tri.getTriplet()));
    }

    public Vector scalarMultiply(double scalar) {
        return new Vector(getTriplet().scalarMultiply(scalar));
    }

    public double scalarProduct(Vector vec){return getTriplet().scalarProduct(vec.getTriplet());}

    public Vector multiplyVectorial(Vector vec){
        return new Vector(getTriplet().multiplyVectorial(vec.getTriplet()));
    }

    public double length(){
        return this.getTriplet().length();
    }

    public Vector normalize(){
        return new Vector(this.getTriplet().normalize());
    }

}
