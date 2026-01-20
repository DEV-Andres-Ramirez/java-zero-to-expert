package com.andres.datatypes.composite.collections.queues;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates Queue, a collection designed for holding elements prior to
 * processing.
 * 
 * <p>
 * <strong>Queue Characteristics:</strong>
 * </p>
 * <ul>
 * <li>FIFO: First In, First Out (like a line of people)</li>
 * <li>Elements added at the tail (rear)</li>
 * <li>Elements removed from the head (front)</li>
 * <li>Processes elements in order of arrival</li>
 * <li>Supports both exception-throwing and special-value methods</li>
 * </ul>
 * 
 * <p>
 * <strong>Queue Method Types:</strong>
 * </p>
 * <table>
 * <tr>
 * <th>Operation</th>
 * <th>Throws Exception</th>
 * <th>Returns Special Value</th>
 * </tr>
 * <tr>
 * <td>Insert</td>
 * <td>add(e)</td>
 * <td>offer(e)</td>
 * </tr>
 * <tr>
 * <td>Remove</td>
 * <td>remove()</td>
 * <td>poll()</td>
 * </tr>
 * <tr>
 * <td>Examine</td>
 * <td>element()</td>
 * <td>peek()</td>
 * </tr>
 * </table>
 * 
 * <p>
 * <strong>When to Use Queue:</strong>
 * </p>
 * <ul>
 * <li>Task processing in order of arrival</li>
 * <li>BFS (Breadth-First Search) algorithms</li>
 * <li>Message queues and event processing</li>
 * <li>Job scheduling systems</li>
 * <li>Print spooling, customer service queues</li>
 * <li>Request buffering in web servers</li>
 * </ul>
 * 
 * <p>
 * <strong>Common Queue Implementations:</strong>
 * </p>
 * <ul>
 * <li><strong>LinkedList:</strong> General-purpose FIFO queue</li>
 * <li><strong>ArrayDeque:</strong> More efficient than LinkedList
 * (recommended)</li>
 * <li><strong>PriorityQueue:</strong> Elements ordered by priority, not
 * FIFO</li>
 * <li><strong>BlockingQueue:</strong> Thread-safe for producer-consumer
 * patterns</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use offer(), poll(), peek() instead of add(), remove(), element() to
 * avoid exceptions</li>
 * <li>Prefer ArrayDeque over LinkedList for better performance</li>
 * <li>Check isEmpty() before calling poll() or peek()</li>
 * <li>Use PriorityQueue when elements need priority ordering</li>
 * <li>For concurrent scenarios, use BlockingQueue implementations</li>
 * </ul>
 */
public final class QueueDemo {

