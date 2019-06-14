package monsterattack;

public class MonsterAttackDriver {

	public static void main(String[] args) {
		
		AttackMonitor monitor = new AttackMonitor();
		hardcodeAttacks(monitor);
		monitor.monitor();
		
	}
	
	public static void hardcodeAttacks(AttackMonitor monitor) {
		monitor.insertMonster("05/22/1980", "Godzilla1", "London", "Bill");
		monitor.insertMonster("06/4/2005", "Godzilla2", "Paris", "Jeff");
		monitor.insertMonster("07/6/1998", "Godzilla3", "Dublin", "Andy");
		monitor.insertMonster("08/6/1998", "Godzilla4", "Dublin", "Andy");
		monitor.insertMonster("09/6/1998", "Godzilla5", "Dublin", "Andy");
	}

}
