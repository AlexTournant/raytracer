package Model;


public class Triangle implements IObjetScene{
    private Point origine, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.origine = a;
        this.b = b;
        this.c = c;
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
        return Math.sqrt(   Math.pow(((getB().getTriplet().getX()) - getOrigine().getTriplet().getX()), 2)) +
                            Math.pow(((getB().getTriplet().getY() - getOrigine().getTriplet().getY())), 2) +
                            Math.pow(((getB().getTriplet().getZ() - getOrigine().getTriplet().getZ())), 2);
    }

    public double getDistanceAC() {
        return Math.sqrt(   Math.pow(((getC().getTriplet().getX() - getOrigine().getTriplet().getX())), 2) +
                            Math.pow(((getC().getTriplet().getY() - getOrigine().getTriplet().getY())), 2) +
                            Math.pow(((getC().getTriplet().getZ() - getOrigine().getTriplet().getZ())), 2));
    }

    public double getDistanceBC() {
        return Math.sqrt(   Math.pow(((getC().getTriplet().getX() - getB().getTriplet().getX())), 2) +
                            Math.pow(((getC().getTriplet().getY() - getB().getTriplet().getY())), 2) +
                            Math.pow(((getC().getTriplet().getZ() - getB().getTriplet().getZ())), 2));
    }

    @Override
    public Point getOrigine() {
        return origine;
    }

    @Override
    public double getRayon() {
        return 0;
    }

    public double intersection(Point lookFrom, Point q, Vector d) {
        Vector n = (this.getB().subtract(getOrigine()).multiplyVectorial(this.getC().subtract(this.getOrigine()))).normalize();
        double t = Plan.intersection(lookFrom, q, n, d);
        if (t > 0) {
            if ((getB().subtract(getOrigine())).multiplyVectorial(lookFrom.subtract(getOrigine())).scalarProduct(n) < 0) {
                return -1;
            } else if ((getC().subtract(getB())).multiplyVectorial(lookFrom.subtract(getB())).scalarProduct(n) < 0) {
                return -1;
            } else if ((getOrigine().subtract(getC())).multiplyVectorial(lookFrom.subtract(getC())).scalarProduct(n) < 0) {
                return -1;
            }
        }
        return t;
    }
}
