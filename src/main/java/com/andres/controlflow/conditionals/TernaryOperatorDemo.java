package com.andres.controlflow.conditionals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the ternary operator (conditional operator) in Java.
 * 
 * <p>
 * <strong>What is the ternary operator?</strong>
 * </p>
 * <p>
 * A concise way to write simple if-else statements in a single line. It's the
 * only ternary operator in Java (takes three operands).
 * </p>
 * 
 * <p>
 * <strong>Syntax:</strong>
 * </p>
 * 
 * <pre>
 * condition ? valueIfTrue : valueIfFalse
 * </pre>
 * 
 * <p>
 * <strong>When to Use Ternary Operator:</strong>
 * </p>
 * <ul>
 * <li>Simple conditional assignment to a variable</li>
 * <li>Inline conditional values in method calls</li>
 * <li>Short, readable conditions with clear outcomes</li>
 * <li>When both branches return/assign a value</li>
 * </ul>
 * 
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Complex conditions (use if-else for readability)</li>
 * <li>Multiple statements in branches</li>
 * <li>Nested ternary operators (very hard to read)</li>
 * <li>Side effects or void operations</li>
 * </ul>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Variable initialization based on condition</li>
 * <li>Returning conditional values from methods</li>
 * <li>Setting default values</li>
 * <li>Simple flag toggling</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use for simple, obvious conditions only</li>
 * <li>Avoid nesting - if you need to nest, use if-else instead</li>
 * <li>Keep both branches short and simple</li>
 * <li>Prefer if-else when readability would suffer</li>
 * <li>Use parentheses for clarity when needed</li>
 * </ul>
 * 
 * <p>
 * <strong>Comparison with if-else:</strong>
 * </p>
 * <ul>
 * <li><strong>Ternary:</strong> More concise, expression-based (returns
 * value)</li>
 * <li><strong>If-else:</strong> More readable for complex logic,
 * statement-based</li>
 * </ul>
 */
public final class TernaryOperatorDemo {

