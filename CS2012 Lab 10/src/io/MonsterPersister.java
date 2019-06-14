package io;

import java.io.File;
import java.util.ArrayList;

import model.MonsterAttack;

public interface MonsterPersister {
	
	public void write(File file, ArrayList<MonsterAttack> list);
	
	public ArrayList<MonsterAttack> read(File file);

}
