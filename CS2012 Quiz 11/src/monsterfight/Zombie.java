package monsterfight;

public class Zombie extends Monster {

	private static int population = 0;
	
	private int number;

	public Zombie() {

		this.name = "ZOMBIE #" + ++population;
		this.number = population;
		this.ferocity = 0.1;
		

	}
	
	@Override
	public String toString() {
		
		return name + " (" + ferocity + ")";
	}
	
	@Override
	public void attack(Monster m) {

		double roll = r.nextDouble();

		System.out.println(name + " tries to eat " + m.getName() + "'s brains");

		if (roll < ferocity) {
			m.expire();
			System.out.println(m.getName() + " dies");
		} else {
			System.out.println(m.getName() + " survives");
		}

	}
	
	public int getNumber() {
		return number;
	}

}
