package addressbook.controller.exception;

import addressbook.model.Contact;

public class ContactAlreadyExistsException extends Exception{
	private static final long serialVersionUID = 1L;
	private Contact contact;

	public ContactAlreadyExistsException() {
		super("Contact already exists.");
	}

	public ContactAlreadyExistsException(Contact c) {
		super("Contact with ID=" + c.getId() + " [" + c.getName() + "] already exists.");
		contact = c;
	}

	public Contact getContact() {
		return contact;
	}
	
}
