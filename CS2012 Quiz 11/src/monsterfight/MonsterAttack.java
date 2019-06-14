package monsterfight;

import java.util.ArrayList;
import java.util.List;

public class MonsterAttack {

	private int round;

	public void fight() {
		Monster godzilla = new HeroMonster("Godzilla", 0.7, "radioactive breath");

		List<Monster> zombies = new ArrayList<Monster>();

		int counter;
		for (counter = 0; counter < 20; counter++) {
			zombies.add(new Zombie());
		}

		fightRecursively(godzilla, zombies);
		
		
		if(godzilla.isAlive()) {
			System.out.println("the zombies were wiped out");
		}else {
			int alive = 0;
			for(counter = 0; counter < zombies.size(); counter++)
				if(zombies.get(counter).isAlive()) alive++;
			
			System.out.println("Godzilla died, " + alive + " zombies rampage");
		}

	}

	private void fightRecursively(Monster hero, List<Monster> zombies) {

		if (hero.isAlive()) {
			if (zombies.size() > 0) {

				List<Monster> remainingZombies = new ArrayList<Monster>();

				System.out.println("\t\t Round " + ++round);

				int counter;
				for (counter = 0; counter < zombies.size(); counter++) {

					if (hero.isAlive()) {

						Monster zombie = zombies.get(counter);

						hero.attack(zombie);

						if (zombie.isAlive()) {
							zombie.attack(hero);
							remainingZombies.add(zombie);
						}
						// else {
						// zombie.attack(hero);
						// }
						
//						if(hero.isAlive() == false) {
//							System.out.println();
//							System.out.println();
//							System.out.println(hero.getName() + " has died, " + remainingZombies.size() + " zombies rampage");
//						}
						
						System.out.println();

					} 
				}
				System.out.println();
				System.out.println();

				fightRecursively(hero, remainingZombies);

			}
//			else {
//				System.out.println("the zombies were wiped out");
//			}
		}

	}

}
