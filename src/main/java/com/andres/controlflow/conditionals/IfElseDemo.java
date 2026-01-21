package com.andres.controlflow.conditionals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates if-else conditional statements in Java.
 * 
 * <p>
 * <strong>What are if-else statements?</strong>
 * </p>
 * <p>
 * Conditional statements that allow executing different code blocks based on
 * boolean conditions. They are fundamental for decision-making logic in
 * programs.
 * </p>
 * 
 * <p>
 * <strong>Syntax Structure:</strong>
 * </p>
 * 
 * <pre>
 * if (condition) {
 *     // Code executed if condition is true
 * } else if (anotherCondition) {
 *     // Code executed if first is false and this is true
 * } else {
 *     // Code executed if all conditions are false
 * }
 * </pre>
 * 
 * <p>
 * <strong>When to Use if-else:</strong>
 * </p>
 * <ul>
 * <li>Complex conditions with multiple branches</li>
 * <li>Conditions based on ranges or comparisons</li>
 * <li>When conditions are not mutually exclusive values</li>
 * <li>Business logic with multiple validation steps</li>
 * <li>Default case: Use switch for simple equality checks on single
 * variable</li>
 * </ul>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>User input validation</li>
 * <li>Access control and permission checks</li>
 * <li>Business rule enforcement</li>
 * <li>Error handling and edge case management</li>
 * <li>Conditional data processing</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Keep conditions simple and readable</li>
 * <li>Use meaningful variable names for boolean conditions</li>
 * <li>Avoid deep nesting (max 2-3 levels) - refactor to methods if needed</li>
 * <li>Consider using early returns to reduce nesting</li>
 * <li>Put most likely conditions first for performance</li>
 * <li>Use braces {} even for single-line blocks (clarity and safety)</li>
 * <li>Consider switch expressions (Java 14+) for multiple equality checks</li>
 * </ul>
 * 
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Assignment (=) instead of comparison (==) in conditions</li>
 * <li>Comparing objects with == instead of .equals()</li>
 * <li>Overly complex nested conditions (hard to maintain)</li>
 * <li>Missing braces leading to logic errors</li>
 * </ul>
 */
public final class IfElseDemo {

