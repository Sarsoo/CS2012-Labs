package finalexam;

public class HorseSizedDuck extends Animal{
	
	public HorseSizedDuck(String name, double wind) {
		this.name = name;
		
		this.power = 0.1;
		this.accuracy = 0.1 / wind;
	}
	
	@Override
	public String toString() {
		
		return name + String.format(" is a horse sized duck of health: %.2f, accuracy: %.2f, power: %.2f", health, accuracy, power);
	}

}
