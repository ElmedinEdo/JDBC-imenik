package com.ui;

/*
 * 
 */


import java.util.ArrayList;
import java.util.Scanner;

import com.imenik.DTO.Student;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentUI.
 */
public class StudentUI {

	/** The input. */
	Scanner input = new Scanner(System.in);

	/**
	 * Creates the student.
	 *
	 * @return the student
	 */
	public Student createStudent() {

		System.out.print("Enter the student's name: ");
		String name = input.next();

		System.out.print("Enter the student's lastname: ");
		String lastname = input.next();

		System.out.print("Enter the student's DOB(YYYY-MM-DD): ");
		String dob = input.next();

		System.out.print("Enter the student's email: ");
		String email = input.next();

		System.out.print("Enter phoneNumber: ");
		String phoneNum=input.next();
		
		Student student = new Student(name, lastname, dob, email, phoneNum);
		return student;

	}

	/**
	 * Edits the student.
	 *
	 * @param student the student
	 * @return the student
	 */
	public Student editStudent(Student student) {

		System.out.print("Set a new name for student (current: " + student.getName() + " ): ");
		String name = input.next();
		student.setName(name);

		System.out.print("Set a new lastname for student (current: " + student.getLastname() + " ): ");
		String lastname = input.next();
		student.setLastname(lastname);

		System.out.print("Set a new DOB for student (current: " + student.getDob() + " ): ");
		String dob = input.next();
		student.setDob(dob);

		System.out.print("Set a new email for student (current: " + student.getEmail() + " ): ");
		String email = input.next();
		student.setEmail(email);

		System.out.print("Set a new phoneNumber for student (current: " + student.getPhoneNum() + " ): ");
		String phoneNum = input.next();
		student.setPhoneNum(phoneNum);
		
		return student;
	}

	/**
	 * Prints the all students.
	 *
	 * @param students the students
	 */
	public void printAllStudents(ArrayList<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
