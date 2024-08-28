package poised;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The {@code ProjectManager} class manages project-related database operations in the Poise Project
 * Management System. It provides methods to add, update, delete, finalise, and retrieve projects,
 * as well as manage associated data such as architects, contractors, and customers.
 */
public class ProjectManager {

	/**
	 * Adds a new project to the database.
	 *
	 * @param project The {@link Project} object containing the details of the project to be added.
	 */
	public void addProject(Project project) {
		// SQL query for inserting a new project
		String sql = "INSERT INTO Projects (project_number, project_name, building_type, address, erf_number, total_fee, amount_paid, deadline, architect_id, contractor_id, customer_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set parameters for the PreparedStatement
			stmt.setInt(1, project.getProjectNumber());
			stmt.setString(2, project.getProjectName());
			stmt.setString(3, project.getBuildingType());
			stmt.setString(4, project.getAddress());
			stmt.setString(5, project.getErfNumber());
			stmt.setDouble(6, project.getTotalFee());
			stmt.setDouble(7, project.getAmountPaid());
			stmt.setDate(8, new java.sql.Date(project.getDeadline().getTime()));
			stmt.setInt(9, project.getArchitect().getId());
			stmt.setInt(10, project.getContractor().getId());
			stmt.setInt(11, project.getCustomer().getId());

			// Execute the update and print a success message
			stmt.executeUpdate();
			System.out.println("Project added successfully!");

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
	}

