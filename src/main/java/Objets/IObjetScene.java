package Objets;

import Triplet.Point;
import Triplet.Vector;

public interface IObjetScene {
    double intersection(Point lookFrom, Vector d);

    Vector getN(Point p) ;
    Point getOrigine();
}
