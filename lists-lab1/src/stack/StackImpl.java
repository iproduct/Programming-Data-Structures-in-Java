package stack;

import list.MyLinkedList;
import list.MyList;

public class StackImpl<T> implements Stack<T> {
	private MyList<T> list = new MyLinkedList<T>();

	@Override
	public void push(T item) {
		list.add(0, item);
	}

	@Override
	public T pop() {
		return list.remove(0);
	}

	@Override
	public T top() {
		return list.get(0);
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new StackImpl<>();
		for(int i = 0; i < 10; i++){
			stack.push(i);
		}
		
		System.out.println(stack.isEmpty());
		
		for(int i = 0; i < 10; i++){
			System.out.println(stack.pop());
		}
		System.out.println(stack.isEmpty());
	}
}
