package com.main;
/*
 * 
 */
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Scanner;

	import com.imenik.BO.AdminBO;
	import com.imenik.DAO.ConnectionManager;
	import com.imenik.DAO.AdminDAOImplementation;
	import com.imenik.DTO.Admin;

	import com.ui.AdminUI;
    import com.ui.MenuAI;

/**
	 * The Class App1.
	 */
	public class AppAdmin  {

		/**
		 * The main method.
		 *
		 * @param args the arguments
		 */
		public static void main(String[] args) {

			// UI Layer - User Interface objects
			AdminUI adminUI = new AdminUI();
			MenuAI menu = new MenuAI();

			// Business Layer - Business object
			AdminBO  adminBO = new AdminBO();

			// Data Access Layer - Data Access Object
			AdminDAOImplementation DAO = new AdminDAOImplementation();

			// variables used throughout the application
			Scanner input = new Scanner(System.in);
			int userInput;
			Admin admin;
			ArrayList<Admin> admins;
			int adminId;
			
			
			// print the menu
			menu.printMenu();
			// get user input
			userInput = input.nextInt();

			// do the magicks!
			switch (userInput) {

			case 1:

				try {
					admins = DAO.getAdmins();
					adminUI.printAllAdminss(admins);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}

				break;

			case 2:

				// create a new admin
				admin = adminUI.createAdmin();

				// check if the created admin is "valid"
				if (!adminBO.isAdminNull(admin)) {
					System.out.println("Admin can't be null");
				} else if (!adminBO.isAdminNameValid(admin)) {
					System.out.println("Admin's name can't be less than 3 characters");
				} else if (!adminBO.isAdminLastNameValid(admin)) {
					System.out.println("Admin's name can't be less than 3 characters");
				} else {

					try {

						if (DAO.saveAdmin(admin)) {
							System.out.println("\nAdmin sucessfully added to the database.");
						}

					} catch (SQLException e) {
					
						e.printStackTrace();
					}
				}

				break;

			case 3:

				System.out.print("Please enter the ID of the admin you'd like to update: ");
				adminId = input.nextInt();

				try {

					admin = DAO.getAdmin(adminId);
					Admin updatedAdmin = adminUI.editAdmin(admin);
					

					if (DAO.updateAdmin(updatedAdmin)) {
						System.out.println("\nAdmin sucessfully updated.");
					}

				} catch (SQLException e) {
					
					e.printStackTrace();
				}

				break;

			case 4:

				System.out.print("Please enter the ID of the admin you'd like to delete: ");
				adminId = input.nextInt();

				try {

					admin = DAO.getAdmin(adminId);

					System.out.println(admin);
					System.out.println("\nAre you sure you want to delete the following admin? (Y/N)");

					char confirmation = input.next().charAt(0);

					if (confirmation == 'Y' || confirmation == 'y') {

						if (DAO.deleteAdmin(admin)) {
							System.out.println("Admin deleted!");
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