    private static final Logger logger = LoggerFactory.getLogger(TernaryOperatorDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private TernaryOperatorDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates ternary operator usage.
     */
    public static void demonstrate() {
        logger.info("--- Ternary Operator (Conditional Operator) ---\n");

        // Basic usage
        demonstrateBasicUsage();

        // Variable assignment
        demonstrateVariableAssignment();

        // Method returns
        demonstrateMethodReturns();

        // Comparison with if-else
        demonstrateComparison();

        // Real-world examples
        demonstrateRealWorldExamples();

        // Best practices vs anti-patterns
        demonstrateBestPractices();

        System.out.println();
    }

    /**
     * Demonstrates basic ternary operator usage.
     */
    private static void demonstrateBasicUsage() {
        logger.info("--- Basic Usage ---");

        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor";
        logger.info("Age {}: {}", age, status);

        // With boolean variable
        boolean isWeekend = true;
        String dayType = isWeekend ? "Weekend" : "Weekday";
        logger.info("Is weekend? {}: {}", isWeekend, dayType);

        // With comparison
        int a = 10;
        int b = 20;
        int max = (a > b) ? a : b;
        logger.info("Max of {} and {}: {}", a, b, max);
    }

    /**
     * Demonstrates variable assignment with ternary operator.
     * 
     * <p>
     * <strong>Advantage:</strong> Initialize final variables conditionally
     * in a single statement.
     * </p>
     */
    private static void demonstrateVariableAssignment() {
        logger.info("\n--- Variable Assignment ---");

        int score = 85;

        // Simple assignment
        String result = (score >= 60) ? "Passed" : "Failed";
        logger.info("Score {}: {}", score, result);

        // Chained ternary (use sparingly)
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : (score >= 70) ? "C" : "F";
        logger.info("Grade for score {}: {}", score, grade);
        logger.warn("Note: Chained ternary can be hard to read - consider if-else");

        // With final variable
        int age = 17;
        final String access = (age >= 18) ? "granted" : "denied";
        logger.info("Access: {}", access);
    }

    /**
     * Demonstrates using ternary in method returns.
     */
    private static void demonstrateMethodReturns() {
        logger.info("\n--- Method Returns ---");

        logger.info("Is even(10): {}", isEven(10));
        logger.info("Is even(7): {}", isEven(7));

        logger.info("Get absolute value(-15): {}", getAbsoluteValue(-15));
        logger.info("Get absolute value(20): {}", getAbsoluteValue(20));
    }

    /**
     * Demonstrates comparison between ternary and if-else.
     */
    private static void demonstrateComparison() {
        logger.info("\n--- Ternary vs If-Else Comparison ---");

        int temperature = 28;

        // Using if-else
        String weatherIfElse;
        if (temperature > 30) {
            weatherIfElse = "Hot";
        } else {
            weatherIfElse = "Pleasant";
        }
        logger.info("If-else approach: Temperature {}°C is {}", temperature, weatherIfElse);

        // Using ternary (more concise)
        String weatherTernary = (temperature > 30) ? "Hot" : "Pleasant";
        logger.info("Ternary approach: Temperature {}°C is {}", temperature, weatherTernary);

        logger.info("\n✓ Both produce same result");
        logger.info("✓ Ternary is more concise for simple cases");
        logger.info("✓ If-else is more readable for complex logic");
    }

    /**
     * Demonstrates real-world use cases.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Default values
        logger.info("Example 1: Setting Default Values");
        String username = null;
        String displayName = (username != null) ? username : "Guest";
        logger.info("Display name: {}", displayName);

        // Example 2: Pluralization
        logger.info("\nExample 2: Pluralization");
        int itemCount = 1;
        String message = itemCount + " item" + ((itemCount != 1) ? "s" : "");
        logger.info(message);

        itemCount = 5;
        message = itemCount + " item" + ((itemCount != 1) ? "s" : "");
        logger.info(message);

        // Example 3: Fee calculation
        logger.info("\nExample 3: Fee Calculation");
        double amount = 150.0;
        boolean isMember = true;
        double fee = isMember ? (amount * 0.02) : (amount * 0.05);
        logger.info("Amount: ${}, Member: {}, Fee: ${}", amount, isMember, fee);

        // Example 4: Status message
        logger.info("\nExample 4: Status Message");
        boolean isOnline = true;
        String statusMessage = isOnline ? "Available" : "Offline";
        logger.info("User status: {}", statusMessage);

        // Example 5: Inline formatting
        logger.info("\nExample 5: Inline Formatting");
        int balance = -50;
        logger.info("Balance: {}{}", (balance >= 0) ? "" : "-", Math.abs(balance));
    }

    /**
     * Demonstrates best practices vs anti-patterns.
     */
    private static void demonstrateBestPractices() {
        logger.info("\n--- Best Practices vs Anti-Patterns ---");

        int value = 10;
        boolean condition = true;

        // GOOD: Simple, clear ternary
        String goodExample = (value > 5) ? "High" : "Low";
        logger.info("✓ Good: Simple and clear - {}", goodExample);

        // BAD: Complex nested ternary (hard to read)
        String badExample = (value > 10) ? "Very High" : (value > 5) ? "High" : (value > 0) ? "Low" : "Very Low";
        logger.warn("✗ Bad: Too complex - use if-else instead - {}", badExample);

        // GOOD: Using parentheses for clarity
        String withParens = (condition && value > 5) ? "Yes" : "No";
        logger.info("✓ Good: Clear parentheses - {}", withParens);

        // BAD: Ternary with side effects
        int counter = 0;
        String sideEffect = (condition) ? String.valueOf(counter++) : String.valueOf(counter);
        logger.info("{}", sideEffect);
        logger.warn("✗ Bad: Side effects in ternary - prefer if-else");

        // GOOD: Extract to variable for readability
        boolean isEligible = value > 5 && condition;
        String extracted = isEligible ? "Eligible" : "Not eligible";
        logger.info("✓ Good: Extracted condition - {}", extracted);

        // When to use if-else instead
        logger.info("\n--- When to Use If-Else Instead ---");
        logger.info("• Multiple statements in branches");
        logger.info("• Complex nested conditions");
        logger.info("• When readability would suffer");
        logger.info("• Side effects or void operations");
    }

    /**
     * Helper method: Check if number is even using ternary.
     */
    private static boolean isEven(int number) {
        return (number % 2 == 0) ? true : false;
        // Note: This could be simplified to just: return number % 2 == 0;
    }

    /**
     * Helper method: Get absolute value using ternary.
     */
    private static int getAbsoluteValue(int number) {
        return (number >= 0) ? number : -number;
    }
}
