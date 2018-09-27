package btree;

import queue.Queue;
import queue.QueueImpl;
import stack.Stack;
import stack.StackImpl;

public class BTNode<K extends Comparable<K>, V> {
	K key;
	V value;
	BTNode<K,V> left;
	BTNode<K,V> right;
	boolean visited;

	public BTNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public BTNode(K key, V value, BTNode<K, V> left, BTNode<K, V> rigth) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = rigth;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public BTNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(BTNode<K, V> left) {
		this.left = left;
	}

	public BTNode<K, V> getRight() {
		return right;
	}

	public void setRight(BTNode<K, V> rigth) {
		this.right = rigth;
	}
	
	public int size() {
		return (left != null? left.size(): 0)
			+ (right != null? right.size(): 0) 
			+ 1;
	}
	
	public int depth() {
		return Math.max(left != null? left.depth(): 0, right != null? right.depth(): 0) + 1;
	}
	
	public void printNode(int h) {
		for(int i = 0; i < 5 * h; i++)
			System.out.print(" ");
		System.out.println(toString());
	}
	
	public void printTree(int h) {
		if(left != null)
			left.printTree(h + 1);
		printNode(h);
		if(right != null)
			right.printTree(h + 1);
	}
	
	public void traverseDF(Visitor<K,V> visitor) {
		if(left != null)
			left.traverseDF(visitor);
		visitor.visit(key, value);
		if(right != null)
			right.traverseDF(visitor);
	}
	
//	public void traverseDFIter(Visitor<K,V> visitor) {
//		Stack<BTNode<K,V>> stack = new StackImpl<>();
//		stack.push(this);
//		
//		while(!stack.isEmpty()) {
//			BTNode<K,V> node = stack.pop();
//			node.setVisited(true);
//			if(node.left == null || node.left.isVisited())
//              visitor.visit(node.getKey(), node.getValue());
//			if(node.right != null)
//				stack.push(node.right);
//			if(node.left != null)
//				stack.push(node.left);
//		}
//	}
	
	public void traverseBFIter(Visitor<K,V> visitor) {
		Queue<BTNode<K,V>> stack = new QueueImpl<>();
		stack.offer(this);
		
		while(!stack.isEmpty()) {
			BTNode<K,V> node = stack.poll();
            visitor.visit(node.getKey(), node.getValue());
			if(node.left != null)
				stack.offer(node.left);
			if(node.right != null)
				stack.offer(node.right);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BTNode other = (BTNode) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[").append(key).append(":").append(value).append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		//leaves
		BTNode<Integer, Integer> l1 = new BTNode<>(1,1);
		BTNode<Integer, Integer> l5 = new BTNode<>(5,5);
		BTNode<Integer, Integer> l7 = new BTNode<>(7,7);
		BTNode<Integer, Integer> l13 = new BTNode<>(13,13);
		
		//branches
		BTNode<Integer, Integer> b4 = new BTNode<>(4,4,null,l5);		
		BTNode<Integer, Integer> b6 = new BTNode<>(6,6,b4,l7);
		BTNode<Integer, Integer> b3 = new BTNode<>(3,3,l1,b6);
		BTNode<Integer, Integer> b14 = new BTNode<>(14,14,l13,null);
		BTNode<Integer, Integer> b10 = new BTNode<>(10,10,null,b14);
		
		//root
		BTNode<Integer, Integer> r8 = new BTNode<>(8,8,b3,b10);

		System.out.println(r8.size());
		System.out.println(r8.depth());
		
//		r8.printTree(0);
		
		r8.traverseBFIter(
			new PrintingVisitor<>()
//			(key, value) -> {
//				System.out.printf("%d:%d, ", key, value);
//			}
		);
		
		

	}

}
