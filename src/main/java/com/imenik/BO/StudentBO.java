package com.imenik.BO;

import com.imenik.DTO.Student;

/**
 * The Class StudentBO.
 */
//business layer object
public class StudentBO {

	/**
	 * Checks if is student null.
	 *
	 * @param student the student
	 * @return true, if is student null
	 */
	public boolean isStudentNull(Student student) {
		if (student == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Checks if is student name valid.
	 *
	 * @param student the student
	 * @return true, if is student name valid
	 */
	public boolean isStudentNameValid(Student student) {

		if (student.getName().length() < 3) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Checks if is student last name valid.
	 *
	 * @param student the student
	 * @return true, if is student last name valid
	 */
	public boolean isStudentLastNameValid(Student student) {
		if (student.getLastname().length() < 3) {
			return false;
		} else {
			return true;
		}
	}

}
