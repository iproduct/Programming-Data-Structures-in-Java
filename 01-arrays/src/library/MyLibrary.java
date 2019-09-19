package library;

import java.util.Arrays;
import java.util.Scanner;

import model.Book;

public class MyLibrary {
	public static final int MAX_BOOKS = 1000;
	private static Scanner sc = new Scanner(System.in);
	private Book[] books = new Book[MAX_BOOKS];
	private int numberBooks = 0;

	public MyLibrary(Book[] books) {
		for(Book book: books) {
			addBook(book);
		}
	}
	
	public Book addBook(Book book) {
		book.setId(numberBooks + 1);
		books[numberBooks] = book;
		numberBooks ++;
		return book;
	}
	
	public Book[] findBooks(String searchString) {
		Book[] results = new Book[numberBooks];
		int position = 0;
		for(int i = 0;  i < numberBooks; i++) {
			if(books[i].getTitle().toLowerCase().contains(searchString.toLowerCase())) {
				results[position++] = books[i];
			}
		}
		return Arrays.copyOf(results, position);
	}
	
	public String getBooksCatalog() {
		//Copy in new array
		Book[] results = Arrays.copyOf(books, numberBooks);
		
		// Sort books by title
		Arrays.sort(results);
		
		// Generate report
		StringBuilder sb = new StringBuilder();
		sb.append(getUnderline(101)).append("\n");
//		for(int i = 0;  i < numberBooks; i++) {
//			sb.append(books[i].toString()).append("\n");
//		}
		sb.append(String.format("|%-30.30s|%-20.20s|%-15.15s|%-15.15s|%-15.15s|\n", 
				"       Title", "     Authors", "    Publisher", "  Genre", 
				"  Keywords"));
		
		sb.append(getUnderline(101)).append("\n");
		
		for(Book b : results) {
			sb.append(String.format("|%-30.30s|%-20.20s|%-15.15s|%-15.15s|%-15.15s|", 
					b.getTitle(), b.getAuthors(), b.getPublisher(), b.getGenre(), 
					b.getKeywords()))
			.append("\n");
		}
		
		sb.append(getUnderline(101)).append("\n");;

		return sb.toString();
	}

	private String getUnderline(int length) {
		char[] underline = new char[length];
		Arrays.fill(underline, '-');
		String underlineStr = new String(underline);
		return underlineStr;
	}
	
	public static void inputBookData(Book book) {
		System.out.println("Въведете данни за книгата (натиснете <ENTER> ако няма промаяна):");
		
		// Input title
		System.out.println("Заглавие [" + book.getTitle() + "]:");
		String answer = sc.nextLine();
		if(answer.length() > 0 || book.getTitle() == null) {
			book.setTitle(answer);
		}
		
		// Input authors
		System.out.println("Автори [" + book.getAuthors() + "]:");
		answer = sc.nextLine();
		if(answer.length() > 0 || book.getAuthors() == null) {
			book.setAuthors(answer);
		}
		
		// Input authors
		System.out.println("Издател [" + book.getPublisher() + "]:");
		answer = sc.nextLine();
		if(answer.length() > 0 || book.getPublisher() == null) {
			book.setPublisher(answer);
		}
		
		// Input authors
		System.out.println("ISBN [" + book.getIsbn() + "]:");
		answer = sc.nextLine();
		if(answer.length() > 0 || book.getIsbn() == null) {
			book.setIsbn(answer);
		}
		
		// Input authors
		System.out.println("Жанр [" + book.getGenre() + "]:");
		answer = sc.nextLine();
		if(answer.length() > 0 || book.getGenre() == null) {
			book.setGenre(answer);
		}
		
		// Input authors
		System.out.println("Описанние [" + book.getDescription() + "]:");
		answer = sc.nextLine();
		if(answer.length() > 0 || book.getDescription() == null) {
			book.setDescription(answer);
		}
		
		// Input authors
		System.out.println("Ключови думи [" + book.getKeywords() + "]:");
		answer = sc.nextLine();
		if(answer.length() > 0 || book.getKeywords() == null) {
			book.setKeywords(answer);
		}
	}

	public static void main(String[] args) {
		Book[] sampleBooks = {
			new Book("Thinking in Java - 4th edition", "Bruce Eckel", "Programming"),
			new Book("Въведение в програмирането с Java", "С. Наков и колектив", "Programming"),
			new Book("Open Data Structures (in Java)", "Pat Morin", "Programming"),
			new Book("Java Data", "Particle", "Programming"),
		};
		MyLibrary lib = new MyLibrary(sampleBooks);
		
		//Print all books report
		System.out.println(lib.getBooksCatalog());
		
		Book newBook = new Book();
		inputBookData(newBook);
		lib.addBook(newBook);
		
		//Print all books report
		System.out.println(lib.getBooksCatalog());
		
		//Serach books
		System.out.println("Въведете низ за търсене:");
		String searchStr = sc.nextLine();
		Book[] found = lib.findBooks(searchStr);
		for(Book b: found) {
			System.out.println(b);
		}

	}

}
