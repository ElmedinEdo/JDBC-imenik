package com.imenik.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class ConnectionManager.
 */
//Singleton - klasa koju mozemo instancirati jednom
public class ConnectionManager {

	/** The instance. */
	// instanca same klase
	private static ConnectionManager instance = null;

	/** The Constant USERNAME. */
	// vrijednosti koje smo izabrali prilikom instalacije MySQL Servera
	private static final String USERNAME = "root";
	
	/** The Constant PASSWORD. */
	private static final String PASSWORD = "elmedin.64";
	
	/** The Constant CONN_STRING. */
	// localhost//imeBazeNaKojuSeSpajamo
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/students";
	
	/** The connection. */
	// connection object
	private Connection connection = null;

	/**
	 * Instantiates a new connection manager.
	 */
	// privatni konstruktor - klasa moze biti instancirana samo unutar sebe
	private ConnectionManager() {

	}

	/**
	 * Gets the single instance of ConnectionManager.
	 *
	 * @return single instance of ConnectionManager
	 */
	// provjeriti da li je instanca null, instancirati i vratiti ili samo vratiti
	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	/**
	 * Open connection.
	 *
	 * @return true, if successful
	 */
	private boolean openConnection() {
		try {
			connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				return connection;
			} else {
				return null;
			}
		}
		return connection;
	}

	/**
	 * Close.
	 */
	public void close() {
		try {
			System.out.println("Connection closed");
			connection.close();
			connection = null;
		} catch (Exception e) {
		}
	}
}