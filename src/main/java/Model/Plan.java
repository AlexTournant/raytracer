package Model;

public class Plan implements IObjetScene {
    private Point origine;

    private Vector normal;

    public Plan(Point origine,Vector normal) {
        this.origine=origine;
        this.normal=normal.normalize();
    }

    public void setOrigine(Point origine) {
        this.origine = origine;
    }

    public Vector getNormal() {
        return normal;
    }

    public void setNormal(Vector normal) {
        this.normal = normal;
    }
    @Override
    public Vector getN(Point p){
        return new Vector(p.subtract(getOrigine()).normalize().getTriplet());
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
        if (d.scalarProduct(getN(lookFrom)) != 0) {
            t = ((getOrigine().subtract(lookFrom)).scalarProduct(getN(lookFrom))) / d.scalarProduct(getN(lookFrom));
            return new Point(d.scalarMultiply(t).add(lookFrom).getTriplet()).getTriplet().length();
        }
        return -1;
    }
}
