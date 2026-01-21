package com.andres.controlflow.loops;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the do-while loop in Java.
 * 
 * <p>
 * <strong>What is a do-while loop?</strong>
 * </p>
 * <p>
 * A control flow statement that executes a block of code at least once, then
 * continues to execute it repeatedly as long as a specified condition remains
 * true.
 * The condition is checked AFTER each iteration (post-test loop).
 * </p>
 * 
 * <p>
 * <strong>Syntax:</strong>
 * </p>
 * 
 * <pre>
 * do {
 *     // Code block to execute (runs at least once)
 * } while (condition);
 * </pre>
 * 
 * <p>
 * <strong>Critical Difference from while:</strong>
 * </p>
 * <ul>
 * <li><strong>do-while:</strong> Executes BEFORE checking condition (at least
 * once)</li>
 * <li><strong>while:</strong> Checks condition BEFORE executing (may not
 * execute at all)</li>
 * </ul>
 * 
 * <p>
 * <strong>When to Use do-while:</strong>
 * </p>
 * <ul>
 * <li>Code must execute at least once, regardless of condition</li>
 * <li>Menu systems (show menu first, then check if continue)</li>
 * <li>Input validation (prompt user, then validate)</li>
 * <li>Game loops (execute one frame, then check if continue)</li>
 * <li>Initialization + condition check pattern</li>
 * </ul>
 * 
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Condition should be checked before first execution (use while)</li>
 * <li>Known number of iterations (use for)</li>
 * <li>Simple collection iteration (use for-each)</li>
 * </ul>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>User input prompts (always show prompt at least once)</li>
 * <li>Menu-driven applications</li>
 * <li>Retry mechanisms (try once, then check if retry)</li>
 * <li>Validation loops (validate, then ask if retry)</li>
 * <li>Interactive games (play one round, then check if continue)</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use when "execute at least once" is a requirement</li>
 * <li>Ensure condition will eventually become false</li>
 * <li>Update loop variable/state inside the loop</li>
 * <li>Consider if while loop would be clearer</li>
 * <li>Document why do-while is used (not as common as while)</li>
 * </ul>
 * 
 * <p>
 * <strong>Common Use Cases:</strong>
 * </p>
 * <ul>
 * <li>User menus (display menu, get choice, check if exit)</li>
 * <li>Password prompts (prompt once, validate, retry if invalid)</li>
 * <li>Dice rolling (roll once, check if continue)</li>
 * <li>Pagination (show page, check if next page)</li>
 * </ul>
 */
public final class DoWhileLoopDemo {