    private static final Logger logger = LoggerFactory.getLogger(IfElseDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private IfElseDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates if-else statement usage.
     */
    public static void demonstrate() {
        logger.info("--- If-Else Conditional Statements ---\n");

        // Basic if-else
        demonstrateBasicIfElse();

        // If-else if-else chain
        demonstrateIfElseIfChain();

        // Nested conditions
        demonstrateNestedConditions();

        // Complex conditions
        demonstrateComplexConditions();

        // Real-world examples
        demonstrateRealWorldExamples();

        // Best practices vs anti-patterns
        demonstrateBestPractices();

        System.out.println();
    }

    /**
     * Demonstrates basic if-else structure.
     */
    private static void demonstrateBasicIfElse() {
        logger.info("--- Basic If-Else ---");

        int age = 17;

        if (age >= 18) {
            logger.info("Age {}: You are an adult", age);
        } else {
            logger.info("Age {}: You are a minor", age);
        }

        // Single condition (if only)
        boolean isLoggedIn = true;
        if (isLoggedIn) {
            logger.info("Welcome back!");
        }

        // Using boolean expression directly
        int score = 85;
        if (score >= 60) {
            logger.info("Score {}: Passed", score);
        } else {
            logger.info("Score {}: Failed", score);
        }
    }

    /**
     * Demonstrates if-else if-else chain for multiple conditions.
     * 
     * <p>
     * <strong>Use Case:</strong> When you have multiple mutually exclusive
     * conditions to check in sequence.
     * </p>
     */
    private static void demonstrateIfElseIfChain() {
        logger.info("\n--- If-Else If-Else Chain ---");

        int age = 45;

        if (age < 13) {
            logger.info("Age {}: Child", age);
        } else if (age < 18) {
            logger.info("Age {}: Teenager", age);
        } else if (age < 65) {
            logger.info("Age {}: Adult", age);
        } else {
            logger.info("Age {}: Senior", age);
        }

        // Grade evaluation example
        logger.info("\n--- Grade Evaluation ---");
        int grade = 88;

        if (grade >= 90) {
            logger.info("Grade {}: A - Excellent", grade);
        } else if (grade >= 80) {
            logger.info("Grade {}: B - Good", grade);
        } else if (grade >= 70) {
            logger.info("Grade {}: C - Satisfactory", grade);
        } else if (grade >= 60) {
            logger.info("Grade {}: D - Needs Improvement", grade);
        } else {
            logger.info("Grade {}: F - Failed", grade);
        }
    }

    /**
     * Demonstrates nested conditions (conditions within conditions).
     * 
     * <p>
     * <strong>Warning:</strong> Avoid deep nesting (>2-3 levels). Consider
     * refactoring to separate methods or using early returns.
     * </p>
     */
    private static void demonstrateNestedConditions() {
        logger.info("\n--- Nested Conditions ---");

        int age = 25;
        boolean hasLicense = true;
        boolean hasInsurance = true;

        if (age >= 18) {
            if (hasLicense) {
                if (hasInsurance) {
                    logger.info("You can drive");
                } else {
                    logger.warn("You need insurance to drive");
                }
            } else {
                logger.warn("You need a driver's license");
            }
        } else {
            logger.warn("You must be 18 or older to drive");
        }

        // Better approach: Early returns (if in a method)
        logger.info("\n--- Better Approach: Flattened Logic ---");
        validateDrivingEligibility(age, hasLicense, hasInsurance);
    }

    /**
     * Demonstrates complex conditions with logical operators.
     * 
     * <p>
     * <strong>Logical Operators:</strong>
     * </p>
     * <ul>
     * <li>&& (AND): Both conditions must be true</li>
     * <li>|| (OR): At least one condition must be true</li>
     * <li>! (NOT): Negates the condition</li>
     * </ul>
     */
    private static void demonstrateComplexConditions() {
        logger.info("\n--- Complex Conditions ---");

        int temperature = 28;
        boolean isRaining = false;
        boolean isWeekend = true;

        // AND operator
        if (temperature > 25 && !isRaining) {
            logger.info("Good weather for outdoor activities");
        }

        // OR operator
        if (isWeekend || temperature > 30) {
            logger.info("Consider going to the beach");
        }

        // Combining multiple operators
        if ((isWeekend || temperature > 30) && !isRaining) {
            logger.info("Perfect day for a picnic");
        }

        // Complex business logic
        logger.info("\n--- Complex Business Logic ---");
        double purchaseAmount = 150.0;
        boolean isMember = true;
        boolean hasPromoCode = false;

        if ((purchaseAmount > 100 && isMember) || (purchaseAmount > 200 && hasPromoCode)) {
            logger.info("Free shipping eligible");
        } else {
            logger.info("Standard shipping applies");
        }
    }

    /**
     * Demonstrates real-world use cases for if-else statements.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: User authentication
        logger.info("Example 1: User Authentication");
        String username = "admin";
        String password = "pass123";

        if (username.equals("admin") && password.equals("pass123")) {
            logger.info("Login successful");
        } else if (username.equals("admin")) {
            logger.warn("Incorrect password");
        } else {
            logger.warn("User not found");
        }

        // Example 2: HTTP status handling
        logger.info("\nExample 2: HTTP Status Handling");
        int httpStatus = 404;

        if (httpStatus >= 200 && httpStatus < 300) {
            logger.info("Success");
        } else if (httpStatus >= 400 && httpStatus < 500) {
            logger.error("Client error");
        } else if (httpStatus >= 500) {
            logger.error("Server error");
        }

        // Example 3: Null safety checks
        logger.info("\nExample 3: Null Safety");
        String userInput = "hello";

        if (userInput != null && !userInput.isEmpty()) {
            logger.info("Processing input: {}", userInput);
        } else {
            logger.warn("Input is null or empty");
        }

        // Example 4: Discount calculation
        logger.info("\nExample 4: Discount Calculation");
        calculateDiscount(250.0, true);
        calculateDiscount(80.0, false);
    }

    /**
     * Demonstrates best practices vs anti-patterns.
     */
    private static void demonstrateBestPractices() {
        logger.info("\n--- Best Practices vs Anti-Patterns ---");

        boolean isActive = true;
        int value = 10;

        // GOOD: Direct boolean check
        if (isActive) {
            logger.info("✓ Good: Direct boolean check");
        }

        // BAD: Redundant comparison
        if (isActive == true) { // NOSONAR - intentional anti-pattern
            logger.warn("✗ Bad: Redundant == true comparison");
        }

        // GOOD: Positive condition first
        if (value > 0) {
            logger.info("✓ Good: Positive value");
        } else {
            logger.info("✓ Good: Non-positive value");
        }

        // GOOD: Using braces even for single line
        if (value > 5) {
            logger.info("✓ Good: Braces improve safety and clarity");
        }

        // BAD: No braces (can lead to bugs)
        if (value > 5)
            logger.warn("✗ Bad: Missing braces - risky for maintenance");

        // GOOD: Extract complex conditions to variables
        boolean isEligibleForDiscount = value > 100 && isActive;
        if (isEligibleForDiscount) {
            logger.info("✓ Good: Complex condition extracted to variable");
        }
    }

    /**
     * Helper method demonstrating early returns to avoid nested conditions.
     */
    private static void validateDrivingEligibility(int age, boolean hasLicense, boolean hasInsurance) {
        // Early returns flatten the logic
        if (age < 18) {
            logger.warn("Validation: Must be 18 or older");
            return;
        }

        if (!hasLicense) {
            logger.warn("Validation: Driver's license required");
            return;
        }

        if (!hasInsurance) {
            logger.warn("Validation: Insurance required");
            return;
        }

        logger.info("Validation: Eligible to drive");
    }

    /**
     * Helper method for discount calculation example.
     */
    private static void calculateDiscount(double amount, boolean isMember) {
        double discount = 0;

        if (amount >= 200) {
            discount = isMember ? 0.20 : 0.15;
        } else if (amount >= 100) {
            discount = isMember ? 0.15 : 0.10;
        } else if (isMember) {
            discount = 0.05;
        }

        double finalAmount = amount * (1 - discount);
        logger.info("Amount: ${}, Member: {}, Discount: {}%, Final: ${}",
                amount, isMember, (int) (discount * 100), finalAmount);
    }
}
