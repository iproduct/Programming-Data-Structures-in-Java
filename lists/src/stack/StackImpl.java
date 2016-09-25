package stack;

import linkedlist.LinkedList;

public class StackImpl<T> implements Stack<T> {
	private LinkedList<T> list = new LinkedList<T>();

	@Override
	public void push(T item) {
		list.addFirst(item);
	}

	@Override
	public T pop() {
		return list.removeFirst();
	}

	@Override
	public T top() {
		return list.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return list.getSize() == 0;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new StackImpl<>();
		for(int i = 0; i < 10; i++){
			stack.push(i);
		}
		
		for(int i = 0; i < 10; i++){
			System.out.println(stack.pop());
		}
	}
}
