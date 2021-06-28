package datamodel;

public class Customer {
	public String id;
	public String firstName;
	public String lastName;
	public String name;
	public String contact;

	protected Customer(String id, String name, String contact) {
		this.id = id;
		this.name = name;
		this.contact = contact;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
