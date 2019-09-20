package control;

import java.util.ArrayList;
import java.util.List;

import model.Contact;

public class AddressBook {
	private List<Contact> contacts = new ArrayList<>();
	private String title;
	
	public AddressBook() {
	}

	public AddressBook(String title) {
		this.title = title;
	}

	public AddressBook(List<Contact> contacts, String title) {
		this.contacts = contacts;
		this.title = title;
	}

	public Contact addContact(Contact contact) {
		contacts.add(contact);
		return contact;
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Contact updateContact(Contact contact) {
		int index = contacts.indexOf(contact);
		contacts.set(index, contact);
		return contact;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Title: ");
		builder.append(title);
		builder.append("Contacts: ");
		builder.append(contacts);
		return builder.toString();
	}

	public Contact deleteContact(Contact contact) {
		int index = contacts.indexOf(contact);
		return contacts.remove(index);
	}
	
	public List<Contact> findContactsByName(String firstName, String lastName) {
		return contacts;
	}
	
	public Contact findContactByEmail(String firstName, String lastName) {
		return contacts.get(0);
	}
	

	public static void main(String[] args) {
		Contact c = new Contact("John", "Smith", "john@gmail.com", "+44 32242342");
		System.out.println(c);
	}

}
