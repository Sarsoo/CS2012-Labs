import java.util.ArrayList;

public class CourseRoll {
	private ArrayList<Student> students = new ArrayList<Student>();
	private int nextCin = 1;
	
	public void offerClass(){
		RandomArrayGenerator gen = new RandomArrayGenerator();
		
		double[] data = gen.getGaussianData(3, 0.75, 30, 2, 4);
		
		int counter;
		Student student;
		for(counter = 0; counter < 30; counter++) {
			student = new Student(nextCin++, data[counter]);
			students.add(student);
		}
		
		for(counter = 0; counter < 30; counter++) {
			System.out.println(students.get(counter));
		}
	}
}
