package com.andres.datatypes.composite.numeric;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates BigDecimal for precise decimal arithmetic.
 * 
 * <p>
 * <strong>What is BigDecimal?</strong>
 * </p>
 * <p>
 * An immutable class for representing decimal numbers with arbitrary precision.
 * Solves the precision problems inherent in float and double types.
 * </p>
 * 
 * <p>
 * <strong>The Floating-Point Problem:</strong>
 * </p>
 * 
 * <pre>
 * double result = 0.1 + 0.2; // Result: 0.30000000000000004 ❌
 * // This is NOT 0.3 due to binary representation limitations
 * </pre>
 * 
 * <p>
 * <strong>When to Use BigDecimal (MANDATORY):</strong>
 * </p>
 * <ul>
 * <li><strong>Monetary calculations:</strong> Banking, finance, e-commerce
 * (NEVER use double)</li>
 * <li><strong>Scientific calculations:</strong> Where precision is
 * critical</li>
 * <li><strong>Tax calculations:</strong> Accounting, invoicing</li>
 * <li><strong>Any calculation:</strong> Where exact decimal representation is
 * required</li>
 * <li><strong>Avoiding rounding errors:</strong> Cumulative calculations</li>
 * </ul>
 * 
 * <p>
 * <strong>Key Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Immutable (operations return new BigDecimal instances)</li>
 * <li>Arbitrary precision (no overflow for most operations)</li>
 * <li>Exact decimal representation</li>
 * <li>Slower than primitive types (acceptable for correctness)</li>
 * <li>Two components: unscaled value + scale</li>
 * </ul>
 * 
 * <p>
 * <strong>CRITICAL Best Practices:</strong>
 * </p>
 * <ul>
 * <li><strong>ALWAYS use String constructor:</strong> new BigDecimal("0.1")
 * ✓</li>
 * <li><strong>NEVER use double constructor:</strong> new BigDecimal(0.1) ❌
 * (inherits imprecision)</li>
 * <li><strong>Specify RoundingMode for division:</strong> To avoid
 * ArithmeticException</li>
 * <li><strong>Use compareTo() for comparison:</strong> NOT equals() (scale
 * matters in equals)</li>
 * <li><strong>Set appropriate scale:</strong> Use setScale() for monetary
 * values (typically 2 decimals)</li>
 * </ul>
 * 
 * <p>
 * <strong>Common Rounding Modes:</strong>
 * </p>
 * <ul>
 * <li><strong>HALF_UP:</strong> Round towards nearest neighbor, up if
 * equidistant (common)</li>
 * <li><strong>HALF_EVEN:</strong> Banker's rounding (reduces bias)</li>
 * <li><strong>CEILING:</strong> Round towards positive infinity</li>
 * <li><strong>FLOOR:</strong> Round towards negative infinity</li>
 * <li><strong>DOWN:</strong> Round towards zero (truncate)</li>
 * <li><strong>UP:</strong> Round away from zero</li>
 * </ul>
 */
public final class BigDecimalDemo {