    private static final Logger logger = LoggerFactory.getLogger(DoWhileLoopDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private DoWhileLoopDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates do-while loop usage.
     */
    public static void demonstrate() {
        logger.info("--- Do-While Loop ---\n");

        // Basic do-while loop
        demonstrateBasicDoWhile();

        // Comparison with while loop
        demonstrateWhileComparison();

        // Menu simulation
        demonstrateMenuPattern();

        // Input validation
        demonstrateInputValidation();

        // Real-world examples
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates basic do-while loop structure.
     */
    private static void demonstrateBasicDoWhile() {
        logger.info("--- Basic Do-While Loop ---");

        // Simple counter (executes at least once)
        logger.info("Counting from 1 to 5:");
        int count = 1;
        do {
            logger.info("  count = {}", count);
            count++;
        } while (count <= 5);

        // Condition false from start (still executes once)
        logger.info("\nCondition false from start (executes once anyway):");
        int value = 10;
        do {
            logger.info("  value = {} (This executes even though 10 is not < 5)", value);
            value++;
        } while (value < 5);

        // Countdown
        logger.info("\nCountdown from 5 to 1:");
        int countdown = 5;
        do {
            logger.info("  {}", countdown);
            countdown--;
        } while (countdown > 0);
    }

    /**
     * Demonstrates key difference between while and do-while.
     */
    private static void demonstrateWhileComparison() {
        logger.info("\n--- Do-While vs While Comparison ---");

        // Scenario: Condition is false from the start
        int startValue = 10;

        // While loop: Doesn't execute
        logger.info("While loop (condition: {} < 5):", startValue);
        int whileCounter = startValue;
        while (whileCounter < 5) {
            logger.info("  This won't print");
            whileCounter++;
        }
        logger.info("  While loop executed 0 times");

        // Do-while loop: Executes once
        logger.info("\nDo-While loop (condition: {} < 5):", startValue);
        int doWhileCounter = startValue;
        int executionCount = 0;
        do {
            executionCount++;
            logger.info("  Execution {} (value = {})", executionCount, doWhileCounter);
            doWhileCounter++;
        } while (doWhileCounter < 5);
        logger.info("  Do-While loop executed {} time(s)", executionCount);

        logger.info("\n✓ Do-while guarantees at least one execution");
        logger.info("✓ While may not execute at all");
    }

    /**
     * Demonstrates menu-driven pattern (classic do-while use case).
     */
    private static void demonstrateMenuPattern() {
        logger.info("\n--- Menu Pattern (Classic Do-While Use Case) ---");

        // Simulated user choices
        List<Integer> choices = List.of(1, 2, 3, 0);
        int choiceIndex = 0;

        int choice;
        do {
            // Display menu
            logger.info("\n=== Main Menu ===");
            logger.info("1. View Profile");
            logger.info("2. Settings");
            logger.info("3. Help");
            logger.info("0. Exit");

            // Get user choice (simulated)
            choice = choices.get(choiceIndex++);
            logger.info("User choice: {}", choice);

            // Process choice
            switch (choice) {
                case 1 -> logger.info("  → Viewing profile...");
                case 2 -> logger.info("  → Opening settings...");
                case 3 -> logger.info("  → Displaying help...");
                case 0 -> logger.info("  → Exiting...");
                default -> logger.warn("  → Invalid choice");
            }

        } while (choice != 0); // Continue until user chooses to exit

        logger.info("\nMenu closed");
        logger.info("✓ Menu displays at least once");
        logger.info("✓ User sees options before deciding to exit");
    }

    /**
     * Demonstrates input validation pattern.
     */
    private static void demonstrateInputValidation() {
        logger.info("\n--- Input Validation Pattern ---");

        // Simulated inputs (in real scenario, would be from Scanner)
        List<Integer> inputs = List.of(-5, 150, 0, 42);
        int inputIndex = 0;

        int value;
        boolean isValid;

        do {
            // Prompt for input (simulated)
            value = inputs.get(inputIndex++);
            logger.info("Enter a number between 1 and 100: {}", value);

            // Validate
            isValid = value >= 1 && value <= 100;

            if (!isValid) {
                logger.warn("  Invalid! Must be between 1 and 100. Try again.");
            }

        } while (!isValid && inputIndex < inputs.size());

        if (isValid) {
            logger.info("\n✓ Valid input received: {}", value);
        } else {
            logger.warn("\n✗ No valid input provided");
        }

        logger.info("\n✓ User is prompted at least once");
        logger.info("✓ Validation happens after input");
    }

    /**
     * Demonstrates real-world use cases.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Password validation
        logger.info("Example 1: Password Validation");
        simulatePasswordValidation();

        // Example 2: Dice rolling game
        logger.info("\nExample 2: Dice Rolling Game");
        simulateDiceGame();

        // Example 3: Retry mechanism
        logger.info("\nExample 3: Retry Mechanism");
        simulateRetryMechanism();

        // Example 4: Pagination
        logger.info("\nExample 4: Pagination");
        simulatePagination();

        // Example 5: At least once execution
        logger.info("\nExample 5: Generate Until Condition");
        generateUntilCondition();

        // Example 6: Game round
        logger.info("\nExample 6: Game Round (Play at least once)");
        simulateGameRound();
    }

    /**
     * Simulates password validation (must prompt at least once).
     */
    private static void simulatePasswordValidation() {
        List<String> passwords = List.of("123", "weak", "StrongPass123!");
        int passwordIndex = 0;

        String password;
        boolean isStrong;

        do {
            password = passwords.get(passwordIndex++);
            logger.info("Enter password: {}", "*".repeat(password.length()));

            // Validate password strength
            isStrong = password.length() >= 8 &&
                    password.matches(".*[A-Z].*") &&
                    password.matches(".*[0-9].*");

            if (!isStrong) {
                logger.warn("  Weak password! Must be 8+ chars with uppercase and number.");
            }

        } while (!isStrong && passwordIndex < passwords.size());

        if (isStrong) {
            logger.info("  ✓ Password accepted");
        }
    }

    /**
     * Simulates a dice rolling game.
     */
    private static void simulateDiceGame() {
        Random random = new Random();
        List<String> decisions = List.of("y", "y", "n");
        int decisionIndex = 0;

        String playAgain;
        do {
            // Roll dice (at least once)
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int total = dice1 + dice2;

            logger.info("  Rolled: {} + {} = {}", dice1, dice2, total);

            if (total == 7 || total == 11) {
                logger.info("  You win!");
            } else {
                logger.info("  Try again!");
            }

            // Ask if play again (simulated)
            playAgain = decisions.get(decisionIndex++);
            logger.info("  Play again? (y/n): {}", playAgain);

        } while (playAgain.equals("y") && decisionIndex < decisions.size());

        logger.info("  Thanks for playing!");
    }

    /**
     * Simulates retry mechanism with attempt counting.
     */
    private static void simulateRetryMechanism() {
        int maxAttempts = 3;
        int attempt = 0;
        boolean success = false;
        Random random = new Random();

        do {
            attempt++;
            logger.info("  Attempt {}/{}", attempt, maxAttempts);

            // Simulate operation (50% success rate)
            success = random.nextBoolean();

            if (success) {
                logger.info("  ✓ Operation successful!");
            } else {
                logger.warn("  ✗ Operation failed");
            }

        } while (!success && attempt < maxAttempts);

        if (!success) {
            logger.error("  Failed after {} attempts", attempt);
        }
    }

    /**
     * Simulates pagination (show at least one page).
     */
    private static void simulatePagination() {
        List<String> allItems = List.of(
                "Item1", "Item2", "Item3", "Item4", "Item5",
                "Item6", "Item7", "Item8", "Item9", "Item10");

        int pageSize = 3;
        int currentPage = 0;
        List<String> decisions = List.of("y", "y", "y", "n");
        int decisionIndex = 0;

        String showMore;
        do {
            int start = currentPage * pageSize;
            int end = Math.min(start + pageSize, allItems.size());

            logger.info("  Page {} (items {}-{}):", currentPage + 1, start + 1, end);
            for (int i = start; i < end; i++) {
                logger.info("    {}", allItems.get(i));
            }

            currentPage++;
            boolean hasMore = end < allItems.size();

            if (hasMore) {
                showMore = decisions.get(decisionIndex++);
                logger.info("  Show more? (y/n): {}", showMore);
            } else {
                showMore = "n";
                logger.info("  No more items");
            }

        } while (showMore.equals("y") && decisionIndex < decisions.size());
    }

    /**
     * Demonstrates generating values until a condition is met.
     */
    private static void generateUntilCondition() {
        Random random = new Random();
        int generatedValue;
        int attempts = 0;

        do {
            attempts++;
            generatedValue = random.nextInt(100) + 1;
            logger.info("  Attempt {}: Generated {}", attempts, generatedValue);
        } while (generatedValue % 10 != 0); // Continue until divisible by 10

        logger.info("  ✓ Found value divisible by 10: {} (after {} attempts)",
                generatedValue, attempts);
    }

    /**
     * Simulates a game round (play at least once).
     */
    private static void simulateGameRound() {
        Random random = new Random();
        List<String> decisions = List.of("y", "n");
        int decisionIndex = 0;

        int round = 0;
        String continueGame;

        do {
            round++;
            int score = random.nextInt(100);
            logger.info("  Round {}: Score = {}", round, score);

            continueGame = decisions.get(decisionIndex++);
            logger.info("  Continue? (y/n): {}", continueGame);

        } while (continueGame.equals("y") && decisionIndex < decisions.size());

        logger.info("  Game ended after {} round(s)", round);
        logger.info("  ✓ At least one round was played");
    }
}
