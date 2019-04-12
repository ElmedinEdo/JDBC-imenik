package com.imenik.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.imenik.DTO.Student;


/**
* The Class StudentDAOImplementation.
*/
public class StudentDAOImplementation implements StudentDAOInterface {

	/** The connection. */
	// connect to the database
	Connection connection = ConnectionManager.getInstance().getConnection();

	/* (non-Javadoc)
	 * @see imenik.DAO.StudentDAOInterface#getStudents()
	 */
	@Override
	public ArrayList<Student> getStudents() throws SQLException {

		// create an array list to hold students
		ArrayList<Student> students = new ArrayList<>();

		// create an SELECT SQL query
		String query = "SELECT * FROM student";

		// create a new ResultSet
		ResultSet rs = null;

		try (
				// java.sql.Statement
				Statement statement = connection.createStatement();) {

			// execute the query
			rs = statement.executeQuery(query);

			// add students to the arrayList
			while (rs.next()) {

				Student student = new Student();

				student.setStudentID(rs.getInt("studentID"));
				student.setName(rs.getString("name"));
				student.setLastname(rs.getString("lastname"));
				student.setDob(rs.getString("dob"));
				student.setEmail(rs.getString("email"));
             student.setPhoneNum(rs.getString("phoneNum"));
				
             students.add(student);

			}

		}

		return students;
	}

	/* (non-Javadoc)
	 * @see imenik.DAO.StudentDAOInterface#getStudent(int)
	 */
	@Override
	public Student getStudent(int userID) throws SQLException {

		Student student = new Student();

		// create an SELECT SQL query
		String query = "SELECT * FROM student WHERE studentID = ?";

		// create a new ResultSet
		ResultSet rs = null;

		try (
				// java.sql.Statement
				PreparedStatement statement = connection.prepareStatement(query);) {

			// fill in the placeholders/parameters
			statement.setInt(1, userID);

			// execute the query
			rs = statement.executeQuery();

			// set the cursor
			if (rs.next()) {

				// populate the student
				student.setStudentID(rs.getInt("studentID"));
				student.setName(rs.getString("name"));
				student.setLastname(rs.getString("lastname"));
				student.setDob(rs.getString("dob"));
				student.setEmail(rs.getString("email"));
             student.setPhoneNum(rs.getString("phoneNum"));
				
             // close the ResultSet
				rs.close();
			}
		}

		return student;
	}

	/* (non-Javadoc)
	 * @see imenik.DAO.StudentDAOInterface#updateStudent(imenik.DTO.Student)
	 */
	@Override
	public boolean updateStudent(Student student) throws SQLException {

		// create an SELECT SQL query
		String query = "UPDATE student SET name = ?, lastname = ?, dob = ?, email = ?, phoneNum = ?  WHERE studentID = ?";

		try (
				// java.sql.Statement
				PreparedStatement statement = connection.prepareStatement(query);) {

			// fill in the placeholders/parameters
			statement.setString(1, student.getName());
			statement.setString(2, student.getLastname());
			statement.setString(3, student.getDob());
			statement.setString(4, student.getEmail());
			statement.setString(5, student.getPhoneNum());
			
			statement.setInt(6, student.getStudentID());

			// execute the query
			if (statement.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		}
	}

	/* (non-Javadoc)
	 * @see imenik.DAO.StudentDAOInterface#deleteStudent(imenik.DTO.Student)
	 */
	@Override
	public boolean deleteStudent(Student student) throws SQLException {

		// create an SELECT SQL query
		String query = "DELETE FROM student WHERE studentID = ?";

		try (
				// java.sql.Statement
				PreparedStatement statement = connection.prepareStatement(query);) {

			// fill in the placeholders/parameters
			statement.setInt(1, student.getStudentID());

			// execute the query
			if (statement.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		}
	}

	/* (non-Javadoc)
	 * @see imenik.DAO.StudentDAOInterface#saveStudent(imenik.DTO.Student)
	 */
	@Override
	public boolean saveStudent(Student student) throws SQLException {

		// create an SELECT SQL query
		String query = "INSERT INTO student(name, lastname, dob, email, phoneNum) VALUES (?, ?, ?, ?, ?)";

		try (
				// java.sql.Statement
				PreparedStatement statement = connection.prepareStatement(query);) {

			// fill in the placeholders/parameters
			statement.setString(1, student.getName());
			statement.setString(2, student.getLastname());
			statement.setString(3, student.getDob());
			statement.setString(4, student.getEmail());
         statement.setString(5, student.getPhoneNum());
			
			// execute the query
			if (statement.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		}

	}

}
