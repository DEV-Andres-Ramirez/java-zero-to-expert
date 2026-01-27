package com.andres.functions.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates method overloading in Java.
 *
 * <p>
 * <strong>What is Method Overloading?</strong>
 * </p>
 * <p>
 * Method overloading is a feature that allows a class to have multiple methods
 * with the <strong>same name</strong> but <strong>different parameter
 * lists</strong>.
 * The compiler determines which method to call based on the arguments provided
 * (compile-time polymorphism).
 * </p>
 *
 * <p>
 * <strong>Overloading Rules:</strong>
 * </p>
 * <ul>
 * <li>Methods must have the same name</li>
 * <li>Methods must differ in: number of parameters, types of parameters, or
 * order of parameter types</li>
 * <li>Return type alone is NOT sufficient to overload methods</li>
 * <li>Access modifiers can differ</li>
 * </ul>
 *
 * <p>
 * <strong>Overloading vs Overriding:</strong>
 * </p>
 * <ul>
 * <li><strong>Overloading:</strong> Same class, same method name, different
 * parameters (compile-time)</li>
 * <li><strong>Overriding:</strong> Subclass redefines parent method (runtime -
 * requires inheritance)</li>
 * </ul>
 *
 * <p>
 * <strong>When to Use Overloading:</strong>
 * </p>
 * <ul>
 * <li>Providing multiple ways to invoke similar functionality</li>
 * <li>Simulating default parameters (Java doesn't have them)</li>
 * <li>Creating flexible APIs with optional parameters</li>
 * <li>Supporting different input types for same operation</li>
 * <li>Factory methods with different construction strategies</li>
 * </ul>
 *
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Methods performing fundamentally different operations (use different
 * names)</li>
 * <li>Too many overloads causing confusion</li>
 * <li>When varargs would be simpler and clearer</li>
 * </ul>
 *
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Constructors with different initialization options</li>
 * <li>Utility methods (print(), calculate(), format())</li>
 * <li>API design for user convenience</li>
 * <li>Mathematical operations (add(), multiply())</li>
 * <li>String/data formatting methods</li>
 * </ul>
 *
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Keep overloaded methods consistent in behavior</li>
 * <li>Make simpler overloads delegate to more complex ones</li>
 * <li>Use descriptive parameter names to clarify differences</li>
 * <li>Document each overload's purpose in Javadoc</li>
 * <li>Avoid ambiguous overloads (e.g., int vs long can cause confusion)</li>
 * <li>Limit to 3-5 overloads maximum for readability</li>
 * </ul>
 *
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Assuming return type is enough to distinguish methods (it's not)</li>
 * <li>Creating ambiguous overloads that confuse the compiler</li>
 * <li>Overloaded methods with inconsistent behavior</li>
 * <li>Too many overloads making API hard to understand</li>
 * <li>Not considering type promotion (byte → int → long)</li>
 * </ul>
 *
 * @author Andrés
 * @version 1.0
 */
public final class MethodOverloadingDemo {

    private static final Logger logger = LoggerFactory.getLogger(MethodOverloadingDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private MethodOverloadingDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates method overloading concepts and patterns.
     */
    public static void demonstrate() {
        logger.info("--- Method Overloading ---\n");

        demonstrateBasicOverloading();
        demonstrateParameterCountOverloading();
        demonstrateTypeOverloading();
        demonstrateOrderOverloading();
        demonstrateTypePromotion();
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates basic method overloading with different parameter types.
     */
    private static void demonstrateBasicOverloading() {
        logger.info("--- Basic Overloading: Different Parameter Types ---");

        logger.info("Same method name 'print', different parameter types:\n");

        // Calls print(String)
        print("Hello, World!");

        // Calls print(int)
        print(42);

        // Calls print(double)
        print(3.14159);

        // Calls print(boolean)
        print(true);

        logger.info("\nCompiler selects the right method based on argument type");
    }

    /**
     * Demonstrates overloading based on parameter count.
     */
    private static void demonstrateParameterCountOverloading() {
        logger.info("\n--- Overloading: Different Parameter Counts ---");

        logger.info("Same method name 'sum', different number of parameters:\n");

        // 2 parameters
        int result1 = sum(5, 10);
        logger.info("sum(5, 10) = {}", result1);

        // 3 parameters
        int result2 = sum(5, 10, 15);
        logger.info("sum(5, 10, 15) = {}", result2);

        // 4 parameters
        int result3 = sum(5, 10, 15, 20);
        logger.info("sum(5, 10, 15, 20) = {}", result3);

        logger.info("\nNote: Varargs can be an alternative to many overloads");
    }

    /**
     * Demonstrates overloading with different types for same operation.
     */
    private static void demonstrateTypeOverloading() {
        logger.info("\n--- Overloading: Different Types for Same Operation ---");

        logger.info("Method 'multiply' works with different numeric types:\n");

        // int version
        int intResult = multiply(5, 4);
        logger.info("multiply(5, 4) [int] = {}", intResult);

        // double version
        double doubleResult = multiply(5.5, 4.2);
        logger.info("multiply(5.5, 4.2) [double] = {}", String.format("%.2f", doubleResult));

        // long version
        long longResult = multiply(1_000_000L, 2_000_000L);
        logger.info("multiply(1000000L, 2000000L) [long] = {}", longResult);
    }

    /**
     * Demonstrates overloading where parameter order matters.
     */
    private static void demonstrateOrderOverloading() {
        logger.info("\n--- Overloading: Parameter Order Matters ---");

        logger.info("Different parameter order creates different methods:\n");

        // (String, int)
        String result1 = format("User", 101);
        logger.info("format(\"User\", 101) = \"{}\"", result1);

        // (int, String)
        String result2 = format(202, "Product");
        logger.info("format(202, \"Product\") = \"{}\"", result2);

        logger.info("\nParameter order is part of the method signature");
    }

    /**
     * Demonstrates automatic type promotion in overloading.
     */
    private static void demonstrateTypePromotion() {
        logger.info("\n--- Type Promotion in Overloading ---");

        logger.info("Java automatically promotes smaller types to larger types:\n");

        // byte → int promotion
        byte b = 5;
        processNumber(b);
        logger.info("byte 5 promoted to int");

        // short → int promotion
        short s = 10;
        processNumber(s);
        logger.info("short 10 promoted to int");

        // char → int promotion
        char c = 'A';
        processNumber(c);
        logger.info("char 'A' promoted to int (ASCII: {})", (int) c);

        logger.info("\nPromotion order: byte → short → int → long → float → double");
    }

    /**
     * Demonstrates real-world overloading scenarios.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Overloading Examples ---");

        // Example 1: Area calculations
        logger.info("Example 1: Area calculations (different shapes)");
        double circleArea = calculateArea(5.0);
        logger.info("Circle area (radius 5): {}", String.format("%.2f", circleArea));

        double rectangleArea = calculateArea(4.0, 6.0);
        logger.info("Rectangle area (4x6): {}", String.format("%.2f", rectangleArea));

        double triangleArea = calculateArea(4.0, 6.0, true);
        logger.info("Triangle area (base 4, height 6): {}", String.format("%.2f", triangleArea));

        // Example 2: String building with defaults
        logger.info("\nExample 2: Building messages with defaults");
        String msg1 = buildMessage("Hello");
        logger.info("buildMessage(\"Hello\") = \"{}\"", msg1);

        String msg2 = buildMessage("Hello", "John");
        logger.info("buildMessage(\"Hello\", \"John\") = \"{}\"", msg2);

        String msg3 = buildMessage("Hello", "John", "!");
        logger.info("buildMessage(\"Hello\", \"John\", \"!\") = \"{}\"", msg3);

        // Example 3: Search with optional parameters
        logger.info("\nExample 3: Search with optional case sensitivity");
        String[] words = { "Apple", "Banana", "Cherry" };

        boolean found1 = contains(words, "banana");
        logger.info("contains([...], \"banana\") = {} (case-insensitive)", found1);

        boolean found2 = contains(words, "banana", true);
        logger.info("contains([...], \"banana\", caseSensitive=true) = {}", found2);

        boolean found3 = contains(words, "Banana", true);
        logger.info("contains([...], \"Banana\", caseSensitive=true) = {}", found3);
    }

    // ========== Overloaded Methods (Examples) ==========

    // print() overloads

    private static void print(String message) {
        logger.info("  [String] {}", message);
    }

    private static void print(int number) {
        logger.info("  [int] {}", number);
    }

    private static void print(double number) {
        logger.info("  [double] {}", number);
    }

    private static void print(boolean flag) {
        logger.info("  [boolean] {}", flag);
    }

    // sum() overloads

    private static int sum(int a, int b) {
        return a + b;
    }

    private static int sum(int a, int b, int c) {
        return a + b + c;
    }

    private static int sum(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    // multiply() overloads

    private static int multiply(int a, int b) {
        return a * b;
    }

    private static double multiply(double a, double b) {
        return a * b;
    }

    private static long multiply(long a, long b) {
        return a * b;
    }

    // format() overloads (order matters)

    private static String format(String name, int id) {
        return String.format("Name: %s, ID: %d", name, id);
    }

    private static String format(int id, String type) {
        return String.format("ID: %d, Type: %s", id, type);
    }

    // processNumber() for type promotion demo

    private static void processNumber(int number) {
        logger.info("  Processing int: {}", number);
    }

    // calculateArea() overloads (real-world example)

    /**
     * Calculates area of circle.
     *
     * @param radius Circle radius
     * @return Circle area
     */
    private static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    /**
     * Calculates area of rectangle.
     *
     * @param width  Rectangle width
     * @param height Rectangle height
     * @return Rectangle area
     */
    private static double calculateArea(double width, double height) {
        return width * height;
    }

    /**
     * Calculates area of triangle.
     *
     * @param base       Triangle base
     * @param height     Triangle height
     * @param isTriangle Must be true to indicate triangle calculation
     * @return Triangle area
     */
    private static double calculateArea(double base, double height, boolean isTriangle) {
        if (!isTriangle) {
            return calculateArea(base, height); // Delegate to rectangle
        }
        return 0.5 * base * height;
    }

    // buildMessage() overloads (simulating default parameters)

    /**
     * Builds message with default recipient.
     */
    private static String buildMessage(String greeting) {
        return buildMessage(greeting, "Guest", ".");
    }

    /**
     * Builds message with specified recipient.
     */
    private static String buildMessage(String greeting, String name) {
        return buildMessage(greeting, name, ".");
    }

    /**
     * Builds complete message with all parts.
     */
    private static String buildMessage(String greeting, String name, String punctuation) {
        return greeting + ", " + name + punctuation;
    }

    // contains() overloads (optional parameters)

    /**
     * Checks if array contains string (case-insensitive by default).
     */
    private static boolean contains(String[] array, String target) {
        return contains(array, target, false);
    }

    /**
     * Checks if array contains string with optional case sensitivity.
     */
    private static boolean contains(String[] array, String target, boolean caseSensitive) {
        for (String item : array) {
            if (caseSensitive) {
                if (item.equals(target)) {
                    return true;
                }
            } else {
                if (item.equalsIgnoreCase(target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
