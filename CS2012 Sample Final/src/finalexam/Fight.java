package finalexam;

import java.util.Random;

public class Fight {

	public static void main(String[] args) {

		Random rand = new Random();

		double rain = rand.nextDouble();
		double wind = rand.nextDouble();

		DuckSizedHorse horse = new DuckSizedHorse("biff", rain);
		HorseSizedDuck duck = new HorseSizedDuck("eric", wind);

		System.out.println(horse);
		System.out.println(duck);
		System.out.println();

		System.out.println(String.format("fight starts, wind: %.2f rain: %.2f", wind, rain));
		
		fightRecursively(horse, duck);
		
		System.out.println();
		if(horse.isAlive()) {
			System.out.println(horse.getName() + " wins");
		}else {
			System.out.println(duck.getName() + " wins");
		}

	}

	public static void fightRecursively(Animal one, Animal two) {
		System.out.println();
		
		if (one.isAlive() && two.isAlive()) {
		
			one.attack(two);
			if(two.isAlive()) {
				two.attack(one);
				fightRecursively(one, two);
			}
		}
	}

}
