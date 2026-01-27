package com.andres.functions.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates variable arguments (varargs) in Java.
 *
 * <p>
 * <strong>What are Varargs?</strong>
 * </p>
 * <p>
 * Varargs (variable-length arguments) allow a method to accept zero or more
 * arguments of a specified type. Introduced in Java 5, varargs provide
 * flexibility
 * when the number of arguments is unknown at compile time.
 * </p>
 *
 * <p>
 * <strong>Varargs Syntax:</strong>
 * </p>
 *
 * <pre>
 * returnType methodName(Type... parameterName) {
 *     // parameterName is treated as an array of Type
 * }
 * </pre>
 *
 * <p>
 * <strong>Varargs Rules:</strong>
 * </p>
 * <ul>
 * <li>Only one varargs parameter allowed per method</li>
 * <li>Varargs parameter must be the last parameter</li>
 * <li>Internally treated as an array</li>
 * <li>Can be called with 0, 1, or more arguments</li>
 * <li>Can pass an array directly</li>
 * </ul>
 *
 * <p>
 * <strong>When to Use Varargs:</strong>
 * </p>
 * <ul>
 * <li>Number of arguments is unknown or variable</li>
 * <li>Creating flexible utility methods (sum, max, min, format)</li>
 * <li>Builder-style APIs</li>
 * <li>Methods that naturally accept collections of similar items</li>
 * <li>Simplifying method calls (avoid creating arrays explicitly)</li>
 * </ul>
 *
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Fixed number of parameters is known (use regular parameters)</li>
 * <li>Different types of parameters needed (use multiple parameters or
 * objects)</li>
 * <li>Performance-critical code (varargs has slight overhead)</li>
 * <li>When method logic requires specific parameter count</li>
 * </ul>
 *
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Mathematical operations: sum(), max(), min(), average()</li>
 * <li>String manipulation: concatenate(), format(), join()</li>
 * <li>Collection creation: List.of(), Set.of() (Java 9+)</li>
 * <li>Logging frameworks: printf-style formatting</li>
 * <li>Testing: assertEquals() with multiple expected values</li>
 * </ul>
 *
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Validate varargs length if minimum/maximum is required</li>
 * <li>Check for null and empty varargs when necessary</li>
 * <li>Use descriptive parameter names (values, items, elements)</li>
 * <li>Document expected usage in Javadoc</li>
 * <li>Consider defensive copying for mutable varargs</li>
 * <li>Prefer varargs over array parameters for public APIs</li>
 * </ul>
 *
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Forgetting varargs must be last parameter</li>
 * <li>Ambiguous overloading with varargs and arrays</li>
 * <li>Not handling empty varargs (length 0)</li>
 * <li>Heap pollution with generic varargs (type safety warnings)</li>
 * <li>Assuming varargs always has at least one element</li>
 * </ul>
 *
 * @author Andrés
 * @version 1.0
 */
public final class VariableArgumentsDemo {

