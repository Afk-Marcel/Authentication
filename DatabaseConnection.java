package poised;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DatabaseConnection class is responsible for establishing and managing the connection to the
 * PoisePMS MySQL database. It provides a static method to retrieve a Connection object that can be
 * used to interact with the database.
 */
public class DatabaseConnection {
	// Database URL, including the database name
	private static final String URL = "jdbc:mysql://localhost:3306/PoisePMS";
	// Database user name
	private static final String USER = "otheruser";
	// Database password
	private static final String PASSWORD = "userother";

	/**
	 * Establishes and returns a connection to the PoisePMS database.
	 *
	 * @return A Connection object that represents a connection to the database.
	 * @throws SQLException If a database access error occurs.
	 */
	public static Connection getConnection() throws SQLException {
		// Create and return a connection to the database using the provided URL, user name, and
		// password
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}