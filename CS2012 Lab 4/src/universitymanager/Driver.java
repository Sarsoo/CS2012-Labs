package universitymanager;

public class Driver {

	public static void main(String[] args) {
		University uni = new University();
		
		uni.insertStudent("Andy", 149, "Test", "Amersham", "Bucks", "UK", 34);
		uni.insertStudent("Bob", 149, "Test Road", "Amersham", "Bucks", "UK", 35);
		uni.insertStudent("Carl", 149, "Test Road", "Amersham", "Bucks", "UK", 36);
		uni.insertStudent("Derek", 149, "Test Road", "Amersham", "Bucks", "UK", 37);
		uni.insertStudent("Evan", 149, "Test Road", "Amersham", "Bucks", "UK", 38);
		uni.insertStudent("Fred", 149, "Test Road", "Amersham", "Bucks", "UK", 39);
		uni.insertStudent("George", 149, "Test Road", "Amersham", "Bucks", "UK", 41);
		uni.insertFaculty("Harry", 149, "Test Road", "Amersham", "Bucks", "UK", 40);
		uni.insertFaculty("Ivan", 149, "Test Road", "Amersham", "Bucks", "UK", 45);
		uni.insertFaculty("Jerry", 149, "Test Road", "Amersham", "Bucks", "UK", 48);
		uni.insertFaculty("Kevin", 149, "Test Road", "Amersham", "Bucks", "UK", 80);
		uni.insertFaculty("Liam", 149, "Test Road", "Amersham", "Bucks", "UK", 90);
		uni.insertCourse("EE-324", 4);
		uni.insertCourse("CS-2352", 8);
		uni.insertCourse("PH-342", 8);
		uni.insertCourse("EN-754", 8);
		
		uni.menu();
	}

}
