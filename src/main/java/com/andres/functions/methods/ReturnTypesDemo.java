package com.andres.functions.methods;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates return types and return value handling in Java.
 *
 * <p>
 * <strong>Return Types in Java:</strong>
 * </p>
 * <p>
 * Methods can return a value to the caller, or return nothing (void). The
 * return
 * type must be declared in the method signature and determines what kind of
 * value
 * the method produces.
 * </p>
 *
 * <p>
 * <strong>Available Return Types:</strong>
 * </p>
 * <ul>
 * <li><strong>void:</strong> Method performs action but returns nothing</li>
 * <li><strong>Primitives:</strong> int, double, boolean, char, etc.</li>
 * <li><strong>Objects:</strong> String, arrays, collections, custom
 * objects</li>
 * <li><strong>null:</strong> Can be returned for object types (not
 * primitives)</li>
 * </ul>
 *
 * <p>
 * <strong>When to Use Each Return Type:</strong>
 * </p>
 * <ul>
 * <li><strong>void:</strong> Methods that perform actions (logging, updating
 * state)</li>
 * <li><strong>boolean:</strong> Validation, existence checks, comparisons</li>
 * <li><strong>int/double:</strong> Calculations, counts, measurements</li>
 * <li><strong>String:</strong> Text formatting, concatenation, conversion</li>
 * <li><strong>Collections:</strong> Filtering, mapping, aggregating data</li>
 * <li><strong>null:</strong> Indicating "not found" or "not applicable"
 * (use cautiously)</li>
 * </ul>
 *
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Returning null without clear documentation (causes
 * NullPointerException)</li>
 * <li>Using objects for simple primitive operations</li>
 * <li>Returning mutable objects when immutability is desired</li>
 * </ul>
 *
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Data transformations: converting input to output</li>
 * <li>Queries: retrieving or computing values</li>
 * <li>Validations: checking conditions and returning status</li>
 * <li>Collection operations: filtering, mapping, reducing</li>
 * <li>Factory methods: creating and returning new objects</li>
 * </ul>
 *
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Be consistent with return types across similar methods</li>
 * <li>Document null return possibilities in Javadoc</li>
 * <li>Use early returns for guard clauses and validation</li>
 * <li>Return empty collections instead of null when possible</li>
 * <li>Consider Optional for methods that might not have a result (Java 8+)</li>
 * <li>Ensure all code paths return appropriate values</li>
 * </ul>
 *
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Forgetting return statement in non-void methods</li>
 * <li>Returning null without null checks in caller</li>
 * <li>Inconsistent return types in conditional branches</li>
 * <li>Not documenting what null means in context</li>
 * <li>Returning references to mutable internal state</li>
 * </ul>
 *
 * @author Andrés
 * @version 1.0
 */
public final class ReturnTypesDemo {

