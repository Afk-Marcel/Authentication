package poised;

/**
 * The Customer class represents a customer in the Poise Project Management System. It contains
 * details such as the customer's ID, name, phone number, email address, and physical address.
 */
public class Customer {
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String physicalAddress;

	/**
	 * Constructs a new Customer object with the provided details.
	 *
	 * @param id              The unique ID of the customer.
	 * @param name            The name of the customer.
	 * @param phoneNumber     The phone number of the customer.
	 * @param email           The email address of the customer.
	 * @param physicalAddress The physical address of the customer.
	 */
	public Customer(int id, String name, String phoneNumber, String email, String physicalAddress) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.physicalAddress = physicalAddress;
	}

	/**
	 * Gets the customer's ID.
	 *
	 * @return The customer's ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the customer's ID.
	 *
	 * @param id The customer's ID.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the customer's name.
	 *
	 * @return The customer's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the customer's name.
	 *
	 * @param name The customer's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the customer's phone number.
	 *
	 * @return The customer's phone number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the customer's phone number.
	 *
	 * @param phoneNumber The customer's phone number.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the customer's email address.
	 *
	 * @return The customer's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the customer's email address.
	 *
	 * @param email The customer's email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the customer's physical address.
	 *
	 * @return The customer's physical address.
	 */
	public String getPhysicalAddress() {
		return physicalAddress;
	}

	/**
	 * Sets the customer's physical address.
	 *
	 * @param physicalAddress The customer's physical address.
	 */
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
}