package addressbook.model;

import java.util.Comparator;

public class ContactAddressComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getAddress().compareToIgnoreCase(c2.getAddress());
	}

}
