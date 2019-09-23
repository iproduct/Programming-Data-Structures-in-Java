package control;

import java.util.ArrayList;
import java.util.List;

import model.Contact;
import model.Phone;

import static model.PhoneKind.*;

public class AddressBook {
	private List<Contact> contacts = new ArrayList<>();
	private String title;
	
	public AddressBook() {
	}

	public AddressBook(String title) {
		this.title = title;
	}

	public AddressBook(String title, List<Contact> contacts) {
		this.contacts = contacts;
		this.title = title;
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

	public Contact addContact(Contact contact) {
		contacts.add(contact);
		return contact;
	}
	
	public Contact updateContact(Contact contact) {
		int index = contacts.indexOf(contact);
		contacts.set(index, contact);
		return contact;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address Book: ");
		builder.append(title);
		builder.append("\n----------------------------------------------------------\n");
		for(Contact c: contacts) {
			builder.append(c.toString());
			builder.append("\n----------------------------------------------------------\n");
		}
		
		return builder.toString();
	}

	public static void main(String[] args) {
		Contact c1 = new Contact("John", "Smith", "john@gmail.com", "+44 32242342");
		Contact c2 = new Contact("Ivan", "Petrov", "ivanp@gmail.com", "+3592 345345");
		List<Phone> phones = new ArrayList<>();
		phones.add(Phone.parsePhone("+359 889 123456"));
		phones.add(Phone.parsePhone("+3592 2345678", WORK));
		phones.add(Phone.parsePhone("+3592 768677", HOME));
		Contact c3 = new Contact("Ludmila", "Petrova", "lucyp@gmail.com", phones, "FMI", 
				"Bulgaria, Sofia, J. Bouchier 25", "Work colleague", null);
		AddressBook book = new AddressBook("My Contacts");
		book.addContact(c1);
		book.addContact(c2);
		book.addContact(c3);
		System.out.println(book);
	}

}
