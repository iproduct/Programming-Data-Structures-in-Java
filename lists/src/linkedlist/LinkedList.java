package linkedlist;

public class LinkedList<T> {
	T item; //head
	LinkedList<T> next; //tail
	
	LinkedList() {}
	
	LinkedList(T item) {
		this.item = item;
	}
	
	public LinkedList<T> addFirst(T newItem) {
		LinkedList<T> newHead = new LinkedList<>(newItem);
		newHead.next = this;
		return newHead;
	}
	
	public LinkedList<T> addLast(T newItem) {
		LinkedList<T> lastItem = new LinkedList<>(newItem);
		getLast().next = lastItem;
		return this;
	}
	
	
	public LinkedList<T> get(int index){
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
	
	public LinkedList<T> getLast(){
		// recursion bottom
		if(this.next == null) 
			return this;
		// recursion step
		return next.getLast();
	}
	
	
	public void add(T newItem, int index) {
		LinkedList<T> newNode = new LinkedList<>(newItem);
		if(index > 0) {
			LinkedList<T> previous = get(index - 1);
			newNode.next = previous.next;
			previous.next = newNode;
		} else {
			addFirst(newItem);
		}
	}
	
	public T remove (int index) {
		return null;
	}
	
	public String toString(){
		if(next == null) //bottom
			return String.format("%d, ", item);
		else             //step
			return String.format("%d, ", item) + next.toString();
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(0);
		for(int i = 1; i < 10; i++)
			list.addLast(i);
		
		//print list
//		while(true){
//			System.out.format("%d, ", list.item);
//			list = list.next;
//			if(list == null) break;
//		}
		
		System.out.println(list);
				
				

	}

}
