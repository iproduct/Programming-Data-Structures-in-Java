package addressbook.controller;

import java.util.Arrays;

import addressbook.model.Contact;
import addressbook.model.ContactAddressComparator;

public class AddressBookOld {
	public static final int MAX_CONTACTS = 1000;
	private Contact[] contacts = new Contact[MAX_CONTACTS];
	private int numberContacts = 0;
	
	public AddressBookOld() {
		addContact(new Contact("Ivan Petrov", "Sofia 1000", "02 8943567", "ivan@abv.bg"));
		addContact(new Contact("Dimitar Nikolov", "Sofia, Buzludza 15A, bl.22, flat 12", "02 53454354", "divanov@gmail.com"));
		addContact(new Contact("Veselin Nikolov", "Sofia 1980", "02 8943567", "ivan@abv.bg"));
		addContact(new Contact("Stoyan Petrov", "Sofia, bul. James Bouchier 29", "02 5678899", "spetrov@abv.bg"));
		addContact(new Contact("Dimitrinka Ivanova", "Sofia, Levski 5, bl. 34, fl. 19", "02 8943567", "dimi1985n@abv.bg"));
	}
	
	public void addContact(Contact c){
		c.setId(getMaxId() + 1);
		contacts[numberContacts++] = c;
	}
	
	public void sortByName(){
		Arrays.sort(contacts, 0, numberContacts);
	}
	
	public void sortByAddress(){
		Arrays.sort(contacts, 0, numberContacts, new ContactAddressComparator());
	}
	
	public String formatAllContacts(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < numberContacts; i++) {
			sb.append(
				String.format("| %-20.20s | %-20.20s| %-12.12s| %-24.24s |",
						contacts[i].getName(),
						contacts[i].getAddress(),
						contacts[i].getPhone(),
						contacts[i].getEmail()
				)
			).append("\n");
		}
		return sb.toString();
	}
	
	protected long getMaxId() {
		long maxId = 0;
		for(int i = 0;  i < numberContacts; i++){
			if(contacts[i].getId() > maxId)
				maxId = contacts[i].getId();
		}
		return maxId;
	}
	

	public static void main(String[] args) {
		AddressBookOld myBook = new AddressBookOld();
		myBook.sortByAddress();
		System.out.println(myBook.formatAllContacts());

	}


}
