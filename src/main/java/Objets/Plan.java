package Objets;

import Triplet.Point;
import Triplet.Vector;

public class Plan implements IObjetScene{
    private Point origine;

    private Vector normal;

    public Plan(Point origine, Vector normal) {
        this.origine=origine;
        this.normal=normal.normalize();
    }
    @Override
    public Point getOrigine() {
        return origine;
    }

    @Override
    public double intersection(Point lookFrom, Vector d) {
        double t ;
        if (d.scalarProduct(this.normal) != 0) {
            t=-(lookFrom.subtract(origine).scalarProduct(normal))/(d.scalarProduct(normal));
            return t;
        }
        return -1;
    }

    @Override
    public Vector getN(Point p) {
        return new Vector(this.normal.getTriplet());
    }
}
