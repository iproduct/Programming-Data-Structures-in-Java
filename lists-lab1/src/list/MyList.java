package list;

import java.util.Iterator;

public interface MyList<T> {
	void add(T element);
	void add(int index, T element);
	void set(int index, T element);
	T get(int index);
	T remove(int index);
	T find(T criteria);
	int findIndex(T criteria);
	int size();
	Iterator<T> iterator();
}
