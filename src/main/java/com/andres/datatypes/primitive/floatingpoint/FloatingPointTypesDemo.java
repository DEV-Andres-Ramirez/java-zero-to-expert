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
    private static final double EPSILON = 1e-10; // For floating-point comparisons

    /**
     * Private constructor to prevent instantiation.
     */
    private FloatingPointTypesDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates floating-point types with examples and precision issues.
     */
    public static void demonstrate() {
        logger.info("--- Floating-Point Data Types ---\n");

        // float: 32 bits, single precision
        float floatValue = 3.14159f; // 'f' suffix required
        logger.info("float - Value: {}, Size: {} bits, Precision: ~6-7 digits",
                floatValue, Float.SIZE);

        // double: 64 bits, double precision (RECOMMENDED TYPE)
        double doubleValue = 3.141592653589793;
        logger.info("double - Value: {}, Size: {} bits, Precision: ~15-16 digits",
                doubleValue, Double.SIZE);

        // Precision problem demonstration
        demonstratePrecisionIssues();

        // Special values
        demonstrateSpecialValues();

        // Proper comparison
        demonstrateProperComparison();

        System.out.println();
    }

    /**
     * Demonstrates the precision problem inherent in floating-point arithmetic.
     */
    private static void demonstratePrecisionIssues() {
        logger.info("\n--- Precision Issues ---");

        double result = 0.1 + 0.2;
        logger.info("0.1 + 0.2 = {} (expected: 0.3)", result);
        logger.warn("WARNING: Do NOT use float/double for money. Use BigDecimal.");

        // More examples
        double a = 0.1;
        double b = 0.2;
        double c = 0.3;

        logger.info("\nDirect comparison: 0.1 + 0.2 == 0.3? {}", (a + b) == c);
        logger.info("Actual values: {} vs {}", (a + b), c);
    }

    /**
     * Demonstrates special floating-point values.
     */
    private static void demonstrateSpecialValues() {
        logger.info("\n--- Special Values ---");

        logger.info("Positive Infinity: {}", Double.POSITIVE_INFINITY);
        logger.info("Negative Infinity: {}", Double.NEGATIVE_INFINITY);
        logger.info("NaN (Not a Number): {}", Double.NaN);

        // Operations resulting in special values
        logger.info("\nOperations producing special values:");
        logger.info("1.0 / 0.0 = {}", 1.0 / 0.0); // Positive Infinity
        logger.info("-1.0 / 0.0 = {}", -1.0 / 0.0); // Negative Infinity
        logger.info("0.0 / 0.0 = {}", 0.0 / 0.0); // NaN
        logger.info("Math.sqrt(-1) = {}", Math.sqrt(-1)); // NaN
    }

    /**
     * Demonstrates proper floating-point comparison using epsilon.
     * 
     * <p>
     * <strong>Why use epsilon?</strong>
     * </p>
     * <p>
     * Due to precision limitations, direct equality (==) often fails.
     * Instead, check if values are "close enough" within a tolerance (epsilon).
     * </p>
     */
    private static void demonstrateProperComparison() {
        logger.info("\n--- Proper Floating-Point Comparison ---");

        double a = 0.1 + 0.2;
        double b = 0.3;

        // Wrong way (direct comparison)
        logger.info("Wrong way - Direct comparison (a == b): {}", a == b);

        // Right way (epsilon comparison)
        boolean areEqual = Math.abs(a - b) < EPSILON;
        logger.info("Right way - Epsilon comparison: {}", areEqual);
        logger.info("Difference: {} (epsilon: {})", Math.abs(a - b), EPSILON);
    }
}
