package queue;

import list.MyLinkedList;
import list.MyList;

public class QueueImpl<T> implements Queue<T> {
	private MyList<T> list = new MyLinkedList<T>();
	
	@Override
	public void offer(T item) {
		list.add(item);
	}

	@Override
	public T poll() {
		return list.remove(0);
	}

	@Override
	public T peek() {
		return list.get(0);
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
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
