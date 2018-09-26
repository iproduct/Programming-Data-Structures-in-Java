package list;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
	private Node<T> currentNode;

	public MyIterator(MyLinkedList<T> list) {
		currentNode = list.getFirst();
	}

	@Override
	public boolean hasNext() {
		return currentNode != null;
	}

	@Override
	public T next() {
		T result = currentNode.getValue();
		currentNode = currentNode.getNext();
		return result;
	}

}
