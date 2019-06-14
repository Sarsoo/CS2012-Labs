package doublearray;

import java.util.Scanner;

public class ArrayModifier {

	public static void main(String[] args) {
		double[] array = getArray();
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
		
		//double[] newArray = new double[array.length];
		double[] newArray = getReciprocalArray(array);
		System.out.print("Reciprocal Array: ");
		printArray(newArray);
		System.out.print("Original Array: ");
		printArray(array);
		
	}

	static double[] getArray() { //Return array of 10 valid doubles
		Scanner scan = new Scanner(System.in);
		double[] array = new double[10];
		
		System.out.println("Enter 10 Doubles, 1 per line: ");
		for (int counter = 0; counter < 10; counter++) {
			while (!scan.hasNextDouble()) {
				scan.nextLine();
				System.out.println("Error: Enter Double");
			}
			array[counter] = scan.nextDouble();
		}
		scan.close();
		return array;
	}

	static void sqrtArray(double[] array) { //Print sqrt of each value
		
		
		for (double i : array) {
			System.out.println(Math.sqrt(i));
		}
		
		
		/*
		double[] newArray = new double[array.length];
		for (int counter = 0; counter < array.length; counter++) {

			newArray[counter] = Math.sqrt(array[counter]);
		}
		printArray(newArray);
		*/
	}

	static void truncateArray(double[] array) {	//truncate values of array to 500
		for (int counter = 0; counter < array.length; counter++) {

			if (array[counter] > 500)
				array[counter] = 500;

		}
	}

	static double[] getReciprocalArray(double[] array) { //returns new array of reciprocals
		double[] newArray = new double[array.length];
		for (int counter = 0; counter < array.length; counter++) {

			newArray[counter] = 1 / array[counter];
		}

		return newArray;
	}

	static void printArray(double[] array) { //print out array
		System.out.print('{');
		for (int counter = 0; counter < array.length; counter++) {
			System.out.print(array[counter]);
			if (counter != (array.length - 1))
				System.out.print(", ");

		}
		System.out.println('}');
	}

}
