package addressbook.view;

import java.util.HashMap;
import java.util.Map;

import addressbook.control.AddressBook;

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
	}

	public static void main(String[] args) {
		AddressBookPresentation presentation = new AddressBookPresentation(null);
		presentation.showMainMenu();
	}

}
