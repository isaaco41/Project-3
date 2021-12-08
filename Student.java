package ManagementSystem;

class Student {

	int StudentID = (int)(Math.random()*100); //Gives a random integer to every new object
	String StuFirstName;
	String StuLastName;
	String StuYear; 
	boolean Status = true; //Automatically set every new Student object to active
		
	Student(int ID, String FN, String LN, String Year, boolean S){ //Object constructor
		
		ID = StudentID; 
		StuFirstName = FN;
		StuLastName = LN;
		StuYear = Year;
		S = Status;
	}
	
	public String getName() { //Use this method to print out names for certain commands
		System.out.print(StuFirstName + " " + StuLastName);
		return StuFirstName + StuLastName; 
	}
	
	public String returnName() {
		return StuFirstName + " " + StuLastName;
	}
	
	public String returnFN() {
		return StuFirstName;
	}
	
	public String returnLN() {
		return StuLastName;
	}
	
	public String returnYr() { //Methods that return values of Student objects
		return StuYear;
	}
	
	public boolean returnS() {
		return Status;
	}
	public void getID() { //Prints the Student ID 
		System.out.print(StudentID);
	}
	
	public int returnID() { //Does NOT print but rather returns the ID to find an object in the array
		return StudentID;
	}
	
	public boolean deactivate() { //Sets a Student to Inactive
		Status = false;
		return Status;
	}
	
	public void displayStudents() { //Printing format when displaying all the Students in the array
		System.out.println("\n" + StuFirstName + " " + StuLastName);
		System.out.println("ID: " + StudentID);
		System.out.println("Level: " + StuYear);
		if(Status == false) {
			System.out.println("Status: Inactive");
		}
		else if (Status == true) {
			System.out.println("Status: Active");
		}
	}
	
	public String returnStudents() //Returns the student info to be added to files
	{
		return StuFirstName + " " + StuLastName + "\n" +
	           "ID: " + StudentID + "\n" + 
			   "Level: " + StuYear + "\n" +
			   "Status: " + Status;
	
	}
	
	}

