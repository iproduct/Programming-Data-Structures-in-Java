package btree;

public class BSTree<K extends Comparable<K>, V>  {
	BTNode<K,V> root;
	
	public void insert(K key, V value) {
		root = insertR(root, key, value);
	}

	private BTNode<K,V> insertR(BTNode<K,V> root, K key, V value) {
		if(root == null) // recursion bottom
			return new BTNode<K,V>(key, value);
		if(key.compareTo(root.getKey()) == 0) // recursion bottom
			root.setValue(value);
		if(key.compareTo(root.getKey()) < 0) // recursion step
			root.left = insertR(root.left, key, value);
		else 
			root.right = insertR(root.right, key, value);
		return root;
	}
	
	public V search(K key) {
		return searchR(root, key);
	}
	
	public V searchR(BTNode<K,V> root, K key) {
		if(root == null) return null; // recursion bottom
		if(root.getKey().compareTo(key) == 0) {
			return root.getValue(); // recursion bottom
		} else if(key.compareTo(root.getKey()) < 0) // recursion step
			return searchR(root.left, key);
		else {
			return searchR(root.right, key);
		}
	}
	
//	public Entry<K,V> searchIter(K key) {
//		BTNode<Entry<K,V>> current = root;
//		while(current != nil) {
//			if(current.entry.getKey().equals(key)) 
//				return current.entry;
//			if(key.compareTo(current.entry.getKey()) < 0) 
//				current = current.left;
//			else if (key.compareTo(current.entry.getKey()) > 0)
//				current = current.right;
//			else 
//				throw new RuntimeException(
//						"Inconsistent implementation of Comparable interface and equals semantics.");
//		}
//		return null;
//	}
	
	public void print() {
		root.printTree(0);
	}
}
