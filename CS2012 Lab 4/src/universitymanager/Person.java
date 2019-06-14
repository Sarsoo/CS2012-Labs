package universitymanager;

import java.util.ArrayList;

public class Person {
	protected String name;
	protected Address address;
	private ArrayList<Course> courseSchedule = new ArrayList<Course>();
	
	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
		
	}
	
	public String toString() {
		return name;
	}
	
	public void enrollCourse(Course course) {
		courseSchedule.add(course);
	}
	
	public int getNumberOfCourses() {
		return courseSchedule.size();
	}
	
	public void dropCourse(Course course) {
		courseSchedule.remove(course);
	}
	
	public String getCourseIdentifier(int index) {
		return courseSchedule.get(index).getCourseIdentifier();
		
	}
	
	public ArrayList<Course> getCourses() {
		return courseSchedule;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