    private static final Logger logger = LoggerFactory.getLogger(BigDecimalDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private BigDecimalDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates BigDecimal usage and operations.
     */
    public static void demonstrate() {
        logger.info("--- BigDecimal (Precise Decimal Arithmetic) ---\n");

        // The floating-point precision problem
        demonstratePrecisionProblem();

        // Correct BigDecimal creation
        demonstrateCreation();

        // Basic arithmetic operations
        demonstrateArithmetic();

        // Division with rounding
        demonstrateDivision();

        // Comparison methods
        demonstrateComparison();

        // Scale and rounding
        demonstrateScaleAndRounding();

        // Real-world financial calculations
        demonstrateFinancialCalculations();

        // Common pitfalls
        demonstratePitfalls();

        System.out.println();
    }

    /**
     * Demonstrates the precision problem with float/double.
     * 
     * <p>
     * This is why BigDecimal is MANDATORY for monetary calculations.
     * </p>
     */
    private static void demonstratePrecisionProblem() {
        logger.info("--- The Floating-Point Precision Problem ---");

        // Problem with double
        double d1 = 0.1;
        double d2 = 0.2;
        double dSum = d1 + d2;
        logger.info("double: 0.1 + 0.2 = {} ❌", dSum);
        logger.info("Expected: 0.3");
        logger.info("Actual:   {}", dSum);

        // More examples
        logger.info("\nMore precision issues:");
        logger.info("1.0 - 0.9 = {} (expected: 0.1)", 1.0 - 0.9);
        logger.info("0.1 * 3 = {} (expected: 0.3)", 0.1 * 3);

        // Solution with BigDecimal
        logger.info("\n--- Solution with BigDecimal ---");
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        BigDecimal bdSum = bd1.add(bd2);
        logger.info("BigDecimal: 0.1 + 0.2 = {} ✓", bdSum);

        logger.warn("\nWARNING: NEVER use float/double for money!");
        logger.warn("Always use BigDecimal for financial calculations.");
    }

    /**
     * Demonstrates correct and incorrect BigDecimal creation.
     * 
     * <p>
     * <strong>CRITICAL RULE:</strong> Always use String constructor, never double.
     * </p>
     */
    private static void demonstrateCreation() {
        logger.info("\n--- BigDecimal Creation ---");

        // CORRECT: String constructor
        BigDecimal correct = new BigDecimal("0.1");
        logger.info("✓ CORRECT - String constructor: new BigDecimal(\"0.1\") = {}", correct);

        // WRONG: double constructor (inherits imprecision)
        BigDecimal wrong = new BigDecimal(0.1);
        logger.info("✗ WRONG - double constructor: new BigDecimal(0.1) = {}", wrong);
        logger.warn("  Notice the imprecision from double!");

        // Alternative correct methods
        BigDecimal fromInt = BigDecimal.valueOf(100);
        BigDecimal fromLong = BigDecimal.valueOf(1000L);
        logger.info("\nOther correct methods:");
        logger.info("BigDecimal.valueOf(100) = {}", fromInt);
        logger.info("BigDecimal.valueOf(1000L) = {}", fromLong);

        // Creating common values
        logger.info("\nCommon constants:");
        logger.info("BigDecimal.ZERO = {}", BigDecimal.ZERO);
        logger.info("BigDecimal.ONE = {}", BigDecimal.ONE);
        logger.info("BigDecimal.TEN = {}", BigDecimal.TEN);
    }

    /**
     * Demonstrates basic arithmetic operations.
     * 
     * <p>
     * <strong>Important:</strong> BigDecimal is immutable. Operations return
     * new instances, they don't modify the original.
     * </p>
     */
    private static void demonstrateArithmetic() {
        logger.info("\n--- Arithmetic Operations ---");

        BigDecimal a = new BigDecimal("10.50");
        BigDecimal b = new BigDecimal("3.25");

        logger.info("a = {}", a);
        logger.info("b = {}", b);

        // Addition
        BigDecimal sum = a.add(b);
        logger.info("\nAddition (a + b): {}", sum);

        // Subtraction
        BigDecimal difference = a.subtract(b);
        logger.info("Subtraction (a - b): {}", difference);

        // Multiplication
        BigDecimal product = a.multiply(b);
        logger.info("Multiplication (a * b): {}", product);

        // Division (requires rounding mode - see next section)
        BigDecimal quotient = a.divide(b, 2, RoundingMode.HALF_UP);
        logger.info("Division (a / b): {} (rounded to 2 decimals)", quotient);

        // Absolute value
        BigDecimal negative = new BigDecimal("-15.75");
        BigDecimal absolute = negative.abs();
        logger.info("\nAbsolute value of {}: {}", negative, absolute);

        // Negate
        BigDecimal negated = a.negate();
        logger.info("Negate {}: {}", a, negated);

        // Power
        BigDecimal squared = a.pow(2);
        logger.info("Square of {}: {}", a, squared);
    }

    /**
     * Demonstrates division with proper rounding.
     * 
     * <p>
     * <strong>WARNING:</strong> Division without specifying scale and rounding
     * mode can throw ArithmeticException for non-terminating decimals.
     * </p>
     */
    private static void demonstrateDivision() {
        logger.info("\n--- Division with Rounding ---");

        BigDecimal dividend = new BigDecimal("10");
        BigDecimal divisor = new BigDecimal("3");

        logger.info("Dividing {} by {}", dividend, divisor);

        // This would throw ArithmeticException (non-terminating decimal)
        // BigDecimal result = dividend.divide(divisor); // DON'T DO THIS!

        // Correct: Specify scale and rounding mode
        BigDecimal result2 = dividend.divide(divisor, 2, RoundingMode.HALF_UP);
        logger.info("With scale 2, HALF_UP: {}", result2);

        BigDecimal result5 = dividend.divide(divisor, 5, RoundingMode.HALF_UP);
        logger.info("With scale 5, HALF_UP: {}", result5);

        // Different rounding modes
        logger.info("\n--- Different Rounding Modes ---");
        BigDecimal value = new BigDecimal("2.5");
        BigDecimal two = new BigDecimal("2");

        logger.info("Dividing {} by {} with different rounding modes:", value, two);
        logger.info("HALF_UP: {}", value.divide(two, 0, RoundingMode.HALF_UP));
        logger.info("HALF_DOWN: {}", value.divide(two, 0, RoundingMode.HALF_DOWN));
        logger.info("HALF_EVEN (Banker's): {}", value.divide(two, 0, RoundingMode.HALF_EVEN));
        logger.info("CEILING: {}", value.divide(two, 0, RoundingMode.CEILING));
        logger.info("FLOOR: {}", value.divide(two, 0, RoundingMode.FLOOR));
        logger.info("UP: {}", value.divide(two, 0, RoundingMode.UP));
        logger.info("DOWN: {}", value.divide(two, 0, RoundingMode.DOWN));
    }

    /**
     * Demonstrates proper comparison methods.
     * 
     * <p>
     * <strong>CRITICAL:</strong> Use compareTo(), NOT equals() for value
     * comparison.
     * </p>
     */
    private static void demonstrateComparison() {
        logger.info("\n--- Comparison Methods ---");

        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("1.00");

        logger.info("a = {} (scale: {})", a, a.scale());
        logger.info("b = {} (scale: {})", b, b.scale());

        // equals() compares value AND scale
        boolean equalsResult = a.equals(b);
        logger.info("\na.equals(b): {} (compares value AND scale) ✗", equalsResult);

        // compareTo() compares only value (CORRECT for numerical comparison)
        int compareResult = a.compareTo(b);
        logger.info("a.compareTo(b): {} (compares only value) ✓", compareResult);
        logger.info("a.compareTo(b) == 0: {} (values are equal)", compareResult == 0);

        // Comparison operators
        logger.info("\n--- Comparison Examples ---");
        BigDecimal x = new BigDecimal("10.5");
        BigDecimal y = new BigDecimal("5.25");

        logger.info("{} > {}: {}", x, y, x.compareTo(y) > 0);
        logger.info("{} < {}: {}", x, y, x.compareTo(y) < 0);
        logger.info("{} >= {}: {}", x, x, x.compareTo(x) >= 0);
        logger.info("{} == {}: {}", x, x, x.compareTo(x) == 0);

        // max and min
        BigDecimal max = x.max(y);
        BigDecimal min = x.min(y);
        logger.info("\nMax of {} and {}: {}", x, y, max);
        logger.info("Min of {} and {}: {}", x, y, min);
    }

    /**
     * Demonstrates scale management and rounding.
     * 
     * <p>
     * <strong>Scale:</strong> Number of digits to the right of decimal point.
     * </p>
     */
    private static void demonstrateScaleAndRounding() {
        logger.info("\n--- Scale and Rounding ---");

        BigDecimal value = new BigDecimal("123.456789");
        logger.info("Original value: {} (scale: {})", value, value.scale());

        // Set scale with rounding
        BigDecimal rounded2 = value.setScale(2, RoundingMode.HALF_UP);
        logger.info("Rounded to 2 decimals (HALF_UP): {}", rounded2);

        BigDecimal rounded4 = value.setScale(4, RoundingMode.HALF_UP);
        logger.info("Rounded to 4 decimals (HALF_UP): {}", rounded4);

        // Increase scale (add zeros)
        BigDecimal extended = rounded2.setScale(5, RoundingMode.UNNECESSARY);
        logger.info("Extended to 5 decimals: {}", extended);

        // Strip trailing zeros
        BigDecimal withZeros = new BigDecimal("100.00");
        BigDecimal stripped = withZeros.stripTrailingZeros();
        logger.info("\nOriginal: {} (scale: {})", withZeros, withZeros.scale());
        logger.info("Stripped: {} (scale: {})", stripped, stripped.scale());

        // Precision vs Scale
        logger.info("\n--- Precision vs Scale ---");
        BigDecimal num = new BigDecimal("123.4500");
        logger.info("Value: {}", num);
        logger.info("Precision (total digits): {}", num.precision());
        logger.info("Scale (decimal places): {}", num.scale());
    }

    /**
     * Demonstrates real-world financial calculations.
     */
    private static void demonstrateFinancialCalculations() {
        logger.info("\n--- Real-World Financial Calculations ---");

        // Example 1: E-commerce total calculation
        logger.info("Example 1: E-commerce Order Total");
        BigDecimal itemPrice = new BigDecimal("19.99");
        BigDecimal quantity = new BigDecimal("3");
        BigDecimal taxRate = new BigDecimal("0.16"); // 16% tax

        BigDecimal subtotal = itemPrice.multiply(quantity);
        BigDecimal tax = subtotal.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = subtotal.add(tax);

        logger.info("Item price: ${}", itemPrice);
        logger.info("Quantity: {}", quantity);
        logger.info("Subtotal: ${}", subtotal);
        logger.info("Tax (16%): ${}", tax);
        logger.info("TOTAL: ${}", total.setScale(2, RoundingMode.HALF_UP));

        // Example 2: Interest calculation
        logger.info("\nExample 2: Simple Interest Calculation");
        BigDecimal principal = new BigDecimal("1000.00");
        BigDecimal rate = new BigDecimal("0.05"); // 5% annual rate
        BigDecimal time = new BigDecimal("2"); // 2 years

        BigDecimal interest = principal.multiply(rate).multiply(time);
        BigDecimal amount = principal.add(interest);

        logger.info("Principal: ${}", principal);
        logger.info("Annual rate: {}%", rate.multiply(new BigDecimal("100")));
        logger.info("Time: {} years", time);
        logger.info("Interest: ${}", interest.setScale(2, RoundingMode.HALF_UP));
        logger.info("Total amount: ${}", amount.setScale(2, RoundingMode.HALF_UP));

        // Example 3: Currency conversion
        logger.info("\nExample 3: Currency Conversion");
        BigDecimal usdAmount = new BigDecimal("100.00");
        BigDecimal exchangeRate = new BigDecimal("4250.50"); // USD to COP

        BigDecimal copAmount = usdAmount.multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP);
        logger.info("USD: ${}", usdAmount);
        logger.info("Exchange rate: 1 USD = {} COP", exchangeRate);
        logger.info("COP: ${}", copAmount);

        // Example 4: Discount calculation
        logger.info("\nExample 4: Discount Calculation");
        BigDecimal originalPrice = new BigDecimal("250.00");
        BigDecimal discountPercent = new BigDecimal("0.20"); // 20% off

        BigDecimal discountAmount = originalPrice.multiply(discountPercent).setScale(2, RoundingMode.HALF_UP);
        BigDecimal finalPrice = originalPrice.subtract(discountAmount);

        logger.info("Original price: ${}", originalPrice);
        logger.info("Discount: {}%", discountPercent.multiply(new BigDecimal("100")));
        logger.info("Discount amount: ${}", discountAmount);
        logger.info("Final price: ${}", finalPrice);
    }

