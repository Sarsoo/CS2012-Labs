package test;

//import static org.junit.Assert.*;

import org.junit.Test;
import logic.StreetMap;

public class StreetMapTest {

//	@Test
//	public void test() {
//		StreetMap map = new StreetMap();
//		
//		int row, column;
//		for(row = 0; row < 27; row++) {
//			for(column = 0; column < 27; column++) {
//				
//				System.out.println(map.getCoordinate(row, column));
//				
//			}
//		}
//	}
//	
	@Test
	public void test() {
		StreetMap map = new StreetMap(5, 1, 2, 30);
		
		map.print();
//		map.randomise();
//		map.print();
	}

}
