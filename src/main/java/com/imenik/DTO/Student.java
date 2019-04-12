package com.imenik.DTO;

/*
 * The Class Student.
 */
public class Student {

	/** The student ID. */
	// data fields
	private int studentID;
	
	/** The name. */
	private String name;
	
	/** The lastname. */
	private String lastname;
	
	/** The dob. */
	private String dob;
	
	/** The email. */
	private String email;
	
	/** The phone num. */
	private String phoneNum;

	/**
	 * Instantiates a new student.
	 */
	public Student() {
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param studentID the student ID
	 * @param name the name
	 * @param lastname the lastname
	 * @param dob the dob
	 * @param email the email
	 * @param phoneNum the phone num
	 */
	// constructor when pulling from the database
	public Student(int studentID, String name, String lastname, String dob, String email, String phoneNum) {
		this.studentID = studentID;
		this.name = name;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.phoneNum=phoneNum;
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param name the name
	 * @param lastname the lastname
	 * @param dob the dob
	 * @param email the email
	 * @param phoneNum the phone num
	 */
	// constuctor for when creating an object in app
	public Student(String name, String lastname, String dob, String email, String phoneNum) {
		this.name = name;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.phoneNum=phoneNum;
	}

	/**
	 * Gets the student ID.
	 *
	 * @return the student ID
	 */
	// getters
	public int getStudentID() {
		return studentID;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Gets the phone num.
	 *
	 * @return the phone num
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * Sets the student ID.
	 *
	 * @param studentID the new student ID
	 */
	// setters
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the phone num.
	 *
	 * @param phoneNum the new phone num
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Imenik:[KorisnickiID = " + studentID + ", name=" + name + ", lastname=" + lastname + ", dob=" + dob
				+ ", email=" + email + ", phoneNum=" + phoneNum + "]";
	}

}