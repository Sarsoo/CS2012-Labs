package logic;

import java.util.Random;

public class StreetMap {
	private Coordinate[][] map = new Coordinate[27][27];

	private Coordinate player = new Coordinate(1, 1);
	private Bull[] bulls;

	private boolean isDead = false;

	private int turn = 0;

	private int bullNumber;
	private int turnNumber;
	private int headstart;
	private int wallPercent;

	public int getTurn() {
		return turn;
	}

	public int getHeadstart() {
		return headstart;
	}

	public StreetMap(int bullNumber, int turnNumber, int headstart, int wallPercent) {
		this.bullNumber = bullNumber;
		this.turnNumber = turnNumber;
		this.headstart = headstart;
		this.wallPercent = wallPercent;

		int row, column;
		for (row = 0; row < 27; row++) {
			for (column = 0; column < 27; column++) {

				Coordinate coord = new Coordinate(row, column, 'W');

				map[row][column] = coord;

			}
		}
		getCoordinate(0, 1).setState('S');
		getCoordinate(26, 25).setState('E');

		randomise();

		// bulls = new Bull[bullNumber];
		// int counter;
		// for (counter = 0; counter < bullNumber; counter++) {
		// bulls[counter] = new Bull();
		// }

	}

	public void randomise() {
		Random random = new Random();

		int row, column;
		for (row = 1; row < 26; row++) {
			for (column = 1; column < 26; column++) {

				int rand = random.nextInt(100) + 1;

				if (rand > wallPercent) {
					getCoordinate(row, column).setState(' ');
				} else {
					getCoordinate(row, column).setState('W');
				}
			}
		}

		for (row = 1; row < 5; row++) {
			for (column = 1; column < 5; column++) {
				getCoordinate(row, column).setState(' ');
			}
		}
		
		for (row = 24; row < 26; row++) {
			for (column = 24; column < 26; column++) {
				getCoordinate(row, column).setState(' ');
			}
		}
		
		getCoordinate(3, 3).setState('W');
		

		// int counter;
		// for (counter = 0; counter < bullNumber; counter++) {
		//// bulls[counter] = new Bull();
		// }

		bulls = new Bull[bullNumber];
		int counter;
		for (counter = 0; counter < bullNumber; counter++) {
			bulls[counter] = new Bull();
		}

		player.setColumn(1);
		player.setRow(1);

		isDead = false;
		turn = 0;

	}

	public boolean validMove(int row, int column) {

		if (row == 0)
			return false;
		if (column == 0)
			return false;
		if (column == 26)
			return false;
		if (row == 26) {
			if (column == 25)
				return true;
			return false;
		}

		Coordinate coord = map[row][column];

		char state = coord.getState();

		if (state == 'W') {
			return false;
		}

		if (turn > headstart + 1) {
			for (Bull bull : bulls) {
				Coordinate bullCoord = bull.getLocation();
				if (bullCoord.getRow() == row)
					if (bullCoord.getColumn() == column)
						return false;
			}
		}
		return true;
	}

	public boolean isWon() {
		if (player.equals(new Coordinate(26, 25)))
			return true;
		return false;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setIsDead(boolean b) {
		this.isDead = b;

	}

	public void movePlayerUp() {
		player.decreaseRow();
		if (++turn > headstart)
			moveBulls();
	}

	public void movePlayerDown() {
		player.increaseRow();
		if (++turn > headstart)
			moveBulls();
	}

	public void movePlayerLeft() {
		player.decreaseCol();
		if (++turn > headstart)
			moveBulls();
	}

	public void movePlayerRight() {
		player.increaseCol();
		if (++turn > headstart)
			moveBulls();
	}

	public void moveBulls() {
		int counter;
		for (Bull bull : bulls) {
			for (counter = 0; counter < turnNumber; counter++) {
				bull.move(player, this);
			}
		}
	}

	public Coordinate getCoordinate(int row, int column) {
		return map[row][column];
	}

	public Coordinate[][] getMap() {
		return map;
	}

	public void setCoordinateState(int row, int column, char state) {
		getCoordinate(row, column).setState(state);
	}

	public void setMap(Coordinate[][] map) {
		this.map = map;
	}

	public Coordinate getPlayer() {
		return player;
	}

	public Bull[] getBulls() {
		return bulls;
	}

	public void print() {
		int row, column;
		for (row = 0; row < 27; row++) {
			for (column = 0; column < 27; column++) {

				System.out.print(getCoordinate(row, column).getState());
				if (column == 26)
					System.out.println();
			}
		}
	}

	public void isBlocked() {
		if (player.getRow() != 26) {

			if (!validMove(player.getRow() - 1, player.getColumn())) {
				if (!validMove(player.getRow() + 1, player.getColumn())) {
					if (!validMove(player.getRow(), player.getColumn() - 1)) {
						if (!validMove(player.getRow(), player.getColumn() + 1)) {
							isDead = true;
						}
					}
				}
			}
		}
	}
}
