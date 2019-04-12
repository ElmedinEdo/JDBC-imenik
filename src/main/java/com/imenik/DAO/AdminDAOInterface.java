package com.imenik.DAO;


import java.sql.SQLException;
import java.util.ArrayList;

import com.imenik.DTO.Admin;


/**
 * The Interface AdminDAOInterface.
 */
public interface AdminDAOInterface {
	
	/**
	 * Gets the admins.
	 *
	 * @return the admins
	 * @throws SQLException the SQL exception
	 */
	// method to get all admins
		public ArrayList<Admin> getAdmins() throws SQLException;

		/**
		 * Gets the admin.
		 *
		 * @param userID the user ID
		 * @return the admin
		 * @throws SQLException the SQL exception
		 */
		// method to get a specific admin
		public Admin getAdmin(int userID) throws SQLException;

		/**
		 * Update admin.
		 *
		 * @param admin the admin
		 * @return true, if successful
		 * @throws SQLException the SQL exception
		 */
		// method to update a specific admin
		public boolean updateAdmin(Admin admin) throws SQLException;

		/**
		 * Delete admin.
		 *
		 * @param admin the admin
		 * @return true, if successful
		 * @throws SQLException the SQL exception
		 */
		// method to delete a specific admin
		public boolean deleteAdmin(Admin admin) throws SQLException;

		/**
		 * Save admin.
		 *
		 * @param admin the admin
		 * @return true, if successful
		 * @throws SQLException the SQL exception
		 */
		// method to save a admin
		public boolean saveAdmin(Admin admin) throws SQLException;

	}


