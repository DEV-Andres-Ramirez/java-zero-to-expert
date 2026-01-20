package com.andres.datatypes.composite.collections.queues;

import java.util.ArrayDeque;
import java.util.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates Deque (Double-Ended Queue), a linear collection supporting
 * element
 * insertion and removal at both ends.
 * 
 * <p>
 * <strong>Deque Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Double-Ended Queue: can add/remove from both ends</li>
 * <li>Can function as FIFO queue OR LIFO stack</li>
 * <li>More versatile than traditional Queue</li>
 * <li>Provides methods for both ends: First (head) and Last (tail)</li>
 * <li>Supports both exception and special-value methods</li>
 * </ul>
 * 
 * <p>
 * <strong>Deque Method Categories:</strong>
 * </p>
 * <table>
 * <tr>
 * <th>Operation</th>
 * <th>First Element</th>
 * <th>Last Element</th>
 * </tr>
 * <tr>
 * <td>Insert</td>
 * <td>addFirst(), offerFirst()</td>
 * <td>addLast(), offerLast()</td>
 * </tr>
 * <tr>
 * <td>Remove</td>
 * <td>removeFirst(), pollFirst()</td>
 * <td>removeLast(), pollLast()</td>
 * </tr>
 * <tr>
 * <td>Examine</td>
 * <td>getFirst(), peekFirst()</td>
 * <td>getLast(), peekLast()</td>
 * </tr>
 * </table>
 * 
 * <p>
 * <strong>When to Use Deque:</strong>
 * </p>
 * <ul>
 * <li>Implementing LIFO stack (BETTER than Stack class)</li>
 * <li>Processing requiring access to both ends</li>
 * <li>Undo/Redo functionality in applications</li>
 * <li>Sliding window algorithms</li>
 * <li>Browser history (back/forward navigation)</li>
 * <li>Work-stealing algorithms in concurrent systems</li>
 * </ul>
 * 
 * <p>
 * <strong>Common Deque Implementations:</strong>
 * </p>
 * <ul>
 * <li><strong>ArrayDeque:</strong> Resizable array, RECOMMENDED (most
 * efficient)</li>
 * <li><strong>LinkedList:</strong> Doubly-linked list, implements both List and
 * Deque</li>
 * </ul>
 * 
 * <p>
 * <strong>Deque vs Stack Class:</strong>
 * </p>
 * <ul>
 * <li><strong>Stack:</strong> Legacy class (synchronized, slower), NOT
 * recommended</li>
 * <li><strong>Deque:</strong> Modern replacement, faster, more flexible</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use ArrayDeque for best performance (better than LinkedList)</li>
 * <li>Use Deque instead of Stack class for LIFO operations</li>
 * <li>Prefer special-value methods (offer, poll, peek) over exception
 * methods</li>
 * <li>Choose appropriate end operations based on use case</li>
 * <li>Not thread-safe - use Collections.synchronizedDeque() if needed</li>
 * </ul>
 */
public final class DequeDemo {

