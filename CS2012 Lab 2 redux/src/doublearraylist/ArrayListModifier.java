package doublearraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListModifier {

	public static void main(String[] args) {
		ArrayList<Double> array = getArray();
		System.out.print("Original Array: ");
		printArray(array);
		System.out.println();

		System.out.print("Square Root: ");
		sqrtArray(array);
		System.out.print("Original Array: ");
		printArray(array);
		System.out.println();

		System.out.print("Truncated at 500: ");
		truncateArray(array);
		printArray(array);
		System.out.println();

		// double[] newArray = new double[array.length];
		ArrayList<Double> newArray = getReciprocalArray(array);
		System.out.print("Reciprocal Array: ");
		printArray(newArray);
		System.out.print("Original Array: ");
		printArray(array);

	}

	static ArrayList<Double> getArray() { // Return array of 10 valid doubles
		Scanner scan = new Scanner(System.in);
		ArrayList<Double> array = new ArrayList<Double>();
		
		int arraysize;
		
		System.out.println("How many Doubles would you like?: ");
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.println("Error: Enter Int");
		}
		arraysize = scan.nextInt();

		System.out.println("Enter " + arraysize + " Doubles, 1 per line: ");
		for (int counter = 0; counter < arraysize; counter++) {
			while (!scan.hasNextDouble()) {
				scan.nextLine();
				System.out.println("Error: Enter Double");
			}
			array.add(scan.nextDouble());
		}
		scan.close();
		return array;
	}

	static void sqrtArray(ArrayList<Double> array) { // Print sqrt of each value

		for (double i : array) {
			System.out.println(Math.sqrt(i));
		}

		/*
		 * double[] newArray = new double[array.length]; for (int counter = 0; counter <
		 * array.length; counter++) {
		 * 
		 * newArray[counter] = Math.sqrt(array[counter]); } printArray(newArray);
		 */
	}

	static void truncateArray(ArrayList<Double> array) { // truncate values of array to 500
		for (int counter = 0; counter < array.size(); counter++) {

			if (array.get(counter) > 500)
				array.set(counter, (double)500);

		}
	}

	static ArrayList<Double> getReciprocalArray(ArrayList<Double> array) { // returns new array of reciprocals
		ArrayList<Double> newArray = new ArrayList<Double>();
		for (int counter = 0; counter < array.size(); counter++) {

			newArray.add(1/array.get(counter));
		}

		return newArray;
	}

	static void printArray(ArrayList<Double> array) { // print out array
		System.out.print('{');
		for (int counter = 0; counter < array.size(); counter++) {
			System.out.print(array.get(counter));
			if (counter != (array.size() - 1))
				System.out.print(", ");

		}
		System.out.println('}');
	}
}
