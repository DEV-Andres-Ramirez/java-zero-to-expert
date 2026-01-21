package com.andres.controlflow.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the while loop in Java.
 * 
 * <p>
 * <strong>What is a while loop?</strong>
 * </p>
 * <p>
 * A control flow statement that executes a block of code repeatedly as long as
 * a specified condition remains true. The condition is checked BEFORE each
 * iteration.
 * </p>
 * 
 * <p>
 * <strong>Syntax:</strong>
 * </p>
 * 
 * <pre>
 * while (condition) {
 *     // Code block to execute
 *     // Must update condition to avoid infinite loop
 * }
 * </pre>
 * 
 * <p>
 * <strong>When to Use while Loop:</strong>
 * </p>
 * <ul>
 * <li>Number of iterations is unknown in advance</li>
 * <li>Loop depends on dynamic condition (user input, file reading)</li>
 * <li>Condition-based repetition (retry logic, polling)</li>
 * <li>Event-driven loops (game loops, server listeners)</li>
 * <li>When condition needs to be checked BEFORE first execution</li>
 * </ul>
 * 
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Known number of iterations (use for loop)</li>
 * <li>Simple collection iteration (use for-each)</li>
 * <li>Need to execute at least once (use do-while)</li>
 * </ul>
 * 
 * <p>
 * <strong>Key Differences:</strong>
 * </p>
 * <ul>
 * <li><strong>while:</strong> Condition checked BEFORE execution (may not
 * execute at all)</li>
 * <li><strong>do-while:</strong> Condition checked AFTER execution (executes at
 * least once)</li>
 * <li><strong>for:</strong> Best for known iterations with counter</li>
 * </ul>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>User input validation (retry until valid)</li>
 * <li>File/stream processing (read until end)</li>
 * <li>Network communication (listen for connections)</li>
 * <li>Game loops and simulations</li>
 * <li>Polling and waiting for events</li>
 * <li>Search algorithms (until found or exhausted)</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Ensure condition will eventually become false (avoid infinite loops)</li>
 * <li>Update loop variable/state inside the loop</li>
 * <li>Keep condition simple and readable</li>
 * <li>Consider using break for early exit when appropriate</li>
 * <li>Be cautious with complex conditions - extract to variables</li>
 * <li>Use appropriate timeout mechanisms for potentially infinite loops</li>
 * </ul>
 * 
 * <p>
 * <strong>Common Pitfalls:</strong>
 * </p>
 * <ul>
 * <li>Infinite loops (condition never becomes false)</li>
 * <li>Off-by-one errors in condition</li>
 * <li>Forgetting to update loop variable</li>
 * <li>Complex conditions that are hard to reason about</li>
 * </ul>
 */
public final class WhileLoopDemo {

