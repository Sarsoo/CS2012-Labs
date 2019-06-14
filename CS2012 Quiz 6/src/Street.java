import java.util.ArrayList;

public class Street {
	private String name;
	private ArrayList<Building> buildings = new ArrayList<Building>();
	
	public Street(String name) {
		this.setName(name);
	}
		
	public void addHouse(double size, boolean haunted, String feature) {
		buildings.add(new House(size, haunted, feature));
	}
	
	public void addAsylum(double size, boolean haunted, String name) {
		buildings.add(new Asylum(size, haunted, name));
	}
	
	public void stroll() {
		System.out.println("Let's go down " + this.getName());
		
		int counter;
		Building currentBuilding;
		for(counter = 0; counter < buildings.size(); counter++) {
			currentBuilding = buildings.get(counter);
			
			currentBuilding.explore();
		}
		
		System.out.println(this.getHaunted() + " of the buildings on " + this.getName() + " are haunted");
	}
	
	public int getHaunted() {
		int haunted = 0;
		
		int counter;
		Building building;
		for(counter = 0; counter < buildings.size(); counter++) {
			
			building = buildings.get(counter);
			
			if(building.isHaunted()) haunted++;
			
		}
		
		return haunted;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
