package model;

public class Book implements Comparable<Book>{
	private static int nextId = 0;

	private int id = ++nextId;
	private String title;
	private String authors;
	private String publisher;
	private String isbn;
	private String genre;
	private String description;
	private String keywords;

	// No-args constructor
	public Book() {
	}

	// Required args constructor
	public Book(String title, String authors, String genre) {
		this.title = title;
		this.authors = authors;
		this.genre = genre;
	}

	// All args constructor
	public Book(String title, String authors, String publisher, String isbn, String genre, String description,
			String keywords) {
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.isbn = isbn;
		this.genre = genre;
		this.description = description;
		this.keywords = keywords;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	// hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	// String representation of the Book
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + authors + ", publisher=" + publisher + ", isbn="
				+ isbn + ", genre=" + genre + ", description=" + description + ", keywords=" + keywords + "]";
	}

	@Override
	public int compareTo(Book o) {
		return getTitle().compareToIgnoreCase(o.getTitle());
	}

}
