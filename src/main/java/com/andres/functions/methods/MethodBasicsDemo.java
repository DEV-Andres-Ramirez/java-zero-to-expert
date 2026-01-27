package com.andres.functions.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates fundamental method concepts in Java.
 *
 * <p>
 * <strong>What is a Method?</strong>
 * </p>
 * <p>
 * A method is a block of code that performs a specific task. Methods allow you
 * to
 * break down complex problems into smaller, reusable pieces. In Java, methods
 * are
 * defined inside classes and can have different access levels, return types,
 * and
 * parameters.
 * </p>
 *
 * <p>
 * <strong>Method Signature Components:</strong>
 * </p>
 *
 * <pre>
 * [access-modifier] [static] [return-type] methodName([parameters]) {
 *     // method body
 *     [return value;]
 * }
 * </pre>
 *
 * <p>
 * <strong>When to Use Methods:</strong>
 * </p>
 * <ul>
 * <li>Breaking down complex logic into manageable pieces</li>
 * <li>Reusing code across multiple locations</li>
 * <li>Improving code organization and readability</li>
 * <li>Implementing specific business logic or calculations</li>
 * <li>Abstracting implementation details</li>
 * </ul>
 *
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Over-engineering simple, one-time operations</li>
 * <li>Creating methods that are too granular (method per line)</li>
 * <li>Extracting methods that obscure logic flow</li>
 * </ul>
 *
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Utility functions (math calculations, string formatting)</li>
 * <li>Validation logic (email validation, input checking)</li>
 * <li>Data transformations and conversions</li>
 * <li>Business rule implementations</li>
 * <li>Algorithm implementations</li>
 * </ul>
 *
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use descriptive, verb-based names (calculateTotal, not total)</li>
 * <li>Keep methods focused on a single responsibility</li>
 * <li>Limit method length (generally under 20-30 lines)</li>
 * <li>Use appropriate access modifiers (public for API, private for
 * helpers)</li>
 * <li>Document complex methods with Javadoc</li>
 * <li>Prefer static methods in utility classes</li>
 * <li>Return early to reduce nesting (guard clauses)</li>
 * </ul>
 *
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Methods doing too many things (violation of single responsibility)</li>
 * <li>Poor naming leading to unclear purpose</li>
 * <li>Too many parameters (consider parameter objects)</li>
 * <li>Side effects in methods that appear to be pure functions</li>
 * <li>Forgetting to document public method contracts</li>
 * </ul>
 *
 * @author Andrés
 * @version 1.0
 */
public final class MethodBasicsDemo {

