
public class Driver {

	public static void main(String[] args) {
		Street street = new Street("York Way");
		
		street.addHouse(15, false, "Blue Door");
		street.addHouse(13.5, true, "Red Door");
		street.addAsylum(20, true, "First Asylum");
		street.addAsylum(20, false, "New Asylum");
		street.addHouse(15, false, "Lack of Doors");
		street.addHouse(10, true, "Broken Window");
		street.addHouse(15, false, "Red Postbox");
		
		street.stroll();
	}

}
