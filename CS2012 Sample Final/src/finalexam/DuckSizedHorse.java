package finalexam;

public class DuckSizedHorse extends Animal{
	
	public DuckSizedHorse(String name, double rain) {
		this.name = name;
		
		this.accuracy = 0.1;
		this.power = 0.1/rain;
		
	}
	
	@Override
	public String toString() {
		
		return name + String.format(" is a duck sized horse of health: %.2f, accuracy: %.2f, power: %.2f", health, accuracy, power);
	}

}
