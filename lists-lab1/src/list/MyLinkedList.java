package list;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{
	private Node<T> first;

	public MyLinkedList() {
	}
	
	public Node<T> getFirst() {
		return first;
	}
	
	@Override
	public T get(int index) {
		if(first == null) {
			throw new IndexOutOfBoundsException("Ivalid index " + index);
		}
		
		Node<T> node = first;
		int position = 0;
		
		while(node.getNext() != null && position < index) {
			node = node.getNext();
			position ++;
		}
		if(position < index)
			throw new IndexOutOfBoundsException("Ivalid index " + index);
		
		return node.getValue();
	}

	@Override
	public void add(T element) {
		if(first == null) {
			first = new Node(element);
			return;
		}
		
		Node<T> node = first;	
		while(node.getNext() != null)
			node = node.getNext();
		node.setNext(new Node(element));
	}

	@Override
	public void add(int index, T element) {
		if(index == 0) {
			if(first == null) {
				first = new Node(element);
			} else {
				Node<T> temp = first;
				first = new Node(element);
				first.setNext(temp);
			}
			return;
		}
		
		Node<T> node = first;
		int position = 0;
		
		while(node.getNext() != null && position < index - 1) {
			node = node.getNext();
			position ++;
		}
		if(position < index - 1)
			throw new IndexOutOfBoundsException("Ivalid insertion index.");
		
		Node<T> tempNext = node.getNext();
		Node<T> newNode = new Node(element);
		node.setNext(newNode);
		newNode.setNext(tempNext);
	}

	@Override
	public void set(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) {
		if(index == 0) {
			if(first == null) {
				new IndexOutOfBoundsException("Invalid index " + index + " - list is empty.");
			} else {
				T result = first.getValue();
				first = first.getNext();
				return result;
			}
		}
		
		Node<T> node = first;
		int position = 0;
		
		while(node.getNext() != null && position < index - 1) {
			node = node.getNext();
			position ++;
		}
		if(position < index - 1 || node.getNext() == null)
			throw new IndexOutOfBoundsException("Ivalid index " + index);
		
		T result = node.getNext().getValue();
		node.setNext(node.getNext().getNext());
		
		return result;
	}

	@Override
	public T find(T criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findIndex(T criteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		if(first == null) {
			return 0;
		}
		
		Node<T> node = first;
		int position = 0;
		
		while(node.getNext() != null ) {
			node = node.getNext();
			position ++;
		}
		
		return position + 1;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new MyIterator<>(this);
	}
	
	public static void main(String[] args) {
		MyList<String> list = new MyLinkedList<>();
		
		list.add("Sofia");
		list.add("Plovdiv");
		list.add("Varna");
		list.add(0, "Ruse");
		list.add(2, "Samokov");
		
//		System.out.println(list.remove(2));
//		System.out.println(list.remove(0));
		
		System.out.println("\nResult list:");
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("\nResult list using for-each:");
		for(String s: list) {
			System.out.println(s);
		}
		
	}

	

}
