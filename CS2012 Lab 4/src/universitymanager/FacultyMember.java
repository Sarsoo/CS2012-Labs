package universitymanager;

public class FacultyMember extends Person{
	private int employeeId;
	
	
	public FacultyMember(String name, Address address, int employeeId) {
		super(name, address);
		this.employeeId = employeeId;
	}
	
	public String toString() {
		return employeeId + "#: " + name;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
}
