package Model;

/**
 * Represents a triangle using three vector, points A, B, and C
 */
public class Triangle {

    /**
     * Initilaize attributes
     */
    private Point a, b, c;


    /**
     * Constructs a Triangle using specified vector
     *
     * @param a Vector A of the triangle
     * @param b Vector B of the triangle
     * @param c Vector C of the triangle
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Get the vector A of the triangle
     *
     * @return Vector A
     */
    public Point getA() {
        return a;
    }

    /**
     * Set the vector A of the triangle
     *
     * @param a The new vector A
     */
    public void setA(Point a) {
        this.a = a;
    }

    /**
     * Get the vector B of the triangle
     *
     * @return Vector B
     */
    public Point getB() {
        return b;
    }

    /**
     * Set the vector B of the triangle
     *
     * @param b The new vector B
     */
    public void setB(Point b) {
        this.b = b;
    }

    /**
     * Get the vector C of the triangle
     *
     * @return Vector C
     */
    public Point getC() {
        return c;
    }

    /**
     * Set the vector C of the triangle
     *
     * @param c The new vector   C
     */
    public void setC(Point c) {
        this.c = c;
    }

    /**
     * Calculate the distance between vectors A and B
     *
     * @return The distance between A and B
     */
    public double getDistanceAB() {
        return Math.sqrt(   Math.pow(((getB().getTriplet().getX()) - getA().getTriplet().getX()), 2)) +
                            Math.pow(((getB().getTriplet().getY() - getA().getTriplet().getY())), 2) +
                            Math.pow(((getB().getTriplet().getZ() - getA().getTriplet().getZ())), 2);
    }

    /**
     * Calculate the distance between vectors A and C
     *
     * @return The distance between A and C
     */
    public double getDistanceAC() {
        return Math.sqrt(   Math.pow(((getC().getTriplet().getX() - getA().getTriplet().getX())), 2) +
                            Math.pow(((getC().getTriplet().getY() - getA().getTriplet().getY())), 2) +
                            Math.pow(((getC().getTriplet().getZ() - getA().getTriplet().getZ())), 2));
    }

    /**
     * Calculate the distance between vectors B and C
     *
     * @return The distance between B and C
     */
    public double getDistanceBC() {
        return Math.sqrt(   Math.pow(((getC().getTriplet().getX() - getB().getTriplet().getX())), 2) +
                            Math.pow(((getC().getTriplet().getY() - getB().getTriplet().getY())), 2) +
                            Math.pow(((getC().getTriplet().getZ() - getB().triplet.getZ())), 2));
    }
}
