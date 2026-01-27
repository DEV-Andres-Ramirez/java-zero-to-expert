package com.andres.functions.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates comparison between recursive and iterative solutions.
 *
 * <p>
 * <strong>Recursion vs Iteration:</strong>
 * </p>
 * <p>
 * Both recursion and iteration can solve the same problems, but each has
 * trade-offs
 * in terms of performance, readability, and maintainability. Understanding when
 * to
 * use each approach is a critical programming skill.
 * </p>
 *
 * <p>
 * <strong>Recursion Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Uses call stack for state management</li>
 * <li>More intuitive for naturally recursive problems</li>
 * <li>Space complexity: O(n) due to call stack</li>
 * <li>Overhead: function call cost per iteration</li>
 * <li>Risk: stack overflow for deep recursion</li>
 * </ul>
 *
 * <p>
 * <strong>Iteration Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Uses explicit loops (for, while)</li>
 * <li>More efficient (no function call overhead)</li>
 * <li>Space complexity: typically O(1)</li>
 * <li>No stack overflow risk</li>
 * <li>Can be less intuitive for tree/graph problems</li>
 * </ul>
 *
 * <p>
 * <strong>When to Use Recursion:</strong>
 * </p>
 * <ul>
 * <li>Problem has natural recursive structure (trees, graphs)</li>
 * <li>Divide-and-conquer algorithms (binary search, merge sort)</li>
 * <li>Backtracking problems (maze solving, N-queens)</li>
 * <li>When recursive solution is significantly clearer</li>
 * <li>Depth is guaranteed to be reasonable (no stack overflow risk)</li>
 * </ul>
 *
 * <p>
 * <strong>When to Use Iteration:</strong>
 * </p>
 * <ul>
 * <li>Simple sequential processing (sum, count, search)</li>
 * <li>Performance-critical code</li>
 * <li>Deep or unbounded recursion depth</li>
 * <li>When iterative solution is equally clear</li>
 * <li>Memory-constrained environments</li>
 * </ul>
 *
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Recursion: file system traversal, tree operations, parsing</li>
 * <li>Iteration: array processing, simple loops, large datasets</li>
 * <li>Hybrid: tree traversal with explicit stack (iterative DFS)</li>
 * </ul>
 *
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Default to iteration for simple problems</li>
 * <li>Use recursion when it significantly improves clarity</li>
 * <li>Profile performance for large inputs</li>
 * <li>Consider tail recursion for easier conversion to iteration</li>
 * <li>Document why recursion was chosen over iteration</li>
 * <li>Test both approaches with edge cases</li>
 * </ul>
 *
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Using recursion for trivial problems (unnecessary overhead)</li>
 * <li>Not considering stack overflow risk</li>
 * <li>Ignoring performance implications (naive fibonacci)</li>
 * <li>Converting recursion to iteration without understanding trade-offs</li>
 * </ul>
 *
 * @author Andrés
 * @version 1.0
 */
public final class RecursionVsIterationDemo {

