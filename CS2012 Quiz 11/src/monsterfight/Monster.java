package monsterfight;

import java.util.Random;

public abstract class Monster {
	protected Random r = new Random();
	protected boolean alive = true;
	protected String name;
	protected double ferocity; // probability (0 through 1) chance that the monster will succeed in each
								// attack.

	public abstract void attack(Monster m); // implement this in the subclasses

	public boolean isAlive() {
		return alive;
	}

	public void expire() { // run when a monster dies
		alive = false;
	}

	// plcheck
	public String getName() {
		return name;
	}
}