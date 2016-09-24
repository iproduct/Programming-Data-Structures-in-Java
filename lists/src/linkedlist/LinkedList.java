package linkedlist;

public class LinkedList<T> {
	private Node<T> head;
	private int size;
	
	public LinkedList(){
	}

	public void addFirst(T item) {
		if(head == null){
			head = new Node(item);
		} else {
			head = head.addFirst(item);
		}
		size++;
	}
	
	public void addLast(T item) {
		if(head == null){
			head = new Node(item);
		} else {
			head = head.addLast(item);
		}
		size++;
	}
	
	public void add(T item, int index){
		size++;
		checkIndexValid(index);
		if(head == null){
			head = new Node(item);
		} else {
			head = head.add(item, index);
		}
	}

	public int getSize() {
		return size;
	}
	
	public T get(int index){
		checkIndexValid(index);
		return head.get(index).getItem();
	}
	
	public T getFirst() {
		checkIndexValid(0);
		return head.getItem();
	}
	
	public T getLast() {
		checkIndexValid(size-1);
		return head.getLast().getItem();
	}
	
	// Private implementation
	private void checkIndexValid(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size || size == 0) throw 
			new IndexOutOfBoundsException("There is no element with index:" 
				+ index + " required.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
