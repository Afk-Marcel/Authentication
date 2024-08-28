package poised;

import java.util.Date;

/**
 * The Project class represents a construction project in the Poise Project Management System. It
 * contains details such as project ID, project number, name, building type, address, ERF number,
 * total fee, amount paid, deadline, completion date, and associated participants like the
 * architect, contractor, and customer.
 */
public class Project {
	private int projectId;
	private int projectNumber;
	private String projectName;
	private String buildingType;
	private String address;
	private String erfNumber;
	private double totalFee;
	private double amountPaid;
	private Date deadline;
	private Date completionDate;
	private Architect architect;
	private Contractor contractor;
	private Customer customer;

	/**
	 * Constructs a new Project object with the provided details.
	 *
	 * @param projectId      The unique ID of the project.
	 * @param projectNumber  The number assigned to the project.
	 * @param projectName    The name of the project.
	 * @param buildingType   The type of building for the project.
	 * @param address        The physical address of the project.
	 * @param erfNumber      The ERF number associated with the project.
	 * @param totalFee       The total fee for the project.
	 * @param amountPaid     The amount that has been paid so far.
	 * @param deadline       The deadline for the project's completion.
	 * @param completionDate The date when the project was completed.
	 * @param architect      The architect associated with the project.
	 * @param contractor     The contractor responsible for the project.
	 * @param customer       The customer who owns the project.
	 */
	public Project(int projectId, int projectNumber, String projectName, String buildingType,
			String address, String erfNumber, double totalFee, double amountPaid, Date deadline,
			Date completionDate, Architect architect, Contractor contractor, Customer customer) {
		this.projectId = projectId;
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.address = address;
		this.erfNumber = erfNumber;
		this.totalFee = totalFee;
		this.amountPaid = amountPaid;
		this.deadline = deadline;
		this.completionDate = completionDate;
		this.architect = architect;
		this.contractor = contractor;
		this.customer = customer;
	}

	/**
	 * Gets the project ID.
	 *
	 * @return The project ID.
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * Sets the project ID.
	 *
	 * @param projectId The project ID.
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gets the project number.
	 *
	 * @return The project number.
	 */
	public int getProjectNumber() {
		return projectNumber;
	}

	/**
	 * Sets the project number.
	 *
	 * @param projectNumber The project number.
	 */
	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}

	/**
	 * Gets the project name.
	 *
	 * @return The project name.
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Sets the project name.
	 *
	 * @param projectName The project name.
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Gets the building type.
	 *
	 * @return The building type.
	 */
	public String getBuildingType() {
		return buildingType;
	}

	/**
	 * Sets the building type.
	 *
	 * @param buildingType The building type.
	 */
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	/**
	 * Gets the project address.
	 *
	 * @return The project address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the project address.
	 *
	 * @param address The project address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the ERF number.
	 *
	 * @return The ERF number.
	 */
	public String getErfNumber() {
		return erfNumber;
	}

	/**
	 * Sets the ERF number.
	 *
	 * @param erfNumber The ERF number.
	 */
	public void setErfNumber(String erfNumber) {
		this.erfNumber = erfNumber;
	}

	/**
	 * Gets the total fee for the project.
	 *
	 * @return The total fee.
	 */
	public double getTotalFee() {
		return totalFee;
	}

	/**
	 * Sets the total fee for the project.
	 *
	 * @param totalFee The total fee.
	 */
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * Gets the amount paid so far.
	 *
	 * @return The amount paid.
	 */
	public double getAmountPaid() {
		return amountPaid;
	}

	/**
	 * Sets the amount paid so far.
	 *
	 * @param amountPaid The amount paid.
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	/**
	 * Gets the deadline for the project.
	 *
	 * @return The deadline.
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * Sets the deadline for the project.
	 *
	 * @param deadline The deadline.
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	/**
	 * Gets the completion date for the project.
	 *
	 * @return The completion date.
	 */
	public Date getCompletionDate() {
		return completionDate;
	}

	/**
	 * Sets the completion date for the project.
	 *
	 * @param completionDate The completion date.
	 */
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	/**
	 * Gets the architect associated with the project.
	 *
	 * @return The architect.
	 */
	public Architect getArchitect() {
		return architect;
	}

	/**
	 * Sets the architect associated with the project.
	 *
	 * @param architect The architect.
	 */
	public void setArchitect(Architect architect) {
		this.architect = architect;
	}

	/**
	 * Gets the contractor responsible for the project.
	 *
	 * @return The contractor.
	 */
	public Contractor getContractor() {
		return contractor;
	}

	/**
	 * Sets the contractor responsible for the project.
	 *
	 * @param contractor The contractor.
	 */
	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	/**
	 * Gets the customer who owns the project.
	 *
	 * @return The customer.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer who owns the project.
	 *
	 * @param customer The customer.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}