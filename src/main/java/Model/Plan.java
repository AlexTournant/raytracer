package Model;

public class Plan implements IObjetScene{
    private Point origine;

    private Vector normal;

    public Plan(Point origine, Vector normal) {
        this.origine=origine;
        this.normal=normal.normalize();
    }

    public void setOrigine(Point origine) {
        this.origine = origine;
    }

    public void setNormal(Vector normal) {
        this.normal = normal;
    }
    @Override
    public Point getOrigine() {
        return origine;
    }

    public double getRayon() {
        return 0;
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
