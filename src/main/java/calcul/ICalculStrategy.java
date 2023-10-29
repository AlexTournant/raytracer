package calcul;

/**
 * The ICalculStrategy interface defines a method for performing ray tracing calculations.
 */
public interface ICalculStrategy {
    /**
     * Performs the ray tracing calculations. Implementing classes should define the specific
     * ray tracing logic within this method.
     *
     * @throws RuntimeException if an error occurs during the ray tracing process.
     */
    void rayTracing() throws Exception;
}
