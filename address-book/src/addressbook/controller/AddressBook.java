package addressbook.controller;

import addressbook.model.Contact;

public class AddressBook {
	public static final int MAX_CONTACTS = 1000;
	private Contact[] contacts = new Contact[MAX_CONTACTS];
	private int numberContacts = 0;
	
	public AddressBook() {
		
	}
	
	public void addContact(Contact c){
		c.setId(getMaxId() + 1);
		contacts[numberContacts++] = c;
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
		// TODO Auto-generated method stub

	}

}
