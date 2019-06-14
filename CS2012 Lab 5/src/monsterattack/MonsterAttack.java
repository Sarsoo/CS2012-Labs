package monsterattack;

public class MonsterAttack {
	private int attackId;
	private int dayOfAttack;
	private int monthOfAttack;
	private int yearOfAttack;
	private String nameOfMonster;
	private String attackLocation;
	private String reporterName;

	private static int lastAttackId = 0;

	public MonsterAttack(String argDate, String argMonsterName, String argLocation, String argReporter) {
		lastAttackId += 1;

		this.setNameOfMonster(argMonsterName);
		this.setAttackLocation(argLocation);
		this.setReporterName(argReporter);

		this.setAttackId(lastAttackId);

		String[] arrOfDate = argDate.split("/", 4);
		try {
			if (arrOfDate.length == 3) {
				this.setDayOfAttack(Integer.parseInt(arrOfDate[1]));
				this.setMonthOfAttack(Integer.parseInt(arrOfDate[0]));
				this.setYearOfAttack(Integer.parseInt(arrOfDate[2]));
			}
		} catch (Exception e) {
			System.out.println(" ERROR: " + e);
			System.out.println(" Error Setting Date, Default to 0/0/0");
		}
	}

	public int getAttackId() {
		return attackId;
	}

	public void setAttackId(int attackId) {
		this.attackId = attackId;
	}

	public int getDayOfAttack() {
		return dayOfAttack;
	}

	public void setDayOfAttack(int dayOfAttack) {
		this.dayOfAttack = dayOfAttack;
	}

	public int getMonthOfAttack() {
		return monthOfAttack;
	}

	public void setMonthOfAttack(int monthOfAttack) {
		this.monthOfAttack = monthOfAttack;
	}

	public int getYearOfAttack() {
		return yearOfAttack;
	}

	public void setYearOfAttack(int yearOfAttack) {
		this.yearOfAttack = yearOfAttack;
	}

	public String getNameOfMonster() {
		return nameOfMonster;
	}

	public void setNameOfMonster(String nameOfMonster) {
		this.nameOfMonster = nameOfMonster;
	}

	public String getAttackLocation() {
		return attackLocation;
	}

	public void setAttackLocation(String attackLocation) {
		this.attackLocation = attackLocation;
	}

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getAttackId());
		sb.append("#: ");
		sb.append(this.getNameOfMonster());
		sb.append(" at ");
		sb.append(this.getAttackLocation());
		sb.append(" on ");
		sb.append(this.getMonthOfAttack());
		sb.append("/");
		sb.append(this.getDayOfAttack());
		sb.append("/");
		sb.append(this.getYearOfAttack());
		sb.append(", Reported By ");
		sb.append(this.getReporterName());
		String str = sb.toString();
		return str;
	}
}
