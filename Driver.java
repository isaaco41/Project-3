//Isaac Osorio
//ITSS 3312.002
//Fall 2021
package ManagementSystem;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class Driver {
	
	JFrame f = new JFrame("Management System");
    JButton SMS = new JButton("SMS");
    JButton CMS = new JButton("CMS");
    JButton Exit = new JButton("Exit");
 JFrame s = new JFrame("Student Management System");
    static JButton sms1 = new JButton("Add a student");
    JButton sms2 = new JButton("Deactivate a student");
    JButton sms3 = new JButton("Display all students");
    JButton sms4 = new JButton("Search by student ID");
    JButton sms5 = new JButton("Assign on-campus job");
    JButton sms6 = new JButton("Display all students with on-campus jobs");
    JButton sms7 = new JButton("Exit SMS");
 JFrame c = new JFrame("Course Management System");
    JButton cms1 = new JButton("Add a course");
    JButton cms2 = new JButton("Assign student to course");
    JButton cms3 = new JButton("Display students with assigned courses");
    JButton cms4 = new JButton("Exit CMS");
	
	public static int findIndex(Student arr[], int t) { //Method that makes returning the index of an element easier than a for-loop
		int len = arr.length;
		int i = 0;
		while(i < len) {
			if (arr[i].returnID() == t) {
				return i;
			}else {
				i++;
			}
		}
		return -1;
	}
	
	public static void main(String[] arg) throws IOException { //IOException to catch errors if file is not found
	
	Scanner input = new Scanner(System.in);

	System.out.print("             Welcome to the Student and Course Management System!\n" + //New primary menu
	"This system will allow you to manage studenets and courses. Let's start with the number\n"
	+ "of students this system will have: ");
	
	int size = input.nextInt(); //The inputed number is the size of the object array
	Student[] obj = new Student[size]; 
	Student_Employee[] obj2 = new Student_Employee[size]; //Student_Employee array is always the same size as the student array
	
	
	
	boolean menuLoop = true; //Boolean variable set to true to keep menu in a loop
	int menu; //Used to determine which menu option the user selects
	int SMSmenu; //Boolean variable for SMS loop
	int CMSmenu; //Boolean variable for CMS loop
	int arrayOrder = -1; //Used to initialize new Student objects in order
	int EmpArrayOrder = -1; //Maintains order of Student_employee array
	
	while(menuLoop) {

		System.out.print("\n***Welcome to the Student and Course Management System***\n" + 
		"Press '1' for Student Management System (SMS)\n" +
		"Press '2' for Course Managment System (CMS)\n" +
		"Press '0' to exit");
		
		boolean SMSmenuLoop = true;
		boolean CMSmenuLoop = true; //Set to true to allow user to return to menus after exiting
		menu = input.nextInt();
		switch (menu) {
		
		case 1: 
		while (SMSmenuLoop) { 
			System.out.print("\n***Welcome to SMS***\n" + 
					"Press ‘1’ to add a student\n" + 
					"Press ‘2’ to deactivate a student\n" + 
					"Press ‘3’ to display all students\n" + 
					"Press ‘4’ to search for a student by ID\n" + 
					"Press '5' to assign on-campus job\n" + 
					"Press '6' to display all students with on-campus jobs\n" +
					"Press ‘0’ to exit the system\n" + 
					"");
			
			
			SMSmenu = input.nextInt();
			switch (SMSmenu){ //Switch statement allows multiple options or "cases" and loops it back to while statement
				
			case 1: 
				arrayOrder++; //Keeping new objects in order so they don't overlap
				if (arrayOrder == size) { //Done to avoid an ArrayOutofBounds Exception
					System.out.print("\nThe system has reached the maximum amount of students\n");
				}
				else {	
				Scanner newObj = new Scanner(System.in);
				System.out.print("Enter first name: ");
				String firstN = newObj.nextLine();
				
				System.out.print("Enter last name: ");
				String lastN = newObj.nextLine();
				
				System.out.print("Enter level of the student: ");
				String level = newObj.nextLine();
				
				int id = 0; //Temporary/placeholder number
				boolean active = true; 
				
				obj[arrayOrder] = new Student(id, firstN, lastN, level, active); //Constructs a new object in the appropriate array slot
				System.out.print("\n" + firstN + " " + lastN + " has been added as a " +
				level + " with ID " );
				obj[arrayOrder].getID(); //Prints ID of new Student
				System.out.println();
				}
				break;
				
			case 2: 
				System.out.print("Enter the ID for the student you want to deactivate: ");
				int deactivate = input.nextInt();
				for(int i = 0; i < obj.length; i++) { //Checking if any of the objects have the specific ID
					if (obj[i].returnID() == deactivate) { //If found, it will deactivate
						obj[i].deactivate();
						obj[i].getName();
						System.out.print(" has been deactivated \n");
					}
				}
				break;
			
			case 3: 	
				
				try {
				for(int k = 0; k < obj.length; k++) { //Loops to display all students in the array
					obj[k].displayStudents(); //Will give a NullPointException if some array slots are empty
				}
				}catch(NullPointerException e) { //Handles exception when indexes are empty
					System.out.print("\nAll students displayed\n");
				}
				
				 try {
				      File myObj = new File("/Users/isaacosorio/Desktop/Project 2/StudentReport.txt"); //Creation of StudentReport.txt
				      if (myObj.createNewFile()) { //Boolean variable to show if file was created
				        System.out.println("File created: " + myObj.getName()); 
				      } else {
				        System.out.println("\nStudent Report file already exists."); 
				      }
				    } catch (IOException e) { //Catches exception
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
				 
				  FileWriter fw1 = null; //FileWriter is the only object that is able to edit/update files,
				  BufferedWriter bw1 = null; //but has not write method, so I utilizes the method of
				  PrintWriter pw1 = null;//PrintWriter via BufferedWriter
				 
				try {
			    	fw1 = new FileWriter("StudentReport.txt", true); //Parameters is the file name and boolean variable
			    	bw1 = new BufferedWriter(fw1);
			    	pw1 = new PrintWriter(bw1); //Basically nested Writer objects
			    	try {
			    	for (int i = 0; i < obj.length; i++) {
			    	pw1.println(obj[i].returnStudents()); //Returns string value of student information and adds to file
			    	}
			    	System.out.println("Done"); //Shows user the command went through
			    	pw1.flush();
			    	} catch(NullPointerException e) {	
			    	}
			    	
			    } finally {
			    	try {
			    		pw1.close();
			    	    bw1.close();
			    		fw1.close(); //Closes and saves the file
			    	}
			    catch(IOException e) {
			    	System.out.println("Error");
			    }
			    }
			
				break;
				
			case 4: 
				System.out.print("Enter the student ID: ");
				int search = input.nextInt();
				for (int f = 0; f < obj.length; f++) { //Loops to check if any object has the specific ID
					if (obj[f].returnID() == search) {
						obj[f].displayStudents();
					}
				}
				break;
			
			case 5: //Assigns a student a job
				Scanner type = new Scanner(System.in);
				System.out.print("Enter student ID: ");
				search = type.nextInt();
				type.nextLine();
			
				System.out.print("Enter job: ");
				String job = type.nextLine();
				
				System.out.print("Enter job type: ");
				String jType = type.nextLine();
			
				EmpArrayOrder++; //Places new object in next open index
				for(int i = 0; i < obj.length; i++) { //Checking if any of the objects have the specific ID
					if (obj[i].returnID() == search) {
						System.out.println();
						obj[i].getName();
				        System.out.print(" has been assigned " + jType + " " + job + " job.\n");
				        obj2[EmpArrayOrder] = new Student_Employee(obj[i].returnID(), 
								obj[i].returnFN(), obj[i].returnLN(), 
								obj[i].returnYr(), obj[i].returnS(), jType, job); //Uses methods from Student class to return values for the appropriate student
					}
				}
				break;
			
			case 6: //Displays all students with jobs
				try {
				for(int f = 0; f < obj2.length; f++) 
					obj2[f].displayEmpStudents(); //Uses a subclass method to return student info
				}catch(NullPointerException e) {
					System.out.print("\nAll students with jobs are displayed\n");
				}
				break;
				
			case 0: 
				System.out.println("\nExiting the Student Management System...\n"
						+ "Goodbye!");
				SMSmenuLoop = false; //Sets Boolean variable to false, and thus the loop terminates
				break;
			}
			
		}
		    break;
		case 2: 
		while(CMSmenuLoop) { //2nd nested while-loop and menu
			
			System.out.print("\n***Welcome to CMS***\n" +
			"Press '1' to add a new course\n" +
			"Press '2' to assign student a new course\n" +
			"Press '3' to display students with assigned courses\n" +
			"Press '0' to exit CMS");
			
		CMSmenu = input.nextInt();
		switch(CMSmenu) {
		
		case 1: //Able to create a course
			
			System.out.print("\nEnter course ID: ");
			int CourseID = input.nextInt();
			
			input.nextLine();
			System.out.print("Enter course name: ");
			String CourseName = input.nextLine(); //Asks user for course info
			
			  FileWriter fw2 = null; //Initializes Writers to null to be able to use later
			  BufferedWriter bw2 = null;
			  PrintWriter pw2 = null;
			 
			try {
		    	fw2 = new FileWriter("Courses.txt", true); //Updating Courses.txt
		    	bw2 = new BufferedWriter(fw2);
		    	pw2 = new PrintWriter(bw2);
		    	 
		    	pw2.println(CourseID + " course " + CourseName); //Style the information is added in
		    	
		    	System.out.println("Done");
		    	pw2.flush();
		    	
		    } finally {
		    	try {
		    		pw2.close();
		    	    bw2.close();
		    		fw2.close(); //Closes courses.txt
		    	}
		    catch(IOException e) {
		    	System.out.println("Error");
		    }
		    }
			
			System.out.print("\nConfirmation: New course " + CourseID + " has been added\n"); //Confirmation message for creation of course

			break;
			
		case 2: //Assigns a student to a course
			
			System.out.print("\nEnter student ID: "); //Asking for specific student
		    int search = input.nextInt();
		    
		    System.out.print("Enter course ID: ");
		    int courseID = input.nextInt();
		    System.out.println();   
		    
		    System.out.println(obj[findIndex(obj, search)].returnName() + " has been assigned to course " + courseID); //Uses findIndex to return index of specific student
		    
		    FileWriter fw = null;
		    BufferedWriter bw = null;
		    PrintWriter pw = null;
		    
	    	try {
		    	fw = new FileWriter("CourseAssignment.txt", true);
		    	bw = new BufferedWriter(fw);
		    	pw = new PrintWriter(bw);
		    	
		    	pw.println(obj[findIndex(obj, search)].returnName() + " has been assigned to course " + courseID); //Adds to file
		    	System.out.println("Done");
		    	pw.flush();
		    	
		    } finally {
		    	try {
		    		pw.close();
		    	    bw.close();
		    		fw.close(); //Closes and saves file
		    	}
		    catch(IOException e) {
		    	System.out.println("Error");
		    }
		    }
			break;
			
		case 3: //Prints all course assignments
			
			FileReader fr = new FileReader("/Users/isaacosorio/Desktop/Project 2/CourseAssignment.txt"); //FileReader object to read file contents
			int i; 
			
			System.out.println();
			while((i = fr.read()) != -1) { 
				System.out.print((char)i); //Loops keeps reading and printing file contents until nothing is left
			}
			
			break; 
			
		case 0:
			System.out.print("\nExiting the CMS...\n" +
		         "Goodbye!\n");
			CMSmenuLoop = false;
			break;
		}
		}
		    break; 
		case 0: 
		System.out.print("\nGoodbye!"); 
		menuLoop = false; //Terminates final loop and exits Management System
		break;
	}
	}
	}
	}

