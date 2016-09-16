package addressbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import addressbook.controller.exception.ContactDoesNotExistException;
import addressbook.model.Contact;
import addressbook.model.ContactAddressComparator;
import addressbook.model.ContactNameComparator;

public class AddressBook {
	private List<Contact> contacts = new ArrayList<>();
	
	public AddressBook() {
		addContact(new Contact("Ivan Petrov", "Sofia 1000", "02 8943567", "ivan@abv.bg"));
		addContact(new Contact("Dimitar Nikolov", "Sofia, Buzludza 15A, bl.22, flat 12", "02 53454354", "divanov@gmail.com"));
		addContact(new Contact("Veselin Nikolov", "Sofia 1980", "02 8943567", "ivan@abv.bg"));
		addContact(new Contact("Stoyan Petrov", "Sofia, bul. James Bouchier 29", "02 5678899", "spetrov@abv.bg"));
		addContact(new Contact("Dimitrinka Ivanova", "Sofia, Levski 5, bl. 34, fl. 19", "02 8943567", "dimi1985n@abv.bg"));
	}
	
	public void addContact(Contact c) {
		c.setId(getMaxId() + 1);
		contacts.add(c);
	}
	
	public void editContact(Contact c) throws ContactDoesNotExistException {
		int indexFound = Collections.binarySearch(contacts, c);
		if( indexFound < 0)
			throw new ContactDoesNotExistException(c);
		contacts.set(indexFound, c);
	}	
	
	public List<Contact> sortByName(){
		List<Contact> result = new ArrayList<>(contacts);
		Collections.sort(result, new ContactNameComparator());
		return result;
	}
	
	public List<Contact> sortByAddress(){
		List<Contact> result = new ArrayList<>(contacts);
		Collections.sort(result, new ContactAddressComparator());
		return result;
	}
	
	public List<Contact> findContactsByName(String namePart){
		List<Contact> results = new ArrayList<>();	
		for(Contact c: contacts)
			if(c.getName().contains(namePart)){
				results.add(c);
			}
		return results;
	}
	
	public static String formatAllContacts(List<Contact> contactsToSort){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < contactsToSort.size(); i++ ) {
			sb.append(
				String.format("| %d | %-20.20s | %-20.20s| %-12.12s| %-24.24s |",
						contactsToSort.get(i).getId(),
						contactsToSort.get(i).getName(),
						contactsToSort.get(i).getAddress(),
						contactsToSort.get(i).getPhone(),
						contactsToSort.get(i).getEmail()
				)
			).append("\n");
		}
		return sb.toString();
	}
	
	protected long getMaxId() {
//		long maxId = 0;
//		for(Contact c : contacts){
//			if(c.getId() > maxId)
//				maxId = c.getId();
//		}
//		return maxId;
		if(contacts.isEmpty()) {
			return 0L;
		} else {
			return Collections.max(contacts).getId();
		}
	
	}
	
	public List<Contact> getAllContacts() {
		return contacts;
	}

	public static void main(String[] args) {
		AddressBook myBook = new AddressBook();
		List<Contact> ivansList = myBook.findContactsByName("Ivan");
		if(!ivansList.isEmpty()){
			Contact ivan = ivansList.get(0);
			ivan.setAddress("Plovidiv, ul. Marica 19");
//			Contact ivan = new Contact("Ivan Petrov", "Plovdiv 1000", "02 8943567", "ivan@abv.bg");
			try {
				myBook.editContact(ivan);
			} catch (ContactDoesNotExistException e) {
				System.out.println(e.getMessage());
			}
		}
			
		System.out.println(
				formatAllContacts(
						myBook.getAllContacts()));

	}


}
