package com.andres.datatypes.primitive.casting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates type casting (conversion) between primitive types in Java.
 * 
 * <p>
 * <strong>Types of Casting:</strong>
 * </p>
 * <ul>
 * <li><strong>Widening (Implicit/Automatic):</strong> From smaller to larger
 * precision
 * (byte → short → int → long → float → double). No data loss, Java does it
 * automatically.</li>
 * <li><strong>Narrowing (Explicit/Manual):</strong> From larger to smaller
 * precision
 * (double → float → long → int → short → byte). May lose data, requires
 * explicit cast.</li>
 * </ul>
 * 
 * <p>
 * <strong>Casting Hierarchy:</strong>
 * </p>
 * 
 * <pre>
 * byte (8) → short (16) → int (32) → long (64) → float (32) → double (64)
 *         ↖  char (16)  ↗
 * </pre>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Type compatibility in method calls and assignments</li>
 * <li>Precision adjustment for calculations</li>
 * <li>Data serialization and deserialization</li>
 * <li>API compatibility (legacy systems)</li>
 * </ul>
 * 
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Overflow in narrowing conversions</li>
 * <li>Precision loss when converting to smaller types</li>
 * <li>Unexpected results with integer division before casting</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Avoid narrowing casts when possible</li>
 * <li>Validate ranges before narrowing conversion</li>
 * <li>Document why casting is necessary</li>
 * <li>Consider wrapper class conversion methods (Integer.parseInt(), etc.)</li>
 * <li>Use Math.toIntExact() for safe long-to-int conversion</li>
 * </ul>
 */
public final class TypeCastingDemo {

    private static final Logger logger = LoggerFactory.getLogger(TypeCastingDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private TypeCastingDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    // ========== Widening Casting (Automatic) ==========

    /**
     * Widens byte to int (automatic, no data loss).
     *
     * @param value Byte value
     * @return Value as int
     */
    public static int byteToInt(byte value) {
        return value;  // Automatic widening: byte → int
    }

    /**
     * Widens int to long (automatic, no data loss).
     *
     * @param value Int value
     * @return Value as long
     */
    public static long intToLong(int value) {
        return value;  // Automatic widening: int → long
    }

    /**
     * Widens long to double (automatic, no data loss).
     *
     * @param value Long value
     * @return Value as double
     */
    public static double longToDouble(long value) {
        return value;  // Automatic widening: long → double
    }

    // ========== Narrowing Casting (Explicit) ==========

    /**
     * Narrows double to int (explicit, loses decimal part).
     * <p>
     * <strong>Warning:</strong> Truncates decimals, does not round.
     * </p>
     *
     * @param value Double value
     * @return Value as int (decimals truncated)
     */
    public static int doubleToInt(double value) {
        return (int) value;  // Explicit narrowing: truncates decimals
    }

    /**
     * Narrows float to int (explicit, loses decimal part).
     *
     * @param value Float value
     * @return Value as int (decimals truncated)
     */
    public static int floatToInt(float value) {
        return (int) value;  // Explicit narrowing
    }

    /**
     * Narrows int to byte (explicit, may overflow).
     * <p>
     * <strong>Warning:</strong> If value exceeds byte range (-128 to 127),
     * overflow occurs (wraparound behavior).
     * </p>
     *
     * @param value Int value
     * @return Value as byte (may overflow)
     */
    public static byte intToByte(int value) {
        return (byte) value;  // May overflow if value > 127 or < -128
    }

    // ========== Safe Casting with Validation ==========

    /**
     * Safely converts int to byte with range validation.
     * <p>
     * Throws exception if value is out of byte range to prevent silent overflow.
     * </p>
     *
     * @param value Int value to convert
     * @return Value as byte
     * @throws IllegalArgumentException if value is out of byte range
     */
    public static byte safeIntToByte(int value) {
        if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
            throw new IllegalArgumentException(
                    "Value " + value + " out of byte range [" +
                            Byte.MIN_VALUE + ", " + Byte.MAX_VALUE + "]"
            );
        }
        return (byte) value;
    }