    private static final Logger logger = LoggerFactory.getLogger(VariableArgumentsDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private VariableArgumentsDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates variable arguments (varargs) usage.
     */
    public static void demonstrate() {
        logger.info("--- Variable Arguments (Varargs) ---\n");

        demonstrateBasicVarargs();
        demonstrateVarargsAsArray();
        demonstrateVarargsWithOtherParameters();
        demonstrateEmptyVarargs();
        demonstrateVarargsVsArray();
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates basic varargs usage with different argument counts.
     */
    private static void demonstrateBasicVarargs() {
        logger.info("--- Basic Varargs Usage ---");

        logger.info("Calling sum() with different number of arguments:\n");

        // 0 arguments
        int result0 = sum();
        logger.info("sum() = {} (zero arguments)", result0);

        // 1 argument
        int result1 = sum(5);
        logger.info("sum(5) = {} (one argument)", result1);

        // 3 arguments
        int result3 = sum(5, 10, 15);
        logger.info("sum(5, 10, 15) = {} (three arguments)", result3);

        // 5 arguments
        int result5 = sum(1, 2, 3, 4, 5);
        logger.info("sum(1, 2, 3, 4, 5) = {} (five arguments)", result5);

        logger.info("\nVarargs accepts 0 or more arguments");
    }

    /**
     * Demonstrates that varargs is treated as an array internally.
     */
    private static void demonstrateVarargsAsArray() {
        logger.info("\n--- Varargs as Array Internally ---");

        logger.info("Accessing varargs elements like array:\n");

        // Call method that shows array behavior
        processNumbers(10, 20, 30, 40, 50);

        logger.info("\nVarargs parameter is actually an array inside the method");
    }

    /**
     * Demonstrates varargs combined with regular parameters.
     */
    private static void demonstrateVarargsWithOtherParameters() {
        logger.info("\n--- Varargs with Other Parameters ---");

        logger.info("Varargs must be the LAST parameter\n");

        // Regular parameter + varargs
        String result1 = join(", ", "Apple", "Banana", "Cherry");
        logger.info("join(\", \", \"Apple\", \"Banana\", \"Cherry\") = \"{}\"", result1);

        String result2 = join(" - ", "Java", "Python", "JavaScript", "C++");
        logger.info("join(\" - \", \"Java\", \"Python\", \"JavaScript\", \"C++\") = \"{}\"", result2);

        // Multiple regular parameters + varargs
        String result3 = formatList("Languages", ": ", "Java", "Python", "C++");
        logger.info("formatList(\"Languages\", \": \", ...) = \"{}\"", result3);
    }

    /**
     * Demonstrates handling empty varargs (zero arguments).
     */
    private static void demonstrateEmptyVarargs() {
        logger.info("\n--- Empty Varargs (Zero Arguments) ---");

        logger.info("Methods must handle the case of zero arguments:\n");

        // Empty varargs
        int maxEmpty = max();
        logger.info("max() with no arguments = {} (returns Integer.MIN_VALUE as default)", maxEmpty);

        // One argument
        int max1 = max(42);
        logger.info("max(42) with one argument = {}", max1);

        // Multiple arguments
        int maxMultiple = max(15, 42, 8, 23, 37);
        logger.info("max(15, 42, 8, 23, 37) = {}", maxMultiple);

        logger.info("\nAlways validate varargs length when necessary");
    }

    /**
     * Demonstrates varargs vs explicit array parameter.
     */
    private static void demonstrateVarargsVsArray() {
        logger.info("\n--- Varargs vs Array Parameter ---");

        logger.info("Varargs: Can call with individual arguments OR array");
        logger.info("Array: Must create array explicitly\n");

        // Varargs: flexible calling
        int varargsSum1 = sum(1, 2, 3, 4, 5);
        logger.info("Varargs - sum(1, 2, 3, 4, 5) = {}", varargsSum1);

        // Varargs: can also pass array
        int[] numbers = { 1, 2, 3, 4, 5 };
        int varargsSum2 = sum(numbers);
        logger.info("Varargs - sum(array) = {}", varargsSum2);

        // Array parameter: must create array
        int arraySum = sumArray(numbers);
        logger.info("Array parameter - sumArray(array) = {}", arraySum);

        logger.info("\nVarargs is more flexible for callers");
    }

    /**
     * Demonstrates real-world varargs applications.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Varargs Examples ---");

        // Example 1: Statistical calculations
        logger.info("Example 1: Calculate average of grades");
        double avg = average(85, 92, 78, 88, 95);
        logger.info("average(85, 92, 78, 88, 95) = {}", String.format("%.2f", avg));

        // Example 2: Finding extremes
        logger.info("\nExample 2: Find minimum value");
        int minimum = min(45, 12, 78, 23, 8, 56);
        logger.info("min(45, 12, 78, 23, 8, 56) = {}", minimum);

        // Example 3: String concatenation
        logger.info("\nExample 3: Concatenate strings");
        String concat = concatenate("Hello", " ", "World", "!", " ", "Java", " ", "Rocks");
        logger.info("concatenate(...) = \"{}\"", concat);

        // Example 4: Building lists
        logger.info("\nExample 4: Create comma-separated list");
        String list = toCommaSeparatedString("Java", "Python", "JavaScript", "C++", "Go");
        logger.info("toCommaSeparatedString(...) = \"{}\"", list);

        // Example 5: Multiple of same value
        logger.info("\nExample 5: Check if number is multiple of any");
        boolean isMultiple1 = isMultipleOfAny(15, 2, 3, 5);
        logger.info("isMultipleOfAny(15, 2, 3, 5) = {} (15 is multiple of 3 and 5)", isMultiple1);

        boolean isMultiple2 = isMultipleOfAny(17, 2, 3, 5);
        logger.info("isMultipleOfAny(17, 2, 3, 5) = {} (17 is not multiple of any)", isMultiple2);
    }

    // ========== Varargs Methods ==========

    /**
     * Sums any number of integers using varargs.
     *
     * @param numbers Variable number of integers
     * @return Sum of all numbers (0 if no arguments)
     */
    private static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    /**
     * Processes numbers and shows array-like access.
     *
     * @param numbers Variable number of integers
     */
    private static void processNumbers(int... numbers) {
        logger.info("Total arguments: {}", numbers.length);
        logger.info("Accessing elements:");
        for (int i = 0; i < numbers.length; i++) {
            logger.info("  numbers[{}] = {}", i, numbers[i]);
        }
    }

    /**
     * Joins strings with a separator (regular param + varargs).
     *
     * @param separator String to place between items
     * @param items     Variable number of strings to join
     * @return Joined string
     */
    private static String join(String separator, String... items) {
        if (items.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder(items[0]);
        for (int i = 1; i < items.length; i++) {
            result.append(separator).append(items[i]);
        }
        return result.toString();
    }

    /**
     * Formats a list with prefix and separator.
     *
     * @param prefix    List prefix
     * @param separator Item separator
     * @param items     Variable number of items
     * @return Formatted list string
     */
    private static String formatList(String prefix, String separator, String... items) {
        return prefix + separator + join(", ", items);
    }

    /**
     * Finds maximum value from varargs (handles empty case).
     *
     * @param numbers Variable number of integers
     * @return Maximum value, or Integer.MIN_VALUE if no arguments
     */
    private static int max(int... numbers) {
        if (numbers.length == 0) {
            return Integer.MIN_VALUE; // Default for empty
        }

        int maximum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maximum) {
                maximum = numbers[i];
            }
        }
        return maximum;
    }

    /**
     * Sums array elements (for comparison with varargs).
     *
     * @param numbers Array of integers
     * @return Sum of array elements
     */
    private static int sumArray(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    /**
     * Calculates average of numbers.
     *
     * @param numbers Variable number of numbers
     * @return Average, or 0.0 if no numbers
     */
    private static double average(int... numbers) {
        if (numbers.length == 0) {
            return 0.0;
        }
        return (double) sum(numbers) / numbers.length;
    }

    /**
     * Finds minimum value.
     *
     * @param numbers Variable number of integers
     * @return Minimum value, or Integer.MAX_VALUE if no arguments
     */
    private static int min(int... numbers) {
        if (numbers.length == 0) {
            return Integer.MAX_VALUE;
        }

        int minimum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minimum) {
                minimum = numbers[i];
            }
        }
        return minimum;
    }

    /**
     * Concatenates strings.
     *
     * @param strings Variable number of strings
     * @return Concatenated string
     */
    private static String concatenate(String... strings) {
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }

    /**
     * Creates comma-separated string from items.
     *
     * @param items Variable number of string items
     * @return Comma-separated string
     */
    private static String toCommaSeparatedString(String... items) {
        return join(", ", items);
    }

    /**
     * Checks if number is multiple of any of the divisors.
     *
     * @param number   Number to check
     * @param divisors Variable number of potential divisors
     * @return true if number is multiple of at least one divisor
     */
    private static boolean isMultipleOfAny(int number, int... divisors) {
        for (int divisor : divisors) {
            if (divisor != 0 && number % divisor == 0) {
                return true;
            }
        }
        return false;
    }
}
