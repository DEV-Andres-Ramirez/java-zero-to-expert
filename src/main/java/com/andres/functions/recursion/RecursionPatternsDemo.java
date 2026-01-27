package com.andres.functions.recursion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates common recursion patterns and algorithms in Java.
 *
 * <p>
 * <strong>Recursion Patterns:</strong>
 * </p>
 * <p>
 * Different problems require different recursive approaches. Understanding these
 * patterns helps choose the right recursion strategy and optimize solutions.
 * </p>
 *
 * <p>
 * <strong>Common Recursion Patterns:</strong>
 * </p>
 * <ul>
 * <li><strong>Linear Recursion:</strong> Single recursive call per invocation
 * (factorial, sum)</li>
 * <li><strong>Binary Recursion:</strong> Two recursive calls per invocation
 * (fibonacci, binary trees)</li>
 * <li><strong>Tail Recursion:</strong> Recursive call is last operation (can be
 * optimized)</li>
 * <li><strong>Multiple Recursion:</strong> Many recursive calls (tree
 * traversal)</li>
 * <li><strong>Mutual Recursion:</strong> Functions calling each other
 * recursively</li>
 * </ul>
 *
 * <p>
 * <strong>When to Use Each Pattern:</strong>
 * </p>
 * <ul>
 * <li><strong>Linear:</strong> Sequential processing, single path (lists,
 * arrays)</li>
 * <li><strong>Binary:</strong> Divide-and-conquer, two subproblems (trees,
 * fibonacci)</li>
 * <li><strong>Tail:</strong> When iterative conversion is desired, accumulator
 * pattern</li>
 * <li><strong>Multiple:</strong> Tree/graph structures with many branches</li>
 * </ul>
 *
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Binary recursion for fibonacci (exponential time - use memoization)</li>
 * <li>Deep linear recursion when iteration is simpler</li>
 * <li>Multiple recursion without pruning/optimization</li>
 * </ul>
 *
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Tree algorithms: traversal, search, height calculation</li>
 * <li>Mathematical algorithms: GCD, exponentiation, combinatorics</li>
 * <li>String processing: reversal, palindrome checking, pattern matching</li>
 * <li>Array operations: searching, sorting, partitioning</li>
 * <li>Divide-and-conquer: binary search, merge sort, quick sort</li>
 * </ul>
 *
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Choose pattern based on problem structure</li>
 * <li>Use tail recursion for easy iteration conversion</li>
 * <li>Consider memoization for binary recursion with overlapping
 * subproblems</li>
 * <li>Document time/space complexity for each recursive method</li>
 * <li>Test with small inputs first, then scale up</li>
 * <li>Profile performance for large inputs</li>
 * </ul>
 *
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Using binary recursion without memoization (exponential time)</li>
 * <li>Not recognizing tail recursion opportunities</li>
 * <li>Excessive stack depth with deep recursion</li>
 * <li>Not considering iterative alternatives for simple patterns</li>
 * </ul>
 *
 * @author Andrés
 * @version 1.0
 */
public final class RecursionPatternsDemo {