    private static final Logger logger = LoggerFactory.getLogger(RecursionVsIterationDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private RecursionVsIterationDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates comparison between recursive and iterative approaches.
     */
    public static void demonstrate() {
        logger.info("--- Recursion vs Iteration ---\n");

        demonstrateFactorialComparison();
        demonstrateFibonacciComparison();
        demonstrateSumComparison();
        demonstrateArraySearchComparison();
        demonstratePerformanceConsiderations();
        demonstrateDecisionGuidelines();

        System.out.println();
    }

    /**
     * Compares recursive and iterative factorial implementations.
     */
    private static void demonstrateFactorialComparison() {
        logger.info("--- Factorial: Recursion vs Iteration ---");

        int n = 8;

        // Recursive approach
        long resultRecursive = factorialRecursive(n);
        logger.info("Recursive: factorial({}) = {}", n, resultRecursive);

        // Iterative approach
        long resultIterative = factorialIterative(n);
        logger.info("Iterative: factorial({}) = {}", n, resultIterative);

        logger.info("\nAnalysis:");
        logger.info("• Recursion: O(n) time, O(n) space (call stack)");
        logger.info("• Iteration: O(n) time, O(1) space");
        logger.info("• Winner: Iteration (more efficient, no stack risk)");
    }

    /**
     * Compares recursive and iterative fibonacci implementations.
     */
    private static void demonstrateFibonacciComparison() {
        logger.info("\n--- Fibonacci: Recursion vs Iteration ---");

        int n = 10;

        // Naive recursive (exponential time)
        long resultRecursive = fibonacciRecursive(n);
        logger.info("Recursive (naive): fibonacci({}) = {}", n, resultRecursive);

        // Iterative (linear time)
        long resultIterative = fibonacciIterative(n);
        logger.info("Iterative: fibonacci({}) = {}", n, resultIterative);

        logger.info("\nAnalysis:");
        logger.info("• Naive Recursion: O(2^n) time - EXPONENTIAL!");
        logger.info("• Iteration: O(n) time, O(1) space");
        logger.info("• Winner: Iteration (MUCH faster for large n)");

        logger.info("\nDemonstration with larger n:");
        int largeN = 30;
        logger.info("fibonacci({}) iterative = {} (fast)", largeN, fibonacciIterative(largeN));
        logger.info("Note: Recursive would take several seconds for n=30");
    }

    /**
     * Compares recursive and iterative sum implementations.
     */
    private static void demonstrateSumComparison() {
        logger.info("\n--- Sum 1 to N: Recursion vs Iteration ---");

        int n = 100;

        // Recursive
        int resultRecursive = sumRecursive(n);
        logger.info("Recursive: sum(1 to {}) = {}", n, resultRecursive);

        // Iterative
        int resultIterative = sumIterative(n);
        logger.info("Iterative: sum(1 to {}) = {}", n, resultIterative);

        logger.info("\nAnalysis:");
        logger.info("• Both: O(n) time");
        logger.info("• Recursion: O(n) space, Iteration: O(1) space");
        logger.info("• Winner: Iteration (simpler, more efficient)");
        logger.info("• Note: Could use formula n*(n+1)/2 for O(1) time!");
    }

    /**
     * Compares recursive and iterative array search.
     */
    private static void demonstrateArraySearchComparison() {
        logger.info("\n--- Array Maximum: Recursion vs Iteration ---");

        int[] numbers = { 45, 12, 78, 23, 89, 34, 56, 91, 67 };

        // Recursive
        int maxRecursive = findMaxRecursive(numbers, 0);
        logger.info("Recursive: findMax([...]) = {}", maxRecursive);

        // Iterative
        int maxIterative = findMaxIterative(numbers);
        logger.info("Iterative: findMax([...]) = {}", maxIterative);

        logger.info("\nAnalysis:");
        logger.info("• Both: O(n) time");
        logger.info("• Recursion: O(n) space, Iteration: O(1) space");
        logger.info("• Winner: Iteration (clearer and more efficient)");
    }

    /**
     * Demonstrates performance considerations.
     */
    private static void demonstratePerformanceConsiderations() {
        logger.info("\n--- Performance Considerations ---");

        logger.info("Time Complexity Comparison:");
        logger.info("• Factorial: Both O(n) - similar time performance");
        logger.info("• Fibonacci (naive): Recursive O(2^n), Iterative O(n) - huge difference!");
        logger.info("• Sum: Both O(n) - similar time performance");

        logger.info("\nSpace Complexity Comparison:");
        logger.info("• Recursion: Always uses O(depth) stack space");
        logger.info("• Iteration: Usually O(1) space");

        logger.info("\nOverhead:");
        logger.info("• Recursion: Function call overhead per iteration");
        logger.info("• Iteration: Direct loop - minimal overhead");

        logger.info("\nStack Overflow Risk:");
        logger.info("• Recursion: Can crash with StackOverflowError for deep recursion");
        logger.info("• Iteration: No stack overflow risk");

        logger.info("\nExample: Deep recursion risk");
        logger.info("sum(10000) iterative = {} (safe)", sumIterative(10000));
        logger.info("sum(10000) recursive = <would likely cause StackOverflowError>");
    }

    /**
     * Provides decision-making guidelines.
     */
    private static void demonstrateDecisionGuidelines() {
        logger.info("\n--- When to Use Each Approach ---");

        logger.info("\nUse RECURSION when:");
        logger.info("✓ Problem has natural recursive structure (trees, graphs)");
        logger.info("✓ Divide-and-conquer is natural fit (binary search, merge sort)");
        logger.info("✓ Backtracking is needed (maze solving, permutations)");
        logger.info("✓ Recursive solution is significantly clearer");
        logger.info("✓ Depth is bounded and reasonable (< 1000 typically)");

        logger.info("\nUse ITERATION when:");
        logger.info("✓ Simple sequential processing (sum, count, basic loops)");
        logger.info("✓ Performance is critical");
        logger.info("✓ Deep or unbounded recursion depth");
        logger.info("✓ Both solutions are equally clear");
        logger.info("✓ Working with large datasets");

        logger.info("\nReal-World Examples:");
        logger.info("• File system traversal → Recursion (tree structure)");
        logger.info("• Array sum → Iteration (simple, sequential)");
        logger.info("• Binary search → Either (both clear, iteration slightly faster)");
        logger.info("• Tree traversal → Recursion (natural fit)");
        logger.info("• Factorial → Iteration (simpler, more efficient)");
        logger.info("• Merge sort → Recursion (divide-and-conquer nature)");

        logger.info("\nConversion Tips:");
        logger.info("• Tail recursion → Easy to convert (replace with loop + accumulator)");
        logger.info("• Linear recursion → Use loop with single variable");
        logger.info("• Binary recursion → Use explicit stack (like iterative DFS)");
    }

    // ========== Factorial Implementations ==========

    /**
     * Factorial using recursion.
     * Time: O(n), Space: O(n)
     */
    private static long factorialRecursive(int n) {
        if (n <= 1)
            return 1;
        return n * factorialRecursive(n - 1);
    }

    /**
     * Factorial using iteration.
     * Time: O(n), Space: O(1)
     */
    private static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // ========== Fibonacci Implementations ==========

    /**
     * Fibonacci using naive recursion (exponential time).
     * Time: O(2^n), Space: O(n)
     */
    private static long fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * Fibonacci using iteration (linear time).
     * Time: O(n), Space: O(1)
     */
    private static long fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // ========== Sum Implementations ==========

    /**
     * Sum 1 to n using recursion.
     * Time: O(n), Space: O(n)
     */
    private static int sumRecursive(int n) {
        if (n <= 0)
            return 0;
        return n + sumRecursive(n - 1);
    }

    /**
     * Sum 1 to n using iteration.
     * Time: O(n), Space: O(1)
     */
    private static int sumIterative(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // ========== Array Maximum Implementations ==========

    /**
     * Find max using recursion.
     * Time: O(n), Space: O(n)
     */
    private static int findMaxRecursive(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }

        int maxOfRest = findMaxRecursive(arr, index + 1);
        return Math.max(arr[index], maxOfRest);
    }

    /**
     * Find max using iteration.
     * Time: O(n), Space: O(1)
     */
    private static int findMaxIterative(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
