package view;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import control.BookTitleComparator;
import control.MyLibrary;
import model.Book;

public class LibraryPresentation {
	private static final Object[][] options = {
		{1, "List all books"},
		{2, "Find by Title"},
		{3, "Add Book"},
		{4, "Edit Book"},
		{5, "Delete Book"},
		{6, "Save to File"},
		{7, "Load from File"},
		{8, "Exit"}
	};
	public static final String BOOKS_DB_FILE = "books.db";
	private static Scanner sc = new Scanner(System.in);
	
	private MyLibrary library;
	private Map<Integer, String> optionsMap = new HashMap<>();
	
	public LibraryPresentation(MyLibrary library) {
		this.library = library;
		if(library.getBooksCount() == 0) {
			try {
				library.readFromFile(BOOKS_DB_FILE);
			} catch (IOException e) {
				System.out.println("Error reading database file: " + e.getMessage());
			} catch (ParseException e) {
				System.out.println("Error parsing books data: " + e.getMessage());
			}
		}
		for(Object[] o: options) {
			optionsMap.put((Integer) o[0], (String)o[1]);
		}
	}
	
	public int presentMainMenu() {
		for(Integer opKey : optionsMap.keySet()) {
			System.out.printf("| %d | %-30.30s |\n", opKey, optionsMap.get(opKey));
		}
		int answer = inputIntValue("Choose operation:", 
				(int) options[0][0], (int) options[options.length-1][0]);
		switch (answer) {
			case 1: System.out.println(library.getBooksCatalog()); break;
			case 2: {
				System.out.print("Enter search string:");
				String searchStr = sc.nextLine();
				System.out.println(library.getBooksCatalog(library.findBooks(searchStr))); 
				break;
			}
			case 3: {
				library.addBook(library.inputBookData(new Book()));
				saveBooks();
				break;
			}
			case 4: {
				Book[] books = library.getBooks();
				int id = inputIntValue("Choose book ID to edit:", 
						books[0].getId(), books[books.length - 1].getId());
				Book book = library.findBookById(id);
				if(book == null) {
					System.out.println("Error: Book with ID=" + id + " does not exist.");
				} else {
					library.update(library.inputBookData(book));
				}
				saveBooks();
				break;
			}
			case 5: { //delete book
				// homework 
				break;
			}
			case 6: { //write db to file
				try {
					library.writeToFile(BOOKS_DB_FILE);
					System.out.println(library.getBooksCount() 
							+ " books successfully written to DB file '"
							+ BOOKS_DB_FILE +"'.");
				} catch (IOException e) {
					System.out.println("Error writing to books DB file '" 
							+ BOOKS_DB_FILE + "': " + e.getMessage());
				}
				break;
			}
			case 7: { //load from db file
				try {
					library.readFromFile(BOOKS_DB_FILE);
					System.out.println(library.getBooksCount() 
							+ " books successfully loaded from DB file '"
							+ BOOKS_DB_FILE +"'.");
				} catch (IOException e) {
					System.out.println("Error reading from books DB file '" 
							+ BOOKS_DB_FILE + "': " + e.getMessage());
				} catch (ParseException e) {
					System.out.println("Error parsing data from books DB file '" 
							+ BOOKS_DB_FILE + "': " + e.getMessage());
				}
			}
		}
		return answer;
	}

	private int inputIntValue(String message, int minValue, int maxValue) {
		int answer = Integer.MIN_VALUE;
		do {
			System.out.print(message);
			String answerStr = sc.nextLine();
			try {
				answer = Integer.parseInt(answerStr);
			} catch(NumberFormatException e) {
				System.out.println("Choose a valid option number.");
			}
		} while( answer < minValue || answer > maxValue);
		return answer;
	}
	
	public void saveBooks( ) {
		System.out.println("Saving books data to DB file ...");
		try {
			library.writeToFile(BOOKS_DB_FILE);
		} catch (IOException e) {
			System.out.println("Error writing to books DB file '" + BOOKS_DB_FILE 
					+ "': " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		LibraryPresentation lp = new LibraryPresentation(new MyLibrary());
		do {
		} while (lp.presentMainMenu() < (int) options[options.length-1][0]);
		lp.saveBooks();
		System.out.println("Exiting program.");
	}

}