    /**
     * Safely converts int to short with range validation.
     *
     * @param value Int value to convert
     * @return Value as short
     * @throws IllegalArgumentException if value is out of short range
     */
    public static short safeIntToShort(int value) {
        if (value < Short.MIN_VALUE || value > Short.MAX_VALUE) {
            throw new IllegalArgumentException(
                    "Value " + value + " out of short range [" +
                            Short.MIN_VALUE + ", " + Short.MAX_VALUE + "]"
            );
        }
        return (short) value;
    }

    /**
     * Safely converts long to int using Math.toIntExact().
     * <p>
     * Throws ArithmeticException on overflow instead of silently wrapping.
     * </p>
     *
     * @param value Long value to convert
     * @return Value as int
     * @throws ArithmeticException if value overflows int range
     */
    public static int safeLongToInt(long value) {
        return Math.toIntExact(value);  // Throws exception on overflow
    }

    // ========== Real-World Examples ==========

    /**
     * Converts temperature from Celsius to Fahrenheit.
     *
     * @param celsius Temperature in Celsius
     * @return Temperature in Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    /**
     * Calculates percentage as double from integer values.
     *
     * @param part  Partial value
     * @param total Total value
     * @return Percentage (0-100)
     */
    public static double calculatePercentage(int part, int total) {
        if (total == 0) return 0.0;
        return ((double) part / total) * 100.0;  // Cast before division
    }

    // ========== Demonstrations (Educational - with logging) ==========

    /**
     * Demonstrates overflow behavior in narrowing conversions.
     * <p>
     * <strong>Educational purpose:</strong> Shows what happens when narrowing
     * to a type that cannot hold the value (wraparound behavior).
     * </p>
     */
    public static void demonstrateOverflow() {
        logger.warn("=== OVERFLOW DEMONSTRATION ===");

        int largeInt = 130;
        byte convertedByte = (byte) largeInt;

        logger.warn("int {} → byte {} (overflow occurred)", largeInt, convertedByte);
        logger.warn("Byte range: {} to {}", Byte.MIN_VALUE, Byte.MAX_VALUE);
        logger.warn("Value 130 wrapped around to {}", convertedByte);

        logger.info("\nSafe alternative using validation:");
        int valueToConvert = 100;
        if (valueToConvert >= Byte.MIN_VALUE && valueToConvert <= Byte.MAX_VALUE) {
            byte safeByte = (byte) valueToConvert;
            logger.info("✓ Safe: {} → byte {}", valueToConvert, safeByte);
        }

        logger.info("\nSafe alternative using Math.toIntExact():");
        try {
            long hugeLong = 3_000_000_000L;
            int result = Math.toIntExact(hugeLong);
            logger.info("Result: {}", result);
        } catch (ArithmeticException e) {
            logger.error("✓ Overflow detected and prevented: {}", e.getMessage());
        }

        logger.warn("===========================\n");
    }

    /**
     * Demonstrates integer division pitfall with casting.
     * <p>
     * <strong>Educational purpose:</strong> Shows that casting AFTER division
     * doesn't recover lost precision. Cast operands BEFORE division.
     * </p>
     */
    public static void demonstrateIntegerDivisionPitfall() {
        logger.warn("=== INTEGER DIVISION PITFALL ===");

        int a = 5;
        int b = 2;

        // Wrong: cast after division (precision already lost)
        double wrong = (double) (a / b);  // a/b = 2 (int), then cast to 2.0
        logger.warn("❌ Wrong: (double)(5 / 2) = {} (precision lost)", wrong);

        // Right: cast before division
        double right = (double) a / b;  // a cast to double, then division
        logger.info("✓ Right: (double)5 / 2 = {} (precision preserved)", right);

        // Alternative: use double literals
        double alternative = 5.0 / 2;
        logger.info("✓ Alternative: 5.0 / 2 = {}", alternative);

        logger.warn("================================\n");
    }
}
