package addressbook.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import addressbook.exceptions.EntityExistsException;
import addressbook.exceptions.NonexistingEntityException;
import addressbook.model.Address;
import addressbook.model.Contact;

public class AddressBook {
	private String title;
	private List<Contact> contacts;

	public AddressBook() {
		this.title = "";
		contacts = new ArrayList<>();
	}

	public AddressBook(String title) {
		this.title = title;
		contacts = new ArrayList<>();
	}
	
	public AddressBook(String title, List<Contact> contacts) {
		this.title = title;
		this.contacts = contacts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	// Business methods
	public void addContact(Contact contact) throws EntityExistsException {
//		contacts.add(contact);
		int result = Collections.binarySearch(contacts, contact);
		if(result >= 0) {
			throw new EntityExistsException("Contact for " + contact.getfName() + " " 
					+ contact.getlName() + " already exists.");
		} else {
			int insertionPoint = -result - 1;
			contacts.add(insertionPoint, contact);
		}
	}
	
	// Use set method of List
	public void updateContact(Contact contact) throws NonexistingEntityException {
		int found = Collections.binarySearch(contacts, contact);
		if(found < 0) {
			throw new NonexistingEntityException("Contact for " + contact.getfName() + " " 
					+ contact.getlName() + " already exists.");
		}
		contacts.set(found, contact);
	}
	
	public void removeContact(Contact contact) {
		contacts.remove(contact);
	}
	
	public Contact findByFirstAndLastName(String fName, String lName) {
		int found = Collections.binarySearch(contacts, new Contact(fName, lName));
		return found >= 0 ? contacts.get(found) : null;
	}
	
	public List<Contact> findByFirstOrLastOrOrganization(String fName, String lName, String organization) {
		List<Contact> results = new ArrayList<>();
		for(Contact c: contacts) {
			if((fName != null && c.getfName().toLowerCase().indexOf(fName.toLowerCase()) >= 0 )|| 
				(lName != null && c.getlName().toLowerCase().indexOf(lName.toLowerCase()) >= 0) ||
				(organization != null && c.getOrganization().toLowerCase().indexOf(organization.toLowerCase()) >= 0)) {
				results.add(c);
			}
		}
		return results;
	}
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressBook other = (AddressBook) obj;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();  
		builder.append("AddressBook [title=")
			.append(title).append(", contacts=")
			.append(contacts)
			.append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		Contact[] sample = {
				new Contact("Ivan", "Petrov", "ivan@abv.bg", "0898123456"),
				new Contact("John", "Smith", "john@gogle.com", "04123456789"),
				new Contact("Hristo", "Petrov", "hristo@abv.bg", "0898123434"),
				new Contact("Maria", "Petrova", "maria@abv.bg", "0898123411"),
				new Contact("John", "Smith", "john@gogle.com", "04123456789"), //Error existing
				new Contact("Maria", "Dimitrova", "mariad@abv.bg", "0898123422"),
		};
		
		AddressBook book = new AddressBook();
		
		// Add sample contacts
		for(Contact c : sample) {
			try {
				book.addContact(c);
			} catch (EntityExistsException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		}
		
		// Print contacts
		for(Contact c : book.getContacts()) {
			System.out.println(c);
		}
		System.out.println();
		
		// Update  contact
		Contact hristoUpdate = new Contact("Hristo", "Petrov", "hristo@gmail.com", "08999999999");
		hristoUpdate.setAddress(new Address("Bulgaria", "Sofia", "Graf Ignatiev, 55"));
		try {
			book.updateContact(hristoUpdate);
		} catch (NonexistingEntityException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
//		Contact toBeDeleted = new Contact("Ivan", "Petrov", null, null);
//		book.removeContact(toBeDeleted);
		
		List<Contact> results = book.findByFirstOrLastOrOrganization(null, "Pet", null);
		
		// Print contacts
		for(Contact c : results) {
			System.out.println(c);
		}
		
		System.out.println("\nFound: " + book.findByFirstAndLastName("Hristo", "Petrov"));
		
	}

}