    /**
     * Demonstrates common pitfalls and how to avoid them.
     */
    private static void demonstratePitfalls() {
        logger.info("\n--- Common Pitfalls and Solutions ---");

        // Pitfall 1: Using double constructor
        logger.info("Pitfall 1: Using double constructor");
        double d = 0.1;
        BigDecimal wrong = new BigDecimal(d);
        BigDecimal correct = new BigDecimal("0.1");
        logger.info("new BigDecimal(0.1): {} ✗", wrong);
        logger.info("new BigDecimal(\"0.1\"): {} ✓", correct);

        // Pitfall 2: Forgetting to assign result (immutability)
        logger.info("\nPitfall 2: Forgetting immutability");
        BigDecimal value = new BigDecimal("10");
        value.add(new BigDecimal("5")); // WRONG: result not captured
        logger.info("After value.add(5) without assignment: {} (unchanged)", value);
        value = value.add(new BigDecimal("5")); // CORRECT
        logger.info("After value = value.add(5): {} ✓", value);

        // Pitfall 3: Division without rounding mode
        logger.info("\nPitfall 3: Division without rounding mode");
        logger.info("10 / 3 without rounding mode → ArithmeticException");
        logger.info("Solution: Always specify scale and rounding mode");
        BigDecimal result = new BigDecimal("10").divide(new BigDecimal("3"), 2, RoundingMode.HALF_UP);
        logger.info("Correct: {}", result);

        // Pitfall 4: Using equals() instead of compareTo()
        logger.info("\nPitfall 4: Using equals() for comparison");
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("1.00");
        logger.info("1.0 equals 1.00: {} (different scales) ✗", a.equals(b));
        logger.info("1.0 compareTo 1.00 == 0: {} ✓", a.compareTo(b) == 0);

        // Pitfall 5: Not setting appropriate scale for money
        logger.info("\nPitfall 5: Scale management for money");
        BigDecimal money = new BigDecimal("10.5");
        logger.info("Money without scale: {} (missing cent)", money);
        BigDecimal properMoney = money.setScale(2, RoundingMode.UNNECESSARY);
        logger.info("Money with scale 2: {} ✓", properMoney);

        logger.info("\n=== BigDecimal Best Practices Summary ===");
        logger.info("1. Always use String constructor: new BigDecimal(\"0.1\")");
        logger.info("2. Specify scale and rounding for division");
        logger.info("3. Use compareTo() for comparison, not equals()");
        logger.info("4. Remember immutability: result = value.add(x)");
        logger.info("5. Set scale to 2 for monetary values");
    }
}
