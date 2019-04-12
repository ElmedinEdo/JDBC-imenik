package com.imenik.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.imenik.DTO.Admin;

/**
 * The Class AdminDAOImplementation.
 */
public class AdminDAOImplementation implements AdminDAOInterface {

	/** The connection. */
	// connect to the database
		Connection connection = ConnectionManager.getInstance().getConnection();

		/* (non-Javadoc)
		 * @see imenik.DAO.AdminDAOInterface#getAdmins()
		 */
		@Override
		public ArrayList<Admin> getAdmins() throws SQLException {

			// create an array list to hold admins
			ArrayList<Admin> admins = new ArrayList<>();

			// create an SELECT SQL query
			String query = "SELECT * FROM admin";

			// create a new ResultSet
			ResultSet rs = null;

			try (
					// java.sql.Statement
					Statement statement = connection.createStatement();) {

				// execute the query
				rs = statement.executeQuery(query);

				// add admins to the arrayList
				while (rs.next()) {

					Admin admin = new Admin();

					admin.setAdminID(rs.getInt("adminID"));
					admin.setName(rs.getString("name"));
					admin.setLastname(rs.getString("lastname"));
					admin.setPassword(rs.getString("password"));
					
					admins.add(admin);

				}

			}

			return admins;
		}

		/* (non-Javadoc)
		 * @see imenik.DAO.AdminDAOInterface#getAdmin(int)
		 */
		@Override
		public Admin getAdmin(int userID) throws SQLException {
			
			Admin admin = new Admin();
			
			// create an SELECT SQL query
			String query = "SELECT * FROM admin WHERE adminID = ?";

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

					// populate the admin
				
					admin.setAdminID(rs.getInt("adminID"));
					admin.setName(rs.getString("name"));
					admin.setLastname(rs.getString("lastname"));
					admin.setPassword(rs.getString("password"));
      
	                                
	                // close the ResultSet
					rs.close();
				}
			}

			return admin;
		}

		/* (non-Javadoc)
		 * @see imenik.DAO.AdminDAOInterface#updateAdmin(imenik.DTO.Admin)
		 */
		@Override
		public boolean updateAdmin(Admin admin) throws SQLException {

			// create an SELECT SQL query
			String query = "UPDATE admin SET name = ?, lastname = ?, password = ?  WHERE adminID = ?";

			try (
					// java.sql.Statement
					PreparedStatement statement = connection.prepareStatement(query);) {

				// fill in the placeholders/parameters
				statement.setString(1, admin.getName());
				statement.setString(2, admin.getLastname());
				statement.setString(3, admin.getPassword());
				
				statement.setInt(4, admin.getAdminID());

				// execute the query
				if (statement.executeUpdate() == 1) {
					return true;
				} else {
					return false;
				}

			}
		}

		/* (non-Javadoc)
		 * @see imenik.DAO.AdminDAOInterface#deleteAdmin(imenik.DTO.Admin)
		 */
		@Override
		public boolean deleteAdmin(Admin admin) throws SQLException {

			// create an SELECT SQL query
			String query = "DELETE FROM admin WHERE adminID = ?";

			try (
					// java.sql.Statement
					PreparedStatement statement = connection.prepareStatement(query);) {

				// fill in the placeholders/parameters
				statement.setInt(1, admin.getAdminID());

				// execute the query
				if (statement.executeUpdate() == 1) {
					return true;
				} else {
					return false;
				}

			}
		}

		/* (non-Javadoc)
		 * @see imenik.DAO.AdminDAOInterface#saveAdmin(imenik.DTO.Admin)
		 */
		@Override
		public boolean saveAdmin(Admin admin) throws SQLException {

			// create an SELECT SQL query
			String query = "INSERT INTO admin(name, lastname, password) VALUES (?, ?, ? )";

			try (
					// java.sql.Statement
					PreparedStatement statement = connection.prepareStatement(query);) {

				// fill in the placeholders/parameters
				statement.setString(1, admin.getName());
				statement.setString(2, admin.getLastname());
				
	            statement.setString(3, admin.getPassword());
				
				// execute the query
				if (statement.executeUpdate() == 1) {
					return true;
				} else {
					return false;
				}

			}

		}

	}

	
	

