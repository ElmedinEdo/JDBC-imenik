package com.imenik.BO;

import com.imenik.DTO.Admin;

/**
 * The Class AdminBO.
 */
//business layer object
public class AdminBO {
	
	
      	/**
		 * Checks if is admin null.
		 *
		 * @param admin the admin
		 * @return true, if is admin null
		 */
		public boolean isAdminNull(Admin admin) {
			if (admin == null) {
				return false;
			} else {
				return true;
			}
		}

		/**
		 * Checks if is admin name valid.
		 *
		 * @param admin the admin
		 * @return true, if is admin name valid
		 */
		public boolean isAdminNameValid(Admin admin) {

			if (admin.getName().length() < 3) {
				return false;
			} else {
				return true;
			}

		}

		/**
		 * Checks if is admin last name valid.
		 *
		 * @param admin the admin
		 * @return true, if is admin last name valid
		 */
		public boolean isAdminLastNameValid(Admin admin) {
			if (admin.getLastname().length() < 3) {
				return false;
			} else {
				return true;
			}
		}

	}


