package linkedlist;

public class LinkedList<T> {
	private Node<T> head;
	private int size;
	private Node<T> last;
	
	public LinkedList(){
	}

	public void addFirst(T item) {
		if(head == null){
			head = new Node<>(item);
			last = head;
		} else {
			head = head.addFirst(item);
		}
		size++;
	}
	
	public void addLast(T item) {
		if(head == null){
			head = new Node<>(item);
			last = head;
		} else {
			head = head.addLast(item, last);
			last = last.getNext();
		}
		size++;
	}
	
	public void add(T item, int index){
		size++;
		checkIndexValid(index);
		if(head == null){
			head = new Node<>(item);
		} else if(index == size-1) {
			head = head.addLast(item, last);
			last = last.getNext();
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
	
	public T remove(int index) {
		checkIndexValid(index);
		if(index == size - 1) {
			return removeLast();
		} else {
			Node<T> removed = head.get(index);
			head = head.remove(index);
			size --;
			return removed.getItem();
		}
	}
	
	public T removeFirst() {
		checkIndexValid(0);
		Node<T> removed = head.get(0);
		head = head.remove(0);
		size--;
		return removed.getItem();
	}
	
	public T removeLast() {
		checkIndexValid(size-1);
		Node<T> removed = last;	
		if(size == 1) {
			head = null;
			last = null;
		} else {
			Node<T> previous = head.get(size-2);
			previous.setNext(null);
			last = previous;
		}
		size--;
		return removed.getItem();
	}
	
	@Override
	public String toString(){
		return head.toString();
	}
	
	// Private implementation
	private void checkIndexValid(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size || size == 0) throw 
			new IndexOutOfBoundsException("There is no element with index:" 
				+ index + " required.");
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < 10; i++){
			list.addLast(i);
		}
		
		System.out.println(list.removeFirst());
		
		System.out.println(list.getSize());
		list.add(100, list.getSize()-1);
		
		System.out.println(list);
		System.out.println(list.removeLast());
		
		System.out.println(list);

	}

}
