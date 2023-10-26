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
    public Point getOrigine() {
        return origine;
    }

    @Override
    public double getRayon() {
        return 0;
    }
}
