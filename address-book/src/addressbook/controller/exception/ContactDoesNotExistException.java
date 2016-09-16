package addressbook.controller.exception;

import addressbook.model.Contact;

public class ContactDoesNotExistException extends Exception{
	private static final long serialVersionUID = 1L;
	private Contact contact;

	public ContactDoesNotExistException() {
		super("Contact does not exist.");
	}

	public ContactDoesNotExistException(Contact c) {
		super("Contact with ID=" + c.getId() + " [" + c.getName() + "] does not exist.");
		contact = c;
	}

	public Contact getContact() {
		return contact;
	}
	
}
