package poised;

/**
 * The Architect class represents an architect in the Poise Project Management System. It contains
 * details such as the architect's ID, name, phone number, email address, and physical address.
 */
public class Architect {
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String physicalAddress;

	/**
	 * Constructs a new Architect object with the provided details.
	 *
	 * @param id              The unique ID of the architect.
	 * @param name            The name of the architect.
	 * @param phoneNumber     The phone number of the architect.
	 * @param email           The email address of the architect.
	 * @param physicalAddress The physical address of the architect.
	 */
	public Architect(int id, String name, String phoneNumber, String email, String physicalAddress) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.physicalAddress = physicalAddress;
	}

	/**
	 * Gets the architect's ID.
	 *
	 * @return The architect's ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the architect's ID.
	 *
	 * @param id The architect's ID.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the architect's name.
	 *
	 * @return The architect's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the architect's name.
	 *
	 * @param name The architect's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the architect's phone number.
	 *
	 * @return The architect's phone number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the architect's phone number.
	 *
	 * @param phoneNumber The architect's phone number.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the architect's email address.
	 *
	 * @return The architect's email address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the architect's email address.
	 *
	 * @param email The architect's email address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the architect's physical address.
	 *
	 * @return The architect's physical address.
	 */
	public String getPhysicalAddress() {
		return physicalAddress;
	}

	/**
	 * Sets the architect's physical address.
	 *
	 * @param physicalAddress The architect's physical address.
	 */
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
}