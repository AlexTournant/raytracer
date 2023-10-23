package Model;


public class Triangle {
    Triplet a, b, c;


    public Triangle(Triplet a, Triplet b, Triplet c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triplet getA() {
        return a;
    }

    public void setA(Triplet a) {
        this.a = a;
    }

    public Triplet getB() {
        return b;
    }

    public void setB(Triplet b) {
        this.b = b;
    }

    public Triplet getC() {
        return c;
    }

    public void setC(Triplet c) {
        this.c = c;
    }

    public double getDistanceAB() {
        return Math.sqrt(   Math.pow(((getB().getX() - getA().getX())), 2) +
                            Math.pow(((getB().getY() - getA().getY())), 2) +
                            Math.pow(((getB().getZ() - getA().getZ())), 2));
    }

    public double getDistanceAC() {
        return Math.sqrt(   Math.pow(((getC().getX() - getA().getX())), 2) +
                            Math.pow(((getC().getY() - getA().getY())), 2) +
                            Math.pow(((getC().getZ() - getA().getZ())), 2));
    }

    public double getDistanceBC() {
        return Math.sqrt(   Math.pow(((getC().getX() - getB().getX())), 2) +
                            Math.pow(((getC().getY() - getB().getY())), 2) +
                            Math.pow(((getC().getZ() - getB().getZ())), 2));
    }
}
