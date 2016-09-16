package addressbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import addressbook.controller.exception.ContactAlreadyExistsException;
import addressbook.model.Contact;
import addressbook.model.ContactAddressComparator;

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
		if(Collections.binarySearch(contacts, c) >= 0)
			new ContactAlreadyExistsException(c);
		c.setId(getMaxId() + 1);
		contacts.add(c);
	}
	
	public void sortByName(){
		Collections.sort(contacts);
	}
	
	public void sortByAddress(){
		Collections.sort(contacts, new ContactAddressComparator());
	}
	
	public List<Contact> findContactsByName(String namePart){
		List<Contact> results = new ArrayList<>();	
		for(Contact c: contacts)
			if(c.getName().contains(namePart)){
				results.add(c);
			}
		return results;
	}
	
	public String formatAllContacts(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < contacts.size(); i++ ) {
			sb.append(
				String.format("| %-20.20s | %-20.20s| %-12.12s| %-24.24s |",
						contacts.get(i).getName(),
						contacts.get(i).getAddress(),
						contacts.get(i).getPhone(),
						contacts.get(i).getEmail()
				)
			).append("\n");
		}
		return sb.toString();
	}
	
	protected long getMaxId() {
		long maxId = 0;
		for(Contact c : contacts){
			if(c.getId() > maxId)
				maxId = c.getId();
		}
		return maxId;
	}
	

	public static void main(String[] args) {
		AddressBook myBook = new AddressBook();
		List<Contact> ivansList = myBook.findContactsByName("Ivan");
//		myBook.sortByName();
		System.out.println(ivansList);

	}


}