    private static final Logger logger = LoggerFactory.getLogger(WhileLoopDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private WhileLoopDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates while loop usage.
     */
    public static void demonstrate() {
        logger.info("--- While Loop ---\n");

        // Basic while loop
        demonstrateBasicWhileLoop();

        // Condition-based loops
        demonstrateConditionBasedLoops();

        // Loop control (break, continue)
        demonstrateLoopControl();

        // Sentinel-controlled loops
        demonstrateSentinelControlled();

        // Real-world examples
        demonstrateRealWorldExamples();

        // Infinite loops (intentional)
        demonstrateInfiniteLoops();

        System.out.println();
    }

    /**
     * Demonstrates basic while loop structure.
     */
    private static void demonstrateBasicWhileLoop() {
        logger.info("--- Basic While Loop ---");

        // Simple counter
        logger.info("Counting from 1 to 5:");
        int count = 1;
        while (count <= 5) {
            logger.info("  count = {}", count);
            count++; // CRITICAL: Update variable to avoid infinite loop
        }

        // Countdown
        logger.info("\nCountdown from 5 to 1:");
        int countdown = 5;
        while (countdown > 0) {
            logger.info("  {}", countdown);
            countdown--;
        }

        // Condition may be false from start
        logger.info("\nCondition false from start (won't execute):");
        int value = 10;
        while (value < 5) {
            logger.info("  This won't print");
            value++;
        }
        logger.info("  Loop didn't execute because {} is not < 5", value);
    }

    /**
     * Demonstrates condition-based while loops.
     */
    private static void demonstrateConditionBasedLoops() {
        logger.info("\n--- Condition-Based Loops ---");

        // Loop until condition changes
        logger.info("Doubling until greater than 100:");
        int number = 1;
        while (number <= 100) {
            logger.info("  number = {}", number);
            number *= 2;
        }
        logger.info("Final value: {}", number);

        // Multiple conditions
        logger.info("\nLoop with multiple conditions:");
        int x = 0;
        int y = 10;
        while (x < 5 && y > 5) {
            logger.info("  x = {}, y = {}", x, y);
            x++;
            y--;
        }

        // Complex condition extracted to variable
        logger.info("\nLoop with extracted condition:");
        int balance = 100;
        int withdrawalAttempts = 0;
        int maxAttempts = 3;

        boolean canContinue = balance > 0 && withdrawalAttempts < maxAttempts;
        while (canContinue) {
            balance -= 20;
            withdrawalAttempts++;
            logger.info("  Withdrawal {}: Balance = {}", withdrawalAttempts, balance);

            // Update condition
            canContinue = balance > 0 && withdrawalAttempts < maxAttempts;
        }
    }

    /**
     * Demonstrates loop control with break and continue.
     */
    private static void demonstrateLoopControl() {
        logger.info("\n--- Loop Control (break, continue) ---");

        // Using break to exit early
        logger.info("Using break (stop when found):");
        int target = 7;
        int current = 1;
        while (current <= 10) {
            if (current == target) {
                logger.info("  Found target: {}", target);
                break; // Exit loop
            }
            logger.info("  Searching... current = {}", current);
            current++;
        }

        // Using continue to skip iterations
        logger.info("\nUsing continue (skip odd numbers):");
        int num = 0;
        while (num < 10) {
            num++;
            if (num % 2 != 0) {
                continue; // Skip odd numbers
            }
            logger.info("  Even number: {}", num);
        }

        // Multiple exit conditions
        logger.info("\nMultiple exit conditions:");
        int attempts = 0;
        int maxAttempts = 5;
        boolean success = false;

        while (attempts < maxAttempts && !success) {
            attempts++;
            logger.info("  Attempt {}", attempts);

            // Simulate random success
            success = (attempts == 3); // Success on 3rd attempt

            if (success) {
                logger.info("  Success!");
                break;
            }
        }

        if (!success) {
            logger.warn("  Failed after {} attempts", attempts);
        }
    }

    /**
     * Demonstrates sentinel-controlled loops.
     * 
     * <p>
     * <strong>Sentinel Value:</strong> A special value that signals the end of
     * input.
     * </p>
     */
    private static void demonstrateSentinelControlled() {
        logger.info("\n--- Sentinel-Controlled Loops ---");

        // Processing list until sentinel value
        List<Integer> values = new ArrayList<>(List.of(10, 20, 30, -1, 40, 50));
        int sentinel = -1;

        logger.info("Processing until sentinel value (-1):");
        int index = 0;
        while (index < values.size()) {
            int value = values.get(index);
            if (value == sentinel) {
                logger.info("  Sentinel value reached. Stopping.");
                break;
            }
            logger.info("  Processing: {}", value);
            index++;
        }

        // Sum until zero
        logger.info("\nSum until zero:");
        List<Integer> numbers = List.of(5, 10, 15, 0, 20, 25);
        int sum = 0;
        int i = 0;

        while (i < numbers.size() && numbers.get(i) != 0) {
            sum += numbers.get(i);
            logger.info("  Adding {}, sum = {}", numbers.get(i), sum);
            i++;
        }
        logger.info("Final sum: {}", sum);
    }

    /**
     * Demonstrates real-world use cases.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Input validation
        logger.info("Example 1: Input Validation (simulated)");
        simulateInputValidation();

        // Example 2: Retry logic
        logger.info("\nExample 2: Retry Logic");
        simulateRetryLogic();

        // Example 3: Data processing until condition
        logger.info("\nExample 3: Finding first divisible number");
        int searchStart = 100;
        while (searchStart % 7 != 0) {
            searchStart++;
        }
        logger.info("First number >= 100 divisible by 7: {}", searchStart);

        // Example 4: Accumulation
        logger.info("\nExample 4: Accumulating values until threshold");
        int total = 0;
        int addValue = 5;
        int threshold = 50;

        while (total < threshold) {
            total += addValue;
            logger.info("  Added {}, total = {}", addValue, total);
        }
        logger.info("Threshold {} reached", threshold);

        // Example 5: Search algorithm
        logger.info("\nExample 5: Linear search");
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve");
        String searchName = "Charlie";
        int position = 0;
        boolean found = false;

        while (position < names.size() && !found) {
            if (names.get(position).equals(searchName)) {
                found = true;
                logger.info("Found '{}' at position {}", searchName, position);
            } else {
                position++;
            }
        }

        if (!found) {
            logger.info("'{}' not found", searchName);
        }

        // Example 6: Removing elements
        logger.info("\nExample 6: Removing all occurrences");
        List<String> items = new ArrayList<>(List.of("A", "B", "A", "C", "A", "D"));
        String toRemove = "A";

        logger.info("Original: {}", items);
        while (items.contains(toRemove)) {
            items.remove(toRemove);
            logger.info("  Removed '{}', remaining: {}", toRemove, items);
        }
        logger.info("Final: {}", items);
    }

    /**
     * Demonstrates intentional infinite loops with exit conditions.
     * 
     * <p>
     * <strong>Use Cases:</strong> Server loops, game loops, event loops
     * </p>
     */
    private static void demonstrateInfiniteLoops() {
        logger.info("\n--- Intentional Infinite Loops ---");

        // Infinite loop with break (common pattern)
        logger.info("Infinite loop with break condition:");
        int iterations = 0;
        int maxIterations = 5;

        while (true) { // Infinite loop
            iterations++;
            logger.info("  Iteration {}", iterations);

            if (iterations >= maxIterations) {
                logger.info("  Exit condition met");
                break; // Exit the infinite loop
            }
        }

        // Server-like loop simulation
        logger.info("\nSimulated server loop:");
        simulateServerLoop();

        logger.info("\nNote: Infinite loops are useful for:");
        logger.info("  • Server applications (listen for connections)");
        logger.info("  • Game loops (update and render continuously)");
        logger.info("  • Event processing (wait for events)");
        logger.info("  • Background services (continuous monitoring)");
    }

    /**
     * Simulates input validation with retry.
     */
    private static void simulateInputValidation() {
        // Simulated input values (in real scenario, would be from Scanner)
        int[] inputs = { -5, 150, 0, 42 };
        int inputIndex = 0;

        int value = inputs[inputIndex++];
        while (value < 1 || value > 100) {
            logger.warn("  Invalid input: {}. Must be between 1 and 100.", value);
            if (inputIndex < inputs.length) {
                value = inputs[inputIndex++];
            } else {
                break; // No more inputs
            }
        }

        if (value >= 1 && value <= 100) {
            logger.info("  Valid input received: {}", value);
        }
    }

    /**
     * Simulates retry logic with exponential backoff.
     */
    private static void simulateRetryLogic() {
        int maxRetries = 4;
        int retryCount = 0;
        boolean success = false;
        Random random = new Random();

        while (retryCount < maxRetries && !success) {
            retryCount++;
            logger.info("  Attempt {} of {}", retryCount, maxRetries);

            // Simulate operation (30% success rate)
            success = random.nextInt(100) < 30;

            if (!success && retryCount < maxRetries) {
                int delay = (int) Math.pow(2, retryCount - 1); // Exponential backoff
                logger.warn("  Failed. Retrying in {} seconds...", delay);
            }
        }

        if (success) {
            logger.info("  Operation succeeded on attempt {}", retryCount);
        } else {
            logger.error("  Operation failed after {} attempts", retryCount);
        }
    }

    /**
     * Simulates a server loop that processes requests.
     */
    private static void simulateServerLoop() {
        int requestsToProcess = 3;
        int processedRequests = 0;

        while (true) {
            // Simulate request arrival
            if (processedRequests < requestsToProcess) {
                processedRequests++;
                logger.info("  Processing request {}", processedRequests);
            } else {
                logger.info("  No more requests. Shutting down.");
                break;
            }
        }
    }
}
