package control;

import model.Contact;

public class AddressBook {

	public static void main(String[] args) {
		Contact c = new Contact("John", "Smith", "john@gmail.com", "+44 32242342");
		System.out.println(c);
	}

}
