package addressbook.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	private static final String[][] fields = {
			{"Input first name", "[A-Z][a-z]{1,11}"},
			{"Input last name ", "[A-Z][a-z]{1,11}"},
			{"Input organization", ".{0,15}"},
			{"Input email", "[A-Za-z_0-9\\.]+@(\\w+\\.)+\\w+"},
			{"Input phone", "\\d{8,12}"},
			{"Input address", "[\\w\\s]+,[\\w\\s]+,[\\w\\s]+"},
			{"Input description", ".*"},
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
	
	public void showMainMenu() throws EntityExistsException {
		int answer;
		do {
			for (Integer key : optionsMap.keySet()) {
				System.out.printf("| %d | %-50.50s |\n", key, optionsMap.get(key));
			}
			answer = inputIntWithValidation("Choose operation:", true);
			if (answer == 0) {
				answer = 1;
			}

			switch (answer) {
			case 1:
				printContacts(controller.getContacts());
				break;
			case 2:
				controller.addContact(inputNewContact());
				break;
			}
		} while (answer != 9);
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
	
	private static String inputStringWithRegexValidation(String message, String regex) {
		Pattern pattern = Pattern.compile(regex);
		String answer = null;
		do {
			System.out.print(message + ": ");
			String input = sc.nextLine();
			Matcher matcher = pattern.matcher(input);
			if(matcher.matches()) {
				answer = input;
			} else {
				System.out.println("Invalid answer. Should match regex '" + regex + "'.");
			}
		} while(answer == null);
		return answer;
	}
	
	public static Contact inputNewContact() {
		Contact contact = new Contact();
		contact.setfName(inputStringWithRegexValidation(fields[0][0], fields[0][1]));
		contact.setlName(inputStringWithRegexValidation(fields[1][0], fields[1][1]));
		contact.setOrganization(inputStringWithRegexValidation(fields[2][0], fields[2][1]));
		contact.setEmail(inputStringWithRegexValidation(fields[3][0], fields[3][1]));
		contact.setMobilePhone(inputStringWithRegexValidation(fields[4][0], fields[4][1]));
//		contact.setAddress(inputStringWithRegexValidation(fields[5][0], fields[5][1]));
		contact.setDescription(inputStringWithRegexValidation(fields[6][0], fields[6][1]));
		return contact;
	}


	public static void main(String[] args) throws EntityExistsException {
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
