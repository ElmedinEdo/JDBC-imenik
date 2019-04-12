package com.imenik.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.imenik.DTO.Student;

/**
 * The Interface StudentDAOInterface.
 */
public interface StudentDAOInterface {

	/**
	 * Gets the students.
	 *
	 * @return the students
	 * @throws SQLException the SQL exception
	 */
	// method to get all students
	public ArrayList<Student> getStudents() throws SQLException;

	/**
	 * Gets the student.
	 *
	 * @param userID the user ID
	 * @return the student
	 * @throws SQLException the SQL exception
	 */
	// method to get a specific student
	public Student getStudent(int userID) throws SQLException;

	/**
	 * Update student.
	 *
	 * @param student the student
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	// method to update a specific student
	public boolean updateStudent(Student student) throws SQLException;

	/**
	 * Delete student.
	 *
	 * @param student the student
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	// method to delete a specific student
	public boolean deleteStudent(Student student) throws SQLException;

	/**
	 * Save student.
	 *
	 * @param student the student
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	// method to save a student
	public boolean saveStudent(Student student) throws SQLException;

}