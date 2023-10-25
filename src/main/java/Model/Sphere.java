package Model;

public class Sphere implements IObjetScene{

    private Point origine;
    private double ray;

    public Sphere(Point origine, double ray) {
        this.origine = origine;
        this.ray = ray;
    }

    public Point getOrigine() {
        return origine;
    }

    public void setOrigine(Point origine) {
        this.origine = origine;
    }

    public double getRay() {
        return ray;
    }

    public void setRay(double ray) {
        this.ray = ray;
    }

    public double getDiameter() {
        return this.getRay() * 2;
    }

    public double getCircumference() {
        return 2 * Math.PI * this.getRay();
    }

    public double getVolume() {
        return (double) 4 / 3 * Math.PI * Math.pow(this.getRay(), 3);
    }


    public double intersection(Point lookFrom, Vector d) {
        double a = 1;
        double b = ((lookFrom.subtract(this.getOrigine())).multiply(2)).getTriplet().scalarProduct(d.getTriplet());
        double c = lookFrom.subtract(this.getOrigine()).getTriplet().scalarProduct(lookFrom.subtract(this.getOrigine()).getTriplet());

        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta < 0) {
            return -1;
        } else if (delta == 0) {
            double alpha = -b / 2 * a;
            if (alpha < 0) {
                return -1;
            } else {
                return alpha;
            }
        } else {
            double t1 = (-b + Math.sqrt(delta)) / 2 * a;
            double t2 = (-b - Math.sqrt(delta)) / 2 * a;
            if (t2 > 0) {
                return t2;
            } else if (t1 > 0) {
                return t1;
            } else {
                return -1;
            }
        }


    }




}
