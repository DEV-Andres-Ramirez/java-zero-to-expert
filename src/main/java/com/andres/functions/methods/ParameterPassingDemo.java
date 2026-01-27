package com.andres.functions.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates parameter passing mechanisms in Java.
 *
 * <p>
 * <strong>Java's Parameter Passing: Pass-by-Value</strong>
 * </p>
 * <p>
 * Java is <strong>strictly pass-by-value</strong>. This means a copy of the
 * value
 * is passed to the method. However, this behaves differently for primitives vs
 * object references:
 * </p>
 * <ul>
 * <li><strong>Primitives:</strong> Copy of the actual value is passed
 * (modifications don't affect original)</li>
 * <li><strong>Objects:</strong> Copy of the reference is passed (both refer to
 * same object, so modifications DO affect original)</li>
 * </ul>
 *
 * <p>
 * <strong>When to Use Different Parameter Types:</strong>
 * </p>
 * <ul>
 * <li>Primitives: When passing simple values (numbers, booleans) that won't be
 * modified</li>
 * <li>Immutable objects (String, Integer): Safe from unintended
 * modifications</li>
 * <li>Mutable objects (arrays, collections): When you want method to modify the
 * object</li>
 * <li>Multiple parameters: Breaking down complex operations into clear
 * inputs</li>
 * </ul>
 *
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Too many parameters (more than 3-5 suggests need for parameter
 * object)</li>
 * <li>Passing mutable objects when immutability is desired</li>
 * <li>Using object parameters for simple primitive operations</li>
 * </ul>
 *
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Data processing: transforming inputs to outputs</li>
 * <li>Calculations: passing values to compute results</li>
 * <li>Collection manipulation: modifying arrays or lists in place</li>
 * <li>Configuration: passing settings to methods</li>
 * </ul>
 *
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Limit parameters to 3-5 for readability</li>
 * <li>Use descriptive parameter names</li>
 * <li>Document whether method modifies parameters</li>
 * <li>Prefer immutable parameters when possible</li>
 * <li>Consider parameter objects for many related parameters</li>
 * <li>Validate parameters at method entry (guard clauses)</li>
 * </ul>
 *
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Expecting primitive modifications to persist (they won't)</li>
 * <li>Confusion about "pass by reference" - Java doesn't have this</li>
 * <li>Unintended mutations of mutable object parameters</li>
 * <li>Modifying String parameters (creates new objects, doesn't modify
 * original)</li>
 * <li>Not documenting side effects on mutable parameters</li>
 * </ul>
 *
 * @author Andrés
 * @version 1.0
 */
public final class ParameterPassingDemo {

    private static final Logger logger = LoggerFactory.getLogger(ParameterPassingDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private ParameterPassingDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates parameter passing mechanisms and behavior.
     */
    public static void demonstrate() {
        logger.info("--- Parameter Passing ---\n");

        demonstratePrimitiveParameters();
        demonstrateObjectReferenceParameters();
        demonstrateStringImmutability();
        demonstrateMultipleParameters();
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates pass-by-value for primitive types.
     */
    private static void demonstratePrimitiveParameters() {
        logger.info("--- Primitive Parameters (Pass-by-Value) ---");

        // Original values
        int number = 10;
        double decimal = 5.5;
        boolean flag = true;

        logger.info("Before method calls:");
        logger.info("  number = {}", number);
        logger.info("  decimal = {}", decimal);
        logger.info("  flag = {}", flag);

        // Call methods that attempt to modify
        modifyPrimitive(number);
        modifyDouble(decimal);
        modifyBoolean(flag);

        logger.info("\nAfter method calls:");
        logger.info("  number = {} (unchanged)", number);
        logger.info("  decimal = {} (unchanged)", decimal);
        logger.info("  flag = {} (unchanged)", flag);

        logger.info("\nConclusion: Primitive modifications inside methods don't affect originals");
    }

    /**
     * Demonstrates pass-by-value for object references.
     */
    private static void demonstrateObjectReferenceParameters() {
        logger.info("\n--- Object Reference Parameters ---");

        // Mutable object: array
        int[] numbers = { 1, 2, 3, 4, 5 };

        logger.info("Original array: {}", arrayToString(numbers));

        // Method modifies array contents
        multiplyArrayElements(numbers, 2);

        logger.info("After multiplyArrayElements(numbers, 2): {}", arrayToString(numbers));
        logger.info("Result: Array WAS modified (reference points to same object)");

        // StringBuilder (mutable)
        StringBuilder text = new StringBuilder("Hello");
        logger.info("\nOriginal StringBuilder: \"{}\"", text);

        appendToStringBuilder(text, " World");

        logger.info("After appendToStringBuilder: \"{}\"", text);
        logger.info("Result: StringBuilder WAS modified");
    }

    /**
     * Demonstrates String immutability with parameters.
     */
    private static void demonstrateStringImmutability() {
        logger.info("\n--- String Immutability ---");

        String text = "Original";
        logger.info("Original String: \"{}\"", text);

        // String methods create new objects, don't modify original
        attemptToModifyString(text);

        logger.info("After attemptToModifyString: \"{}\" (unchanged)", text);
        logger.info("Reason: Strings are immutable - modifications create new objects");
    }

    /**
     * Demonstrates methods with multiple parameters.
     */
    private static void demonstrateMultipleParameters() {
        logger.info("\n--- Multiple Parameters ---");

        logger.info("Example: Method with 2 parameters");
        int result1 = add(5, 3);
        logger.info("add(5, 3) = {}", result1);

        logger.info("\nExample: Method with 3 parameters");
        double result2 = calculateTotalPrice(100.0, 0.15, 2);
        logger.info("calculateTotalPrice(100.0, 0.15, 2) = ${}", String.format("%.2f", result2));

        logger.info("\nExample: Method with 4 parameters");
        String fullInfo = buildPersonInfo("John", "Doe", 30, "Engineer");
        logger.info("buildPersonInfo(...) = {}", fullInfo);

        logger.info("\nNote: More than 3-5 parameters suggests need for parameter object");
    }

    /**
     * Demonstrates real-world parameter passing scenarios.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Processing array in-place
        logger.info("Example 1: Normalize array values");
        int[] scores = { 85, 90, 78, 92, 88 };
        logger.info("Original scores: {}", arrayToString(scores));
        normalizeScores(scores, 10);
        logger.info("After adding 10 bonus points: {}", arrayToString(scores));

        // Example 2: Calculation with multiple inputs
        logger.info("\nExample 2: Calculate discount");
        double originalPrice = 150.0;
        double discountPercent = 20.0;
        double finalPrice = applyDiscount(originalPrice, discountPercent);
        logger.info("Original: ${}, Discount: {}%, Final: ${}",
                originalPrice, discountPercent, String.format("%.2f", finalPrice));

        // Example 3: String building (immutable handling)
        logger.info("\nExample 3: Build greeting message");
        String name = "Alice";
        String greeting = createGreeting(name, "Good morning");
        logger.info("Input name: \"{}\", Greeting: \"{}\"", name, greeting);
    }

    // ========== Helper Methods ==========

    /**
     * Attempts to modify a primitive int (won't affect original).
     */
    private static void modifyPrimitive(int value) {
        value = value * 2;
        logger.info("  Inside modifyPrimitive: value = {} (local copy modified)", value);
    }

    /**
     * Attempts to modify a primitive double (won't affect original).
     */
    private static void modifyDouble(double value) {
        value = value + 10.5;
        logger.info("  Inside modifyDouble: value = {} (local copy modified)", value);
    }

    /**
     * Attempts to modify a primitive boolean (won't affect original).
     */
    private static void modifyBoolean(boolean value) {
        value = !value;
        logger.info("  Inside modifyBoolean: value = {} (local copy modified)", value);
    }

    /**
     * Modifies array elements (DOES affect original array).
     *
     * @param array      The array to modify
     * @param multiplier Value to multiply each element by
     */
    private static void multiplyArrayElements(int[] array, int multiplier) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= multiplier;
        }
    }

    /**
     * Appends text to StringBuilder (DOES affect original StringBuilder).
     *
     * @param sb   The StringBuilder to modify
     * @param text Text to append
     */
    private static void appendToStringBuilder(StringBuilder sb, String text) {
        sb.append(text);
    }

    /**
     * Attempts to modify String (won't affect original due to immutability).
     *
     * @param text The string (immutable)
     */
    private static void attemptToModifyString(String text) {
        text = text + " Modified";
        logger.info("  Inside method: text = \"{}\" (new object created)", text);
    }

    /**
     * Adds two integers.
     *
     * @param a First number
     * @param b Second number
     * @return Sum of a and b
     */
    private static int add(int a, int b) {
        return a + b;
    }

    /**
     * Calculates total price with tax and quantity.
     *
     * @param price    Base price per item
     * @param taxRate  Tax rate (e.g., 0.15 for 15%)
     * @param quantity Number of items
     * @return Total price
     */
    private static double calculateTotalPrice(double price, double taxRate, int quantity) {
        double subtotal = price * quantity;
        double tax = subtotal * taxRate;
        return subtotal + tax;
    }

    /**
     * Builds a person information string.
     *
     * @param firstName First name
     * @param lastName  Last name
     * @param age       Age
     * @param job       Job title
     * @return Formatted person info
     */
    private static String buildPersonInfo(String firstName, String lastName, int age, String job) {
        return String.format("%s %s, %d years old, works as %s", firstName, lastName, age, job);
    }

    /**
     * Normalizes array scores by adding bonus points.
     *
     * @param scores      Array of scores to modify
     * @param bonusPoints Points to add to each score
     */
    private static void normalizeScores(int[] scores, int bonusPoints) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonusPoints;
        }
    }

    /**
     * Applies discount to a price.
     *
     * @param price           Original price
     * @param discountPercent Discount percentage
     * @return Final price after discount
     */
    private static double applyDiscount(double price, double discountPercent) {
        return price * (1 - discountPercent / 100.0);
    }

    /**
     * Creates a greeting message.
     *
     * @param name     Person's name
     * @param greeting Greeting phrase
     * @return Complete greeting message
     */
    private static String createGreeting(String name, String greeting) {
        return greeting + ", " + name + "!";
    }

    /**
     * Converts array to string representation.
     *
     * @param array The array to convert
     * @return String representation
     */
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
