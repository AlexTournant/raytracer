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

    public Triplet add(Triplet vec) {
        return new Triplet(getX() + vec.getX(), getY() + vec.getY(), getZ() + vec.getZ());
    }

    public Triplet subtract(Triplet vec) {
        return new Triplet(getX() - vec.getX(), getY() - vec.getY(), getZ() - vec.getZ());
    }

    public Triplet scalarMultiply(double scalar){
            return new Triplet(getX() * scalar, getY() * scalar, getZ() * scalar);
    }
    public double scalarProduct(Triplet vec) {
        return getX() * vec.getX()+ getY() * vec.getY()+ getZ() * vec.getZ();
    }

    public Triplet multiplyVectorial(Triplet vec) { return new Triplet(getY()*vec.getZ()-getZ()* vec.getY(),getZ()*vec.getX()-getX()*vec.getZ(),getX()*vec.getY()-getY()*vec.getX()); }

    public Triplet shurProduct(Triplet vec){
            return new Triplet(getX()*vec.getX(),getY()*vec.getY(),getZ()*vec.getZ());
    }

    public Triplet divide(Triplet vec) {
        return new Triplet(getX() / vec.getX(), getY() / vec.getY(), getZ() / vec.getZ());
    }

    public double length() {
        return (double) Math.sqrt(x*x+y*y+z*z);
    }

    public Triplet normalize() {
        double length = length();
        return new Triplet(getX() / length, getY() / length, getZ() / length);
    }

}