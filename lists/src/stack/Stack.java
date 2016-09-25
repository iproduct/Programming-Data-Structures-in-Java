package stack;

public interface Stack<T> {
	void push(T Item);
	T pop();
	T top();
	boolean isEmpty();
}
