package com.andres.datatypes.primitive.bool;

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

    /**
     * Private constructor to prevent instantiation.
     */
    private BooleanTypeDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    // ========== Basic Logical Operations ==========

    /**
     * Performs logical AND operation.
     *
     * @param a First boolean operand
     * @param b Second boolean operand
     * @return true if both a and b are true
     */
    public static boolean and(boolean a, boolean b) {
        return a && b;  // Logical AND - true only if both are true
    }

    /**
     * Performs logical OR operation.
     *
     * @param a First boolean operand
     * @param b Second boolean operand
     * @return true if at least one of a or b is true
     */
    public static boolean or(boolean a, boolean b) {
        return a || b;  // Logical OR - true if at least one is true
    }

    /**
     * Performs logical NOT operation.
     *
     * @param value Boolean value to negate
     * @return Inverted boolean value
     */
    public static boolean not(boolean value) {
        return !value;  // Logical NOT - inverts the value
    }

    /**
     * Performs logical XOR (exclusive OR) operation.
     *
     * @param a First boolean operand
     * @param b Second boolean operand
     * @return true if exactly one of a or b is true (not both)
     */
    public static boolean xor(boolean a, boolean b) {
        return a ^ b;  // Logical XOR - true if values differ
    }

    // ========== Comparison Operations ==========

    /**
     * Checks if first value is greater than second.
     *
     * @param a First value
     * @param b Second value
     * @return true if a > b
     */
    public static boolean isGreater(int a, int b) {
        return a > b;
    }

    /**
     * Checks if first value is less than second.
     *
     * @param a First value
     * @param b Second value
     * @return true if a < b
     */
    public static boolean isLess(int a, int b) {
        return a < b;
    }

    /**
     * Checks if two values are equal.
     *
     * @param a First value
     * @param b Second value
     * @return true if a equals b
     */
    public static boolean areEqual(int a, int b) {
        return a == b;
    }

    /**
     * Checks if value is within specified range (inclusive).
     *
     * @param value Value to check
     * @param min   Minimum value (inclusive)
     * @param max   Maximum value (inclusive)
     * @return true if value is between min and max
     */
    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    // ========== Real-World Examples ==========

    /**
     * Safely checks if string is non-empty using short-circuit evaluation.
     * <p>
     * Short-circuit: if text is null, length() is never called,
     * preventing NullPointerException.
     * </p>
     *
     * @param text String to check
     * @return true if text is not null and has length > 0
     */
    public static boolean isNonEmptyString(String text) {
        // Short-circuit: if text is null, length() is never evaluated
        return (text != null) && (text.length() > 0);
    }

    /**
     * Checks if user can access a resource (authorization example).
     * <p>
     * Both conditions must be true: user must be authenticated AND have permission.
     * </p>
     *
     * @param isAuthenticated Whether user is authenticated
     * @param hasPermission   Whether user has required permission
     * @return true if user can access the resource
     */
    public static boolean canAccessResource(boolean isAuthenticated, boolean hasPermission) {
        return isAuthenticated && hasPermission;  // Both required
    }

    /**
     * Validates if age is within valid human age range.
     *
     * @param age Age to validate
     * @return true if age is between 0 and 150
     */
    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 150;
    }

    /**
     * Checks if password meets minimum strength requirements.
     * <p>
     * Requirement: password must be at least 8 characters long.
     * </p>
     *
     * @param password Password to validate
     * @return true if password meets requirements
     */
    public static boolean isPasswordStrong(String password) {
        return password != null && password.length() >= 8;
    }

    // ========== Anti-Pattern Demonstration ==========

    /**
     * Demonstrates correct and incorrect boolean usage patterns.
     * <p>
     * <strong>Anti-patterns to avoid:</strong>
     * </p>
     * <ul>
     * <li>{@code if (flag == true)} - redundant, just use {@code if (flag)}</li>
     * <li>{@code return flag ? true : false} - redundant, just use {@code return flag}</li>
     * <li>{@code if (flag) return true; else return false;} - use direct return</li>
     * </ul>
     *
     * @param flag Boolean value to check
     * @return The flag value directly
     */
    public static boolean checkCondition(boolean flag) {
        // GOOD: Direct use in condition
        if (flag) {
            // Do something when flag is true
        }

        // BAD: Redundant comparison (anti-pattern)
        // if (flag == true) { ... }  // Avoid this!

        // GOOD: Direct return
        return flag;

        // BAD: Unnecessary ternary (anti-pattern)
        // return flag ? true : false;  // Just return flag!

        // BAD: Unnecessary if-else (anti-pattern)
        // if (flag) {
        //     return true;
        // } else {
        //     return false;
        // }
    }
}
