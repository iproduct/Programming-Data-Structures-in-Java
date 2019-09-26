package lists;

import java.util.GregorianCalendar;
import java.util.Iterator;

import exceptions.MyListException;
import model.Book;

public class MyLinkedList<E> implements MyList<E>{
	private ListElement<E > first = null;
	private ListElement<E > last = null;
	private int size = 0;

	@Override
	public void add(E element) {
		add(size(), element);
	}

	@Override
	public void add(int index, E element) {
		if(index < 0 || index > size)
			throw new MyListException("Index out bounds: " + index);
		
		int pos = 0;
		ListElement<E> current = first;
		ListElement<E> previous = null;
		while(pos < index && pos <= size && current != null) {
			previous = current;
			current = current.getNext();
			pos++;
		}
		ListElement<E> newElem = new ListElement<E>(element, current);
		if(previous != null) {
			previous.setNext(newElem);
		} else {
			first = newElem;
		}
		if(current == null) {
			last = newElem;
		}
		size++;	
	}

	@Override
	public E get(int index) {
		if(index < 0 || index > size-1)
			throw new MyListException("Index out bounds: " + index);

		ListElement<E> current = first;
		int pos = 0;
		while(current != null && pos++ < index) {
			current = current.getNext();
		}
		return current.getValue();
	}
	
	@Override
	public void set(int index, E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			ListElement<E> current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				E result = current.getValue();
				current = current.getNext();
				return result;
			}
			
		};
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Iterator<E> it = iterator();
//		if(it.hasNext()) {
//			sb.append(it.next().toString());
//		}
		while(it.hasNext()) {
			sb.append(it.next().toString());
			if(it.hasNext()) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		MyList<Book> myBooks = new MyLinkedList<>();
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
//		myBooks.add(0, sampleBooks[0]);
//		myBooks.add(myBooks.size(), sampleBooks[1]);
		for(Book b: sampleBooks) {
			myBooks.add(b);
		}
		System.out.println(myBooks);
		System.out.println("First Book: " + myBooks.get(4));

	}

}
