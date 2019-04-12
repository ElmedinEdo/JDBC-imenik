package com.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.imenik.BO.StudentBO;
import com.imenik.DAO.ConnectionManager;
import com.imenik.DAO.StudentDAOImplementation;
import com.imenik.DTO.Student;
import com.ui.MenuUI;
import com.ui.StudentUI;

/**
 * The Class App.
 */
public class AppStudent  {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		// UI Layer - User Interface objects
		StudentUI studentUI = new StudentUI();
		MenuUI menu = new MenuUI();

		// Business Layer - Business object
		StudentBO studentBO = new StudentBO();

		// Data Access Layer - Data Access Object
		StudentDAOImplementation DAO = new StudentDAOImplementation();

		// variables used throughout the application
		Scanner input = new Scanner(System.in);
		int userInput;
		Student student;
		ArrayList<Student> students;
		int studentId;
		
		
		// print the menu
		menu.printMenu();
		// get user input
		userInput = input.nextInt();

		// do the magicks!
		switch (userInput) {

		case 1:

			try {
				students = DAO.getStudents();
				studentUI.printAllStudents(students);
			} catch (SQLException e) {
				 e.printStackTrace();
			}

			break;

		case 2:

			// create a new student
			student = studentUI.createStudent();

			// check if the created student is "valid"
			if (!studentBO.isStudentNull(student)) {
				System.out.println("Student can't be null");
			} else if (!studentBO.isStudentNameValid(student)) {
				System.out.println("Student's name can't be less than 3 characters");
			} else if (!studentBO.isStudentLastNameValid(student)) {
				System.out.println("Student's name can't be less than 3 characters");
			} else {

				try {

					if (DAO.saveStudent(student)) {
						System.out.println("\nStudent sucessfully added to the database.");
					}

				} catch (SQLException e) {
					 e.printStackTrace();
				}
			}

			break;

		case 3:

			System.out.print("Please enter the ID of the student you'd like to update: ");
			studentId = input.nextInt();

			try {

				student = DAO.getStudent(studentId);
				Student updatedStudent = studentUI.editStudent(student);
			
				if (DAO.updateStudent(updatedStudent)) {
					System.out.println("\nStudent sucessfully updated.");
				}

			} catch (SQLException e) {
				   e.printStackTrace();
			}

			break;

		case 4:

			System.out.print("Please enter the ID of the student you'd like to delete: ");
			studentId = input.nextInt();

			try {

				student = DAO.getStudent(studentId);

				System.out.println(student);
				System.out.println("\nAre you sure you want to delete the following student? (Y/N)");

				char confirmation = input.next().charAt(0);

				if (confirmation == 'Y' || confirmation == 'y') {

					if (DAO.deleteStudent(student)) {
						System.out.println("Student deleted!");
					}

				} else {
					System.out.println("Aborting...");
				}

			} catch (SQLException e) {
				 e.printStackTrace();
			}

			break;

		case 5:

			System.out.println("Exit!");

			try {
				ConnectionManager.getInstance().getConnection().close();
				input.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			break;

		}

	}

}
