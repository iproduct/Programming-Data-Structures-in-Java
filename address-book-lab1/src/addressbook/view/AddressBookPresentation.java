package addressbook.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import addressbook.control.AddressBook;
import addressbook.exceptions.EntityExistsException;
import addressbook.model.Address;
import addressbook.model.Contact;

public class AddressBookPresentation {
	private static final Object[][] options = {
		{1, "List all contacts"},
		{2, "Add contact"},
		{3, "Find by first, last name"},
		{4, "Find by part of first, last name or organization"},
		{5, "Update contact"},
		{6, "Delete contact"},
		{9, "Exit"}
	};
	private static final Scanner sc = new Scanner(System.in);
	
	private AddressBook controller;
	private Map<Integer, String> optionsMap = new HashMap<>();

	public AddressBookPresentation(AddressBook controller) {
		this.controller = controller;
		for(Object[] o: options) {
			optionsMap.put((Integer) o[0], (String) o[1]);
		}
	}
	
	public void showMainMenu() {
		for(Integer key: optionsMap.keySet()) {
			System.out.printf("| %d | %-50.50s |\n", key, optionsMap.get(key));
		}
		int answer = inputIntWithValidation("Choose operation:", true);
		if (answer == 0) {
			answer = 1;
		}
		
		switch(answer) {
		case 1: printContacts(controller.getContacts()); break;
		}
	}
	
	private static void printContacts(List<Contact> contacts) {
		for(Contact contact: contacts) {
			System.out.printf(
				"| %-12.12s | %-12.12s | %-20.20s | %-12.12s | %-20.20s |\n", 
				contact.getfName(),
				contact.getlName(),
				contact.getEmail(),
				contact.getMobilePhone(),
				contact.getAddress()
			);
		}
		
	}

	private static int inputIntWithValidation(String message, boolean allowEmptyAnswer) {
		int value = 0;
		do {
			System.out.print(message);
			String lenStr = sc.nextLine();
			if (allowEmptyAnswer && lenStr.length() == 0)
				return 0;

			try {
				value = Integer.parseInt(lenStr);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid value. Try again.");
			}
		} while (value <= 0);
		return value;
	}


	public static void main(String[] args) {
		Contact[] sample = {
				new Contact("Ivan", "Petrov", "ivan@abv.bg", "0898123456"),
				new Contact("John", "Smith", "john@gogle.com", "04123456789"),
				new Contact("Hristo", "Petrov", "hristo@abv.bg", "0898123434"),
				new Contact("Maria", "Petrova", "maria@abv.bg", "0898123411"),
				new Contact("Maria", "Dimitrova", "mariad@abv.bg", "0898123422"),
		};
		
		AddressBook book = new AddressBook();
		
		// Add sample contacts
		for(Contact c : sample) {
			c.setAddress(new Address("BG", "Sofia", "1000"));
			try {
				book.addContact(c);
			} catch (EntityExistsException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		}
		
		// Show main menu
		AddressBookPresentation presentation = 
				new AddressBookPresentation(book);
		presentation.showMainMenu();
	}

}
