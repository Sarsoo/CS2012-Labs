package test;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Coordinate;

public class CoordinateTest {

	@Test
	public void testInit() {
		Coordinate coord = new Coordinate(1,1,'W');
		assertNotNull(coord);
	}
	
//	@Test
//	public void testToString() {
//		Coordinate coord = new Coordinate(1,2);
//		assertEquals(coord.toString(), "(1, 2)  ");
//	}
	
	@Test
	public void testToStringWall() {
		Coordinate coord = new Coordinate(1,2,'W');
		assertEquals(coord.toString(), "(1, 2) W");
	}

}
