package expressivo;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for the Expression abstract data type.
 */
public class ExpressionTest {

	// testing strategy:  
	// partition tests for each concrete class:  
	// - number: test with integers, floating-point values, edge cases like 0 and very large numbers  
	// - variable: test with single-character, multi-character, and case-sensetive variables  
	// - plus: test addition of two numbers, two variables, mixed (number + variable), nested addtions  
	// - times: test multiplication of two numbers, two variables, mixed (number * variable), nested multiplications  

	// for tostring():  
	// - ensure parentheses are corect for readability  
	// - test with nested plus and times combinations  

	// for equals() and hashcode():  
	// - structural equality: ensure two structurally identical expressions are equal  
	// - structral inequality: ensure different expressions are not equal  
	// - hash code consistensy with equals

    @Test
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    // Tests for Number
    @Test
    public void testNumberToString() {
        Expression num = new Number(5.0);
        assertEquals("5.0", num.toString());
    }

    @Test
    public void testNumberEqualsAndHashCode() {
        Expression num1 = new Number(1.0);
        Expression num2 = new Number(1.0);
        Expression num3 = new Number(2.0);

        assertEquals(num1, num2);
        assertEquals(num1.hashCode(), num2.hashCode());
        assertNotEquals(num1, num3);
    }

    // Tests for Variable
    @Test
    public void testVariableToString() {
        Expression var = new Variable("x");
        assertEquals("x", var.toString());
    }

    @Test
    public void testVariableEqualsAndHashCode() {
        Expression var1 = new Variable("x");
        Expression var2 = new Variable("x");
        Expression var3 = new Variable("y");

        assertEquals(var1, var2);
        assertEquals(var1.hashCode(), var2.hashCode());
        assertNotEquals(var1, var3);
    }

    // Tests for Plus
    @Test
    public void testPlusToString() {
        Expression sum = new Plus(new Number(1.0), new Variable("x"));
        assertEquals("(1.0 + x)", sum.toString());
    }

    @Test
    public void testPlusNestedToString() {
        Expression nestedSum = new Plus(new Plus(new Number(1.0), new Variable("x")), new Number(2.0));
        assertEquals("((1.0 + x) + 2.0)", nestedSum.toString());
    }

    @Test
    public void testPlusEqualsAndHashCode() {
        Expression sum1 = new Plus(new Number(1.0), new Variable("x"));
        Expression sum2 = new Plus(new Number(1.0), new Variable("x"));
        Expression sum3 = new Plus(new Variable("x"), new Number(1.0)); // Different structure
        Expression sum4 = new Plus(new Variable("x"), new Variable("y"));

        assertEquals(sum1, sum2);
        assertEquals(sum1.hashCode(), sum2.hashCode());
        assertNotEquals(sum1, sum3);
        assertNotEquals(sum1, sum4);
    }

    // Tests for Times
    @Test
    public void testTimesToString() {
        Expression product = new Times(new Number(2.0), new Variable("y"));
        assertEquals("(2.0 * y)", product.toString());
    }

    @Test
    public void testTimesNestedToString() {
        Expression nestedProduct = new Times(new Times(new Number(2.0), new Variable("y")), new Number(3.0));
        assertEquals("((2.0 * y) * 3.0)", nestedProduct.toString());
    }

    @Test
    public void testTimesEqualsAndHashCode() {
        Expression product1 = new Times(new Number(2.0), new Variable("y"));
        Expression product2 = new Times(new Number(2.0), new Variable("y"));
        Expression product3 = new Times(new Variable("y"), new Number(2.0)); // Different structure
        Expression product4 = new Times(new Variable("x"), new Variable("y"));

        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());
        assertNotEquals(product1, product3);
        assertNotEquals(product1, product4);
    }

    // Mixed tests: Plus and Times combinations
    @Test
    public void testMixedToString() {
        Expression expr = new Plus(new Times(new Number(2.0), new Variable("y")), new Variable("z"));
        assertEquals("((2.0 * y) + z)", expr.toString());
    }

    @Test
    public void testMixedEqualsAndHashCode() {
        Expression expr1 = new Plus(new Times(new Number(2.0), new Variable("y")), new Variable("z"));
        Expression expr2 = new Plus(new Times(new Number(2.0), new Variable("y")), new Variable("z"));
        Expression expr3 = new Plus(new Variable("z"), new Times(new Number(2.0), new Variable("y"))); // Different structure

        assertEquals(expr1, expr2);
        assertEquals(expr1.hashCode(), expr2.hashCode());
        assertNotEquals(expr1, expr3);
    }
}
