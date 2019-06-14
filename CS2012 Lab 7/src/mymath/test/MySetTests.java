package mymath.test;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mymath.MySet;

class MySetTests {

	@Test
	void testCreatable() {
		int[] num = { 1, 2, 3 };
		MySet set = new MySet(num);
		assertNotNull(set);
	}

	@Test
	void testToString() {
		int[] num = { 1, 2, 3, 4 };
		MySet set = new MySet(num);
		assertEquals(set.toString(), "[1, 2, 3, 4]");
	}

	@Test
	void testEquals() {
		int[] num = { 1, 2, 3 };
		int[] num2 = { 1, 2, 3 };

		MySet set = new MySet(num);
		MySet set2 = new MySet(num2);

		assertEquals(set, set2);
	}

	@Test
	void test0Array() {
		int[] num = { 0 };
		MySet set = new MySet(null);
		assertNotNull(set);
	}

	@Test
	void testNegNum() {
		int[] num = { -1, 2, 3 };
		MySet set = new MySet(num);
		// System.out.println(set);
		assertEquals(set.toString(), "[-1, 2, 3]");
	}

	@Test
	void testGetNumberSet() {
		int[] num = { 1, 2, 3 };

		MySet set = new MySet(num);

		int[] getNum = set.getNumbersSet();

		assertArrayEquals(num, getNum);
	}
	
	@Test
	void testGetNullSet() {

		MySet set = new MySet(null);

		int[] getNum = set.getNumbersSet();

		assertNull(getNum);
	}

	@Test
	void testSetNumberSet() {
		int[] num = { 1, 2, 3 };

		MySet set = new MySet(num);

		int[] newNum = { 1, 2, 3, 4 };
		set.setNumbersSet(newNum);

		int[] getNum = set.getNumbersSet();

		assertArrayEquals(newNum, getNum);
	}

	@Test
	void testDuplicateElement() {
		int[] num = { 1, 2, 2, 3 };
		MySet set = new MySet(num);

		int[] expected = { 1, 2, 3 };
		MySet setExpected = new MySet(expected);

		assertEquals(set, setExpected);
	}

	@Test
	void testDuplicateElement2() {
		int[] num = { 1, 2, 2, 2, 3, 3 };
		MySet set = new MySet(num);

		int[] expected = { 1, 2, 2, 3 };
		MySet setExpected = new MySet(expected);

		assertEquals(set, setExpected);
	}

	@Test
	void testCheckForDuplicatesMethod() {
		int[] num = { 1, 2, 2, 3 };
		MySet set = new MySet(num);

		int[] filtered = set.checkForDuplicates(num);

		int[] expected = { 1, 2, 3 };

		assertArrayEquals(filtered, expected);
	}

	@Test
	void testAddition() {
		int[] num = { 1, 2, 3 };
		MySet set = new MySet(num);

		int[] num2 = { 4, 5, 6 };
		MySet set2 = new MySet(num2);

		int[] expected = { 1, 2, 3, 4, 5, 6 };
		MySet setExpected = new MySet(expected);

		MySet answer = set.add(set2);
		// System.out.println(answer);
		assertEquals(answer, setExpected);
	}

	@Test
	void testAddSameSets() {
		int[] num = { 1, 2, 3 };
		MySet set = new MySet(num);

		int[] num2 = { 1, 2, 3 };
		MySet set2 = new MySet(num2);

		int[] expected = { 1, 2, 3 };
		MySet setExpected = new MySet(expected);

		MySet answer = set.add(set2);

		assertEquals(answer, setExpected);
	}

	@Test
	void testAddWithOverlap() {
		int[] num = { 1, 2, 3 };
		MySet set = new MySet(num);

		int[] num2 = { 3, 4, 5, 6 };
		MySet set2 = new MySet(num2);

		int[] expected = { 1, 2, 3, 4, 5, 6 };
		MySet setExpected = new MySet(expected);

		MySet answer = set.add(set2);
		// System.out.println(answer);
		assertEquals(answer, setExpected);
	}

	@Test
	void testSubtraction() {
		int[] num = { 1, 2, 3, 4, 5, 6 };
		MySet set = new MySet(num);

		int[] num2 = { 3, 4, 5, 6 };
		MySet set2 = new MySet(num2);

		int[] expected = { 1, 2 };
		MySet setExpected = new MySet(expected);

		MySet answer = set.subtract(set2);
		assertEquals(answer, setExpected);
	}

	@Test
	void testSubtractSameSets() {
		int[] num = { 1, 2, 3, 4, 5, 6 };
		MySet set = new MySet(num);

		int[] num2 = { 1, 2, 3, 4, 5, 6 };
		MySet set2 = new MySet(num2);

		MySet setExpected = new MySet(null);

		MySet answer = set.subtract(set2);
		// System.out.println(answer);
		assertEquals(answer, setExpected);
	}

	@Test
	void testSubtractNoOverlap() {
		int[] num = { 1, 2 };
		MySet set = new MySet(num);

		int[] num2 = { 3, 4, 5, 6 };
		MySet set2 = new MySet(num2);

		int[] expected = { 1, 2 };
		MySet setExpected = new MySet(expected);

		MySet answer = set.subtract(set2);
		assertEquals(answer, setExpected);
	}

	@Test
	void testMultiply() {
		int[] num = { 1, 2, 3, 4, 5, 6 };
		MySet set = new MySet(num);

		int[] num2 = { 3, 4, 5, 8, 9 };
		MySet set2 = new MySet(num2);

		int[] expected = { 1, 2, 6, 8, 9 };
		MySet setExpected = new MySet(expected);

		MySet answer = set.multiply(set2);
		assertEquals(answer, setExpected);
	}

	@Test
	void testMultiplySameSet() {
		int[] num = { 3, 4, 5, 6 };
		MySet set = new MySet(num);

		int[] num2 = { 3, 4, 5, 6 };
		MySet set2 = new MySet(num2);

		MySet setExpected = new MySet(null);

		MySet answer = set.multiply(set2);
		assertEquals(answer, setExpected);
	}

	@Test
	void testMultiplyNoOverlap() {
		int[] num = { 1, 2, 3 };
		MySet set = new MySet(num);

		int[] num2 = { 4, 5, 6 };
		MySet set2 = new MySet(num2);

		int[] numExpected = { 1, 2, 3, 4, 5, 6 };
		MySet setExpected = new MySet(numExpected);

		MySet answer = set.multiply(set2);
		assertEquals(answer, setExpected);
	}

	@Test
	void testDivide() {
		int[] num = { 1, 2, 3, 4, 5, 6 };
		MySet set = new MySet(num);

		int[] num2 = { 3, 4, 5, 6, 7, 8 };
		MySet set2 = new MySet(num2);

		int[] expected = { 3, 4, 5, 6 };
		MySet setExpected = new MySet(expected);

		MySet answer = set.divide(set2);

		assertEquals(setExpected, answer);
	}

	@Test
	void testDivideSameSet() {
		int[] num = { 1, 2, 3 };
		MySet set = new MySet(num);

		int[] num2 = { 1, 2, 3 };
		MySet set2 = new MySet(num2);

		int[] expected = { 1, 2, 3 };
		MySet setExpected = new MySet(expected);

		MySet answer = set.divide(set2);

		assertEquals(setExpected, answer);
	}

	@Test
	void testDivideNoOverlap() {
		int[] num = { 1, 2, 3 };
		MySet set = new MySet(num);

		int[] num2 = { 4, 5, 6 };
		MySet set2 = new MySet(num2);

		MySet setExpected = new MySet(null);

		MySet answer = set.divide(set2);

		assertEquals(setExpected, answer);
	}

}
