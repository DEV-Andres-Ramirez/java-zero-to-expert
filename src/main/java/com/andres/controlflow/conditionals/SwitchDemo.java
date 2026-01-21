package com.andres.controlflow.conditionals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates switch statements and switch expressions in Java.
 * 
 * <p>
 * <strong>What is a switch statement?</strong>
 * </p>
 * <p>
 * A multi-way branch statement that executes different code blocks based on the
 * value of a variable. More efficient and readable than multiple if-else
 * statements
 * when checking a single variable against multiple constant values.
 * </p>
 * 
 * <p>
 * <strong>Supported Types:</strong>
 * </p>
 * <ul>
 * <li>Primitive types: byte, short, char, int</li>
 * <li>Wrapper types: Byte, Short, Character, Integer</li>
 * <li>String (Java 7+)</li>
 * <li>Enum types</li>
 * </ul>
 * 
 * <p>
 * <strong>Switch Statement vs Switch Expression:</strong>
 * </p>
 * <ul>
 * <li><strong>Traditional Switch (Java 1-13):</strong> Uses break, fall-through
 * behavior</li>
 * <li><strong>Switch Expression (Java 14+):</strong> Arrow syntax (->), no
 * fall-through,
 * returns value</li>
 * </ul>
 * 
 * <p>
 * <strong>When to Use Switch:</strong>
 * </p>
 * <ul>
 * <li>Checking a single variable against multiple specific values</li>
 * <li>Enum-based state machines or command processing</li>
 * <li>Menu systems and user choice handling</li>
 * <li>Cleaner alternative to long if-else chains on same variable</li>
 * </ul>
 * 
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Range checking (e.g., age >= 18) - use if-else</li>
 * <li>Complex conditions with multiple variables - use if-else</li>
 * <li>Boolean conditions - use if-else</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Always include a default case for completeness</li>
 * <li>Prefer switch expressions (Java 14+) for cleaner, safer code</li>
 * <li>Avoid fall-through unless intentional (document if used)</li>
 * <li>Use enums for type safety instead of magic strings/numbers</li>
 * <li>Keep cases simple - extract complex logic to methods</li>
 * </ul>
 */
public final class SwitchDemo {

    private static final Logger logger = LoggerFactory.getLogger(SwitchDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private SwitchDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates switch statement and expression usage.
     */
    public static void demonstrate() {
        logger.info("--- Switch Statements and Expressions ---\n");

        // Traditional switch with break
        demonstrateTraditionalSwitch();

        // Switch expression (Java 14+)
        demonstrateSwitchExpression();

        // Switch with Strings
        demonstrateSwitchWithStrings();

        // Switch with Enums
        demonstrateSwitchWithEnums();

        // Multiple case labels
        demonstrateMultipleCaseLabels();

        // Real-world examples
        demonstrateRealWorldExamples();

        // Comparison with if-else
        demonstrateComparison();

        System.out.println();
    }

    /**
     * Demonstrates traditional switch statement with break.
     * 
     * <p>
     * <strong>Important:</strong> Must use 'break' to prevent fall-through
     * to the next case.
     * </p>
     */
    private static void demonstrateTraditionalSwitch() {
        logger.info("--- Traditional Switch Statement ---");

        int dayNumber = 3;

        switch (dayNumber) {
            case 1:
                logger.info("Day {}: Monday", dayNumber);
                break;
            case 2:
                logger.info("Day {}: Tuesday", dayNumber);
                break;
            case 3:
                logger.info("Day {}: Wednesday", dayNumber);
                break;
            case 4:
                logger.info("Day {}: Thursday", dayNumber);
                break;
            case 5:
                logger.info("Day {}: Friday", dayNumber);
                break;
            case 6:
                logger.info("Day {}: Saturday", dayNumber);
                break;
            case 7:
                logger.info("Day {}: Sunday", dayNumber);
                break;
            default:
                logger.warn("Day {}: Invalid day number", dayNumber);
                break;
        }

        // Example without break (fall-through - generally avoid)
        logger.info("\n--- Fall-Through Example (Use Carefully) ---");
        int month = 2;
        int days;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = 28; // Simplified, not accounting for leap years
                break;
            default:
                days = 0;
                logger.warn("Invalid month");
                break;
        }

        logger.info("Month {}: {} days", month, days);
    }

    /**
     * Demonstrates modern switch expression (Java 14+).
     * 
     * <p>
     * <strong>Advantages:</strong>
     * </p>
     * <ul>
     * <li>No fall-through (safer)</li>
     * <li>No break needed</li>
     * <li>Can return a value directly</li>
     * <li>More concise and expressive</li>
     * <li>Compile-time exhaustiveness check</li>
     * </ul>
     */
    private static void demonstrateSwitchExpression() {
        logger.info("\n--- Modern Switch Expression (Java 14+) ---");

        String day = "MONDAY";

        // Switch expression with arrow syntax
        String message = switch (day) {
            case "MONDAY" -> "Start of the work week";
            case "TUESDAY", "WEDNESDAY", "THURSDAY" -> "Midweek day";
            case "FRIDAY" -> "End of the work week";
            case "SATURDAY", "SUNDAY" -> "Weekend!";
            default -> "Unknown day";
        };

        logger.info("Day {}: {}", day, message);

        // Using switch expression for assignment
        logger.info("\n--- Switch Expression for Assignment ---");
        int numericDay = 5;

        String dayType = switch (numericDay) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid";
        };

        logger.info("Day {}: {}", numericDay, dayType);

        // Switch expression with code block
        logger.info("\n--- Switch Expression with Code Block ---");
        int score = 85;

