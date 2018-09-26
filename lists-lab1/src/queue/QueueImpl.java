package queue;

import linkedlist.LinkedList;
import stack.Stack;
import stack.StackImpl;

public class QueueImpl<T> implements Queue<T> {
	private LinkedList<T> list = new LinkedList<T>();
	
	@Override
	public void offer(T item) {
		list.addLast(item);
	}

	@Override
	public T poll() {
		return list.removeFirst();
	}

	@Override
	public T peek() {
		return list.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return list.getSize() == 0;
	}

	
	public static void main(String[] args) {
		Queue<Integer> queue = new QueueImpl<>();
		for(int i = 0; i < 10; i++){
			queue.offer(i);
		}
		
		while(!queue.isEmpty()){
			System.out.println(queue.poll());
		}
	}
}
