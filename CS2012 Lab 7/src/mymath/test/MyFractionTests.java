package mymath.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mymath.MyFraction;

class MyFractionTests {

	@Test
	void testCreatable() {
		MyFraction fraction = new MyFraction(1,1, '+');
		assertNotNull(fraction);
	}
	
	@Test
	void testNegativeNumerator() {
		MyFraction fraction = new MyFraction(-1,5, '+');
		assertSame(fraction.getNumerator(), 1);
	}
	
	@Test
	void testNegativeDenominator() {
		MyFraction fraction = new MyFraction(1,-5, '+');
		assertSame(fraction.getDenominator(), 5);
	}
	
	@Test
	void test0Denominator() {
		String message = null;
		try {
			MyFraction fraction = new MyFraction(1,0, '+');
		}catch(IllegalArgumentException e) {
			message = e.getMessage();
			System.err.println("Test Construct with 0 Denominator: " + message);
		}
		assertEquals(message, "Trying to Enter Denominator of 0");
	}
	
	@Test
	void testInvalidSign() {
		String message = null;
		try {
			MyFraction fraction = new MyFraction(2,5, 'f');
		}catch(IllegalArgumentException e) {
			message = e.getMessage();
			System.err.println("Test Invalid Sign Char: " + message);
		}
		assertEquals(message, "Invalid Sign Character Entererd (+, -)");
	}
	
	@Test
	void testNumeratorGet() {
		MyFraction fraction = new MyFraction(1,1, '+');
		assertSame(fraction.getNumerator(), 1);
	}
	
	@Test
	void testNumeratorSet() {
		MyFraction fraction = new MyFraction(1,1, '+');
		fraction.setNumerator(5);
		assertSame(fraction.getNumerator(), 5);
	}

	@Test
	void testDenominatorGet() {
		MyFraction fraction = new MyFraction(1,1, '+');
		assertSame(fraction.getDenominator(), 1);
	}
	
	@Test
	void testDenominatorSet() {
		MyFraction fraction = new MyFraction(1,1, '+');
		fraction.setDenominator(5);
		assertSame(fraction.getDenominator(), 5);
	}

	@Test
	void testSignGet() {
		MyFraction fraction = new MyFraction(1,1, '+');
		assertEquals(fraction.getSign(), '+');
	}
	
	@Test
	void testSignSet() {
		MyFraction fraction = new MyFraction(1,1, '+');
		fraction.setSign('-');
		assertEquals(fraction.getSign(), '-');
	}

	@Test
	void testToStringPositive() {
		MyFraction fraction = new MyFraction(2,3, '+');
		assertEquals(fraction.toString(), "2/3");
	}
	
	@Test
	void testToStringNegative() {
		MyFraction fraction = new MyFraction(1,3, '-');
		assertEquals(fraction.toString(), "-1/3");
	}
	
	@Test
	void testEquals() {
		MyFraction fraction = new MyFraction(2,3, '+');
		assertEquals(fraction, new MyFraction(2, 3, '+'));
	}
	
	@Test
	void testEqualsWhenNotReduced() {
		MyFraction fraction = new MyFraction(2,3, '+');
		assertEquals(fraction, new MyFraction(40, 60, '+'));
	}
	
	@Test
	void testEqualsNegative() {
		MyFraction fraction = new MyFraction(2,3, '-');
		assertEquals(fraction, new MyFraction(2, 3, '-'));
	}
	
	@Test
	void testSmallest() {
		MyFraction fraction = new MyFraction(2,10, '+');
		MyFraction fractionSmaller = fraction.reduceFraction();
		assertEquals(fractionSmaller, new MyFraction(1,5,'+'));
	}
	
	@Test
	void testSmallest2() {
		MyFraction fraction = new MyFraction(98,21, '+');
		MyFraction fractionSmaller = fraction.reduceFraction();
		assertEquals(fractionSmaller, new MyFraction(14,3,'+'));
	}
	
