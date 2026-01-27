package com.andres.functions.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates recursion fundamentals in Java.
 *
 * <p>
 * <strong>What is Recursion?</strong>
 * </p>
 * <p>
 * Recursion is a programming technique where a method calls itself to solve a
 * problem.
 * The problem is broken down into smaller sub-problems of the same type, and
 * the
 * solution is built up from the solutions to these sub-problems.
 * </p>
 *
 * <p>
 * <strong>Essential Components of Recursion:</strong>
 * </p>
 * <ul>
 * <li><strong>Base Case:</strong> The terminating condition that stops
 * recursion</li>
 * <li><strong>Recursive Case:</strong> The method calling itself with a simpler
 * input</li>
 * <li><strong>Progress:</strong> Each recursive call must move toward the base
 * case</li>
 * </ul>
 *
 * <p>
 * <strong>Recursion Pattern:</strong>
 * </p>
 *
 * <pre>
 * returnType recursiveMethod(parameters) {
 *     // Base case - stops recursion
 *     if (baseCondition) {
 *         return baseValue;
 *     }
 *
 *     // Recursive case - calls itself with simpler problem
 *     return someOperation(recursiveMethod(simplifiedParameters));
 * }
 * </pre>
 *
 * <p>
 * <strong>When to Use Recursion:</strong>
 * </p>
 * <ul>
 * <li>Problems with naturally recursive structure (trees, graphs)</li>
 * <li>Divide-and-conquer algorithms (binary search, merge sort)</li>
 * <li>Mathematical definitions (factorial, fibonacci, exponents)</li>
 * <li>Backtracking problems (maze solving, puzzle solving)</li>
 * <li>When recursive solution is more intuitive than iterative</li>
 * </ul>
 *
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Simple iteration suffices (basic loops)</li>
 * <li>Deep recursion risk (stack overflow for large inputs)</li>
 * <li>Performance critical code (recursion has overhead)</li>
 * <li>When iterative solution is simpler and clearer</li>
 * </ul>
 *
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>File system traversal (directory trees)</li>
 * <li>Tree and graph algorithms</li>
 * <li>Parsing expressions and grammars</li>
 * <li>Mathematical computations (GCD, exponentiation)</li>
 * <li>Divide-and-conquer algorithms</li>
 * </ul>
 *
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Always define clear base case(s) first</li>
 * <li>Ensure each recursive call progresses toward base case</li>
 * <li>Validate inputs to prevent infinite recursion</li>
 * <li>Consider iteration for simple problems</li>
 * <li>Be aware of stack depth limitations (typically ~1000-10000 calls)</li>
 * <li>Document time/space complexity in Javadoc</li>
 * <li>Use tail recursion when possible (though Java doesn't optimize it)</li>
 * </ul>
 *
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Missing or incorrect base case (infinite recursion →
 * StackOverflowError)</li>
 * <li>No progress toward base case (infinite recursion)</li>
 * <li>Stack overflow with large inputs</li>
 * <li>Inefficient algorithms (exponential time in naive fibonacci)</li>
 * <li>Not considering iterative alternatives</li>
 * <li>Forgetting to return recursive call result</li>
 * </ul>
 *
 * @author Andrés
 * @version 1.0
 */
public final class RecursionBasicsDemo {

    private static final Logger logger = LoggerFactory.getLogger(RecursionBasicsDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private RecursionBasicsDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates recursion basics and fundamental concepts.
     */
    public static void demonstrate() {
        logger.info("--- Recursion Basics ---\n");

        demonstrateBasicRecursion();
        demonstrateBaseCase();
        demonstrateRecursiveCase();
        demonstrateCallStackConcept();
        demonstrateStackOverflowWarning();
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates basic recursion with countdown example.
     */
    private static void demonstrateBasicRecursion() {
        logger.info("--- Basic Recursion: Countdown ---");

        logger.info("Counting down from 5:");
        countdown(5);

        logger.info("\nRecursion Structure:");
        logger.info("1. Method calls itself");
        logger.info("2. Each call has smaller problem (n-1)");
        logger.info("3. Base case stops recursion (n <= 0)");
    }

    /**
     * Demonstrates the critical importance of base cases.
     */
    private static void demonstrateBaseCase() {
        logger.info("\n--- Base Case Importance ---");

        logger.info("Base case is the termination condition.");
        logger.info("Without it: infinite recursion → StackOverflowError");

        logger.info("\nExample: factorial(n)");
        logger.info("Base case: if (n <= 1) return 1;");
        logger.info("Without base case: factorial(5) → factorial(4) → factorial(3) → ... → CRASH");

        // Demonstrate with factorial
        int result = factorial(5);
        logger.info("\nfactorial(5) = {}", result);
        logger.info("This worked because base case (n <= 1) stopped recursion");
    }

    /**
     * Demonstrates recursive case and progress toward base case.
     */
    private static void demonstrateRecursiveCase() {
        logger.info("\n--- Recursive Case ---");

        logger.info("Recursive case must:");
        logger.info("1. Call the method itself");
        logger.info("2. Use a SIMPLER input (progress toward base case)");
        logger.info("3. Combine recursive result to solve current problem");

        logger.info("\nExample: sum(n) = n + sum(n-1)");
        int sum = sum(5);
        logger.info("sum(5) = 5 + sum(4) = 5 + 4 + 3 + 2 + 1 = {}", sum);
    }

    /**
     * Demonstrates call stack concept in recursion.
     */
    private static void demonstrateCallStackConcept() {
        logger.info("\n--- Call Stack Visualization ---");

        logger.info("Recursion uses the call stack:");
        logger.info("Each method call is 'pushed' onto stack");
        logger.info("Returns 'pop' from stack (LIFO - Last In First Out)");

        logger.info("\nTracing factorial(4):");
        int result = factorialWithTrace(4, 0);
        logger.info("Final result: {}", result);

        logger.info("\nCall stack grew to depth 4, then unwound");
    }

    /**
     * Warns about stack overflow and infinite recursion.
     */
    private static void demonstrateStackOverflowWarning() {
        logger.info("\n--- Stack Overflow Warning ---");

        logger.info("Java call stack has limited size (typically ~1000-10000 calls)");
        logger.info("Deep recursion can cause StackOverflowError");

        logger.info("\nDangers:");
        logger.info("1. Missing base case → infinite recursion");
        logger.info("2. Base case never reached → infinite recursion");
        logger.info("3. Input too large → stack overflow even with correct logic");

        logger.info("\nPrevention:");
        logger.info("• Always validate inputs");
        logger.info("• Test with large inputs");
        logger.info("• Consider iteration for deep recursion");
        logger.info("• Use tail recursion when possible (easier to optimize)");

        logger.warn("\nNote: We won't trigger actual StackOverflowError in this demo");
    }

    /**
     * Demonstrates classic recursive examples.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Recursive Examples ---");

        // Factorial
        logger.info("Example 1: Factorial");
        logger.info("factorial(5) = 5! = 5 × 4 × 3 × 2 × 1 = {}", factorial(5));

        // Power
        logger.info("\nExample 2: Exponentiation");
        logger.info("power(2, 3) = 2³ = 2 × 2 × 2 = {}", power(2, 3));

        // Sum
        logger.info("\nExample 3: Sum of 1 to n");
        logger.info("sum(10) = 1 + 2 + ... + 10 = {}", sum(10));

        // Fibonacci
        logger.info("\nExample 4: Fibonacci (introduction)");
        logger.info("fibonacci(6) = {}", fibonacci(6));
        logger.info("Note: Naive fibonacci is inefficient (exponential time)");
        logger.info("Better approaches exist (will cover in RecursionPatternsDemo)");

        // String reversal
        logger.info("\nExample 5: String Reversal");
        String original = "Hello";
        String reversed = reverseString(original);
        logger.info("reverseString(\"{}\") = \"{}\"", original, reversed);

        // Count digits
        logger.info("\nExample 6: Count Digits");
        int number = 12345;
        int digitCount = countDigits(number);
        logger.info("countDigits({}) = {}", number, digitCount);
    }

    // ========== Recursive Helper Methods ==========

    /**
     * Recursive countdown from n to 1.
     *
     * @param n Starting number
     */
    private static void countdown(int n) {
        // Base case: stop when n reaches 0
        if (n <= 0) {
            logger.info("  Liftoff!");
            return;
        }

        // Recursive case: print and call with n-1
        logger.info("  {}", n);
        countdown(n - 1);
    }

    /**
     * Calculates factorial of n recursively.
     * Time complexity: O(n)
     * Space complexity: O(n) due to call stack
     *
     * @param n Non-negative integer
     * @return n! (factorial of n)
     */
    private static int factorial(int n) {
        // Base case
        if (n <= 1) {
            return 1;
        }

        // Recursive case: n! = n × (n-1)!
        return n * factorial(n - 1);
    }

    /**
     * Calculates sum of integers from 1 to n.
     * Time complexity: O(n)
     * Space complexity: O(n) due to call stack
     *
     * @param n Upper bound
     * @return Sum of 1 to n
     */
    private static int sum(int n) {
        // Base case
        if (n <= 0) {
            return 0;
        }

        // Recursive case: sum(n) = n + sum(n-1)
        return n + sum(n - 1);
    }

    /**
     * Calculates base raised to exponent power.
     * Time complexity: O(exponent)
     * Space complexity: O(exponent) due to call stack
     *
     * @param base     The base number
     * @param exponent The exponent (non-negative)
     * @return base^exponent
     */
    private static int power(int base, int exponent) {
        // Base case
        if (exponent == 0) {
            return 1;
        }

        // Recursive case: base^exp = base × base^(exp-1)
        return base * power(base, exponent - 1);
    }

    /**
     * Calculates nth Fibonacci number (naive approach).
     * Time complexity: O(2^n) - exponential!
     * Space complexity: O(n) due to call stack depth
     *
     * @param n Position in Fibonacci sequence
     * @return nth Fibonacci number
     */
    private static int fibonacci(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }

        // Recursive case: fib(n) = fib(n-1) + fib(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Reverses a string recursively.
     * Time complexity: O(n)
     * Space complexity: O(n) due to call stack and string concatenation
     *
     * @param str The string to reverse
     * @return Reversed string
     */
    private static String reverseString(String str) {
        // Base case: empty or single character
        if (str == null || str.length() <= 1) {
            return str;
        }

        // Recursive case: last char + reverse of rest
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }

    /**
     * Counts digits in a number recursively.
     * Time complexity: O(log n) - number of digits
     * Space complexity: O(log n) due to call stack
     *
     * @param n The number (non-negative)
     * @return Number of digits
     */
    private static int countDigits(int n) {
        // Base case: single digit
        if (n < 10) {
            return 1;
        }

        // Recursive case: 1 + count of remaining digits
        return 1 + countDigits(n / 10);
    }

    /**
     * Factorial with trace logging to show call stack.
     *
     * @param n     Number to calculate factorial
     * @param depth Current recursion depth (for indentation)
     * @return n!
     */
    private static int factorialWithTrace(int n, int depth) {
        String indent = "  ".repeat(depth);
        logger.info("{}→ factorial({}) called", indent, n);

        if (n <= 1) {
            logger.info("{}← factorial({}) = 1 (base case)", indent, n);
            return 1;
        }

        int result = n * factorialWithTrace(n - 1, depth + 1);
        logger.info("{}← factorial({}) = {}", indent, n, result);
        return result;
    }
}
