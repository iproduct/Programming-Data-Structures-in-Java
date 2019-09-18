package sorting;

import java.util.Arrays;

import model.Book;

public class ArraysSort {

	public static void main(String[] args) {
		int[] a = {23, 15, 17, 92, 110, 4, 12, 67, 54, 45};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		Book[] sampleBooks = {
			new Book("Thinking in Java - 4th edition", "Bruce Eckel", "Programming"),
			new Book("Въведение в програмирането с Java", "С. Наков и колектив", "Programming"),
			new Book("Open Data Structures (in Java)", "Pat Morin", "Programming"),
			new Book("Java Data", "Particle", "Programming"),
		};
//		Arrays.sort(sampleBooks, new BookAuthorComparator());
		Arrays.sort(sampleBooks);
		for(Book b: sampleBooks) {
			System.out.println(b);
		}
		
		Book bookToSearch = new Book("Thinking in Java - 4th edition", "", "");
		int foundIndex = Arrays.binarySearch(sampleBooks, bookToSearch);
		
		System.out.println("Found on index: " + foundIndex);
	}

}
