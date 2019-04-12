package com.imenik.DTO;

/**
 * The Class Admin.
 */
public class Admin  {

	/** The admin ID. */
	// data fields
	private int adminID;
	
	/** The name. */
	private String name;
	
	/** The lastname. */
	private String lastname;
	
	/** The password. */
	private String password;

	/**
	 * Instantiates a new admin.
	 */
	public Admin() {
	}

	/**
	 * Instantiates a new admin.
	 *
	 * @param adminID the admin ID
	 * @param name the name
	 * @param lastname the lastname
	 * @param password the password
	 */
	// constructor when pulling from the database
	public Admin(int adminID, String name, String lastname, String password) {
		this.adminID = adminID;
		this.name = name;
		this.lastname = lastname;
		this.password= password;
	}

	/**
	 * Instantiates a new admin.
	 *
	 * @param name the name
	 * @param lastname the lastname
	 * @param password the password
	 */
	// constuctor for when creating an object in app
	public Admin(String name, String lastname, String password) {
		this.name = name;
		this.lastname = lastname;
		this.password = password;
		
	}

	/**
	 * Gets the admin ID.
	 *
	 * @return the admin ID
	 */
	public int getAdminID() {
		return adminID;
	}

	/**
	 * Sets the admin ID.
	 *
	 * @param adminID the new admin ID
	 */
	public void setAdminID(int adminID) {
		this.adminID = adminID;
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
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Imenik: adminID=" + adminID + ", name =" + name + ", lastname =" + lastname + ", password =" + password ;
	}

}