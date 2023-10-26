package Model;

public class Intersection {

    private IObjetScene ios;

    public double intersection(Point lookFrom, Vector d) {
        double a = 1;
        double b = ((lookFrom.subtract(ios.getOrigine())).scalarProduct(d))*2;
        double c = (lookFrom.subtract(ios.getOrigine()).scalarProduct(lookFrom.subtract(ios.getOrigine())))-Math.pow(ios.getRayon(),2);
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

    public IObjetScene getIos() {
        return ios;
    }

    public void setIos(IObjetScene ios) {
        this.ios = ios;
    }
}
