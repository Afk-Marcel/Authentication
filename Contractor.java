package poised;

/**
 * The Contractor class represents a contractor in the Poise Project Management System. It contains
 * details such as the contractor's ID, name, phone number, email address, and physical address.
 */
public class Contractor {
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String physicalAddress;

	/**
	 * Constructs a new Contractor object with the provided details.
	 *
	 * @param id              The unique ID of the contractor.
	 * @param name            The name of the contractor.
	 * @param phoneNumber     The phone number of the contractor.
	 * @param email           The email address of the contractor.
	 * @param physicalAddress The physical address of the contractor.
	 */
	public Contractor(int id, String name, String phoneNumber, String email, String physicalAddress) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.physicalAddress = physicalAddress;
	}

	/**
	 * Gets the contractor's ID.
	 *
	 * @return The contractor's ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the contractor's ID.
	 *
	 * @param id The contractor's ID.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the contractor's name.
	 *
	 * @return The contractor's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the contractor's name.
	 *
	 * @param name The contractor's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the contractor's phone number.
	 *
	 * @return The contractor's phone number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the contractor's phone number.
	 *
	 * @param phoneNumber The contractor's phone number.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the contractor's email address.
	 *
	 * @return The contractor's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the contractor's email address.
	 *
	 * @param email The contractor's email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the contractor's physical address.
	 *
	 * @return The contractor's physical address.
	 */
	public String getPhysicalAddress() {
		return physicalAddress;
	}

	/**
	 * Sets the contractor's physical address.
	 *
	 * @param physicalAddress The contractor's physical address.
	 */
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
}