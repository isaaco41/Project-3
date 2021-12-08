package ManagementSystem;

public class Student_Employee extends Student{ //Inherits Student class to be able to use methods

		String EmpType;
		String job; //Additional variables for student_employee objects
		
		Student_Employee(int ID, String FN, String LN, String Year, 
				boolean S, String employmentType, String jobType) {
			super(ID, FN, LN, Year, S); //supers the constructor to be able to use the same variables
			
			EmpType = employmentType;
			job = jobType;
		}
		
		public void displayEmpStudents() { //Methods that prints the info for Student_Employee objects
			System.out.println("\n" + StuFirstName + " " + StuLastName);
			System.out.println("ID : " + StudentID);
			System.out.println(EmpType + " " + job);
		}
	}

