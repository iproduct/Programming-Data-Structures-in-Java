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
		
	}
	
//	public showMainMenu() {
//	
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