    private static final Logger logger = LoggerFactory.getLogger(QueueDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private QueueDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates Queue usage and operations.
     */
    public static void demonstrate() {
        logger.info("--- Queue (FIFO - First In First Out) ---\n");

        // Basic FIFO queue operations
        demonstrateBasicOperations();

        // Exception vs Special Value methods
        demonstrateMethodTypes();

        // Queue processing patterns
        demonstrateProcessingPatterns();

        // PriorityQueue (priority-based ordering)
        demonstratePriorityQueue();

        // Real-world examples
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates basic Queue operations.
     */
    private static void demonstrateBasicOperations() {
        logger.info("--- Basic FIFO Operations ---");

        // Create queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // Adding elements (enqueue)
        queue.offer("Customer 1");
        queue.offer("Customer 2");
        queue.offer("Customer 3");
        queue.offer("Customer 4");

        logger.info("Queue after adding 4 customers: {}", queue);
        logger.info("Size: {}", queue.size());

        // Peek (examine front without removing)
        String front = queue.peek();
        logger.info("Front customer (peek): {}", front);
        logger.info("Queue after peek: {} (unchanged)", queue);

        // Poll (remove and return front)
        String served = queue.poll();
        logger.info("\nServing: {}", served);
        logger.info("Queue after poll: {}", queue);

        // Check if empty
        logger.info("Is queue empty? {}", queue.isEmpty());
    }

    /**
     * Demonstrates difference between exception-throwing and special-value methods.
     * 
     * <p>
     * <strong>Method Comparison:</strong>
     * </p>
     * <ul>
     * <li>add() vs offer(): add() throws exception if queue is full, offer()
     * returns false</li>
     * <li>remove() vs poll(): remove() throws exception if empty, poll() returns
     * null</li>
     * <li>element() vs peek(): element() throws exception if empty, peek() returns
     * null</li>
     * </ul>
     */
    private static void demonstrateMethodTypes() {
        logger.info("\n--- Exception vs Special Value Methods ---");

        Queue<String> queue = new LinkedList<>();

        // offer() - Returns false if cannot add (safer)
        boolean added = queue.offer("Task 1");
        logger.info("offer() result: {}", added);

        // add() - Throws exception if cannot add
        queue.add("Task 2");
        logger.info("add() succeeded");

        logger.info("Queue: {}", queue);

        // peek() - Returns null if empty (safer)
        String peeked = queue.peek();
        logger.info("peek() result: {}", peeked);

        // element() - Throws exception if empty
        String examined = queue.element();
        logger.info("element() result: {}", examined);

        // poll() - Returns null if empty (safer)
        String polled = queue.poll();
        logger.info("poll() result: {}", polled);

        // remove() - Throws exception if empty
        String removed = queue.remove();
        logger.info("remove() result: {}", removed);

        // Now queue is empty
        logger.info("\nQueue is now empty");

        // Safe operations on empty queue
        String safePeek = queue.peek();
        String safePoll = queue.poll();
        logger.info("peek() on empty queue: {}", safePeek);
        logger.info("poll() on empty queue: {}", safePoll);

        logger.info("\nRecommendation: Use offer(), poll(), peek() to avoid exceptions");
    }

    /**
     * Demonstrates common queue processing patterns.
     */
    private static void demonstrateProcessingPatterns() {
        logger.info("\n--- Queue Processing Patterns ---");

        // Pattern 1: Process all elements
        logger.info("Pattern 1: Process Until Empty");
        Queue<String> tasks = new LinkedList<>();
        tasks.offer("Task A");
        tasks.offer("Task B");
        tasks.offer("Task C");
        tasks.offer("Task D");

        logger.info("Initial queue: {}", tasks);
        logger.info("Processing all tasks:");

        while (!tasks.isEmpty()) {
            String task = tasks.poll();
            logger.info("  Processing: {}", task);
        }
        logger.info("Queue is now empty: {}", tasks.isEmpty());

        // Pattern 2: Process with peek and conditional removal
        logger.info("\nPattern 2: Conditional Processing");
        Queue<Integer> numbers = new LinkedList<>();
        numbers.offer(10);
        numbers.offer(5);
        numbers.offer(15);
        numbers.offer(3);

        logger.info("Initial queue: {}", numbers);
        logger.info("Processing numbers greater than 5:");

        while (!numbers.isEmpty()) {
            Integer num = numbers.peek();
            if (num > 5) {
                numbers.poll();
                logger.info("  Processed: {}", num);
            } else {
                logger.info("  Skipping: {} (≤ 5)", num);
                break; // Stop at first non-qualifying element
            }
        }
        logger.info("Remaining queue: {}", numbers);

        // Pattern 3: Batch processing
        logger.info("\nPattern 3: Batch Processing");
        Queue<String> jobs = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            jobs.offer("Job-" + i);
        }

        int batchSize = 3;
        int batchNumber = 1;

        logger.info("Processing in batches of {}:", batchSize);
        while (!jobs.isEmpty()) {
            logger.info("  Batch {}:", batchNumber++);
            for (int i = 0; i < batchSize && !jobs.isEmpty(); i++) {
                logger.info("    {}", jobs.poll());
            }
        }
    }

    /**
     * Demonstrates PriorityQueue for priority-based ordering.
     * 
     * <p>
     * <strong>PriorityQueue Characteristics:</strong>
     * </p>
     * <ul>
     * <li>NOT FIFO - elements ordered by natural ordering or comparator</li>
     * <li>Smallest element (or highest priority) always at the head</li>
     * <li>Backed by binary heap internally</li>
     * <li>O(log n) for add/poll, O(1) for peek</li>
     * </ul>
     */
    private static void demonstratePriorityQueue() {
        logger.info("\n--- PriorityQueue (Priority-Based Ordering) ---");

        // Natural ordering (numbers: smallest first)
        logger.info("PriorityQueue with natural ordering:");
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(5);
        priorityQueue.offer(1);
        priorityQueue.offer(3);
        priorityQueue.offer(9);
        priorityQueue.offer(2);

        logger.info("Added in order: 5, 1, 3, 9, 2");
        logger.info("Processing by priority (smallest first):");
        while (!priorityQueue.isEmpty()) {
            logger.info("  {}", priorityQueue.poll());
        }

        // Custom comparator (largest first)
        logger.info("\nPriorityQueue with custom comparator (largest first):");
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.offer(5);
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.offer(9);
        maxHeap.offer(2);

        logger.info("Processing by priority (largest first):");
        while (!maxHeap.isEmpty()) {
            logger.info("  {}", maxHeap.poll());
        }

        // Priority queue with objects
        demonstrateTaskPriorityQueue();
    }

    /**
     * Demonstrates PriorityQueue with custom objects.
     */
    private static void demonstrateTaskPriorityQueue() {
        logger.info("\n--- PriorityQueue with Task Objects ---");

        // Task with priority
        record Task(String name, int priority) implements Comparable<Task> {
            @Override
            public int compareTo(Task other) {
                return Integer.compare(other.priority, this.priority); // Higher priority first
            }

            @Override
            public String toString() {
                return String.format("%s (priority: %d)", name, priority);
            }
        }

        Queue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.offer(new Task("Email response", 2));
        taskQueue.offer(new Task("Critical bug fix", 5));
        taskQueue.offer(new Task("Code review", 3));
        taskQueue.offer(new Task("Documentation", 1));
        taskQueue.offer(new Task("Security patch", 5));

        logger.info("Processing tasks by priority:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            logger.info("  {}", task);
        }
    }

    /**
     * Demonstrates real-world use cases for Queue.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Customer service queue
        logger.info("Example 1: Customer Service Queue");
        Queue<String> customerService = new LinkedList<>();
        customerService.offer("Customer #101");
        customerService.offer("Customer #102");
        customerService.offer("Customer #103");

        logger.info("Waiting customers: {}", customerService.size());
        logger.info("Now serving: {}", customerService.poll());
        logger.info("Next in line: {}", customerService.peek());

        // Example 2: Print job queue
        logger.info("\nExample 2: Print Job Queue");
        Queue<String> printQueue = new LinkedList<>();
        printQueue.offer("Document1.pdf - 10 pages");
        printQueue.offer("Report.docx - 5 pages");
        printQueue.offer("Spreadsheet.xlsx - 3 pages");

        logger.info("Print queue:");
        int jobNumber = 1;
        while (!printQueue.isEmpty()) {
            logger.info("  Printing job {}: {}", jobNumber++, printQueue.poll());
        }

        // Example 3: BFS (Breadth-First Search) simulation
        logger.info("\nExample 3: BFS Traversal Simulation");
        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.offer("Root");
        bfsQueue.offer("Root -> Left");
        bfsQueue.offer("Root -> Right");
        bfsQueue.offer("Root -> Left -> Left");
        bfsQueue.offer("Root -> Left -> Right");

        logger.info("BFS traversal order:");
        while (!bfsQueue.isEmpty()) {
            logger.info("  Visiting: {}", bfsQueue.poll());
        }

        // Example 4: Request buffer for rate limiting
        logger.info("\nExample 4: Request Buffer (Rate Limiting)");
        Queue<String> requestBuffer = new LinkedList<>();
        int maxBufferSize = 5;

        // Simulate incoming requests
        for (int i = 1; i <= 7; i++) {
            if (requestBuffer.size() < maxBufferSize) {
                requestBuffer.offer("Request-" + i);
                logger.info("  Buffered: Request-{}", i);
            } else {
                logger.warn("  Rejected: Request-{} (buffer full)", i);
            }
        }

        logger.info("Processing buffered requests:");
        while (!requestBuffer.isEmpty()) {
            logger.info("  Processing: {}", requestBuffer.poll());
        }
    }
}
