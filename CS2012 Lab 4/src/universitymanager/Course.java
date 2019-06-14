package universitymanager;

public class Course {
	private String courseIdentifier;
	private int numberOfUnits;
	
	
	public Course(String courseIdentifier, int numberOfUnits) {
		this.courseIdentifier = courseIdentifier;
		this.numberOfUnits = numberOfUnits;
	}
	
	public String toString() {
		return courseIdentifier + ": " + numberOfUnits + " Units";
	}
	
	
	public String getCourseIdentifier() {
		return courseIdentifier;
	}
	public void setCourseIdentifier(String courseIdentifier) {
		this.courseIdentifier = courseIdentifier;
	}
	public int getNumberOfUnits() {
		return numberOfUnits;
	}
	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	
}
