package com.ui;

/*
 * 
 */
	import java.util.ArrayList;
	import java.util.Scanner;

	import com.imenik.DTO.Admin;

	// TODO: Auto-generated Javadoc
/**
	 * The Class AdminUI.
	 */
	public class AdminUI {

		/** The input. */
		Scanner input = new Scanner(System.in);

		/**
		 * Creates the admin.
		 *
		 * @return the admin
		 */
		public Admin createAdmin() {

			System.out.print("Enter the admin's name: ");
			String name = input.next();

			System.out.print("Enter the admin's lastname: ");
			String lastname = input.next();

			System.out.print("Enter the admins's password: ");
			String password = input.next();

				
			Admin admin = new Admin(name, lastname, password);
			return admin;

		}

		/**
		 * Edits the admin.
		 *
		 * @param admin the admin
		 * @return the admin
		 */
		public Admin editAdmin(Admin admin) {

			System.out.print("Set a new name for admin (current: " + admin.getName() + " ): ");
			String name = input.next();
			admin.setName(name);

			System.out.print("Set a new lastname for admin (current: " + admin.getLastname() + " ): ");
			String lastname = input.next();
			admin.setLastname(lastname);


			System.out.print("Set a new password for admin (current: " + admin.getPassword() + " ): ");
			String password = input.next();
			admin.setPassword(password);
		
			return admin;
		}

		/**
		 * Prints the all adminss.
		 *
		 * @param admins the admins
		 */
		public void printAllAdminss(ArrayList<Admin> admins) {
			for (Admin admin : admins) {
				System.out.println(admin);
			}
		}
	}


