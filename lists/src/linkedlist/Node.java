package linkedlist;

class Node<T> {
	private T item; //head
	private Node<T> next; //tail
	
	Node() {}
	
	Node(T item) {
		this.item = item;
	}
	
	public T getItem() {
		return item;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> addFirst(T newItem) {
		Node<T> newHead = new Node<>(newItem);
		newHead.next = this;
		return newHead;
	}
	
	public Node<T> addLast(T newItem, Node<T> last) {
		Node<T> lastItem = new Node<>(newItem);
		last.next = lastItem;
		return this;
	}
	
	
	public Node<T> get(int index){
		// argument validity check
		if(index < 0)
			throw new IndexOutOfBoundsException("There is no element with index required.");
		// recursion bottom
		if(index == 0)
			return this;
		// recursion step
		if(this.next == null) 
			throw new IndexOutOfBoundsException("There is no element with index required.");
		return next.get(--index);
	}
	
	public Node<T> getLast(){
		// recursion bottom
		if(this.next == null) 
			return this;
		// recursion step
		return next.getLast();
	}
	
	
	public Node<T> add(T newItem, int index) {
		Node<T> newNode = new Node<>(newItem);
		if(index > 0) {
			Node<T> previous = get(index - 1);
			newNode.next = previous.next;
			previous.next = newNode;
			return this;
		} else {
			return addFirst(newItem);
		}
	}
	
	public Node<T> remove (int index) {
		if(index == 0)
			return next;
		else {
			Node<T> previous = get(index - 1);
			previous.next = previous.next.next;
			return this;
		}
	}
	
	public String toString(){
		if(next == null) //bottom
			return String.format("%d, ", item);
		else             //step
			return String.format("%d, ", item) + next.toString();
	}
	
	public static void main(String[] args) {
//		Node<Integer> list = new Node<>(0);
//		for(int i = 1; i < 10; i++)
//			list.addLast(i);
//		
//		//print list
////		while(true){
////			System.out.format("%d, ", list.item);
////			list = list.next;
////			if(list == null) break;
////		}
//		
//		System.out.println(list);
//		list = list.remove(9);	
//		System.out.println(list);		

	}

}
