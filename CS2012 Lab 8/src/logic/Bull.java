package logic;

import java.util.Random;

public class Bull {
	private Coordinate location;

	private Coordinate lastSeen;

	public Bull() {
		this.setLocation(new Coordinate(1, 1));
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}

	public void move(Coordinate player, StreetMap map) {
		// location = new Coordinate(2,2);

		boolean see = canSee(player, map);
		System.out.println("canSee: " + see);

		if (see == true && (map.getTurn() > map.getHeadstart() + 1)) {
			lastSeen = new Coordinate(player.getRow(), player.getColumn());
			System.out.println(lastSeen);
		}

		if (lastSeen != null) {
			System.out.println("MOVE");

			if (location.getRow() == lastSeen.getRow()) {
				System.out.println("Same Row");

				if (location.getColumn() < lastSeen.getColumn()) {
					System.out.println("west player");

					if (map.validMove(location.getRow(), location.getColumn() + 1)) {

						System.out.println("valid");
						location.setColumn(location.getColumn() + 1);
						System.out.println("Move east");

					} else {
						moveRandom(map);
					}
				}

				else {
					System.out.println("east player");
					if (map.validMove(location.getRow(), location.getColumn() - 1)) {
						System.out.println("valid");
						location.setColumn(location.getColumn() - 1);
						System.out.println("Move north");

					} else {
						moveRandom(map);
					}
				}
			} else if (location.getColumn() == lastSeen.getColumn()) {
				System.out.println("Same Column");
				if (location.getRow() < lastSeen.getRow()) {
					if (map.validMove(location.getRow() + 1, location.getColumn())) {
						System.out.println("valid");
						location.setRow(location.getRow() + 1);
						System.out.println("Move south");

					} else {
						moveRandom(map);
					}
				}

				else {
					if (map.validMove(location.getRow() - 1, location.getColumn())) {
						System.out.println("valid");
						location.setRow(location.getRow() - 1);
						System.out.println("Move north");

					} else {
						moveRandom(map);
					}
				}
			} else {
				moveRandom(map);
			}

			if (location.equals(lastSeen))
				lastSeen = null;

		} else {
			moveRandom(map);
		}

		if (location.equals(player)) {
			map.setIsDead(true);
		}
		
		see = canSee(player, map);
		if (see == true && (map.getTurn() > map.getHeadstart() + 1)) {
			lastSeen = new Coordinate(player.getRow(), player.getColumn());
			System.out.println(lastSeen);
		}
		
		
	}

	public void moveRandom(StreetMap map) {
		boolean moveMade = false;

		System.out.println("Move random");

		Random rand = new Random();
		int counter = 0;
		do {

			int random = rand.nextInt(4) + 1;
			System.out.println("random: " + random);

			switch (random) {
			// NORTH
			case (1):
				if (map.validMove(location.getRow() - 1, location.getColumn())) {
					location.setRow(location.getRow() - 1);
					moveMade = true;
				}
				counter++;
				break;
			// EAST
			case (2):
				if (map.validMove(location.getRow(), location.getColumn() + 1)) {
					location.setColumn(location.getColumn() + 1);
					moveMade = true;
				}
				counter++;
				break;
			// SOUTH
			case (3):
				if (map.validMove(location.getRow() + 1, location.getColumn())) {
					location.setRow(location.getRow() + 1);
					moveMade = true;
				}
				counter++;
				break;
			// WEST
			case (4):
				if (map.validMove(location.getRow(), location.getColumn() - 1)) {
					location.setColumn(location.getColumn() - 1);
					moveMade = true;
				}
				counter++;
				break;
			default:
				System.err.println("Invalid random number");

			}
		} while ((moveMade == false) && (counter < 5));
	}

	public boolean canSee(Coordinate player, StreetMap map) {
		boolean canSee = false;

		// SAME ROW
		if (location.getRow() == player.getRow()) {
			canSee = true;

			int distance = Math.abs(player.getColumn() - location.getColumn()) - 1;

			boolean wall = false;
			int counter;
			Coordinate coord;

			// BULL ABOVE PLAYER
			if (location.getColumn() < player.getColumn()) {

				for (counter = location.getColumn() + 1; counter < distance; counter++) {

					coord = map.getCoordinate(location.getRow(), counter);

					if (coord.getState() == 'W') {
						wall = true;
					}
				}
			}
			// PLAYER ABOVE BULL
			else {

				for (counter = player.getColumn() + 1; counter < distance; counter++) {

					coord = map.getCoordinate(location.getRow(), counter);

					if (coord.getState() == 'W') {
						wall = true;
					}
				}

			}

			if (wall == true)
				canSee = false;

		}
		// SAME COLUMN
		else if (location.getColumn() == player.getColumn()) {
			canSee = true;

			int distance = Math.abs(player.getRow() - location.getRow()) - 1;

			boolean wall = false;
			int counter;
			Coordinate coord;

			// BULL ABOVE PLAYER
			if (location.getRow() < player.getRow()) {

				for (counter = location.getRow() + 1; counter < distance; counter++) {

					coord = map.getCoordinate(counter, location.getColumn());

					if (coord.getState() == 'W') {
						wall = true;
					}
				}
			}
			// PLAYER ABOVE BULL
			else {

				for (counter = player.getRow() + 1; counter < distance; counter++) {

					coord = map.getCoordinate(counter, location.getColumn());

					if (coord.getState() == 'W') {
						wall = true;
					}
				}

			}

			if (wall == true)
				canSee = false;
		}

		return canSee;
	}
}