	@Test
	void testSmallestNegative() {
		MyFraction fraction = new MyFraction(3,15, '-');
		MyFraction fractionSmaller = fraction.reduceFraction();
		assertEquals(fractionSmaller, new MyFraction(1,5,'-'));
	}
	
	@Test
	void testSmallestWhenSmall() {
		MyFraction fraction = new MyFraction(5,7, '+');
		MyFraction fractionSmaller = fraction.reduceFraction();
		assertEquals(fractionSmaller, new MyFraction(5,7,'+'));
	}
	
	@Test
	void testMuliplyPosPos() {
		MyFraction fraction = new MyFraction(5,7, '+');
		MyFraction fraction2 = new MyFraction(1,2, '+');
		MyFraction fractionProduct = fraction.multiply(fraction2);
		assertEquals(fractionProduct, new MyFraction(5,14,'+'));
	}
	
	@Test
	void testMuliplyPosNeg() {
		MyFraction fraction = new MyFraction(5,7, '+');
		MyFraction fraction2 = new MyFraction(1,2, '-');
		MyFraction fractionProduct = fraction.multiply(fraction2);
		assertEquals(fractionProduct, new MyFraction(5,14,'-'));
	}
	
	@Test
	void testMuliplyNegPos() {
		MyFraction fraction = new MyFraction(5,7, '-');
		MyFraction fraction2 = new MyFraction(1,2, '+');
		MyFraction fractionProduct = fraction.multiply(fraction2);
		assertEquals(fractionProduct, new MyFraction(5,14,'-'));
	}
	
	@Test
	void testMuliplyNegNeg() {
		MyFraction fraction = new MyFraction(5,7, '-');
		MyFraction fraction2 = new MyFraction(1,2, '-');
		MyFraction fractionProduct = fraction.multiply(fraction2);
		assertEquals(fractionProduct, new MyFraction(5,14,'+'));
	}
	
	@Test
	void testMuliplyForSmallest() {
		MyFraction fraction = new MyFraction(4,10, '+');
		MyFraction fraction2 = new MyFraction(2,5, '+');
		MyFraction fractionProduct = fraction.multiply(fraction2);
		assertEquals(fractionProduct, new MyFraction(4,25,'+'));
	}
	
	@Test
	void testMuliplyBy0() {
		MyFraction fraction = new MyFraction(4,10, '+');
		MyFraction fraction2 = new MyFraction(0,5, '+');
		MyFraction fractionProduct = fraction.multiply(fraction2);
		assertEquals(fractionProduct, new MyFraction(0,1,'+'));
	}
	
	@Test
	void testDivide() {
		MyFraction fraction = new MyFraction(2,7, '+');
		MyFraction fraction2 = new MyFraction(1,2, '+');
		MyFraction fractionProduct = fraction.divide(fraction2);
		assertEquals(fractionProduct, new MyFraction(4,7,'+'));
	}
	
	@Test
	void testDivide2() {
		MyFraction fraction = new MyFraction(4,1, '+');
		MyFraction fraction2 = new MyFraction(2,1, '+');
		MyFraction fractionProduct = fraction.divide(fraction2);
		assertEquals(fractionProduct, new MyFraction(2,1,'+'));
	}
	
	@Test
	void testDivideNegative() {
		MyFraction fraction = new MyFraction(2,7, '+');
		MyFraction fraction2 = new MyFraction(1,2, '-');
		MyFraction fractionProduct = fraction.divide(fraction2);
		assertEquals(fractionProduct, new MyFraction(4,7,'-'));
	}
	
	
	@Test
	void testDivideBy0() {
		MyFraction fraction = new MyFraction(2,7, '+');
		MyFraction fraction2 = new MyFraction(0,2, '+');
		String message = null;
		try {
			MyFraction fractionProduct = fraction.divide(fraction2);
		}catch(IllegalArgumentException e) {
			message = e.getMessage();
			System.err.println("Test Divide by 0: " + message);
		}
		assertEquals(message, "Trying to Divide by 0");
	}
	
