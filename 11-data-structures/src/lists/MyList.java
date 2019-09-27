package lists;

import java.util.Iterator;

public interface MyList<E> extends Iterable<E>{
	void add(E element);
	void add(int index, E element);
	E get(int index);
	void set(int index, E element);
	E remove(int index);
	int indexOf(E element); // returns position or -1 if not found
	String toString();
	Iterator<E> iterator();
	int size();
}