    private static final Logger logger = LoggerFactory.getLogger(MethodBasicsDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private MethodBasicsDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates method basics and fundamental concepts.
     */
    public static void demonstrate() {
        logger.info("--- Method Basics ---\n");

        demonstrateMethodAnatomy();
        demonstrateAccessModifiers();
        demonstrateStaticContext();
        demonstrateNamingConventions();
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates the components of a method signature.
     */
    private static void demonstrateMethodAnatomy() {
        logger.info("--- Method Anatomy ---");

        // Void method example
        logger.info("Calling void method:");
        printWelcomeMessage();

        // Return method example
        logger.info("\nCalling method with return value:");
        int sum = addTwoNumbers(5, 3);
        logger.info("Result of addTwoNumbers(5, 3): {}", sum);

        logger.info("\nMethod Components:");
        logger.info("1. Access Modifier: public, private, protected, package-private");
        logger.info("2. Static keyword: makes method class-level (not instance)");
        logger.info("3. Return Type: void (no return) or any data type");
        logger.info("4. Method Name: camelCase, descriptive verb");
        logger.info("5. Parameters: (Type name, Type name, ...) - can be empty");
        logger.info("6. Method Body: { } containing executable code");
    }

    /**
     * Demonstrates different access modifiers in method context.
     */
    private static void demonstrateAccessModifiers() {
        logger.info("\n--- Access Modifiers ---");

        logger.info("public: Accessible from anywhere");
        logger.info("  Example: demonstrate() - main entry point");

        logger.info("\nprivate: Only accessible within this class");
        logger.info("  Example: all helper methods like demonstrateAccessModifiers()");

        logger.info("\nprotected: Accessible within package and subclasses");
        logger.info("  Note: Less common in utility classes");

        logger.info("\npackage-private (no modifier): Accessible within package only");
        logger.info("  Example: Used for internal package utilities");
    }

    /**
     * Demonstrates static method context and limitations.
     */
    private static void demonstrateStaticContext() {
        logger.info("\n--- Static Methods ---");

        logger.info("Why static in utility classes:");
        logger.info("1. No instance needed - directly callable via ClassName.method()");
        logger.info("2. Stateless operations - no instance state required");
        logger.info("3. Memory efficient - single copy shared across all calls");

        logger.info("\nStatic method rules:");
        logger.info("✓ Can call other static methods");
        logger.info("✓ Can access static variables");
        logger.info("✗ Cannot call instance methods (need object first)");
        logger.info("✗ Cannot access instance variables");

        // Demonstrate static method call
        double area = calculateCircleArea(5.0);
        logger.info("\nExample: calculateCircleArea(5.0) = {}", String.format("%.2f", area));
    }

    /**
     * Demonstrates method naming conventions and best practices.
     */
    private static void demonstrateNamingConventions() {
        logger.info("\n--- Naming Conventions ---");

        logger.info("Good Method Names (Verb-based, Descriptive):");
        logger.info("✓ calculateTotal() - calculation action");
        logger.info("✓ isValid() - boolean check");
        logger.info("✓ getUserName() - retrieval");
        logger.info("✓ setConfiguration() - modification");
        logger.info("✓ processPayment() - action");

        logger.info("\nBad Method Names:");
        logger.info("✗ calc() - too cryptic");
        logger.info("✗ doStuff() - not descriptive");
        logger.info("✗ method1() - meaningless");
        logger.info("✗ x() - single letter");

        logger.info("\nNaming Patterns:");
        logger.info("• get*() - retrieve value");
        logger.info("• set*() - assign value");
        logger.info("• is*()/has*() - boolean checks");
        logger.info("• calculate*() - computations");
        logger.info("• validate*() - validation logic");
    }

    /**
     * Demonstrates real-world method examples.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Method Examples ---");

        // Example 1: Calculation
        logger.info("Example 1: Area Calculation");
        double radius = 7.5;
        double area = calculateCircleArea(radius);
        logger.info("Circle with radius {} has area: {}", radius, String.format("%.2f", area));

        // Example 2: Validation
        logger.info("\nExample 2: Email Validation");
        String email1 = "user@example.com";
        String email2 = "invalid.email";
        logger.info("{} is valid: {}", email1, isValidEmail(email1));
        logger.info("{} is valid: {}", email2, isValidEmail(email2));

        // Example 3: Conversion
        logger.info("\nExample 3: Temperature Conversion");
        double celsius = 25.0;
        double fahrenheit = celsiusToFahrenheit(celsius);
        logger.info("{}°C = {}°F", celsius, String.format("%.1f", fahrenheit));

        // Example 4: Formatting
        logger.info("\nExample 4: Phone Number Formatting");
        String phone = "1234567890";
        String formatted = formatPhoneNumber(phone);
        logger.info("Raw: {} -> Formatted: {}", phone, formatted);
    }

    // ========== Helper Methods (Examples) ==========

    /**
     * Simple void method - no return value.
     */
    private static void printWelcomeMessage() {
        logger.info("  Welcome to Java Methods!");
    }

    /**
     * Simple method with return value.
     *
     * @param a First number
     * @param b Second number
     * @return Sum of a and b
     */
    private static int addTwoNumbers(int a, int b) {
        return a + b;
    }

    /**
     * Calculates the area of a circle.
     *
     * @param radius The circle radius
     * @return The calculated area
     */
    private static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    /**
     * Validates email format (simplified).
     *
     * @param email The email to validate
     * @return true if valid format, false otherwise
     */
    private static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    /**
     * Converts Celsius to Fahrenheit.
     *
     * @param celsius Temperature in Celsius
     * @return Temperature in Fahrenheit
     */
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    /**
     * Formats phone number to (XXX) XXX-XXXX pattern.
     *
     * @param phone 10-digit phone number
     * @return Formatted phone number
     */
    private static String formatPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return phone;
        }
        return String.format("(%s) %s-%s",
                phone.substring(0, 3),
                phone.substring(3, 6),
                phone.substring(6, 10));
    }
}