	@Test
	void testAddPosPos() {
		MyFraction fraction = new MyFraction(1,2, '+');
		MyFraction fraction2 = new MyFraction(1,4, '+');
		
		MyFraction fractionAdd = fraction.add(fraction2);
		assertEquals(fractionAdd, new MyFraction(3,4,'+'));
	}
	@Test
	void testAddPosNeg() {
		MyFraction fraction = new MyFraction(5,7, '+');
		MyFraction fraction2 = new MyFraction(1,7, '-');
		
		MyFraction fractionAdd = fraction.add(fraction2);
		assertEquals(fractionAdd, new MyFraction(4,7,'+'));
	}
	@Test
	void testAddNegPos() {
		MyFraction fraction = new MyFraction(15,17, '-');
		MyFraction fraction2 = new MyFraction(1,17, '+');
		
		MyFraction fractionAdd = fraction.add(fraction2);
		assertEquals(fractionAdd, new MyFraction(14,17,'-'));
	}
	@Test
	void testAddNegNeg() {
		MyFraction fraction = new MyFraction(15,17, '-');
		MyFraction fraction2 = new MyFraction(2,17, '-');
		
		MyFraction fractionAdd = fraction.add(fraction2);
		assertEquals(fractionAdd, new MyFraction(1,1,'-'));
	}
	@Test
	void testAddNegToPos() {
		MyFraction fraction = new MyFraction(15,17, '-');
		MyFraction fraction2 = new MyFraction(19,17, '+');
		
		MyFraction fractionAdd = fraction.add(fraction2);
		assertEquals(fractionAdd, new MyFraction(4,17,'+'));
	}
	@Test
	void testAddPosToNeg() {
		MyFraction fraction = new MyFraction(4,17, '+');
		MyFraction fraction2 = new MyFraction(8,17, '-');
		
		MyFraction fractionAdd = fraction.add(fraction2);
		assertEquals(fractionAdd, new MyFraction(4,17,'-'));
	}
	
	
	@Test
	void testSubtractPosPos() {
		MyFraction fraction = new MyFraction(15,17, '+');
		MyFraction fraction2 = new MyFraction(2,17, '+');
		
		MyFraction fractionAdd = fraction.subtract(fraction2);
		assertEquals(fractionAdd, new MyFraction(13,17,'+'));
	}
	@Test
	void testSubtractPosNeg() {
		MyFraction fraction = new MyFraction(15,17, '+');
		MyFraction fraction2 = new MyFraction(5,17, '-');
		
		MyFraction fractionAdd = fraction.subtract(fraction2);
		assertEquals(fractionAdd, new MyFraction(20,17,'+'));
	}
	@Test
	void testSubtractNegPos() {
		MyFraction fraction = new MyFraction(15,17, '-');
		MyFraction fraction2 = new MyFraction(3,17, '+');
		
		MyFraction fractionAdd = fraction.subtract(fraction2);
		assertEquals(fractionAdd, new MyFraction(18,17,'-'));
	}
	@Test
	void testSubtractNegNeg() {
		MyFraction fraction = new MyFraction(15,17, '-');
		MyFraction fraction2 = new MyFraction(2,17, '-');
		
		MyFraction fractionAdd = fraction.subtract(fraction2);
		assertEquals(fractionAdd, new MyFraction(13,17,'-'));
	}
	@Test
	void testSubtractNegtoPos() {
		MyFraction fraction = new MyFraction(15,17, '-');
		MyFraction fraction2 = new MyFraction(20,17, '-');
		
		MyFraction fractionAdd = fraction.subtract(fraction2);
		assertEquals(fractionAdd, new MyFraction(5,17,'+'));
	}
	@Test
	void testSubtractPostoNeg() {
		MyFraction fraction = new MyFraction(15,17, '+');
		MyFraction fraction2 = new MyFraction(16,17, '+');
		
		MyFraction fractionAdd = fraction.subtract(fraction2);
		assertEquals(fractionAdd, new MyFraction(1,17,'-'));
	}

}
