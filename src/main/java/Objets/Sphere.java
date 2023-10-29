package Objets;

import Triplet.Color;
import Triplet.Point;
import Triplet.Vector;

public class Sphere implements IObjetScene {

    private Point origine;
    private double ray;
    private Color color;

    public Sphere(Point origine, double ray) {
        this.origine = origine;
        this.ray = ray;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getOrigine() {
        return origine;
    }
    public double getRayon() {
        return ray;
    }

    public double intersection(Point lookFrom, Vector d) {
        double a = 1;
        double b = ((lookFrom.subtract(getOrigine())).scalarProduct(d))*2;
        double c = (lookFrom.subtract(getOrigine()).scalarProduct(lookFrom.subtract(getOrigine())))-Math.pow(getRayon(),2);
        double delta = Math.pow(b, 2) - (4 * a * c);
        if (delta < 0) {
            return -1;
        } else if (delta == 0) {
            double alpha = -b / (2 * a);
            if (alpha < 0) {
                return -1;
            } else {
                return alpha;
            }
        } else {
            double t1 = (-b + Math.sqrt(delta)) / (2 * a);
            double t2 = (-b - Math.sqrt(delta)) / (2 * a);
            if (t2 > 0) {
                return t2;
            } else if (t1 > 0) {
                return t1;
            } else {
                return -1;
            }
        }


    }

    @Override
    public Vector getN(Point p){
        return p.subtract(getOrigine()).normalize();
    }
}