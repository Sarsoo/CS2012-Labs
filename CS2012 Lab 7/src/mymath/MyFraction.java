package mymath;

public class MyFraction implements MyMath<MyFraction>{
	
	private int numerator;
	private int denominator;
	private char sign;
	
	public MyFraction(int numerator, int denominator, char sign) {
		this.numerator = Math.abs(numerator);
		
		if(denominator == 0) throw new IllegalArgumentException("Trying to Enter Denominator of 0");
		this.denominator = Math.abs(denominator);
		
		if(sign == '+' || sign == '-')
			this.sign = sign;
		else throw new IllegalArgumentException("Invalid Sign Character Entererd (+, -)");
	}
	
	@Override
	public MyFraction add(MyFraction o) {		
		
		if(sign == '+' && o.getSign() == '-') {	//	a + (-b) = a - b
			return subtract(new MyFraction(o.getNumerator(), o.getDenominator(), '+'));
		}
		if(sign == '-' && o.getSign() == '+') {	//	(-a) + b = b - a
			return o.subtract(new MyFraction(getNumerator(), getDenominator(), '+'));
		}
		if(sign == '-' && o.getSign() == '-') {	//	(-a) + (-b) = -(a + b)
			MyFraction newFraction = reduceFraction().getMultipliedByDenominator(o.getDenominator());
			MyFraction newInputFraction = o.reduceFraction().getMultipliedByDenominator(getDenominator());
			
			return new MyFraction(newFraction.getNumerator() + newInputFraction.getNumerator(), newFraction.getDenominator(), '-').reduceFraction();
			
		}
		if(sign == '+' && o.getSign() == '+') {	//	a + b = a + b
			MyFraction newFraction = reduceFraction().getMultipliedByDenominator(o.getDenominator());
			MyFraction newInputFraction = o.reduceFraction().getMultipliedByDenominator(getDenominator());
			
			return new MyFraction(newFraction.getNumerator() + newInputFraction.getNumerator(), newFraction.getDenominator(), '+').reduceFraction();
			
		}
		
		return null;
	}

	@Override
	public MyFraction subtract(MyFraction o) {

		if(sign == '+' && o.getSign() == '-') {	//	a - (-b) = a + b
			return add(new MyFraction(o.getNumerator(), o.getDenominator(), '+'));
		}
		if(sign == '-' && o.getSign() == '+') {	//	(-a) - b = -(b + a)
			return o.add(new MyFraction(getNumerator(), getDenominator(), '+')).toggleSign().reduceFraction();
		}
		if(sign == '-' && o.getSign() == '-') {	//	(-a) - (-b) = b - a
			MyFraction newFraction = reduceFraction().getMultipliedByDenominator(o.getDenominator());	// a
			MyFraction newInputFraction = o.reduceFraction().getMultipliedByDenominator(getDenominator());	//	b
			
			char sign;
			if(newInputFraction.getNumerator() > newFraction.getNumerator()) sign = '+';
			else sign = '-';
			
			return new MyFraction(Math.abs(newInputFraction.getNumerator() - newFraction.getNumerator()), newFraction.getDenominator(), sign).reduceFraction();
			
		}
		if(sign == '+' && o.getSign() == '+') {	//	a - b = a - b
			MyFraction newFraction = reduceFraction().getMultipliedByDenominator(o.getDenominator());
			MyFraction newInputFraction = o.reduceFraction().getMultipliedByDenominator(getDenominator());
			
			char sign;
			if(newFraction.getNumerator() > newInputFraction.getNumerator()) sign = '+';
			else sign = '-';
			
			return new MyFraction(Math.abs(newFraction.getNumerator() - newInputFraction.getNumerator()), newFraction.getDenominator(), sign).reduceFraction();
			
		}
		
		return null;
	}
	
	public MyFraction toggleSign() {
		if(getSign() == '+') return new MyFraction(getNumerator(), getDenominator(), '-');
		else return new MyFraction(getNumerator(), getDenominator(), '+');
	}
	
	private MyFraction getMultipliedByDenominator(int denominatorCoeff) {
		return new MyFraction((getNumerator() * denominatorCoeff), (getDenominator() * denominatorCoeff), sign);
	}
	
	@Override
	public MyFraction multiply(MyFraction o) {
		int newNumerator = this.getNumerator() * o.getNumerator();
		int newDenominator = this.getDenominator() * o.getDenominator();
		char newSign = 0;
		if(this.getSign() == '+' && o.getSign() == '+') newSign = '+';
		if(this.getSign() == '+' && o.getSign() == '-') newSign = '-';
		if(this.getSign() == '-' && o.getSign() == '+') newSign = '-';
		if(this.getSign() == '-' && o.getSign() == '-') newSign = '+';
		
		return (new MyFraction(newNumerator, newDenominator, newSign)).reduceFraction();
	}

	@Override
	public MyFraction divide(MyFraction o) {
		if(o.getNumerator() == 0) throw new IllegalArgumentException("Trying to Divide by 0");
		return this.multiply(new MyFraction(o.getDenominator(), o.getNumerator(), o.getSign()));
	}

	public MyFraction reduceFraction() {
		//TODO look into stronger solution than list of primes
		int[] array = {2,3,5,7,9,11,13,17,19,23,29,31,37,41,43,47,53};
		
		int newNumerator = this.numerator;
		int newDenominator = this.denominator;
		boolean isSmallest = false;
		while(!isSmallest) {
			isSmallest = true;
			
			for(int num : array) {
				if(((newNumerator % num) == 0 ) && ((newDenominator % num) == 0 )) {
					newNumerator = newNumerator / num;
					newDenominator = newDenominator / num;
					isSmallest = false;
				}
			}
			
			if(newNumerator == newDenominator) {
				newNumerator = 1;
				newDenominator = 1;
				isSmallest = true;
			}
		}
		
		return new MyFraction(newNumerator, newDenominator, sign);
	}
	

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		if(numerator >= 0)	this.numerator = numerator;
		else System.err.println("Invalid Numerator: Negative Value Not Acceptable, Value Unchanged");
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		if(denominator > 0)	this.denominator = denominator;
		else if(denominator == 0) System.err.println("Invalid Denominator: 0 Not Acceptable");
		else System.err.println("Invalid Denominator: Negative Value Not Acceptable, Value Unchanged");
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		if(sign == '+') this.sign = '+';
		else if(sign == '-') this.sign = '-';
		else System.err.println("Invalid Sign Character Entererd (+, -): sign unchanged");
	}
	
	@Override
	public String toString() {
		if(sign == '-') return "-" + numerator + "/" + denominator;
		else return numerator + "/" + denominator;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() != this.getClass()) return false;
		
		MyFraction thisSmallest = reduceFraction();
		MyFraction fraction = ((MyFraction)obj).reduceFraction();
		if(thisSmallest.getNumerator() == fraction.getNumerator())
			if(thisSmallest.getDenominator() == fraction.getDenominator())
				if(thisSmallest.getSign() == fraction.getSign())
					return true;
		
		return false;
	}
}
