package mymath.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mymath.MyFraction;

class TestsMyFraction {

	@Test
	public void testNumeratorConstructor() {
		MyFraction test = new MyFraction(2, 3, '+');
		assertNotNull(test.getNumerator());
	}

	@Test
	public void testDenominatorConstructor() {
		MyFraction test = new MyFraction(2, 3, '+');
		assertNotNull(test.getDenominator());
	}

	@Test
	public void testSignConstructor() {
		MyFraction test = new MyFraction(2, 3, '-');
		assertNotNull(test.getSign());
	}

	@Test
	public void testFractionReduction() {
		MyFraction test = new MyFraction(3, 6, '+');
		MyFraction reduced = new MyFraction(1, 2, '+');
		assertTrue(test.equals(reduced));
	}

	@Test
	public void testNumerator() {
		MyFraction test = new MyFraction(2, 4, '+');
		assertSame(test.getNumerator(), 2);
	}

	@Test
	public void testDenominator() {
		MyFraction test = new MyFraction(1, 4, '-');
		assertSame(test.getDenominator(), 4);
	}

	@Test
	public void testSign() {
		MyFraction test = new MyFraction(1, 2, '+');
		assertSame(test.getSign(), '+');
	}

	@Test
	public void testAddDoublePositive() {
		MyFraction test = new MyFraction(1, 4, '+');
		MyFraction add = new MyFraction(3, 4, '+');
		MyFraction result = new MyFraction(1, 1, '+');
		assertTrue(result.equals(test.add(add)));
	}
	
	@Test
	public void testAddPositiveNegative() {
		MyFraction test = new MyFraction(1, 4, '+');
		MyFraction add = new MyFraction(3, 4, '-');
		MyFraction result = new MyFraction(1, 2, '-');
		assertTrue(result.equals(test.add(add)));
	}
	
	@Test
	public void testAddNegativePositive() {
		MyFraction test = new MyFraction(1, 4, '-');
		MyFraction add = new MyFraction(3, 4, '+');
		MyFraction result = new MyFraction(1, 2, '+');
		assertTrue(result.equals(test.add(add)));
	}
	
	@Test
	public void testAddDoubleNegative() {
		MyFraction test = new MyFraction(1, 4, '-');
		MyFraction add = new MyFraction(3, 4, '-');
		MyFraction result = new MyFraction(1, 1, '-');
		assertTrue(result.equals(test.add(add)));
	}

	@Test
	public void testSubtractDoublePositive() {
		MyFraction test = new MyFraction(1, 5, '+');
		MyFraction subtract = new MyFraction(3, 5, '+');
		MyFraction result = new MyFraction(2, 5, '-');
		assertTrue(result.equals(test.subtract(subtract)));
	}
	
	@Test
	public void testSubtractPositiveNegative() {
		MyFraction test = new MyFraction(1, 5, '+');
		MyFraction subtract = new MyFraction(3, 5, '-');
		MyFraction result = new MyFraction(4, 5, '+');
		assertTrue(result.equals(test.subtract(subtract)));
	}
	
	@Test
	public void testSubtractNegativePositive() {
		MyFraction test = new MyFraction(1, 5, '-');
		MyFraction subtract = new MyFraction(3, 5, '+');
		MyFraction result = new MyFraction(4, 5, '-');
		assertTrue(result.equals(test.subtract(subtract)));
	}
	
	@Test
	public void testSubtractDoubleNegative() {
		MyFraction test = new MyFraction(1, 5, '-');
		MyFraction subtract = new MyFraction(3, 5, '-');
		MyFraction result = new MyFraction(2, 5, '+');
		assertTrue(result.equals(test.subtract(subtract)));
	}

	@Test
	public void testMultiplyDoublePositive() {
		MyFraction test = new MyFraction(5, 5, '+');
		MyFraction multiply = new MyFraction(1, 5, '+');
		MyFraction result = new MyFraction(1, 5, '+');
		assertTrue(result.equals(test.multiply(multiply)));
	}
	
	@Test
	public void testMultiplyDoubleNegative() {
		MyFraction test = new MyFraction(5, 5, '-');
		MyFraction multiply = new MyFraction(1, 5, '-');
		MyFraction result = new MyFraction(1, 5, '+');
		assertTrue(result.equals(test.multiply(multiply)));
	}
	
	@Test
	public void testMultiplyPositiveNegative() {
		MyFraction test = new MyFraction(5, 5, '+');
		MyFraction multiply = new MyFraction(1, 5, '-');
		MyFraction result = new MyFraction(1, 5, '-');
		assertTrue(result.equals(test.multiply(multiply)));
	}
	
	@Test
	public void testMultiplyNegativePositive() {
		MyFraction test = new MyFraction(5, 5, '-');
		MyFraction multiply = new MyFraction(1, 5, '+');
		MyFraction result = new MyFraction(1, 5, '-');
		assertTrue(result.equals(test.multiply(multiply)));
	}

	@Test
	public void testDivideDoublePositive() {
		MyFraction test = new MyFraction(2, 3, '+');
		MyFraction divide = new MyFraction(3, 1, '+');
		MyFraction result = new MyFraction(2, 9, '+');
		assertTrue(result.equals(test.divide(divide)));
	}
	
	@Test
	public void testDivideDoubleNegative() {
		MyFraction test = new MyFraction(2, 3, '-');
		MyFraction divide = new MyFraction(3, 1, '-');
		MyFraction result = new MyFraction(2, 9, '+');
		assertTrue(result.equals(test.divide(divide)));
	}
	
	@Test
	public void testDividePositiveNegative() {
		MyFraction test = new MyFraction(2, 3, '+');
		MyFraction divide = new MyFraction(3, 1, '-');
		MyFraction result = new MyFraction(2, 9, '-');
		assertTrue(result.equals(test.divide(divide)));
	}
	
	@Test
	public void testDivideNegativePositive() {
		MyFraction test = new MyFraction(2, 3, '-');
		MyFraction divide = new MyFraction(3, 1, '+');
		MyFraction result = new MyFraction(2, 9, '-');
		assertTrue(result.equals(test.divide(divide)));
	}
	
	@Test
	public void testToString() {
		MyFraction test = new MyFraction( 3 , 10 , '+' );
		assertNotNull( test.toString() );
	}
}