    private static final Logger logger = LoggerFactory.getLogger(RecursionPatternsDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private RecursionPatternsDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates common recursion patterns and algorithms.
     */
    public static void demonstrate() {
        logger.info("--- Recursion Patterns ---\n");

        demonstrateLinearRecursion();
        demonstrateBinaryRecursion();
        demonstrateTailRecursion();
        demonstrateArrayRecursion();
        demonstrateStringRecursion();
        demonstrateRealWorldAlgorithms();

        System.out.println();
    }

    /**
     * Demonstrates linear recursion (single recursive call).
     */
    private static void demonstrateLinearRecursion() {
        logger.info("--- Linear Recursion (Single Call Per Invocation) ---");

        logger.info("Characteristic: One recursive call per method invocation");
        logger.info("Examples: factorial, sum, list traversal\n");

        // Factorial
        int fact = factorial(6);
        logger.info("factorial(6) = {}", fact);

        // Array sum
        int[] numbers = { 5, 10, 15, 20, 25 };
        int sum = arraySum(numbers, 0);
        logger.info("arraySum([5,10,15,20,25]) = {}", sum);

        logger.info("\nComplexity: O(n) time, O(n) space (call stack)");
    }

    /**
     * Demonstrates binary recursion (two recursive calls).
     */
    private static void demonstrateBinaryRecursion() {
        logger.info("\n--- Binary Recursion (Two Calls Per Invocation) ---");

        logger.info("Characteristic: Two recursive calls per method invocation");
        logger.info("Examples: fibonacci, binary trees, divide-and-conquer\n");

        // Fibonacci
        logger.info("fibonacci sequence (naive binary recursion):");
        for (int i = 0; i <= 6; i++) {
            logger.info("  fib({}) = {}", i, fibonacci(i));
        }

        logger.info("\nWarning: Naive fibonacci is O(2^n) - exponential time!");
        logger.info("Many duplicate calculations. Solution: use memoization or iteration");
    }

    /**
     * Demonstrates tail recursion (recursive call is last operation).
     */
    private static void demonstrateTailRecursion() {
        logger.info("\n--- Tail Recursion (Last Operation is Recursive Call) ---");

        logger.info("Characteristic: Recursive call is the last operation");
        logger.info("Benefit: Can be optimized to iteration (Java doesn't auto-optimize)\n");

        // Tail recursive factorial
        int fact = factorialTail(6, 1);
        logger.info("factorialTail(6) = {}", fact);

        // Tail recursive sum
        int sum = sumTail(10, 0);
        logger.info("sumTail(10) = {}", sum);

        logger.info("\nTail recursion uses accumulator parameter");
        logger.info("Easier to convert to iteration - just use loop with accumulator");
    }

    /**
     * Demonstrates recursion on arrays.
     */
    private static void demonstrateArrayRecursion() {
        logger.info("\n--- Array Recursion ---");

        int[] numbers = { 45, 12, 78, 23, 89, 34, 56 };

        // Find max
        int max = findMax(numbers, 0);
        logger.info("findMax([45,12,78,23,89,34,56]) = {}", max);

        // Check if sorted
        int[] sorted = { 1, 3, 5, 7, 9 };
        int[] unsorted = { 1, 5, 3, 7, 9 };
        boolean isSorted1 = isSorted(sorted, 0);
        boolean isSorted2 = isSorted(unsorted, 0);
        logger.info("isSorted([1,3,5,7,9]) = {}", isSorted1);
        logger.info("isSorted([1,5,3,7,9]) = {}", isSorted2);

        // Count occurrences
        int[] values = { 5, 3, 5, 7, 5, 9, 5 };
        int count = countOccurrences(values, 0, 5);
        logger.info("countOccurrences([5,3,5,7,5,9,5], target=5) = {}", count);
    }

    /**
     * Demonstrates recursion on strings.
     */
    private static void demonstrateStringRecursion() {
        logger.info("\n--- String Recursion ---");

        // Palindrome check
        String word1 = "racecar";
        String word2 = "hello";
        boolean isPalin1 = isPalindrome(word1);
        boolean isPalin2 = isPalindrome(word2);
        logger.info("isPalindrome(\"{}\") = {}", word1, isPalin1);
        logger.info("isPalindrome(\"{}\") = {}", word2, isPalin2);

        // Count vowels
        String text = "Hello World";
        int vowelCount = countVowels(text.toLowerCase(), 0);
        logger.info("countVowels(\"{}\") = {}", text, vowelCount);

        // Remove character
        String original = "banana";
        String removed = removeChar(original, 'a');
        logger.info("removeChar(\"{}\", 'a') = \"{}\"", original, removed);
    }

    /**
     * Demonstrates real-world recursive algorithms.
     */
    private static void demonstrateRealWorldAlgorithms() {
        logger.info("\n--- Real-World Recursive Algorithms ---");

        // GCD (Greatest Common Divisor) - Euclidean algorithm
        logger.info("Example 1: GCD (Euclidean Algorithm)");
        int gcd1 = gcd(48, 18);
        logger.info("gcd(48, 18) = {}", gcd1);

        int gcd2 = gcd(100, 35);
        logger.info("gcd(100, 35) = {}", gcd2);

        // Binary search
        logger.info("\nExample 2: Binary Search (Divide and Conquer)");
        int[] sortedArray = { 2, 5, 8, 12, 16, 23, 38, 45, 56, 67, 78 };
        int index1 = binarySearch(sortedArray, 23, 0, sortedArray.length - 1);
        int index2 = binarySearch(sortedArray, 99, 0, sortedArray.length - 1);
        logger.info("binarySearch([...], 23) = index {}", index1);
        logger.info("binarySearch([...], 99) = {} (not found)", index2);

        // Digit sum
        logger.info("\nExample 3: Sum of Digits");
        int number = 12345;
        int digitSum = digitSum(number);
        logger.info("digitSum({}) = {}", number, digitSum);

        // Power (optimized with divide-and-conquer)
        logger.info("\nExample 4: Fast Exponentiation (O(log n))");
        int power = fastPower(2, 10);
        logger.info("fastPower(2, 10) = {}", power);

        // Decimal to binary
        logger.info("\nExample 5: Decimal to Binary Conversion");
        String binary = decimalToBinary(13);
        logger.info("decimalToBinary(13) = \"{}\"", binary);
    }

    // ========== Linear Recursion Methods ==========

    /**
     * Linear recursion: factorial.
     */
    private static int factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    /**
     * Linear recursion: array sum.
     */
    private static int arraySum(int[] arr, int index) {
        if (index >= arr.length)
            return 0;
        return arr[index] + arraySum(arr, index + 1);
    }

    // ========== Binary Recursion Methods ==========

    /**
     * Binary recursion: fibonacci (naive).
     * Time: O(2^n), Space: O(n)
     */
    private static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2); // Two calls
    }

    // ========== Tail Recursion Methods ==========

    /**
     * Tail recursive factorial with accumulator.
     */
    private static int factorialTail(int n, int accumulator) {
        if (n <= 1)
            return accumulator;
        return factorialTail(n - 1, n * accumulator); // Tail call
    }

    /**
     * Tail recursive sum with accumulator.
     */
    private static int sumTail(int n, int accumulator) {
        if (n <= 0)
            return accumulator;
        return sumTail(n - 1, accumulator + n); // Tail call
    }

    // ========== Array Recursion Methods ==========

    /**
     * Finds maximum value in array recursively.
     */
    private static int findMax(int[] arr, int index) {
        // Base case: last element
        if (index == arr.length - 1) {
            return arr[index];
        }

        // Recursive case: max of current and max of rest
        int maxOfRest = findMax(arr, index + 1);
        return Math.max(arr[index], maxOfRest);
    }

    /**
     * Checks if array is sorted.
     */
    private static boolean isSorted(int[] arr, int index) {
        // Base case: reached end
        if (index >= arr.length - 1) {
            return true;
        }

        // Check current pair and recurse
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        return isSorted(arr, index + 1);
    }

    /**
     * Counts occurrences of target in array.
     */
    private static int countOccurrences(int[] arr, int index, int target) {
        if (index >= arr.length)
            return 0;

        int count = (arr[index] == target) ? 1 : 0;
        return count + countOccurrences(arr, index + 1, target);
    }

    // ========== String Recursion Methods ==========

    /**
     * Checks if string is palindrome.
     */
    private static boolean isPalindrome(String str) {
        // Base case: empty or single character
        if (str.length() <= 1) {
            return true;
        }

        // Check first and last characters
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        // Recurse on substring without first and last
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    /**
     * Counts vowels in string.
     */
    private static int countVowels(String str, int index) {
        if (index >= str.length())
            return 0;

        char c = str.charAt(index);
        int count = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
        return count + countVowels(str, index + 1);
    }

    /**
     * Removes all occurrences of character from string.
     */
    private static String removeChar(String str, char ch) {
        if (str.isEmpty())
            return "";

        if (str.charAt(0) == ch) {
            return removeChar(str.substring(1), ch);
        } else {
            return str.charAt(0) + removeChar(str.substring(1), ch);
        }
    }

    // ========== Real-World Algorithms ==========

    /**
     * Greatest Common Divisor using Euclidean algorithm.
     * Time: O(log min(a,b))
     */
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    /**
     * Binary search (recursive).
     * Time: O(log n), Space: O(log n)
     */
    private static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1; // Not found

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }

    /**
     * Sums digits of a number.
     */
    private static int digitSum(int n) {
        if (n == 0)
            return 0;
        return (n % 10) + digitSum(n / 10);
    }

    /**
     * Fast exponentiation using divide-and-conquer.
     * Time: O(log n) instead of O(n)
     */
    private static int fastPower(int base, int exp) {
        if (exp == 0)
            return 1;

        int half = fastPower(base, exp / 2);

        if (exp % 2 == 0) {
            return half * half;
        } else {
            return base * half * half;
        }
    }

    /**
     * Converts decimal to binary string.
     */
    private static String decimalToBinary(int n) {
        if (n == 0)
            return "0";
        if (n == 1)
            return "1";

        return decimalToBinary(n / 2) + (n % 2);
    }
}
