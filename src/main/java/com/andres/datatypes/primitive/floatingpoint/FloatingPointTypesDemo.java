package com.andres.datatypes.primitive.floatingpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates floating-point primitive data types in Java.
 * 
 * <p>
 * <strong>Floating-Point Types in Java:</strong>
 * </p>
 * <ul>
 * <li><strong>float:</strong> 32 bits, single precision (~6-7 decimal
 * digits)</li>
 * <li><strong>double:</strong> 64 bits, double precision (~15-16 decimal
 * digits)</li>
 * </ul>
 * 
 * <p>
 * <strong>When to use each type:</strong>
 * </p>
 * <ul>
 * <li><strong>float:</strong> 3D graphics, massive processing where precision
 * isn't critical</li>
 * <li><strong>double:</strong> Scientific calculations, statistics, general use
 * (RECOMMENDED)</li>
 * </ul>
 * 
 * <p>
 * <strong>CRITICAL WARNING - Precision Issues:</strong>
 * </p>
 * 
 * <pre>
 * double result = 0.1 + 0.2; // result = 0.30000000000000004 (NOT 0.3)
 * </pre>
 * <p>
 * For this reason, NEVER use float/double for monetary calculations.
 * Use BigDecimal instead.
 * </p>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Scientific and engineering calculations</li>
 * <li>Statistical analysis and data science</li>
 * <li>Graphics and game development (prefer float for performance)</li>
 * <li>Physics simulations</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Prefer double over float (better precision, modern CPUs handle
 * efficiently)</li>
 * <li>NEVER use for money - use BigDecimal</li>
 * <li>Suffix 'f' or 'F' required for float literals</li>
 * <li>Be aware of precision limitations</li>
 * <li>Use comparison with epsilon for equality checks</li>
 * </ul>
 */
public final class FloatingPointTypesDemo {

    private static final Logger logger = LoggerFactory.getLogger(FloatingPointTypesDemo.class);
    private static final double EPSILON = 1e-10;  // Standard epsilon for comparison

    /**
     * Private constructor to prevent instantiation.
     */
    private FloatingPointTypesDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    // ========== Basic Operations ==========

    /**
     * Adds two double values.
     *
     * @param a First value
     * @param b Second value
     * @return Sum of a and b
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts second value from first.
     *
     * @param a First value
     * @param b Second value
     * @return Difference a - b
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two double values.
     *
     * @param a First value
     * @param b Second value
     * @return Product of a and b
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides first value by second.
     *
     * @param a Dividend
     * @param b Divisor
     * @return Quotient a / b
     */
    public static double divide(double a, double b) {
        return a / b;
    }

    // ========== Proper Floating-Point Comparison ==========

    /**
     * Compares two doubles for equality using epsilon tolerance.
     * <p>
     * <strong>Why epsilon comparison?</strong>
     * Due to floating-point precision limitations, direct == comparison often fails.
     * Use epsilon to check if values are "close enough".
     * </p>
     *
     * @param a First value
     * @param b Second value
     * @return true if |a - b| < epsilon
     */
    public static boolean areEqual(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }

    /**
     * Compares two doubles using custom epsilon.
     *
     * @param a       First value
     * @param b       Second value
     * @param epsilon Tolerance for comparison
     * @return true if |a - b| < epsilon
     */
    public static boolean areEqual(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }

    // ========== Special Values ==========

    /**
     * Checks if value is infinite (positive or negative).
     *
     * @param value Value to check
     * @return true if value is infinite
     */
    public static boolean isInfinite(double value) {
        return Double.isInfinite(value);
    }

    /**
     * Checks if value is NaN (Not a Number).
     *
     * @param value Value to check
     * @return true if value is NaN
     */
    public static boolean isNaN(double value) {
        return Double.isNaN(value);
    }

    /**
     * Divides by zero to produce Infinity.
     *
     * @param value Value to divide by zero
     * @return Positive or negative Infinity
     */
    public static double divideByZero(double value) {
        return value / 0.0;  // Returns ±Infinity
    }

    /**
     * Calculates square root of negative number (produces NaN).
     *
     * @param value Negative value
     * @return NaN (Not a Number)
     */
    public static double sqrtNegative(double value) {
        return Math.sqrt(value);  // Returns NaN for negative values
    }

    // ========== Real-World Examples ==========

    /**
     * Calculates average of values.
     *
     * @param values Values to average
     * @return Average value, or 0.0 if no values
     */
    public static double calculateAverage(double... values) {
        if (values.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    /**
     * Calculates weighted average.
     *
     * @param values  Values to average
     * @param weights Weights for each value
     * @return Weighted average
     * @throws IllegalArgumentException if arrays have different lengths
     */
    public static double calculateWeightedAverage(double[] values, double[] weights) {
        if (values.length != weights.length) {
            throw new IllegalArgumentException("Values and weights must have same length");
        }

        double weightedSum = 0.0;
        double totalWeight = 0.0;

        for (int i = 0; i < values.length; i++) {
            weightedSum += values[i] * weights[i];
            totalWeight += weights[i];
        }

        return totalWeight == 0 ? 0.0 : weightedSum / totalWeight;
    }

    /**
     * Calculates distance between two points.
     *
     * @param x1 X coordinate of first point
     * @param y1 Y coordinate of first point
     * @param x2 X coordinate of second point
     * @param y2 Y coordinate of second point
     * @return Euclidean distance
     */
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Calculates compound interest.
     *
     * @param principal   Initial amount
     * @param rate        Annual interest rate (e.g., 0.05 for 5%)
     * @param years       Number of years
     * @param timesPerYear Compounding frequency per year
     * @return Final amount after compound interest
     */
    public static double calculateCompoundInterest(double principal, double rate,
                                                   int years, int timesPerYear) {
        return principal * Math.pow(1 + rate / timesPerYear, timesPerYear * years);
    }

    // ========== Demonstrations (Educational - with logging) ==========

    /**
     * Demonstrates the precision issue inherent in floating-point arithmetic.
     * <p>
     * <strong>Educational purpose:</strong> Shows why you should NEVER use
     * float/double for monetary calculations. Use BigDecimal instead.
     * </p>
     */
    public static void demonstratePrecisionIssue() {
        logger.warn("=== FLOATING-POINT PRECISION ISSUE ===");

        double result = 0.1 + 0.2;
        logger.warn("0.1 + 0.2 = {} (expected: 0.3)", result);
        logger.warn("Result is NOT exactly 0.3 due to binary representation");

        logger.error("NEVER use float/double for money - use BigDecimal!");

        // Direct comparison fails
        double a = 0.1 + 0.2;
        double b = 0.3;
        logger.info("Direct comparison (0.1 + 0.2) == 0.3: {} (FAILS)", a == b);
        logger.info("Actual value: {}", a);
        logger.info("Expected: {}", b);
        logger.info("Difference: {}", Math.abs(a - b));

        // Epsilon comparison works
        boolean equal = areEqual(a, b);
        logger.info("\nEpsilon comparison: {} (CORRECT)", equal);
        logger.info("Using epsilon: {}", EPSILON);

        logger.warn("=======================================\n");
    }
}
