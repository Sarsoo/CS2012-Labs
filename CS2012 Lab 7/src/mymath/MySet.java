package mymath;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MySet implements MyMath<MySet> { // 2147483647

	private int[] numbersSet;

	public MySet(int[] inputNumbers) {
		if(inputNumbers != null)
			numbersSet = checkForDuplicates(inputNumbers);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() != this.getClass()) return false;
		
		MySet o = (MySet) obj;
		int[] importedSet = o.getNumbersSet();
		
		if((importedSet == null) && (numbersSet == null)) return true;
		
		boolean equal;
		Arrays.sort(importedSet, 0, importedSet.length - 1);
		Arrays.sort(numbersSet, 0, importedSet.length - 1);
		int count = 0;
		for (int i = 0; i < importedSet.length; i++) {
			if (numbersSet[i] == importedSet[i]) {
				count++;
			}
		}
		if (count == importedSet.length) {
			equal = true;
		} else {
			equal = false;
		}
		return equal;
	}

	public int[] stringToInt(String inputNumbers) {

		String[] array1 = inputNumbers.split(" ");
		int[] numbers = new int[array1.length];
		try {
			for (int i = 0; i < array1.length; i++) {
				numbers[i] = Integer.parseInt(array1[i]);
			}
		} catch (NumberFormatException ex) {
//			System.out.print("Does not exist");
			return null;
		}
		
		Arrays.sort(numbers);
		
		return numbers;
	}

	public int[] checkForDuplicates(int[] unFilteredSet) {
		String noDuplicates = "";
		Arrays.sort(unFilteredSet, 0, unFilteredSet.length - 1);
		for (int i = 0; i < unFilteredSet.length - 1; i++) {
			if (unFilteredSet[i] != unFilteredSet[i + 1]) {
				noDuplicates += unFilteredSet[i] + " ";
			}
		}
		noDuplicates += unFilteredSet[unFilteredSet.length - 1];
		int[] noTwos = stringToInt(noDuplicates);
		return noTwos;
	}

	public MySet add(MySet o) {

		int[] importedSet = o.getNumbersSet();
		String combineSets = "";
		for (int i = 0; i < importedSet.length; i++) {
			combineSets += importedSet[i] + " ";
		}
		for (int i = 0; i < numbersSet.length; i++) {
			combineSets += numbersSet[i] + " ";
		}
		
		MySet union = new MySet(stringToInt(combineSets));
		return union;
	}

	public MySet subtract(MySet o) {
		int[] importedSet = o.getNumbersSet();
		String complement = "";
		for (int i = 0; i < numbersSet.length; i++) {
			int count = 0;
			for (int j = 0; j < importedSet.length; j++) {
				if (numbersSet[i] == importedSet[j]) {
					count++;
				}
			}
			if (count == 0) {
				complement += numbersSet[i] + " ";
			}
		}
		MySet complements = new MySet(stringToInt(complement));
		return complements;
	}

	public MySet multiply(MySet o) {

		int[] importedSet = o.getNumbersSet();
		String symmetricDifference = "";
		for (int i = 0; i < numbersSet.length; i++) {
			int count = 0;
			for (int j = 0; j < importedSet.length; j++) {
				if (numbersSet[i] == importedSet[j]) {
					count++;
				}
			}
			if (count == 0) {
				symmetricDifference += numbersSet[i] + " ";
			}
		}
		for (int i = 0; i < importedSet.length; i++) {
			int count = 0;
			for (int j = 0; j < numbersSet.length; j++) {
				if (importedSet[i] == numbersSet[j]) {
					count++;
				}
			}
			if (count == 0) {
				symmetricDifference += importedSet[i] + " ";
			}
		}
		MySet symmetricD = new MySet(stringToInt(symmetricDifference));
		return symmetricD;
	}

	public MySet divide(MySet o) {

		int[] importedSet = o.getNumbersSet();
		String intersection = "";
		for (int i = 0; i < numbersSet.length; i++) {
			int count = 0;
			for (int j = 0; j < importedSet.length; j++) {
				if (numbersSet[i] == importedSet[j]) {
					count++;
				}
			}
			if (count != 0) {
				intersection += numbersSet[i] + " ";
			}
		}
		MySet intersectionSet = new MySet(stringToInt(intersection));
		return intersectionSet;
	}

	public String toString() {

		return java.util.Arrays.toString(numbersSet);

	}

	public int[] getNumbersSet() {
		return numbersSet;
	}

	public void setNumbersSet(int[] numbersSet) {
		this.numbersSet = numbersSet;
	}

}
