package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.MonsterAttack;

public class TextMonsterPersister implements MonsterPersister{


	@Override
	public void write(File file, ArrayList<MonsterAttack> list) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			int counter;
			MonsterAttack attack;
			for(counter = 0; counter < list.size(); counter++) {
				attack = list.get(counter);
				writer.write(attack.getAttackId() + "," +
						attack.getYearOfAttack() + "-" +
						attack.getMonthOfAttack() + "-" +
						attack.getDayOfAttack() + "," +
						attack.getNameOfMonster() + "," +
						attack.getAttackLocation() + "," +
						attack.getReporterName());
				
				if(counter != (list.size() - 1)) writer.newLine();
			}
			
			writer.close();
			System.out.println("File Written Successfully");
		}
		catch(IOException e){
			System.out.println(" ERROR: " + e);
			System.out.println("File Writing Aborted");
		}
		
	}

	@Override
	public ArrayList<MonsterAttack> read(File file) {
		
		ArrayList<MonsterAttack> list = new ArrayList<MonsterAttack>();
		try {
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
				
				list.add(attack);
			}
			fscan.close();
			
		}catch(IOException e) {
			System.out.println(" ERROR: " + e);
		}catch(NumberFormatException e) {
			System.out.println(" ERROR: Invalid File " + e);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(" ERROR: Not Enough Data For Attack Found (5 Columns Expected) " + e);
		}
		return list;
	}

}
