package com.andres.datatypes.primitive.integers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates integer primitive data types in Java.
 * 
 * <p>
 * <strong>Integer Types in Java:</strong>
 * </p>
 * <ul>
 * <li><strong>byte:</strong> 8 bits, range: -128 to 127</li>
 * <li><strong>short:</strong> 16 bits, range: -32,768 to 32,767</li>
 * <li><strong>int:</strong> 32 bits, range: -2^31 to 2^31-1 (~2 billion)</li>
 * <li><strong>long:</strong> 64 bits, range: -2^63 to 2^63-1</li>
 * </ul>
 * 
 * <p>
 * <strong>When to use each integer type:</strong>
 * </p>
 * <ul>
 * <li><strong>byte:</strong> Memory savings in large arrays, binary I/O
 * operations</li>
 * <li><strong>short:</strong> Rarely used in modern practice (prefer int)</li>
 * <li><strong>int:</strong> Default type for integers (98% of use cases)</li>
 * <li><strong>long:</strong> Timestamps, unique IDs, very large numbers</li>
 * </ul>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Counters, indices, and loop variables (int)</li>
 * <li>Mathematical calculations and numeric operations</li>
 * <li>Database primary keys and foreign keys (long)</li>
 * <li>File size calculations and memory operations (long)</li>
 * <li>Binary data processing (byte)</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use int for general-purpose integer values</li>
 * <li>Use long only when int is insufficient</li>
 * <li>Use byte for I/O and large arrays (memory optimization)</li>
 * <li>Suffix 'L' required for long literals (prefer uppercase for clarity)</li>
 * <li>Use underscores for readability: 1_000_000 instead of 1000000</li>
 * </ul>
 */
public final class IntegerTypesDemo {

    private static final Logger logger = LoggerFactory.getLogger(IntegerTypesDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private IntegerTypesDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates all integer types with examples and metadata.
     */
    public static void demonstrate() {
        logger.info("--- Integer Data Types ---\n");

        // byte: 8 bits
        byte byteValue = 127; // Maximum value
        logger.info("byte - Value: {}, Size: {} bits, Range: {} to {}",
                byteValue, Byte.SIZE, Byte.MIN_VALUE, Byte.MAX_VALUE);

        // short: 16 bits
        short shortValue = 32_000;
        logger.info("short - Value: {}, Size: {} bits, Range: {} to {}",
                shortValue, Short.SIZE, Short.MIN_VALUE, Short.MAX_VALUE);

        // int: 32 bits (MOST COMMON)
        int intValue = 2_147_483_647; // Using underscores for readability (Java 7+)
        logger.info("int - Value: {}, Size: {} bits, Range: {} to {}",
                intValue, Integer.SIZE, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // long: 64 bits
        long longValue = 9_223_372_036_854_775_807L; // 'L' suffix required
        logger.info("long - Value: {}, Size: {} bits, Range: {} to {}",
                longValue, Long.SIZE, Long.MIN_VALUE, Long.MAX_VALUE);

        // Practical example: Timestamp
        long currentTimestamp = System.currentTimeMillis();
        logger.info("\nPractical Example - Current timestamp: {} (requires long)", currentTimestamp);

        // Arithmetic operations
        demonstrateArithmetic();

        // Overflow demonstration
        demonstrateOverflow();

        System.out.println();
    }

    /**
     * Demonstrates basic arithmetic operations with integers.
     */
    private static void demonstrateArithmetic() {
        logger.info("\n--- Arithmetic Operations ---");

        int a = 10;
        int b = 3;

        logger.info("a = {}, b = {}", a, b);
        logger.info("Addition (a + b): {}", a + b);
        logger.info("Subtraction (a - b): {}", a - b);
        logger.info("Multiplication (a * b): {}", a * b);
        logger.info("Division (a / b): {} (integer division, truncates decimals)", a / b);
        logger.info("Modulo (a % b): {}", a % b);
    }

    /**
     * Demonstrates integer overflow behavior.
     * 
     * <p>
     * <strong>Warning:</strong> Integer overflow does not throw exceptions
     * in Java. The value wraps around to the minimum value.
     * </p>
     */
    private static void demonstrateOverflow() {
        logger.info("\n--- Integer Overflow Example ---");

        int maxInt = Integer.MAX_VALUE;
        logger.info("Maximum int value: {}", maxInt);
        logger.info("Max + 1 (overflow): {}", maxInt + 1);
        logger.warn("WARNING: Overflow occurred! Value wrapped to Integer.MIN_VALUE");

        // Safe alternative: use Math.addExact() which throws exception on overflow
        try {
            int result = Math.addExact(maxInt, 1);
            logger.info("Result: {}", result);
        } catch (ArithmeticException e) {
            logger.error("Overflow detected with Math.addExact(): {}", e.getMessage());
        }
    }
}
