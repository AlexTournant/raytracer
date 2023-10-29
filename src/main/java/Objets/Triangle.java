package Objets;


import Triplet.Point;
import Triplet.Vector;

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

    public Point getC() {
        return c;
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

    public double getRayon() {
        return 0;
    }
    @Override
    public Vector getN(Point p){
        return new Vector(getB().subtract(getOrigine()).multiplyVectorial(getC().subtract(getOrigine())).normalize().getTriplet());
    }

    @Override
    public double intersection(Point lookFrom, Vector d) {
        Vector n = this.getB().subtract(getOrigine()).multiplyVectorial(this.getC().subtract(this.getOrigine()));
        Plan q=new Plan(getOrigine(),n);
        double t = q.intersection(lookFrom,d);
        Point p=d.scalarMultiply(t).add(lookFrom);
        if((b.subtract(origine).multiplyVectorial(p.subtract(origine))).scalarProduct(n)<0){
            return -1;
        } else if ((c.subtract(b).multiplyVectorial(p.subtract(b))).scalarProduct(n)<0) {
            return -1;
        } else if ((origine.subtract(c).multiplyVectorial(p.subtract(c))).scalarProduct(n)<0) {
            return -1;
        }
        return t;
    }
}
