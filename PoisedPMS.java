package poised;

import java.util.Scanner;

/**
 * The PoisedPMS class is the main entry point for the Poise Project Management System. It provides
 * an interactive console interface for managing projects, including adding, updating, finalising,
 * and finding projects.
 */
public class PoisedPMS {

	/**
	 * The main method that runs the Poise Project Management System. It provides a console menu for
	 * users to perform various operations on projects.
	 *
	 * @param args Command-line arguments (not used in this application).
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProjectManager projectManager = new ProjectManager();

		// Infinite loop to keep the program running and interact with the user
		while (true) {
			// Display menu options to the user
			System.out.println("1. Add Project");
			System.out.println("2. Update Project");
			System.out.println("3. Finalize Project");
			System.out.println("4. Find Project");
			System.out.println("5. See a list of projects that still need to be completed");
			System.out.println("6. See a list of projects that are past the due date");
			System.out.println("7. Exit");

			// Read the user's choice
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			// Perform actions based on the user's choice
			switch (choice) {
			case 1:
				/**
				 * Adds a new project to the system. The user is prompted to enter the project's details,
				 * including the project number, name, building type, address, ERF number, total fee, amount
				 * paid, deadline, and the IDs of the associated architect, contractor, and customer.
				 */
				System.out.println("Enter project details:");
				System.out.print("Project Number: ");
				int projectNumber = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				System.out.print("Project Name: ");
				String projectName = scanner.nextLine();

				System.out.print("Building Type: ");
				String buildingType = scanner.nextLine();

				System.out.print("Address: ");
				String address = scanner.nextLine();

				System.out.print("ERF Number: ");
				String erfNumber = scanner.nextLine();

				System.out.print("Total Fee: ");
				double totalFee = scanner.nextDouble();

				System.out.print("Amount Paid: ");
				double amountPaid = scanner.nextDouble();

				System.out.print("Deadline (YYYY-MM-DD): ");
				String deadline = scanner.next();

				// Fetch associated Architect, Contractor, and Customer by their IDs
				System.out.print("Architect ID: ");
				int architectId = scanner.nextInt();
				Architect architect = projectManager.findArchitectById(architectId);

				System.out.print("Contractor ID: ");
				int contractorId = scanner.nextInt();
				Contractor contractor = projectManager.findContractorById(contractorId);

				System.out.print("Customer ID: ");
				int customerId = scanner.nextInt();
				Customer customer = projectManager.findCustomerById(customerId);

				// Create a new Project object and add it to the database
				Project newProject = new Project(0, projectNumber, projectName, buildingType, address,
						erfNumber, totalFee, amountPaid, java.sql.Date.valueOf(deadline), null, architect,
						contractor, customer);
				projectManager.addProject(newProject);
				System.out.println("Project added successfully.");
				break;

			case 2:
				/**
				 * Updates an existing project's details. The user is prompted to enter the project ID to
				 * update, and then can optionally update the project's name, total fee, amount paid, and
				 * deadline.
				 */
				System.out.print("Enter the Project ID to update: ");
				int projectIdToUpdate = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				// Fetch the existing project by its ID
				Project projectToUpdate = projectManager.findProjectByNumber(projectIdToUpdate);
				if (projectToUpdate != null) {
					// Update project details if provided
					System.out.print("New Project Name (leave empty to keep current): ");
					String newName = scanner.nextLine();
					if (!newName.isEmpty()) {
						projectToUpdate.setProjectName(newName);
					}

					System.out.print("New Total Fee (leave empty to keep current): ");
					String newFee = scanner.nextLine();
					if (!newFee.isEmpty()) {
						projectToUpdate.setTotalFee(Double.parseDouble(newFee));
					}

					System.out.print("New Amount Paid (leave empty to keep current): ");
					String newPaid = scanner.nextLine();
					if (!newPaid.isEmpty()) {
						projectToUpdate.setAmountPaid(Double.parseDouble(newPaid));
					}

					System.out.print("New Deadline (leave empty to keep current, format YYYY-MM-DD): ");
					String newDeadline = scanner.nextLine();
					if (!newDeadline.isEmpty()) {
						projectToUpdate.setDeadline(java.sql.Date.valueOf(newDeadline));
					}

					// Update the project in the database
					projectManager.updateProject(projectToUpdate);
					System.out.println("Project updated successfully.");
				} else {
					System.out.println("Project not found.");
				}
				break;

			case 3:
				/**
				 * Finalises a project by setting its completion date to the current date. The user is
				 * prompted to enter the project number to finalise.
				 */
				System.out.print("Enter the Project Number to finalize: ");
				int projectNumberToFinalize = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				// Fetch the project to finalise
				Project projectToFinalize = projectManager.findProjectByNumber(projectNumberToFinalize);
				if (projectToFinalize != null) {
					// Set the completion date to the current date and finalise the project
					projectToFinalize.setCompletionDate(new java.sql.Date(System.currentTimeMillis()));
					projectManager.finalizeProject(projectToFinalize.getProjectId(),
							new java.sql.Date(System.currentTimeMillis()));
					System.out.println("Project finalized successfully.");
				} else {
					System.out.println("Project not found.");
				}
				break;

			case 4:
				/**
				 * Finds and displays a project's details by its project number. The user is prompted to
				 * enter the project number to search for.
				 */
				System.out.print("Enter the Project Number to find: ");
				int projectNumberToFind = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				// Fetch and display the project by its number
				Project project = projectManager.findProjectByNumber(projectNumberToFind);
				if (project != null) {
					System.out.println("Project found:");
					System.out.println(project);
				} else {
					System.out.println("Project not found.");
				}
				break;

			case 5:
				/**
				 * Displays a list of projects that are not yet finalised.
				 */
				projectManager.listIncompleteProjects();
				break;

			case 6:
				/**
				 * Displays a list of projects that are past their due date.
				 */
				projectManager.listOverdueProjects();
				break;

			case 7:
				/**
				 * Exits the application.
				 */
				System.out.println("Exiting...");
				System.exit(0);

			default:
				/**
				 * Handles invalid menu choices.
				 */
				System.out.println("Invalid choice, try again.");
			}
		}
	}
}