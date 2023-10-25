package Model;

public class Intersection {

    private Sphere sphere;

    public double intersection(Point lookFrom, Vector d) {
        double a = 1;
        double b = ((lookFrom.subtract(sphere.getOrigine())).multiply(2)).getTriplet().scalarProduct(d.getTriplet());
        double c = lookFrom.subtract(sphere.getOrigine()).getTriplet().scalarProduct(lookFrom.subtract(sphere.getOrigine()).getTriplet());

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
