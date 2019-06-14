package universitymanager;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class University {
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<FacultyMember> faculty = new ArrayList<FacultyMember>();
	private ArrayList<Course> courses = new ArrayList<Course>();

	public void menu() {
		int response = 0;

		do {
			String[] menuChoices = { "Exit", "Student", "Faculty", "Course" };
			response = JOptionPane.showOptionDialog(null, "Select Object Manager:", "University Manager",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menuChoices, menuChoices[0]);

			switch (response) {
			case 0:
				break;
			case 1:
				studentMenu();
				break;
			case 2:
				facultyMenu();
				break;
			case 3:
				courseMenu();
				break;
			}
		} while (response != 0);
	}

	private void studentMenu() {
		String[] menuChoices = { "Back", "Add Student", "Delete Student", "View Students", "Manage Student's Courses" };
		int response = JOptionPane.showOptionDialog(null, "Student Menu\n" + students.size() + " Students Registered", "Student Manager", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, menuChoices, menuChoices[0]);

		switch (response) {
		case 0:
			break;
		case 1:
			addStudent();
			break;
		case 2:
			deleteStudent();
			break;
		case 3:
			viewStudents();
			break;
		case 4:
			manageStudentCourses();
			break;
		}
	}

	private void facultyMenu() {
		String[] menuChoices = { "Back", "Add Faculty", "Delete Faculty", "View Faculty", "Manage Teaching Schedule" };
		int response = JOptionPane.showOptionDialog(null, "Faculty Menu\n" + faculty.size() + " Employees Registered", "Faculty Manager", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, menuChoices, menuChoices[0]);

		switch (response) {
		case 0:
			break;
		case 1:
			addFaculty();
			break;
		case 2:
			deleteFaculty();
			break;
		case 3:
			viewFaculty();
			break;
		case 4:
			manageFacultyCourses();
			break;
		}
	}

	private void courseMenu() {
		String[] menuChoices = { "Back", "Add Course", "View Courses" };
		int response = JOptionPane.showOptionDialog(null, "Course Menu\n" + courses.size() + " Registered", "Course Manager", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, menuChoices, menuChoices[0]);

		switch (response) {
		case 0:
			break;
		case 1:
			addCourse();
			break;
		case 2:
			viewCourses();
			break;
		}
	}

	// VIEW LIST METHODS
	private void viewStudents() {
		if (students.size() > 0) {
			int counter;
			StringBuilder sb = new StringBuilder();
			for (counter = 0; counter < students.size(); counter++) {
				sb.append(students.get(counter) + " - " + students.get(counter).getNumberOfCourses() + " Course(s)");
				sb.append("\n");
			}
			JOptionPane.showMessageDialog(null, sb, "Student List", JOptionPane.DEFAULT_OPTION, null);
		}else {
			JOptionPane.showMessageDialog(null, "No Students Registered", "Error: Empty List", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void viewFaculty() {
		if (faculty.size() > 0) {
			int counter;
			StringBuilder sb = new StringBuilder();
			for (counter = 0; counter < faculty.size(); counter++) {
				sb.append(faculty.get(counter) + " - " + faculty.get(counter).getNumberOfCourses() + " Course(s)");
				sb.append("\n");
			}
			JOptionPane.showMessageDialog(null, sb, "Faculty List", JOptionPane.DEFAULT_OPTION, null);
		}else {
			JOptionPane.showMessageDialog(null, "No Faculty Registered", "Error: Empty List", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void viewCourses() {
		if (courses.size() > 0) {
			int counter;
			StringBuilder sb = new StringBuilder();
			for (counter = 0; counter < courses.size(); counter++) {
				sb.append(courses.get(counter));
				sb.append("\n");
			}
			JOptionPane.showMessageDialog(null, sb, "Course List", JOptionPane.DEFAULT_OPTION, null);
		}else {
			JOptionPane.showMessageDialog(null, "No Courses Registered", "Error: List Empty", JOptionPane.ERROR_MESSAGE);
		}
	}

	// COURSE MANAGEMENT METHODS
	private void manageStudentCourses() {
		//GET STUDENT FROM USER
		Object[] options = students.toArray();
		Object choice = JOptionPane.showInputDialog(null, "Pick a Student to Manage", "Student Course Manager",
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		int index = students.indexOf(choice);

		if (index != -1) {
			//PRINT STUDENT INFORMATION
			StringBuilder sb = new StringBuilder();
			Student student = students.get(index);
			String message = student.getName() + "\n#" + student.getCIN() + "\n" + student.getAddress();
			sb.append(message);

			if (student.getNumberOfCourses() > 0) {
				//PRINT COURSES
				sb.append("\n\n");
				int i;
				for (i = 0; i < student.getNumberOfCourses(); i++) {
					sb.append(student.getCourseIdentifier(i));
					sb.append("\n");
				}

				// SHOW MENU WITH DROP BUTTON
				String[] menuChoices = { "Add Course", "Remove Course", "Back" };
				int menuChoice = JOptionPane.showOptionDialog(null, sb, student.getName() + " - " + student.getCIN(),
						JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, menuChoices, menuChoices[0]);
				switch (menuChoice) {
				case 0:
					enrollCourse(students.get(index));
					break;
				case 1:
					dropCourse(students.get(index));
					break;
				case 2:
					break;
				}

			} else {

				// SHOW MENU NO DROP BUTTON
				sb.append("\n\nNo Courses Enrolled");
				String[] menuChoices = { "Add Course", "Back" };
				int menuChoice = JOptionPane.showOptionDialog(null, sb, student.getName() + " - " + student.getCIN(),
						JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, menuChoices, menuChoices[0]);
				switch (menuChoice) {
				case 0:
					enrollCourse(students.get(index));
					break;
				case 1:
					break;
				}
			}
		}
	}

	private void manageFacultyCourses() {
		//GET FACULTY MEMBER FROM USER
		Object[] options = faculty.toArray();
		Object choice = JOptionPane.showInputDialog(null, "Pick a Faculty Member to Manage", "Faculty Course Manager",
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		int index = faculty.indexOf(choice);

		if (index != -1) {
			//PRINT FACULTY INFORMATION
			StringBuilder sb = new StringBuilder();
			FacultyMember facultymember = faculty.get(index);
			String message = facultymember.getName() + "\n#" + facultymember.getEmployeeId() + "\n"
					+ facultymember.getAddress();
			sb.append(message);

			if (facultymember.getNumberOfCourses() > 0) {
				//PRINT COURSES
				sb.append("\n\n");
				int i;
				for (i = 0; i < facultymember.getNumberOfCourses(); i++) {
					sb.append(facultymember.getCourseIdentifier(i));
					sb.append("\n");
				}

				// SHOW MENU WITH DROP BUTTON
				String[] menuChoices = { "Add Course", "Remove Course", "Back" };
				int menuChoice = JOptionPane.showOptionDialog(null, sb,
						facultymember.getName() + " - " + facultymember.getEmployeeId(), JOptionPane.DEFAULT_OPTION,
						JOptionPane.DEFAULT_OPTION, null, menuChoices, menuChoices[0]);
				switch (menuChoice) {
				case 0:
					enrollCourse(faculty.get(index));
					break;
				case 1:
					dropCourse(faculty.get(index));
					break;
				case 2:
					break;
				}

			} else {

				// SHOW MENU NO DROP BUTTON
				sb.append("\n\nNo Courses Enrolled");
				String[] menuChoices = { "Add Course", "Back" };
				int menuChoice = JOptionPane.showOptionDialog(null, sb,
						facultymember.getName() + " - " + facultymember.getEmployeeId(), JOptionPane.DEFAULT_OPTION,
						JOptionPane.DEFAULT_OPTION, null, menuChoices, menuChoices[0]);
				switch (menuChoice) {
				case 0:
					enrollCourse(faculty.get(index));
					break;
				case 1:
					break;
				}
			}
		}
	}

	private void enrollCourse(Person person) {
		
		//CREATE MENU OPTIONS FROM REGISTERED COURSES
		ArrayList<Course> menuOptions = new ArrayList<Course>();
		int counter;
		for(counter = 0; counter < courses.size(); counter++) {
			Course course = courses.get(counter);
			menuOptions.add(course);
		}
		
		//REMOVE ALREADY ENROLLED COURSES FROM OPTIONS
		ArrayList<Course> courseSchedule = person.getCourses();
		
		for(counter = 0; counter < courseSchedule.size(); counter++) {
			menuOptions.remove(courseSchedule.get(counter));
		}
		
		Object[] options = menuOptions.toArray();
		
		if(options.length != 0) {
			Object choice = JOptionPane.showInputDialog(null, "Pick a Course to Enroll in", "Add a Course",
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(choice != null) {
				int index = courses.indexOf(choice);

				Course course = courses.get(index);
				person.enrollCourse(course);
			}
		}else {
			JOptionPane.showMessageDialog(null, "No Courses Left to Enroll", "Error: No Courses", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void dropCourse(Person person) {
		Object[] options = person.getCourses().toArray();
		Object choice = JOptionPane.showInputDialog(null, "Pick a Course to Drop", "Drop a Course",
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(choice != null) {
			int index = courses.indexOf(choice);

			Course course = courses.get(index);
			person.dropCourse(course);
		}
	}

	// ADD METHODS
	public void addStudent() {
		String name = JOptionPane.showInputDialog(null, "Enter Student Name:");
		
		if(name != null && name.length() > 0) {
			
			int idNumber = -1;
			String idNumberString = JOptionPane.showInputDialog(null, "Enter Student CIN:");
			
			if(idNumberString != null) {
				
				try{
					idNumber = Integer.parseInt(idNumberString);
				}catch(NumberFormatException e) {
					idNumber = -1;
					JOptionPane.showMessageDialog(null, "CIN Must be Number", "Error: Int Required", JOptionPane.ERROR_MESSAGE);
				}
				
				if(idNumber != -1) {
					
					//CHECK IF ENTERED ID ALREADY EXISTS
					boolean isCINDuplicate = false;
					
					int counter;
					for(counter = 0; counter < students.size(); counter++) {
						if(idNumber == students.get(counter).getCIN()) {
							isCINDuplicate = true;
							break;
						}
					}
					
					if(isCINDuplicate == false) {
						Address address = getAddress();
					
						if (address != null) {
							students.add(new Student(name, address, idNumber));
						}
					}else {
						JOptionPane.showMessageDialog(null, "Registered Student with Entered CIN Already Found", "Error: Duplicate CIN", JOptionPane.ERROR_MESSAGE, null);
					}
				}
			}
		}
	}

	public void addFaculty() {
		String name = JOptionPane.showInputDialog(null, "Enter Faculty Member Name:");
		
		if(name != null && name.length() > 0) {
			
			int idNumber = -1;
			String idNumberString = JOptionPane.showInputDialog(null, "Enter Employee ID:");
			
			if(idNumberString != null) {
				
				try{
					idNumber = Integer.parseInt(idNumberString);
				}catch(NumberFormatException e) {
					idNumber = -1;
					JOptionPane.showMessageDialog(null, "Employee ID Must be Number", "Error: Int Required", JOptionPane.ERROR_MESSAGE);
				}
				
				if(idNumber != -1) {
					
					//CHECK IF ENTERED ID IS DUPLICATE
					boolean isIdDuplicate = false;
					
					int counter;
					for(counter = 0; counter < faculty.size(); counter++) {
						if(idNumber == faculty.get(counter).getEmployeeId()) {
							isIdDuplicate = true;
							break;
						}
					}
					
					
					if(isIdDuplicate == false) {
						Address address = getAddress();
					
						if (address != null) {
							faculty.add(new FacultyMember(name, address, idNumber));
						}
					}else {
						JOptionPane.showMessageDialog(null, "Registered Employee with Entered ID Already Found", "Error: Duplicate ID", JOptionPane.ERROR_MESSAGE, null);
					}
				}
			}
		}
	}

	private void addCourse() {
		String name = JOptionPane.showInputDialog(null, "Enter Course Identifier:");
		
		if(name != null && name.length() > 0) {

			Object[] menuChoices = {1,2,3,4,5,6,7,8};
			
			Object courseUnits = JOptionPane.showInputDialog(null, "Select Number of Units:", "Pick Units", 
					JOptionPane.QUESTION_MESSAGE, null, menuChoices, menuChoices[0]);
			
			if(courseUnits != null) {
				courses.add(new Course(name, (int)courseUnits));
			}
		}
	}

	// DELETE METHODS
	private void deleteStudent() {
		Object[] options = students.toArray();
		Object choice = JOptionPane.showInputDialog(null, "Pick a Student to Delete", "Delete Student",
				JOptionPane.DEFAULT_OPTION, null, options, options[0]);
		int index = students.indexOf(choice);

		if (index != -1) {
			students.remove(index);
			JOptionPane.showMessageDialog(null, "Student Removed", "Deleted", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void deleteFaculty() {
		Object[] options = faculty.toArray();
		Object choice = JOptionPane.showInputDialog(null, "Pick a Faculty Member to Delete", "Delete Faculty Member",
				JOptionPane.DEFAULT_OPTION, null, options, options[0]);
		int index = faculty.indexOf(choice);

		if (index != -1) {
			faculty.remove(index);
			JOptionPane.showMessageDialog(null, "Employee Removed", "Deleted", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// GET ADDRESS FROM USER
	public Address getAddress() {
		int streetNumber = -1;
		String streetNumberString = JOptionPane.showInputDialog(null, "Enter Street Number:");
		if(streetNumberString != null) {
			try {
				streetNumber = Integer.parseInt(streetNumberString);
			}catch(NumberFormatException e) {
				streetNumber = -1;
				JOptionPane.showMessageDialog(null, "Street Number Must be Number", "Error: Int Required", JOptionPane.ERROR_MESSAGE);
			}
			
			if(streetNumber > 0) {
				String streetName = JOptionPane.showInputDialog(null, "Enter Street:");
				if(streetName != null && streetName.length() > 0) {
					String cityName = JOptionPane.showInputDialog(null, "Enter City:");
					if(cityName != null && cityName.length() > 0) {
						String stateName = JOptionPane.showInputDialog(null, "Enter State:");
						if(stateName != null && stateName.length() > 0) {
							String countryName = JOptionPane.showInputDialog(null, "Enter Country:");
							if(countryName != null && countryName.length() > 0) {
								return new Address(streetNumber, streetName, cityName, stateName, countryName);
							}
						}
					}
				}
			}
		}
		
		return null;
	}

	// TESTING METHODS
	public void insertStudent(String name, int streetnumber, String streetname, String city, String state,
			String country, int cin) {
		students.add(new Student(name, new Address(streetnumber, streetname, city, state, country), cin));
	}

	public void insertFaculty(String name, int streetnumber, String streetname, String city, String state,
			String country, int cin) {
		faculty.add(new FacultyMember(name, new Address(streetnumber, streetname, city, state, country), cin));
	}

	public void insertCourse(String name, int units) {
		courses.add(new Course(name, units));
	}
}
