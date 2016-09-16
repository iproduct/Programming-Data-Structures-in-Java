package addressbook.model;

import java.util.Comparator;

public class ContactNameComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getName().compareToIgnoreCase(c2.getName());
	}

}
