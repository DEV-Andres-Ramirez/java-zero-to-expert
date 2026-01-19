package com.andres.datatypes.primitive.bool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the boolean primitive data type in Java.
 * 
 * <p>
 * <strong>Boolean Type Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Only two possible values: true or false</li>
 * <li>Result of logical operations and comparisons</li>
 * <li>Size not defined by specification (JVM dependent, typically 1 byte)</li>
 * <li>Cannot be cast to numeric types (unlike C/C++)</li>
 * </ul>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Binary flags and states (active/inactive, enabled/disabled)</li>
 * <li>Conditional logic (if, while, for conditions)</li>
 * <li>Validation results and checks</li>
 * <li>Feature toggles and configuration flags</li>
 * <li>Access control and permissions (hasPermission, canExecute)</li>
 * </ul>
 * 
 * <p>
 * <strong>Logical Operators:</strong>
 * </p>
 * <ul>
 * <li><strong>&&</strong> - Logical AND (short-circuit)</li>
 * <li><strong>||</strong> - Logical OR (short-circuit)</li>
 * <li><strong>!</strong> - Logical NOT</li>
 * <li><strong>&</strong> - Bitwise AND (non-short-circuit)</li>
 * <li><strong>|</strong> - Bitwise OR (non-short-circuit)</li>
 * <li><strong>^</strong> - Logical XOR</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use descriptive names: isValid, hasPermission, canExecute</li>
 * <li>DO NOT use int (0/1) for boolean values</li>
 * <li>Avoid redundant comparisons: if (isValid == true) → if (isValid)</li>
 * <li>Prefer positive naming: isEnabled over isDisabled (when possible)</li>
 * <li>Use short-circuit operators (&&, ||) by default for efficiency</li>
 * </ul>
 */
public final class BooleanTypeDemo {

    private static final Logger logger = LoggerFactory.getLogger(BooleanTypeDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private BooleanTypeDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates boolean type usage and operations.
     */
    public static void demonstrate() {
        logger.info("--- Boolean Data Type ---\n");

        boolean isJavaAwesome = true;
        boolean isPythonFaster = false;

        logger.info("Is Java awesome? {}", isJavaAwesome);
        logger.info("Is Python faster? {}", isPythonFaster);

        // Logical operations
        demonstrateLogicalOperations(isJavaAwesome, isPythonFaster);

        // Comparison operations
        demonstrateComparisonOperations();

        // Short-circuit evaluation
        demonstrateShortCircuit();

        // Common patterns
        demonstrateCommonPatterns();

        System.out.println();
    }

    /**
     * Demonstrates logical operations (AND, OR, NOT, XOR).
     */
    private static void demonstrateLogicalOperations(boolean a, boolean b) {
        logger.info("\n--- Logical Operations ---");

        logger.info("a = {}, b = {}", a, b);
        logger.info("AND (a && b): {}", a && b);
        logger.info("OR (a || b): {}", a || b);
        logger.info("NOT (!a): {}", !a);
        logger.info("XOR (a ^ b): {}", a ^ b);
    }

    /**
     * Demonstrates comparison operations that return boolean.
     */
    private static void demonstrateComparisonOperations() {
        logger.info("\n--- Comparison Operations ---");

        int x = 10;
        int y = 20;

        logger.info("x = {}, y = {}", x, y);
        logger.info("x > y: {}", x > y);
        logger.info("x < y: {}", x < y);
        logger.info("x >= y: {}", x >= y);
        logger.info("x <= y: {}", x <= y);
        logger.info("x == y: {}", x == y);
        logger.info("x != y: {}", x != y);
    }

    /**
     * Demonstrates short-circuit evaluation behavior.
     * 
     * <p>
     * <strong>Short-circuit evaluation:</strong>
     * </p>
     * <p>
     * With && operator, if first operand is false, second is not evaluated.
     * With || operator, if first operand is true, second is not evaluated.
     * </p>
     * 
     * <p>
     * This is important for performance and avoiding null pointer exceptions.
     * </p>
     */
    private static void demonstrateShortCircuit() {
        logger.info("\n--- Short-Circuit Evaluation ---");

        String text = null;

        // Short-circuit prevents NullPointerException
        boolean result = (text != null) && (text.length() > 0);
        logger.info("Safe null check: text != null && text.length() > 0 = {}", result);
        logger.info("text.length() was NOT evaluated because text is null");

        // Without short-circuit, this would throw NullPointerException:
        // boolean unsafe = (text.length() > 0) && (text != null); // DANGER!

        logger.info("\nShort-circuit with OR:");
        boolean isValid = true;
        boolean expensiveCheck = false;
        boolean combined = isValid || expensiveCheck;
        logger.info("isValid || expensiveCheck = {} (second not evaluated)", combined);
    }

    /**
     * Demonstrates common boolean patterns and anti-patterns.
     */
    private static void demonstrateCommonPatterns() {
        logger.info("\n--- Common Patterns ---");

        boolean isAuthenticated = true;

        // GOOD: Direct use
        if (isAuthenticated) {
            logger.info("✓ Good: if (isAuthenticated)");
        }

        // BAD: Redundant comparison
        if (isAuthenticated == true) { // NOSONAR - intentional anti-pattern
            logger.warn("✗ Avoid: if (isAuthenticated == true) - redundant");
        }

        // GOOD: Boolean method return
        boolean result = checkCondition();
        logger.info("✓ Good: Direct boolean return: {}", result);

        // BAD: Unnecessary ternary
        boolean badResult = checkCondition() ? true : false; // NOSONAR - intentional anti-pattern
        logger.warn("✗ Avoid: condition ? true : false - just return condition: {}", badResult);
    }

    /**
     * Example method returning boolean directly.
     */
    private static boolean checkCondition() {
        int value = 10;
        // GOOD: Direct return of comparison
        return value > 5;

        // BAD: Unnecessary if-else
        // if (value > 5) {
        // return true;
        // } else {
        // return false;
        // }
    }
}