        String grade = switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> {
                logger.warn("Score {} is below passing", score);
                yield "F"; // yield used to return value from block
            }
        };

        logger.info("Score {}: Grade {}", score, grade);
    }

    /**
     * Demonstrates switch with String values (Java 7+).
     */
    private static void demonstrateSwitchWithStrings() {
        logger.info("\n--- Switch with Strings ---");

        String command = "START";

        switch (command) {
            case "START":
                logger.info("Command: Starting process...");
                break;
            case "STOP":
                logger.info("Command: Stopping process...");
                break;
            case "PAUSE":
                logger.info("Command: Pausing process...");
                break;
            case "RESUME":
                logger.info("Command: Resuming process...");
                break;
            default:
                logger.warn("Command: Unknown command '{}'", command);
                break;
        }

        // Modern switch expression with strings
        String status = switch (command) {
            case "START" -> "Process started";
            case "STOP" -> "Process stopped";
            case "PAUSE" -> "Process paused";
            case "RESUME" -> "Process resumed";
            default -> "Invalid command";
        };

        logger.info("Status: {}", status);
    }

    /**
     * Demonstrates switch with Enum types (type-safe and recommended).
     */
    private static void demonstrateSwitchWithEnums() {
        logger.info("\n--- Switch with Enums (Recommended) ---");

        DayOfWeek today = DayOfWeek.FRIDAY;

        // Traditional switch with enum
        switch (today) {
            case MONDAY:
                logger.info("Back to work!");
                break;
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
                logger.info("Midweek grind");
                break;
            case FRIDAY:
                logger.info("TGIF - Almost weekend!");
                break;
            case SATURDAY:
            case SUNDAY:
                logger.info("Enjoy the weekend!");
                break;
        }

        // Modern switch expression with enum
        boolean isWorkDay = switch (today) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
            case SATURDAY, SUNDAY -> false;
        };

        logger.info("Is {} a work day? {}", today, isWorkDay);
    }

    /**
     * Demonstrates multiple case labels.
     */
    private static void demonstrateMultipleCaseLabels() {
        logger.info("\n--- Multiple Case Labels ---");

        char grade = 'B';

        // Traditional switch
        switch (grade) {
            case 'A':
            case 'B':
                logger.info("Traditional: Excellent work!");
                break;
            case 'C':
                logger.info("Traditional: Good job");
                break;
            case 'D':
            case 'F':
                logger.info("Traditional: Needs improvement");
                break;
            default:
                logger.warn("Traditional: Invalid grade");
                break;
        }

        // Modern switch expression (cleaner)
        String feedback = switch (grade) {
            case 'A', 'B' -> "Excellent work!";
            case 'C' -> "Good job";
            case 'D', 'F' -> "Needs improvement";
            default -> "Invalid grade";
        };

        logger.info("Modern: Grade {}: {}", grade, feedback);
    }

    /**
     * Demonstrates real-world use cases.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: HTTP status code handling
        logger.info("Example 1: HTTP Status Code Handling");
        handleHttpStatus(200);
        handleHttpStatus(404);
        handleHttpStatus(500);

        // Example 2: Calculator operations
        logger.info("\nExample 2: Calculator Operations");
        logger.info("5 + 3 = {}", calculate(5, 3, '+'));
        logger.info("10 - 4 = {}", calculate(10, 4, '-'));
        logger.info("6 * 7 = {}", calculate(6, 7, '*'));

        // Example 3: User role permissions
        logger.info("\nExample 3: User Role Permissions");
        checkPermissions(UserRole.ADMIN);
        checkPermissions(UserRole.USER);
    }

    /**
     * Demonstrates comparison with if-else.
     */
    private static void demonstrateComparison() {
        logger.info("\n--- Switch vs If-Else Comparison ---");

        String option = "B";

        // Using if-else
        logger.info("If-Else approach:");
        if (option.equals("A")) {
            logger.info("  Option A selected");
        } else if (option.equals("B")) {
            logger.info("  Option B selected");
        } else if (option.equals("C")) {
            logger.info("  Option C selected");
        } else {
            logger.info("  Invalid option");
        }

        // Using switch (cleaner for this case)
        logger.info("\nSwitch approach:");
        switch (option) {
            case "A" -> logger.info("  Option A selected");
            case "B" -> logger.info("  Option B selected");
            case "C" -> logger.info("  Option C selected");
            default -> logger.info("  Invalid option");
        }

        logger.info("\n✓ Switch is cleaner when checking same variable");
        logger.info("✓ Use if-else for ranges or complex conditions");
    }

    /**
     * Helper method for HTTP status handling.
     */
    private static void handleHttpStatus(int status) {
        String message = switch (status / 100) {
            case 2 -> "Success";
            case 3 -> "Redirection";
            case 4 -> "Client Error";
            case 5 -> "Server Error";
            default -> "Unknown Status";
        };

        logger.info("HTTP {}: {}", status, message);
    }

    /**
     * Helper method for calculator operations.
     */
    private static double calculate(double a, double b, char operator) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (b != 0) ? a / b : 0;
            default -> {
                logger.error("Invalid operator: {}", operator);
                yield 0;
            }
        };
    }

    /**
     * Helper method for permission checking.
     */
    private static void checkPermissions(UserRole role) {
        String permissions = switch (role) {
            case ADMIN -> "Full access";
            case MODERATOR -> "Read and edit";
            case USER -> "Read only";
            case GUEST -> "Limited access";
        };

        logger.info("Role {}: {}", role, permissions);
    }

    /**
     * Enum for days of the week.
     */
    private enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    /**
     * Enum for user roles.
     */
    private enum UserRole {
        ADMIN, MODERATOR, USER, GUEST
    }
}
