package monsterattack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttackMonitor {
	private List<MonsterAttack> attacks = new ArrayList<MonsterAttack>();
	private Scanner scan = new Scanner(System.in);

	public void monitor() {
		int menuChoice = 0;

		do {
			System.out.println("-------------------");
			System.out.println("0: quit");
			System.out.println("1: add monster");
			System.out.println("2: view monsters");
			System.out.println("3: delete monster");
			System.out.println("4: import from csv");
			System.out.println("5: export to csv");
			System.out.print("Enter Option: ");
			while (!scan.hasNextInt()) {
				scan.nextLine();
				System.out.println("-------------------");
				System.out.println(" ERROR: Enter Int");
				System.out.println("-------------------");
				System.out.print("Enter Option: ");
			}
			menuChoice = scan.nextInt();

			switch (menuChoice) {
			case 0:
				break;
			case 1:
				addMonster();
				break;
			case 2:
				showMonsters();
				break;
			case 3:
				deleteMonster();
				break;
			case 4:
				importCSV();
				break;
			case 5:
				exportCSV();
				break;
			}
		} while (menuChoice != 0);

	}
	
	public void insertMonster(String dateOfAttack, String nameOfMonster, String locationOfAttack, String nameOfReporter) {
		MonsterAttack monster = new MonsterAttack(dateOfAttack, nameOfMonster, locationOfAttack, nameOfReporter);
		attacks.add(monster);
	}

	private void addMonster() {

		System.out.println("-------------------");
		System.out.print("Enter Name Of Monster: ");
		String nameOfMonster = scan.next();

		String dateOfAttack = null;
		do {
			
			System.out.print("Enter Date of Attack (MM/DD/YYYY): ");
			dateOfAttack = scan.next();
			
			if(dateOfAttack.length() > 10) {
				dateOfAttack = null;
				System.out.println(" ERROR: String too long");
			}
			
			
		}while(dateOfAttack == null);
		
		System.out.print("Enter Location Of Attack: ");
		String locationOfAttack = scan.next();

		System.out.print("Enter Name Of Reporter: ");
		String nameOfReporter = scan.next();

		attacks.add(new MonsterAttack(dateOfAttack, nameOfMonster, locationOfAttack, nameOfReporter));
	}

	private void showMonsters() {
		System.out.println("-------------------");
		if (attacks.size() != 0) {
			for (int i = 0; i < attacks.size(); i++) {
				// System.out.print('\t');
				System.out.println(attacks.get(i));
			}
		} else {
			System.out.println(" ERROR: List Empty");
		}

	}

	private void deleteMonster() {
		showMonsters();

		System.out.println("-------------------");
		System.out.print("Enter ID of Attack from list above: ");
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.println("ERROR: Enter Int");
		}
		int idToDelete = scan.nextInt();

		boolean found = false;

		for (int counter = 0; counter < attacks.size(); counter++) {
			int attackId = attacks.get(counter).getAttackId();

			if (attackId == idToDelete) {
				found = true;
				attacks.remove(counter);
				// break;
			}
			// counter++;
		}

		if (found == false)
			System.out.println("-------------------\nAttack of given ID not found");
	}
	
	private void importCSV() {
		System.out.println("-------------------");
		System.out.println("Enter Path of File to Import From:");
		String filePath = scan.next();
		
		attacks.clear();
		
		try {
			File file = new File(filePath);
			Scanner fscan = new Scanner(file);
			
			String attackLine = null;
			String[] attackData = null;
			
			int attackId;
			while(fscan.hasNextLine()) {
				attackLine = fscan.nextLine();
				attackData = attackLine.split(",");
				
				attackId = Integer.parseInt(attackData[0]);
				
				MonsterAttack attack = new MonsterAttack(attackData[1], attackData[2], attackData[3], attackData[4]);
				attack.setAttackId(attackId);
				
				attacks.add(attack);
			}
			fscan.close();			
		}catch(IOException e) {
			System.out.println(" ERROR: " + e);
		}catch(NumberFormatException e) {
			System.out.println(" ERROR: Invalid File " + e);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(" ERROR: Not Enough Data For Attack Found (5 Columns Expected) " + e);
		}
	}
	
	private void exportCSV() {
		System.out.println("-------------------");
		System.out.println("Enter Path of File to Export To:");
		String filePath = scan.next();
		
		try {
			File file = new File(filePath);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			int counter;
			MonsterAttack attack;
			for(counter = 0; counter < attacks.size(); counter++) {
				attack = attacks.get(counter);
				writer.write(attack.getAttackId() + "," +
						attack.getMonthOfAttack() + "/" +
						attack.getDayOfAttack() + "/" +
						attack.getYearOfAttack() + "," +
						attack.getNameOfMonster() + "," +
						attack.getAttackLocation() + "," +
						attack.getReporterName());
				
				if(counter != (attacks.size() - 1)) writer.newLine();
			}
			
			writer.close();
			System.out.println("File Written Successfully");
		}
		catch(IOException e){
			System.out.println(" ERROR: " + e);
			System.out.println("File Writing Aborted");
		}
	}
}
