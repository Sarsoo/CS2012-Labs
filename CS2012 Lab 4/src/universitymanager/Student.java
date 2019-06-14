package universitymanager;

public class Student extends Person{
	private int CIN;
	
	public Student(String name, Address address, int CIN){
		super(name, address);
		
		this.CIN = CIN;
	}
	
	public String toString() {
		return CIN + "#: " + name;
	}
	
	public int getCIN() {
		return CIN;
	}
	public void setCIN(int cIN) {
		CIN = cIN;
	}
	
}
