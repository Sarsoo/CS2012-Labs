package monsterfight;

public class HeroMonster extends Monster {
	
	private String weapon;
	
	public HeroMonster(String name, double ferocity, String weapon) {
		
		this.name = name.toUpperCase();
		this.ferocity = ferocity;
		this.weapon = weapon.toUpperCase();
		
	}
	
	@Override
	public String toString() {
		
		return "hero: " + name + " (" + ferocity + ") wielding: " + weapon;
	}

	@Override
	public void attack(Monster m) {
		double roll = r.nextDouble();
		
		System.out.println(name + " attacks " + m.getName() + " with " + weapon);
		
		if(roll < ferocity) {
			m.expire();
			System.out.println(m.getName() + " dies");
		}
		else {
			System.out.println(m.getName() + " survives");
		}

	}

}
