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

    /**
     * Demonstrates type casting with examples.
     */
    public static void demonstrate() {
        logger.info("--- Type Casting (Conversion) ---\n");

        // Widening (automatic)
        demonstrateWideningCast();

        // Narrowing (explicit)
        demonstrateNarrowingCast();

        // Overflow examples
        demonstrateOverflow();

        // Integer division pitfall
        demonstrateIntegerDivisionPitfall();

        System.out.println();
    }

    /**
     * Demonstrates widening (implicit) casting.
     * 
     * <p>
     * <strong>Widening Casting:</strong> Automatic conversion from smaller
     * to larger type. No data loss occurs.
     * </p>
     */
    private static void demonstrateWideningCast() {
        logger.info("--- Widening Casting (Implicit) ---");

        byte byteNum = 100;
        int intNum = byteNum; // Automatic: byte → int
        long longNum = intNum; // Automatic: int → long
        float floatNum = longNum; // Automatic: long → float
        double doubleNum = floatNum; // Automatic: float → double

        logger.info("byte {} → int {} → long {} → float {} → double {}",
                byteNum, intNum, longNum, floatNum, doubleNum);

        // No data loss in widening
        logger.info("No data loss in widening conversions");
    }

    /**
     * Demonstrates narrowing (explicit) casting.
     * 
     * <p>
     * <strong>Narrowing Casting:</strong> Manual conversion from larger
     * to smaller type. May lose precision or cause overflow.
     * </p>
     */
    private static void demonstrateNarrowingCast() {
        logger.info("\n--- Narrowing Casting (Explicit) ---");

        double largeDouble = 9.78;
        int convertedInt = (int) largeDouble; // Loses decimal part

        logger.info("double {} → int {} (decimals lost)", largeDouble, convertedInt);

        // Float to int
        float floatValue = 123.456f;
        int intValue = (int) floatValue;
        logger.info("float {} → int {} (truncation, not rounding)", floatValue, intValue);

        // Long to int (safe example)
        long longValue = 1000L;
        int safeInt = (int) longValue;
        logger.info("long {} → int {} (safe, within range)", longValue, safeInt);
    }

    /**
     * Demonstrates overflow in narrowing conversions.
     * 
     * <p>
     * <strong>Warning:</strong> Narrowing to a type that cannot hold
     * the value results in overflow (wraparound behavior).
     * </p>
     */
    private static void demonstrateOverflow() {
        logger.info("\n--- Overflow in Narrowing ---");

        int largeInt = 130;
        byte convertedByte = (byte) largeInt; // Overflow!

        logger.info("int {} → byte {} (overflow occurred)", largeInt, convertedByte);
        logger.warn("WARNING: Value exceeded byte range ({} to {})",
                Byte.MIN_VALUE, Byte.MAX_VALUE);
        logger.warn("Result wrapped around to {}", convertedByte);

        // Safe alternative: validate range first
        logger.info("\nSafe approach - validate before casting:");
        int valueToConvert = 100;
        if (valueToConvert >= Byte.MIN_VALUE && valueToConvert <= Byte.MAX_VALUE) {
            byte safeByte = (byte) valueToConvert;
            logger.info("Safe conversion: {} → byte {}", valueToConvert, safeByte);
        } else {
            logger.error("Value {} out of byte range, conversion not safe", valueToConvert);
        }

        // Using Math.toIntExact for safe long-to-int
        try {
            long hugeLong = 3_000_000_000L;
            int result = Math.toIntExact(hugeLong); // Throws exception if overflow
            logger.info("Safe conversion: {}", result);
        } catch (ArithmeticException e) {
            logger.error("Math.toIntExact() prevented overflow: {}", e.getMessage());
        }
    }

    /**
     * Demonstrates common integer division pitfall with casting.
     * 
     * <p>
     * <strong>Pitfall:</strong> Casting result of integer division doesn't
     * recover lost precision. Cast operands BEFORE division.
     * </p>
     */
    private static void demonstrateIntegerDivisionPitfall() {
        logger.info("\n--- Integer Division Pitfall ---");

        int a = 5;
        int b = 2;

        // Wrong: casting after division (precision already lost)
        double wrong = (double) (a / b); // a / b = 2 (int), then cast to 2.0
        logger.info("Wrong: (double)(a / b) = {} (precision lost)", wrong);

        // Right: cast before division
        double right = (double) a / b; // a cast to double, then division
        logger.info("Right: (double)a / b = {} (precision preserved)", right);

        // Alternative: use double literals
        double alternative = 5.0 / 2;
        logger.info("Alternative: 5.0 / 2 = {}", alternative);
    }
}
