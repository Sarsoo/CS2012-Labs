package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.MonsterAttack;

public class BinaryMonsterPersister implements MonsterPersister{


	@Override
	public void write(File file, ArrayList<MonsterAttack> list) {
		ObjectOutputStream out = null;
		try {
			
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(file)));
			
			out.writeObject(list);
			out.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<MonsterAttack> read(File file) {
		ObjectInputStream in = null;
		ArrayList<MonsterAttack> list = null;
		try {
			
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(file)));
			list = (ArrayList<MonsterAttack>) in.readObject();
			
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
