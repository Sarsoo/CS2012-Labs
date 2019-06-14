import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class RecursionTest {
	
	@Test
	void testPrimeNegNumber() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(-4));
	}

	@Test
	void testPrime0() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(0));
	}
	
	@Test
	void testPrime1() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(1));
	}
	
	@Test
	void testPrime2() {
		Recursion recursion = new Recursion();
		
		assertTrue(recursion.checkPrime(2));
	}
	
	@Test
	void testPrime3() {
		Recursion recursion = new Recursion();
		
		assertTrue(recursion.checkPrime(3));
	}
	
	@Test
	void testPrime4() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(4));
	}
	
	@Test
	void testPrime5() {
		Recursion recursion = new Recursion();
		
		assertTrue(recursion.checkPrime(5));
	}
	
	@Test
	void testPrime6() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(6));
	}

	@Test
	void testPrime7() {
		Recursion recursion = new Recursion();
		
		assertTrue(recursion.checkPrime(7));
	}
	
	@Test
	void testPrime8() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(8));
	}
	
	@Test
	void testPrime9() {
		Recursion recursion = new Recursion();
//		System.out.println(recursion.checkPrime(9));
		assertFalse(recursion.checkPrime(9));
	}
	
	@Test
	void testPrime10() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(10));
	}
	
	@Test
	void testPrime11() {
		Recursion recursion = new Recursion();
		
		assertTrue(recursion.checkPrime(11));
	}
	
	@Test
	void testPrime12() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(12));
	}
	
	@Test
	void testPrime13() {
		Recursion recursion = new Recursion();
		
		assertTrue(recursion.checkPrime(13));
	}
	
	@Test
	void testPrime17() {
		Recursion recursion = new Recursion();
		
		assertTrue(recursion.checkPrime(17));
	}
	
	@Test
	void testPrime19() {
		Recursion recursion = new Recursion();
		
		assertTrue(recursion.checkPrime(19));
	}
	
	@Test
	void testPrime21() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(21));
	}
	
	@Test
	void testPrime23() {
		Recursion recursion = new Recursion();
		
		assertTrue(recursion.checkPrime(23));
	}
	
	@Test
	void testPrime29() {
		Recursion recursion = new Recursion();
		
		assertTrue(recursion.checkPrime(29));
	}
	
	@Test
	void testPrime30() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(30));
	}
	
	@Test
	void testPrime99() {
		Recursion recursion = new Recursion();
		
		assertFalse(recursion.checkPrime(99));
	}
	
	@Test
	void testSumNullList() {
		Recursion recursion = new Recursion();
		
		List<Integer> list = null;
		
		int sum = recursion.sumOfList(list);
		
		assertEquals(sum, 0);
	}
	
	@Test
	void testSumEmpty() {
		Recursion recursion = new Recursion();
		
		List<Integer> list =  new ArrayList<Integer>();
		
		int sum = recursion.sumOfList(list);
		
		assertEquals(sum, 0);
	}
	
	@Test
	void testSumSingularItem() {
		Recursion recursion = new Recursion();
		
		List<Integer> list =  new ArrayList<Integer>();
		
		list.add(5);
		
		int sum = recursion.sumOfList(list);
		
		assertEquals(sum, 5);
	}
	
	@Test
	void testSumList() {
		Recursion recursion = new Recursion();
		
		List<Integer> list = new ArrayList<Integer>();
		
		int counter;
		for(counter = 0; counter < 5; counter++) {
			list.add(counter + 1);
		}
		
		int sum = recursion.sumOfList(list);
		
		assertEquals(sum, 15);
	}
	
	@Test
	void testSumList2() {
		Recursion recursion = new Recursion();
		
		List<Integer> list = new ArrayList<Integer>();
		
		int counter;
		for(counter = 0; counter < 2; counter++) {
			list.add(counter + 1);
		}
		
		int sum = recursion.sumOfList(list);
		
		assertEquals(sum, 3);
	}
	
	@Test
	void testSumList3() {
		Recursion recursion = new Recursion();
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(2);
		list.add(2);
		list.add(3);
		
		int sum = recursion.sumOfList(list);
		
		assertEquals(sum, 7);
	}
	
	@Test
	void testSumListWithNegative() {
		Recursion recursion = new Recursion();
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(2);
		list.add(2);
		list.add(-3);
		
		int sum = recursion.sumOfList(list);
		
		assertEquals(sum, 1);
	}
	
	@Test
	void testSumListNegativeAnswer() {
		Recursion recursion = new Recursion();
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(2);
		list.add(2);
		list.add(-3);
		list.add(-3);
		
		int sum = recursion.sumOfList(list);
		
		assertEquals(sum, -2);
	}
}
