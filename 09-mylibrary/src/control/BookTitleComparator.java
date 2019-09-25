package control;

import java.util.Comparator;

import model.Book;

public class BookTitleComparator implements Comparator<Book> {
	public int compare(Book b1, Book b2) {
		return b1.getTitle().compareToIgnoreCase(b2.getTitle());
	}
}

