package Model;

/**
 * Represents a triangle object in the 3D scene.
 */
public class Triangle implements IObjetScene {
    /**
     * The origin point of the triangle.
     */
    private Point origine;

    /**
     * The second point of the triangle.
     */
    private Point b;

    /**
     * The third point of the triangle.
     */
    private Point c;

    /**
     * Creates a new Triangle object with three specified points.
     *
     * @param a The origin point of the triangle.
     * @param b The second point of the triangle.
     * @param c The third point of the triangle.
     */
    public Triangle(Point a, Point b, Point c) {
        this.origine = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Gets the second point of the triangle.
     *
     * @return The second point of the triangle.
     */
    public Point getB() {
        return b;
    }

    /**
     * Sets the second point of the triangle.
     *
     * @param b The new second point for the triangle.
     */
    public void setB(Point b) {
        this.b = b;
    }

    /**
     * Gets the third point of the triangle.
     *
     * @return The third point of the triangle.
     */
    public Point getC() {
        return c;
    }

    /**
     * Sets the third point of the triangle.
     *
     * @param c The new third point for the triangle.
     */
    public void setC(Point c) {
        this.c = c;
    }

    /**
     * Calculates the distance between the origin and the second point (AB).
     *
     * @return The distance between the origin and the second point.
     */
    public double getDistanceAB() {
        return Math.sqrt(   Math.pow(((getB().getTriplet().getX()) - getOrigine().getTriplet().getX()), 2)) +
                            Math.pow(((getB().getTriplet().getY() - getOrigine().getTriplet().getY())), 2) +
                            Math.pow(((getB().getTriplet().getZ() - getOrigine().getTriplet().getZ())), 2);
    }

    /**
     * Calculates the distance between the origin and the third point (AC).
     *
     * @return The distance between the origin and the third point.
     */
    public double getDistanceAC() {
        return Math.sqrt(   Math.pow(((getC().getTriplet().getX() - getOrigine().getTriplet().getX())), 2) +
                            Math.pow(((getC().getTriplet().getY() - getOrigine().getTriplet().getY())), 2) +
                            Math.pow(((getC().getTriplet().getZ() - getOrigine().getTriplet().getZ())), 2));
    }

    /**
     * Calculates the distance between the second and third points (BC).
     *
     * @return The distance between the second and third points.
     */
    public double getDistanceBC() {
        return Math.sqrt(   Math.pow(((getC().getTriplet().getX() - getB().getTriplet().getX())), 2) +
                            Math.pow(((getC().getTriplet().getY() - getB().getTriplet().getY())), 2) +
                            Math.pow(((getC().getTriplet().getZ() - getB().getTriplet().getZ())), 2));
    }

    /**
     * Gets the origin point of the triangle.
     *
     * @return The origin point of the triangle.
     */
    @Override
    public Point getOrigine() {
        return origine;
    }

    /**
     * Gets the radius of the triangle (not used for triangles).
     *
     * @return The radius of the triangle (always 0 for triangles).
     */
    public double getRayon() {
        return 0;
    }

    /**
     * Computes the normal vector for the triangle.
     *
     * @param p The point on the triangle's surface (not used in the computation).
     * @return The normalized normal vector for the triangle, which is the cross product
     * of vectors AB and AC.
     */
    @Override
    public Vector getN(Point p){
        return new Vector(getB().subtract(getOrigine()).multiplyVectorial(getC().subtract(getOrigine())).normalize().getTriplet());
    }

    /**
     * Calculates the intersection of a ray with the triangle.
     *
     * @param lookFrom The starting point of the ray.
     * @param d The direction vector of the ray.
     * @return The distance along the ray to the intersection point, or -1 if no intersection occurs.
     */
    @Override
    public double intersection(Point lookFrom, Vector d) {
        Vector n = this.getB().subtract(getOrigine()).multiplyVectorial(this.getC().subtract(this.getOrigine()));
        Plan q=new Plan(getOrigine(),n);
        double t = q.intersection(lookFrom,d);
        Point p=d.scalarMultiply(t).add(lookFrom);
        if((b.subtract(origine).multiplyVectorial(p.subtract(origine))).scalarProduct(n)<0){
            return -1;
        } else if ((c.subtract(b).multiplyVectorial(p.subtract(b))).scalarProduct(n)<0) {
            return -1;
        } else if ((origine.subtract(c).multiplyVectorial(p.subtract(c))).scalarProduct(n)<0) {
            return -1;
        }
        return t;
    }
}