	/**
	 * Updates an existing project in the database.
	 *
	 * @param project The {@link Project} object containing the updated details of the project.
	 */
	public void updateProject(Project project) {
		// SQL query for updating an existing project
		String sql = "UPDATE Projects SET project_name = ?, building_type = ?, address = ?, erf_number = ?, total_fee = ?, amount_paid = ?, deadline = ?, completion_date = ?, architect_id = ?, contractor_id = ?, customer_id = ? WHERE project_number = ?";

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set parameters for the PreparedStatement
			stmt.setString(1, project.getProjectName());
			stmt.setString(2, project.getBuildingType());
			stmt.setString(3, project.getAddress());
			stmt.setString(4, project.getErfNumber());
			stmt.setDouble(5, project.getTotalFee());
			stmt.setDouble(6, project.getAmountPaid());
			stmt.setDate(7, new java.sql.Date(project.getDeadline().getTime()));
			stmt.setDate(8,
					project.getCompletionDate() != null
							? new java.sql.Date(project.getCompletionDate().getTime())
							: null);
			stmt.setInt(9, project.getArchitect().getId());
			stmt.setInt(10, project.getContractor().getId());
			stmt.setInt(11, project.getCustomer().getId());
			stmt.setInt(12, project.getProjectNumber());

			// Execute the update and print a message based on the result
			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Project updated successfully!");
			} else {
				System.out.println("Project not found!");
			}

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
	}

	/**
	 * Deletes a project from the database.
	 *
	 * @param projectNumber The project number of the project to be deleted.
	 */
	public void deleteProject(int projectNumber) {
		// SQL query for deleting a project
		String sql = "DELETE FROM Projects WHERE project_number = ?";

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set parameters for the PreparedStatement
			stmt.setInt(1, projectNumber);

			// Execute the update and print a message based on the result
			int rowsDeleted = stmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Project deleted successfully!");
			} else {
				System.out.println("Project not found!");
			}

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
	}

	/**
	 * Finalises a project by setting its completion date in the database.
	 *
	 * @param projectNumber  The project number of the project to be finalised.
	 * @param completionDate The completion date to be set for the project.
	 */
	public void finalizeProject(int projectNumber, java.util.Date completionDate) {
		// SQL query for updating the completion date of a project
		String sql = "UPDATE Projects SET completion_date = ? WHERE project_number = ?";

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set parameters for the PreparedStatement
			stmt.setDate(1, new java.sql.Date(completionDate.getTime()));
			stmt.setInt(2, projectNumber);

			// Execute the update and print a message based on the result
			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Project finalized successfully!");
			} else {
				System.out.println("Project not found!");
			}

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
	}

	/**
	 * Lists all incomplete projects by querying the database for projects that have no completion
	 * date.
	 */
	public void listIncompleteProjects() {
		// SQL query for selecting incomplete projects
		String sql = "SELECT * FROM Projects WHERE completion_date IS NULL";

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			// Iterate through the result set and print details of each project
			while (rs.next()) {
				int projectNumber = rs.getInt("project_number");
				String projectName = rs.getString("project_name");
				String buildingType = rs.getString("building_type");
				String address = rs.getString("address");
				java.sql.Date deadline = rs.getDate("deadline");

				System.out.printf("Project Number: %d, Name: %s, Type: %s, Address: %s, Deadline: %s%n",
						projectNumber, projectName, buildingType, address, deadline);
			}

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
	}

	/**
	 * Lists all overdue projects by querying the database for projects that have passed their
	 * deadline without being completed.
	 */
	public void listOverdueProjects() {
		// SQL query for selecting overdue projects
		String sql = "SELECT * FROM Projects WHERE deadline < CURDATE() AND completion_date IS NULL";

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			// Iterate through the result set and print details of each overdue project
			while (rs.next()) {
				int projectNumber = rs.getInt("project_number");
				String projectName = rs.getString("project_name");
				String buildingType = rs.getString("building_type");
				String address = rs.getString("address");
				java.sql.Date deadline = rs.getDate("deadline");

				System.out.printf(
						"Overdue Project Number: %d, Name: %s, Type: %s, Address: %s, Deadline: %s%n",
						projectNumber, projectName, buildingType, address, deadline);
			}

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
	}

	/**
	 * Finds an architect by their ID.
	 *
	 * @param architectId The ID of the architect to be found.
	 * @return The {@link Architect} object if found, or {@code null} if not found.
	 */
	public Architect findArchitectById(int architectId) {
		// SQL query for selecting an architect by ID
		String sql = "SELECT * FROM Architects WHERE architect_id = ?";
		Architect architect = null;

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set parameters for the PreparedStatement
			stmt.setInt(1, architectId);
			ResultSet rs = stmt.executeQuery();

			// If an architect is found, create an Architect object
			if (rs.next()) {
				architect = new Architect(rs.getInt("architect_id"), rs.getString("name"),
						rs.getString("phone_number"), rs.getString("email"), rs.getString("physical_address"));
			}

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
		return architect;
	}

	/**
	 * Finds a contractor by their ID.
	 *
	 * @param contractorId The ID of the contractor to be found.
	 * @return The {@link Contractor} object if found, or {@code null} if not found.
	 */
	public Contractor findContractorById(int contractorId) {
		// SQL query for selecting a contractor by ID
		String sql = "SELECT * FROM Contractors WHERE contractor_id = ?";
		Contractor contractor = null;

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set parameters for the PreparedStatement
			stmt.setInt(1, contractorId);
			ResultSet rs = stmt.executeQuery();

			// If a contractor is found, create a Contractor object
			if (rs.next()) {
				contractor = new Contractor(rs.getInt("contractor_id"), rs.getString("name"),
						rs.getString("phone_number"), rs.getString("email"), rs.getString("physical_address"));
			}

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
		return contractor;
	}

	/**
	 * Finds a customer by their ID.
	 *
	 * @param customerId The ID of the customer to be found.
	 * @return The {@link Customer} object if found, or {@code null} if not found.
	 */
	public Customer findCustomerById(int customerId) {
		// SQL query for selecting a customer by ID
		String sql = "SELECT * FROM Customers WHERE customer_id = ?";
		Customer customer = null;

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set parameters for the PreparedStatement
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();

			// If a customer is found, create a Customer object
			if (rs.next()) {
				customer = new Customer(rs.getInt("customer_id"), rs.getString("name"),
						rs.getString("phone_number"), rs.getString("email"), rs.getString("physical_address"));
			}

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
		return customer;
	}

	/**
	 * Finds a project by its name.
	 *
	 * @param projectName The name of the project to be found.
	 * @return The {@link Project} object if found, or {@code null} if not found.
	 */
	public Project findProjectByName(String projectName) {
		// SQL query for selecting a project by its name
		String sql = "SELECT * FROM Projects WHERE project_name = ?";

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set parameters for the PreparedStatement
			stmt.setString(1, projectName);
			ResultSet rs = stmt.executeQuery();

			// If a project is found, create a Project object
			if (rs.next()) {
				return new Project(rs.getInt("project_id"), rs.getInt("project_number"),
						rs.getString("project_name"), rs.getString("building_type"), rs.getString("address"),
						rs.getString("erf_number"), rs.getDouble("total_fee"), rs.getDouble("amount_paid"),
						rs.getDate("deadline"), rs.getDate("completion_date"),
						findArchitectById(rs.getInt("architect_id")),
						findContractorById(rs.getInt("contractor_id")),
						findCustomerById(rs.getInt("customer_id")));
			}

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Finds a project by its number.
	 *
	 * @param projectNumber The number of the project to be found.
	 * @return The {@link Project} object if found, or {@code null} if not found.
	 */
	public Project findProjectByNumber(int projectNumber) {
		// SQL query for selecting a project by its number
		String sql = "SELECT * FROM Projects WHERE project_number = ?";

		// Try-with-resources to ensure resources are closed automatically
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Set parameters for the PreparedStatement
			stmt.setInt(1, projectNumber);
			ResultSet rs = stmt.executeQuery();

			// If a project is found, create a Project object
			if (rs.next()) {
				return new Project(rs.getInt("project_id"), rs.getInt("project_number"),
						rs.getString("project_name"), rs.getString("building_type"), rs.getString("address"),
						rs.getString("erf_number"), rs.getDouble("total_fee"), rs.getDouble("amount_paid"),
						rs.getDate("deadline"), rs.getDate("completion_date"),
						findArchitectById(rs.getInt("architect_id")),
						findContractorById(rs.getInt("contractor_id")),
						findCustomerById(rs.getInt("customer_id")));
			}

		} catch (SQLException e) {
			// Print stack trace for debugging
			e.printStackTrace();
		}
		return null;
	}

}