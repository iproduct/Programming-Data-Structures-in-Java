package queue;

public interface Queue<T> {
	void offer(T Item);
	T poll();
	T peek();
	boolean isEmpty();
}
