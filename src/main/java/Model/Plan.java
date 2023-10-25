package Model;

/**
 * Represents a plane defined by its origin point
 */
public class Plan {

    /**
     * initialize attribute
     */
    private Triplet origine;

    /**
     * Constructs a Plan with a default origin
     */
    public Plan() {
        this.origine = new Triplet(0.0, 0.0, 0.0);
    }

}
