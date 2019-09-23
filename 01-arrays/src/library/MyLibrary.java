package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import model.Book;
import model.WordCount;

public class MyLibrary {
	public static final int MAX_BOOKS = 1000;
	public static final int NUM_KEYWORDS = 5;
	
	private static Scanner sc = new Scanner(System.in);
	private Book[] books = new Book[MAX_BOOKS];
	private int numberBooks = 0;

	public MyLibrary() {
	}
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
		sb.append(getUnderline(108)).append("\n");
//		for(int i = 0;  i < numberBooks; i++) {
//			sb.append(books[i].toString()).append("\n");
//		}
		sb.append(String.format("|%-30.30s|%-20.20s|%-6s|%-15.15s|%-15.15s|%-15.15s|\n", 
				"       Title", "     Authors", " Date", "    Publisher", "  Genre", 
				"  Keywords"));
		
		sb.append(getUnderline(108)).append("\n");
		
		for(Book b : results) {
			sb.append(String.format("|%-30.30s|%-20.20s|%6tY|%-15.15s|%-15.15s|%-15.15s|", 
					b.getTitle(), b.getAuthors(), b.getPublishedDate(), b.getPublisher(), b.getGenre(), 
					b.getKeywords()))
			.append("\n");
		}
		
		sb.append(getUnderline(108)).append("\n");;

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
		
		// Input publisher
		System.out.println("Издател [" + book.getPublisher() + "]:");
		answer = sc.nextLine();
		if(answer.length() > 0 || book.getPublisher() == null) {
			book.setPublisher(answer);
		}
		
		// Input published date
		do {
			System.out.println("Дата [" + book.getPublishedDate() + "]:");
			answer = sc.nextLine();
			if(answer.length() > 0 || book.getPublishedDate() == null) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
				try {
					book.setPublishedDate(sdf.parse(answer));
				} catch (ParseException e) {
					System.out.println("Невалидна дата: " + answer + ". Опитайте отново.");
				}
			}
		} while(book.getPublishedDate() == null);
		
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
	
	public static String[] proposeKeywords(Book b) {
		String[] titleWords = b.getTitle().split("[\\s\\.,?!;:+-]+");
		String[] descriptionWords = b.getDescription().split("[\\s\\.,?!;:+-]+");
		
		String[] words = 
				Arrays.copyOf(titleWords, titleWords.length + descriptionWords.length);
		for(int i = 0; i < descriptionWords.length; i++) {
			words[titleWords.length + i] = descriptionWords[i];
		}
		
		WordCount[] wordCounts = new WordCount[words.length];
		int number = 0;
		
		// Count word occurances
		for(String word: words) {
			WordCount newWordCount = new WordCount(word.toLowerCase(), 1);
			int index = Arrays.binarySearch(wordCounts, 0, number, newWordCount);
			if(index >= 0) {
				wordCounts[index].count ++;
			} else {
				arrayInsert(wordCounts, -(index+1), number, newWordCount);
				number++;
			}
		}
		
		// Sort WordCounts
		Arrays.sort(wordCounts, 0, number, new Comparator<WordCount>() {
			@Override
			public int compare(WordCount w1, WordCount w2) {
				return w2.count - w1.count;
			}
		});
		
		String[] keywords = new String[NUM_KEYWORDS];
		
		for(int i = 0; i < 5; i++) {
			keywords[i] = wordCounts[i].word;
		}
		
		return keywords;
	}

	public static void arrayInsert(WordCount[] wordCounts, int insertIndex, 
			int numberWords, WordCount newWordCount) {
		for(int i = numberWords - 1; i >= insertIndex; i--) {
			wordCounts[i + 1] = wordCounts[i];
		}
		wordCounts[insertIndex] = newWordCount;
	}

	public void writeToFile(String file) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		for(int i = 0; i < numberBooks; i++) {
			Book b = books[i];
			out.print(getField(b.getId() + "") + "|");
			out.print(getField(b.getTitle()) + "|");
			out.print(getField(b.getAuthors()) + "|");
			out.print(getField(b.getPublisher()) + "|");
			out.print(sdf.format(
				b.getPublishedDate() != null ? b.getPublishedDate(): new Date()) + "|");
			out.print(getField(b.getIsbn()) + "|");
			out.print(getField(b.getGenre()) + "|");
			out.print(getField(b.getDescription()) + "|");
			out.print(getField(b.getKeywords() + "|"));
			out.println();
		}
		out.close();
	}
	
	protected String getField(String field) {
		String result = field != null ? field.replaceAll("\\s+", " ") : "";
		result = result.replaceAll("\\|", "/");
		return result;
	}
	
	public int readFromFile(String file) throws IOException, ParseException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String s;
		int count = 0;
		while((s = in.readLine())!= null) {
			String[] fields = s.split("\\|");
			Book b = new Book(fields[1], fields[2], fields[3],  
					fields[4].length() > 0? sdf.parse(fields[4]): null,
					fields[5], fields[6], fields[7], fields[8]);
			try {
				int id = Integer.parseInt(fields[0]);
				b.setId(id);
				addBook(b);
				count++;
			} catch (NumberFormatException e) {
				throw new ParseException("Error parsing ID: " + fields[0], 0);
			}
	    }
	    in.close();
		return count;
	}
	
	public static void main(String[] args) {
		Book[] sampleBooks = {
			new Book("Thinking in Java - 4th edition", "Bruce Eckel", "Prentice Hall", 
					new GregorianCalendar(2006, 0, 1).getTime(),
					"1234567890123", "Programming", 
					"Thinking In Java should be read cover to cover by every Java programmer,\r\n" + 
					"then kept close at hand for frequent reference. The exercises are challenging,\r\n" + 
					"and the chapter on Collections is superb! Not only did this book help me to\r\n" + 
					"pass the Sun Certified Java Programmer exam; it’s also the first book I turn\r\n" + 
					"to whenever I have a Java question. ", "java, programming, book"),
			new Book("Въведение в програмирането с Java", "С. Наков и колектив", "Programming"),
			new Book("Open Data Structures (in Java)", "Pat Morin", "Programming"),
			new Book("Java Data", "Particle", "Programming"),
		};
		MyLibrary lib = new MyLibrary(sampleBooks);
		try {
			lib.writeToFile("books.db");
		} catch (IOException e) {
			System.out.println("Error writing books.db file: " + e.getMessage());
		}
		
		// Read from file
		lib = new MyLibrary();
		try {
			lib.readFromFile("books.db");
		} catch (IOException e) {
			System.out.println("Error reading books.db file: " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Error reading books.db file: " + e.getMessage());
		}
		
		//Print all books report
		System.out.println(lib.getBooksCatalog());
		
//		Book newBook = new Book();
//		inputBookData(newBook);
//		lib.addBook(newBook);
//		
//		//Print all books report
//		System.out.println(lib.getBooksCatalog());
		
//		//Serach books
//		System.out.println("Въведете низ за търсене:");
//		String searchStr = sc.nextLine();
//		Book[] found = lib.findBooks(searchStr);
//		for(Book b: found) {
//			System.out.println(b);
//		}
		
//		System.out.println("Keywords: " + Arrays.toString(proposeKeywords(sampleBooks[0])));
//		
//		System.out.println(sampleBooks[0].getDescription().replaceFirst("J\\S*", "JAVA"));
//		
//		System.out.println(sampleBooks[0]);
//		
	}

}
