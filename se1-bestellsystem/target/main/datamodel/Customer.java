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
		if (this.firstName != null) {
			return firstName;
		} else {
			return "";
		}
	}

	public void setFirstName(String firstName) {
		if (firstName != null) {
			this.firstName = firstName;
		} else {
			this.firstName = "";
		}
	}

	public String getLastName() {
		if (this.lastName != null) {
			return lastName;
		} else {
			if (this.name != null) {
				return this.name;
			}
			return "";
		}
	}

	public void setLastName(String lastName) {
		if (lastName != null) {
			this.lastName = lastName;
		} else {
			this.lastName = "";
		}
	}

	public String getContact() {
		if (contact != null) {
			return contact;
		} else {
			return "";

		}
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
