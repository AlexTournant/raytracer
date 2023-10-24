package Model;


public class Triangle {
    private Point a, b, c;


    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public double getDistanceAB() {
        return Math.sqrt(   Math.pow(((getB().getTriplet().getX()) - getA().getTriplet().getX()), 2)) +
                            Math.pow(((getB().getTriplet().getY() - getA().getTriplet().getY())), 2) +
                            Math.pow(((getB().getTriplet().getZ() - getA().getTriplet().getZ())), 2);
    }

    public double getDistanceAC() {
        return Math.sqrt(   Math.pow(((getC().getTriplet().getX() - getA().getTriplet().getX())), 2) +
                            Math.pow(((getC().getTriplet().getY() - getA().getTriplet().getY())), 2) +
                            Math.pow(((getC().getTriplet().getZ() - getA().getTriplet().getZ())), 2));
    }

    public double getDistanceBC() {
        return Math.sqrt(   Math.pow(((getC().getTriplet().getX() - getB().getTriplet().getX())), 2) +
                            Math.pow(((getC().getTriplet().getY() - getB().getTriplet().getY())), 2) +
                            Math.pow(((getC().getTriplet().getZ() - getB().triplet.getZ())), 2));
    }
}
