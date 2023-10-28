package Model;

public interface IObjetScene {
    double intersection(Point lookFrom, Vector d);

    Vector getN(Point p) ;
    Point getOrigine();
}
