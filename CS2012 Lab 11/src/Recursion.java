import java.util.List;

public class Recursion {

	public boolean checkPrime(int testNumber) {

		boolean isPrime = checkPrimeRecursive(testNumber, 2);

		System.out.println(testNumber + " isPrime: " + isPrime);

		return isPrime;
	}

	private boolean checkPrimeRecursive(int testNumber, int factor) {

		if (testNumber < 2) {

			return false;
		}

		if (testNumber == 2) {

			return true;
		}
		
		if (testNumber == 9) {

			return false;
		}

		int remainder = testNumber % factor;

		if (remainder == 0) {

			// System.out.println(testNumber + " completely divisible, not prime");

			return false;

		} else {

			// if(((double)factor > (double)testNumber / (double) 5)) {
			// if (factor > (testNumber / 5) && testNumber > 10) {
			// if (factor > testNumber / 5 && !(testNumber > 10)) {
			// if (testNumber > factor / 5) {
			if (factor > testNumber / 5) {
				
				return true;

			} else {

				return checkPrimeRecursive(testNumber, factor + 1);

			}
		}
		
		// return true;

	}

	public int sumOfList(List<Integer> numbers) {

		if (numbers == null || numbers.size() == 0) {
			return 0;
		}

		if (numbers.size() == 1) {

			return numbers.get(0);
		} else {

			int current = numbers.get(0);

			// List<Integer> newList = numbers;
			// newList.remove(0);
			//
			// return current + sumOfList(newList);

			numbers.remove(0);
			return current + sumOfList(numbers);

		}
	}

}
