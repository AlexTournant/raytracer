package Model;

public class Triplet {
    private double x, y, z;

        public Triplet(double x, double y, double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Triplet add(Triplet vec) {
        return new Triplet(this.x + vec.x, this.y + vec.y, this.z + vec.z);
    }

    public Triplet subtract(Triplet vec) {
        return new Triplet(this.x - vec.x, this.y - vec.y, this.z - vec.z);
    }

    public Triplet multiply(double scalar) {
        return new Triplet(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public Triplet multiply(Triplet vec) {
        return new Triplet(this.x * vec.x, this.y * vec.y, this.z * vec.z);
    }

    public Triplet multiplyVectorial(Triplet vec) { return new Triplet(this.y*vec.z-this.z* vec.y,this.z*vec.x-this.x*vec.z,this.x*vec.y-this.y*vec.x); }

    public Triplet divide(Triplet vec) {
        return new Triplet(this.x / vec.x, this.y / vec.y, this.z / vec.z);
    }

    public double length() {
        return (double) Math.sqrt(x*x+y*y+z*z);
    }

    public Triplet normalize() {
        double length = length();
        return new Triplet(this.x / length, this.y / length, this.z / length);
    }

}