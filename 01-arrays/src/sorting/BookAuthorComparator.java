package sorting;

import java.util.Comparator;

import model.Book;

public class BookAuthorComparator implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		return b1.getAuthors().compareToIgnoreCase(b2.getAuthors());
	}

}
