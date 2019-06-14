public class Student {
	private int cin;
	private double gpa;

	public Student(int cin, double gpa) {
		super();
		this.cin = cin;
		this.gpa = gpa;
	}

	public String toString() {
		return String.format("Student # %d has GPA of %.2f", cin, gpa);
	}
}