    private static final Logger logger = LoggerFactory.getLogger(DequeDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private DequeDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates Deque usage and operations.
     */
    public static void demonstrate() {
        logger.info("--- Deque (Double-Ended Queue) ---\n");

        // Basic deque operations
        demonstrateBasicOperations();

        // Using as FIFO Queue
        demonstrateAsQueue();

        // Using as LIFO Stack (RECOMMENDED over Stack class)
        demonstrateAsStack();

        // Deque-specific operations
        demonstrateDoubleEndedOperations();

        // Performance comparison
        demonstratePerformanceNote();

        // Real-world examples
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates basic Deque operations on both ends.
     */
    private static void demonstrateBasicOperations() {
        logger.info("--- Basic Deque Operations ---");

        Deque<String> deque = new ArrayDeque<>();

        // Adding at both ends
        deque.offerFirst("Element 1"); // Add at front
        deque.offerLast("Element 2"); // Add at rear
        deque.offerFirst("Element 0"); // Add at front again
        deque.offerLast("Element 3"); // Add at rear again

        logger.info("Deque after operations: {}", deque);
        logger.info("Expected order: [Element 0, Element 1, Element 2, Element 3]");

        // Examining both ends
        logger.info("\nExamining both ends:");
        logger.info("First element (peekFirst): {}", deque.peekFirst());
        logger.info("Last element (peekLast): {}", deque.peekLast());

        // Removing from both ends
        logger.info("\nRemoving from both ends:");
        logger.info("Removed from front (pollFirst): {}", deque.pollFirst());
        logger.info("Removed from rear (pollLast): {}", deque.pollLast());
        logger.info("Deque after removals: {}", deque);
    }

    /**
     * Demonstrates using Deque as a FIFO Queue.
     * 
     * <p>
     * For Queue behavior: add at rear (offerLast), remove from front (pollFirst)
     * </p>
     */
    private static void demonstrateAsQueue() {
        logger.info("\n--- Using Deque as FIFO Queue ---");

        Deque<String> queue = new ArrayDeque<>();

        // Enqueue (add at rear)
        queue.offerLast("First");
        queue.offerLast("Second");
        queue.offerLast("Third");

        logger.info("Queue after enqueue: {}", queue);
        logger.info("Front element: {}", queue.peekFirst());

        // Dequeue (remove from front)
        logger.info("\nDequeueing (FIFO order):");
        while (!queue.isEmpty()) {
            logger.info("  Dequeued: {}", queue.pollFirst());
        }
    }

    /**
     * Demonstrates using Deque as a LIFO Stack.
     * 
     * <p>
     * <strong>IMPORTANT:</strong> Deque is the RECOMMENDED way to implement
     * stack behavior in modern Java. The Stack class is legacy and synchronized.
     * </p>
     * 
     * <p>
     * For Stack behavior: push at front (offerFirst), pop from front (pollFirst)
     * </p>
     */
    private static void demonstrateAsStack() {
        logger.info("\n--- Using Deque as LIFO Stack (RECOMMENDED) ---");

        Deque<String> stack = new ArrayDeque<>();

        // Push (add at front)
        stack.push("Bottom"); // Same as offerFirst()
        stack.push("Middle");
        stack.push("Top");

        logger.info("Stack after push operations: {}", stack);
        logger.info("Top element (peek): {}", stack.peek());

        // Pop (remove from front)
        logger.info("\nPopping (LIFO order):");
        while (!stack.isEmpty()) {
            logger.info("  Popped: {}", stack.pop());
        }

        // Alternative: Using offerFirst/pollFirst explicitly
        logger.info("\n--- Stack Operations with Explicit Methods ---");
        Deque<Integer> numStack = new ArrayDeque<>();

        numStack.offerFirst(1);
        numStack.offerFirst(2);
        numStack.offerFirst(3);

        logger.info("Stack: {}", numStack);
        logger.info("Pop: {}", numStack.pollFirst());
        logger.info("Pop: {}", numStack.pollFirst());
        logger.info("Remaining: {}", numStack);
    }

    /**
     * Demonstrates operations unique to double-ended nature of Deque.
     */
    private static void demonstrateDoubleEndedOperations() {
        logger.info("\n--- Double-Ended Specific Operations ---");

        Deque<Integer> deque = new ArrayDeque<>();

        // Building a deque from both ends
        logger.info("Building deque from both ends:");
        deque.offerLast(5); // [5]
        logger.info("  After offerLast(5): {}", deque);

        deque.offerFirst(3); // [3, 5]
        logger.info("  After offerFirst(3): {}", deque);

        deque.offerLast(7); // [3, 5, 7]
        logger.info("  After offerLast(7): {}", deque);

        deque.offerFirst(1); // [1, 3, 5, 7]
        logger.info("  After offerFirst(1): {}", deque);

        // Removing from both ends alternately
        logger.info("\nRemoving from alternating ends:");
        logger.info("  pollFirst(): {}", deque.pollFirst()); // Remove 1
        logger.info("  pollLast(): {}", deque.pollLast()); // Remove 7
        logger.info("  Remaining: {}", deque); // [3, 5]

        // Iteration (forward and backward)
        Deque<String> words = new ArrayDeque<>();
        words.addAll(java.util.List.of("Alpha", "Beta", "Gamma", "Delta"));

        logger.info("\nForward iteration:");
        for (String word : words) {
            logger.info("  {}", word);
        }

        logger.info("\nReverse iteration:");
        var descendingIterator = words.descendingIterator();
        while (descendingIterator.hasNext()) {
            logger.info("  {}", descendingIterator.next());
        }
    }

    /**
     * Demonstrates performance characteristics and recommendations.
     */
    private static void demonstratePerformanceNote() {
        logger.info("\n--- Performance Notes ---");

        logger.info("ArrayDeque vs LinkedList:");
        logger.info("- ArrayDeque: Better overall performance (RECOMMENDED)");
        logger.info("  • Faster for most operations");
        logger.info("  • Better cache locality (continuous memory)");
        logger.info("  • More memory efficient");
        logger.info("- LinkedList: Use only when:");
        logger.info("  • Need both List and Deque operations");
        logger.info("  • Frequent insertions in middle of list");

        logger.info("\nArrayDeque vs Stack class:");
        logger.info("- ArrayDeque: ALWAYS prefer for stack operations");
        logger.info("  • Not synchronized (faster)");
        logger.info("  • More flexible (can be used as queue too)");
        logger.info("- Stack: Legacy class, avoid in new code");
    }

    /**
     * Demonstrates real-world use cases for Deque.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Undo/Redo functionality
        demonstrateUndoRedo();

        // Example 2: Browser history
        demonstrateBrowserHistory();

        // Example 3: Sliding window maximum
        demonstrateSlidingWindow();

        // Example 4: Palindrome checker
        demonstratePalindromeChecker();
    }

    /**
     * Example 1: Undo/Redo functionality in a text editor.
     */
    private static void demonstrateUndoRedo() {
        logger.info("\nExample 1: Undo/Redo in Text Editor");

        Deque<String> undoStack = new ArrayDeque<>();
        Deque<String> redoStack = new ArrayDeque<>();
        String currentText = "";

        // Type some text
        currentText = "Hello";
        undoStack.push(currentText);
        logger.info("Typed: {}", currentText);

        currentText = "Hello World";
        undoStack.push(currentText);
        logger.info("Typed: {}", currentText);

        currentText = "Hello World!";
        undoStack.push(currentText);
        logger.info("Typed: {}", currentText);

        // Undo
        logger.info("\nUndo operation:");
        if (!undoStack.isEmpty()) {
            redoStack.push(undoStack.pop());
            currentText = undoStack.isEmpty() ? "" : undoStack.peek();
            logger.info("After undo: {}", currentText);
        }

        // Redo
        logger.info("\nRedo operation:");
        if (!redoStack.isEmpty()) {
            String restored = redoStack.pop();
            undoStack.push(restored);
            currentText = restored;
            logger.info("After redo: {}", currentText);
        }
    }

    /**
     * Example 2: Browser history with back/forward navigation.
     */
    private static void demonstrateBrowserHistory() {
        logger.info("\nExample 2: Browser History Navigation");

        Deque<String> history = new ArrayDeque<>();
        Deque<String> forwardHistory = new ArrayDeque<>();

        // Visit pages
        history.push("google.com");
        logger.info("Visited: google.com");

        history.push("github.com");
        logger.info("Visited: github.com");

        history.push("stackoverflow.com");
        logger.info("Visited: stackoverflow.com");

        logger.info("Current page: {}", history.peek());

        // Go back
        logger.info("\nGoing back:");
        if (!history.isEmpty()) {
            String current = history.pop();
            forwardHistory.push(current);
            logger.info("Current page: {}", history.peek());
        }

        // Go forward
        logger.info("\nGoing forward:");
        if (!forwardHistory.isEmpty()) {
            String page = forwardHistory.pop();
            history.push(page);
            logger.info("Current page: {}", history.peek());
        }
    }

    /**
     * Example 3: Sliding window maximum (algorithm problem).
     */
    private static void demonstrateSlidingWindow() {
        logger.info("\nExample 3: Sliding Window Pattern");

        int[] numbers = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int windowSize = 3;

        logger.info("Array: {}", java.util.Arrays.toString(numbers));
        logger.info("Window size: {}", windowSize);
        logger.info("Finding maximums in each window:");

        Deque<Integer> window = new ArrayDeque<>();

        for (int i = 0; i < windowSize && i < numbers.length; i++) {
            window.offerLast(numbers[i]);
        }

        int max = window.stream().mapToInt(Integer::intValue).max().orElse(0);
        logger.info("  Window {}: max = {}", window, max);

        for (int i = windowSize; i < numbers.length; i++) {
            window.pollFirst();
            window.offerLast(numbers[i]);
            max = window.stream().mapToInt(Integer::intValue).max().orElse(0);
            logger.info("  Window {}: max = {}", window, max);
        }
    }

    /**
     * Example 4: Palindrome checker using Deque.
     */
    private static void demonstratePalindromeChecker() {
        logger.info("\nExample 4: Palindrome Checker");

        String[] testWords = { "radar", "hello", "level", "world", "racecar" };

        for (String word : testWords) {
            boolean isPalindrome = checkPalindrome(word);
            logger.info("{}: {}", word, isPalindrome ? "PALINDROME" : "NOT palindrome");
        }
    }

    /**
     * Helper method to check if a word is a palindrome using Deque.
     */
    private static boolean checkPalindrome(String word) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : word.toLowerCase().toCharArray()) {
            deque.offerLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }

        return true;
    }
}