    private static final Logger logger = LoggerFactory.getLogger(ReturnTypesDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private ReturnTypesDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates various return types and their usage.
     */
    public static void demonstrate() {
        logger.info("--- Return Types ---\n");

        demonstrateVoidReturns();
        demonstratePrimitiveReturns();
        demonstrateObjectReturns();
        demonstrateNullReturns();
        demonstrateEarlyReturns();
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates void return type (no return value).
     */
    private static void demonstrateVoidReturns() {
        logger.info("--- Void Return Type ---");
        logger.info("Methods that perform actions without returning values\n");

        logger.info("Example 1: Logging action");
        logMessage("This is a log message");

        logger.info("\nExample 2: Display formatting");
        printSeparator(30);

        logger.info("\nvoid methods are used for:");
        logger.info("• Printing/logging output");
        logger.info("• Updating state or data");
        logger.info("• Performing side effects");
    }

    /**
     * Demonstrates primitive return types.
     */
    private static void demonstratePrimitiveReturns() {
        logger.info("\n--- Primitive Return Types ---");

        // int return
        int sum = add(15, 27);
        logger.info("int - add(15, 27) = {}", sum);

        // double return
        double average = calculateAverage(10, 20, 30, 40, 50);
        logger.info("double - average of [10,20,30,40,50] = {}", String.format("%.2f", average));

        // boolean return
        boolean isEven = isEven(42);
        logger.info("boolean - isEven(42) = {}", isEven);

        // char return
        char grade = getLetterGrade(87);
        logger.info("char - getLetterGrade(87) = '{}'", grade);

        // long return
        long factorial = calculateFactorial(10);
        logger.info("long - factorial(10) = {}", factorial);
    }

    /**
     * Demonstrates object return types.
     */
    private static void demonstrateObjectReturns() {
        logger.info("\n--- Object Return Types ---");

        // String return
        String formatted = formatFullName("John", "Doe");
        logger.info("String - formatFullName(\"John\", \"Doe\") = \"{}\"", formatted);

        // Array return
        int[] evenNumbers = getEvenNumbers(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        logger.info("Array - getEvenNumbers(...) = {}", arrayToString(evenNumbers));

        // List return
        List<Integer> sequence = generateSequence(1, 5);
        logger.info("List - generateSequence(1, 5) = {}", sequence);

        // Custom class return (simulated with String)
        String result = createResult("Success", 200);
        logger.info("Object - createResult(...) = \"{}\"", result);
    }

    /**
     * Demonstrates null return handling.
     */
    private static void demonstrateNullReturns() {
        logger.info("\n--- Null Returns ---");

        logger.info("Searching for existing value:");
        Integer found = findValue(new int[] { 10, 20, 30 }, 20);
        logger.info("findValue([10,20,30], 20) = {}", found);

        logger.info("\nSearching for non-existing value:");
        Integer notFound = findValue(new int[] { 10, 20, 30 }, 99);
        logger.info("findValue([10,20,30], 99) = {} (null means not found)", notFound);

        logger.info("\nDanger: Always check for null before using!");
        if (notFound != null) {
            logger.info("Value: {}", notFound);
        } else {
            logger.info("Value not found - avoided NullPointerException");
        }

        logger.info("\nBetter alternative: Return empty collection instead of null");
        List<Integer> emptyList = getFilteredList(new int[] { 1, 2, 3 }, 100);
        logger.info("Empty result: {} (size: {})", emptyList, emptyList.size());
    }

    /**
     * Demonstrates early returns and guard clauses.
     */
    private static void demonstrateEarlyReturns() {
        logger.info("\n--- Early Returns (Guard Clauses) ---");

        logger.info("Early returns improve readability by handling edge cases first\n");

        logger.info("Example 1: Validation with early return");
        String result1 = validateAndProcess("valid_input");
        logger.info("validateAndProcess(\"valid_input\") = \"{}\"", result1);

        String result2 = validateAndProcess("");
        logger.info("validateAndProcess(\"\") = \"{}\"", result2);

        logger.info("\nExample 2: Multiple conditions");
        int result3 = calculateDiscount(150, "PREMIUM");
        logger.info("calculateDiscount(150, \"PREMIUM\") = {}%", result3);

        int result4 = calculateDiscount(50, "REGULAR");
        logger.info("calculateDiscount(50, \"REGULAR\") = {}%", result4);
    }

    /**
     * Demonstrates real-world return type scenarios.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Validation
        logger.info("Example 1: Password validation");
        boolean isValid = validatePassword("SecurePass123!");
        logger.info("validatePassword(\"SecurePass123!\") = {}", isValid);

        // Example 2: Data extraction
        logger.info("\nExample 2: Email domain extraction");
        String domain = extractDomain("user@example.com");
        logger.info("extractDomain(\"user@example.com\") = \"{}\"", domain);

        // Example 3: Mathematical calculation
        logger.info("\nExample 3: Find maximum value");
        int max = findMax(new int[] { 45, 12, 78, 23, 89, 34 });
        logger.info("findMax([45, 12, 78, 23, 89, 34]) = {}", max);

        // Example 4: Collection filtering
        logger.info("\nExample 4: Get passing scores");
        int[] scores = { 45, 78, 92, 55, 88, 41, 95 };
        int[] passingScores = getPassingScores(scores, 60);
        logger.info("getPassingScores (threshold 60): {}", arrayToString(passingScores));
    }

    // ========== Helper Methods ==========

    /**
     * Void method - logs a message.
     */
    private static void logMessage(String message) {
        logger.info("  [LOG] {}", message);
    }

    /**
     * Void method - prints a separator line.
     */
    private static void printSeparator(int length) {
        logger.info("  {}", "-".repeat(length));
    }

    /**
     * Returns sum of two integers.
     */
    private static int add(int a, int b) {
        return a + b;
    }

    /**
     * Returns average of integers.
     */
    private static double calculateAverage(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }

    /**
     * Returns true if number is even.
     */
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Returns letter grade based on score.
     */
    private static char getLetterGrade(int score) {
        if (score >= 90)
            return 'A';
        if (score >= 80)
            return 'B';
        if (score >= 70)
            return 'C';
        if (score >= 60)
            return 'D';
        return 'F';
    }

    /**
     * Returns factorial of n.
     */
    private static long calculateFactorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Returns formatted full name.
     */
    private static String formatFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    /**
     * Returns array of even numbers.
     */
    private static int[] getEvenNumbers(int[] numbers) {
        List<Integer> evens = new ArrayList<>();
        for (int num : numbers) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        int[] result = new int[evens.size()];
        for (int i = 0; i < evens.size(); i++) {
            result[i] = evens.get(i);
        }
        return result;
    }

    /**
     * Returns list of integers from start to end.
     */
    private static List<Integer> generateSequence(int start, int end) {
        List<Integer> sequence = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            sequence.add(i);
        }
        return sequence;
    }

    /**
     * Returns simulated result object.
     */
    private static String createResult(String status, int code) {
        return String.format("Result{status='%s', code=%d}", status, code);
    }

    /**
     * Returns value if found, null otherwise.
     */
    private static Integer findValue(int[] array, int target) {
        for (int value : array) {
            if (value == target) {
                return value;
            }
        }
        return null; // Not found
    }

    /**
     * Returns filtered list (never null, may be empty).
     */
    private static List<Integer> getFilteredList(int[] array, int threshold) {
        List<Integer> result = new ArrayList<>();
        for (int value : array) {
            if (value >= threshold) {
                result.add(value);
            }
        }
        return result; // Empty list if no matches
    }

    /**
     * Validates input and processes (early return pattern).
     */
    private static String validateAndProcess(String input) {
        // Guard clause: early return on invalid input
        if (input == null || input.isEmpty()) {
            return "Error: Invalid input";
        }

        // Main processing logic
        return "Processed: " + input.toUpperCase();
    }

    /**
     * Calculates discount based on amount and customer type.
     */
    private static int calculateDiscount(int amount, String customerType) {
        // Guard clause: minimum amount
        if (amount < 100) {
            return 0;
        }

        // Different discounts for customer types
        if ("PREMIUM".equals(customerType)) {
            return 20;
        }

        return 10; // Default discount
    }

    /**
     * Validates password strength.
     */
    private static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        return password.matches(".*[A-Z].*") && password.matches(".*[0-9].*");
    }

    /**
     * Extracts domain from email address.
     */
    private static String extractDomain(String email) {
        if (email == null || !email.contains("@")) {
            return "";
        }
        return email.substring(email.indexOf('@') + 1);
    }

    /**
     * Finds maximum value in array.
     */
    private static int findMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    /**
     * Returns scores above threshold.
     */
    private static int[] getPassingScores(int[] scores, int threshold) {
        List<Integer> passing = new ArrayList<>();
        for (int score : scores) {
            if (score >= threshold) {
                passing.add(score);
            }
        }
        int[] result = new int[passing.size()];
        for (int i = 0; i < passing.size(); i++) {
            result[i] = passing.get(i);
        }
        return result;
    }

    /**
     * Converts array to string representation.
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
