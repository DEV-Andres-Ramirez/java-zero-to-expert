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

    // ========== Basic Arithmetic Operations ==========

    /**
     * Adds two integers.
     *
     * @param a First value
     * @param b Second value
     * @return Sum of a and b
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts second integer from first.
     *
     * @param a First value
     * @param b Second value
     * @return Difference a - b
     */
    public static int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     *
     * @param a First value
     * @param b Second value
     * @return Product of a and b
     */
    public static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides first integer by second (integer division).
     * <p>
     * <strong>Note:</strong> Truncates decimals. 10 / 3 = 3 (not 3.333...)
     * </p>
     *
     * @param a Dividend
     * @param b Divisor
     * @return Quotient a / b (truncated)
     */
    public static int divide(int a, int b) {
        return a / b;  // Integer division - truncates decimals
    }

    /**
     * Calculates remainder of division (modulo operation).
     *
     * @param a Dividend
     * @param b Divisor
     * @return Remainder of a / b
     */
    public static int modulo(int a, int b) {
        return a % b;
    }

    // ========== Safe Arithmetic Operations ==========

    /**
     * Safely adds two integers, throwing exception on overflow.
     *
     * @param a First value
     * @param b Second value
     * @return Sum of a and b
     * @throws ArithmeticException if result overflows
     */
    public static int safeAdd(int a, int b) {
        return Math.addExact(a, b);
    }

    /**
     * Safely subtracts integers, throwing exception on overflow.
     *
     * @param a First value
     * @param b Second value
     * @return Difference a - b
     * @throws ArithmeticException if result overflows
     */
    public static int safeSubtract(int a, int b) {
        return Math.subtractExact(a, b);
    }

    /**
     * Safely multiplies integers, throwing exception on overflow.
     *
     * @param a First value
     * @param b Second value
     * @return Product of a and b
     * @throws ArithmeticException if result overflows
     */
    public static int safeMultiply(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    /**
     * Safely adds two longs, throwing exception on overflow.
     *
     * @param a First value
     * @param b Second value
     * @return Sum of a and b
     * @throws ArithmeticException if result overflows
     */
    public static long safeAddLong(long a, long b) {
        return Math.addExact(a, b);
    }

    // ========== Range Validation ==========

    /**
     * Checks if integer value is within byte range.
     *
     * @param value Value to check
     * @return true if value fits in byte (-128 to 127)
     */
    public static boolean isInByteRange(int value) {
        return value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE;
    }

    /**
     * Checks if integer value is within short range.
     *
     * @param value Value to check
     * @return true if value fits in short (-32768 to 32767)
     */
    public static boolean isInShortRange(int value) {
        return value >= Short.MIN_VALUE && value <= Short.MAX_VALUE;
    }

    /**
     * Checks if long value is within int range.
     *
     * @param value Value to check
     * @return true if value fits in int
     */
    public static boolean isInIntRange(long value) {
        return value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE;
    }

    // ========== Real-World Examples ==========

    /**
     * Checks if number is even.
     *
     * @param value Number to check
     * @return true if value is even
     */
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    /**
     * Checks if number is odd.
     *
     * @param value Number to check
     * @return true if value is odd
     */
    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    /**
     * Calculates absolute value.
     *
     * @param value Value to get absolute value of
     * @return Absolute value (always positive)
     */
    public static int absolute(int value) {
        return Math.abs(value);
    }

    /**
     * Finds maximum of two integers.
     *
     * @param a First value
     * @param b Second value
     * @return Larger of a and b
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * Finds minimum of two integers.
     *
     * @param a First value
     * @param b Second value
     * @return Smaller of a and b
     */
    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    /**
     * Calculates number of days between two timestamps.
     *
     * @param timestampMillis1 First timestamp in milliseconds
     * @param timestampMillis2 Second timestamp in milliseconds
     * @return Number of days between timestamps
     */
    public static long daysBetween(long timestampMillis1, long timestampMillis2) {
        long diffMillis = Math.abs(timestampMillis1 - timestampMillis2);
        return diffMillis / (1000 * 60 * 60 * 24);  // Convert millis to days
    }

    /**
     * Calculates factorial iteratively.
     *
     * @param n Number to calculate factorial of (must be >= 0)
     * @return Factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial undefined for negative numbers");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Calculates power (base^exponent) iteratively.
     *
     * @param base     Base number
     * @param exponent Exponent (must be >= 0)
     * @return base raised to exponent
     * @throws IllegalArgumentException if exponent is negative
     */
    public static long power(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative");
        }

        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    // ========== Demonstrations (Educational - with logging) ==========

    /**
     * Demonstrates integer overflow behavior.
     * <p>
     * <strong>Educational purpose:</strong> Shows that integer overflow
     * does NOT throw exceptions - value wraps around silently.
     * Use Math.addExact() to detect overflow.
     * </p>
     */
    public static void demonstrateOverflow() {
        logger.warn("=== INTEGER OVERFLOW ISSUE ===");

        int maxInt = Integer.MAX_VALUE;
        logger.warn("Maximum int value: {}", maxInt);
        logger.warn("Max + 1 = {} (wrapped to MIN_VALUE)", maxInt + 1);
        logger.error("Overflow occurred silently - NO exception thrown!");

        logger.info("\nSafe alternative using Math.addExact():");
        try {
            int result = Math.addExact(maxInt, 1);
            logger.info("Result: {}", result);
        } catch (ArithmeticException e) {
            logger.info("✓ Overflow detected and prevented: {}", e.getMessage());
        }

        logger.warn("==============================\n");
    }
}
