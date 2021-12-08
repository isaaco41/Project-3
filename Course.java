package ManagementSystem;

import java.io.File;
import java.io.IOException;

public class Course extends Driver{ 
	{
		try {
		      File myObj2 = new File("/Users/isaacosorio/Desktop/Project 2/Courses.txt"); //File creation for courses
		      if (myObj2.createNewFile()) {
		        System.out.println("\nFile created: " + myObj2.getName());
		      } else {
		        System.out.println("\nCourses File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("\nAn error occurred.");
		      e.printStackTrace();
		    }
		
		 try {
		      File myObj = new File("/Users/isaacosorio/Desktop/Project 2/CourseAssignment.txt"); //File creation for course assignments
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	}


