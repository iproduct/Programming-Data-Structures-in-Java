package library;

import java.util.Scanner;

import model.Book;

public class MyLibrary {
	private static Scanner sc = new Scanner(System.in);
	private Book[] books;

	public MyLibrary(Book[] books) {
		this.books = books;
	}
	
	public String getBooksCatalog() {
		StringBuilder sb = new StringBuilder();
//		for(int i = 0;  i < books.length; i++) {
//			sb.append(books[i].toString()).append("\n");
//		}
		for(Book b : books) {
			sb.append(b.toString()).append("\n");
		}
		return sb.toString();
	}
	
	public static void inputBookData(Book book) {
		System.out.println("Въведете данни за книгата (натиснете <ENTER> ако няма промаяна):");
		System.out.println("Заглавие [" + book.getTitle() + "]:");
		String answer = sc.nextLine();
		if(answer.length() > 0) {
			book.setTitle(answer);
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
		System.out.println(newBook);

	}

}
