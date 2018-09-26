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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
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
		
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	

}
