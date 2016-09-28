package binarytree;

import static binarytree.BTNode.nil;;
public class BSTree<K extends Comparable<K>, V>  {
	BTNode<Entry<K,V>> root;
	
	@SuppressWarnings("unchecked")
	public BSTree(){
		root = BTNode.nil;
	}
	
	public void insert(Entry<K,V> newEntry) {
		root = insertR(root, newEntry);
	}

	private BTNode<Entry<K,V>> insertR(BTNode<Entry<K,V>> root, Entry<K,V> newEntry) {
		if(root == nil) return 
			new BTNode<Entry<K,V>>(root, root, root, newEntry);
		if(newEntry.getKey().compareTo(root.entry.getKey()) < 0)
			root.left = insertR(root.left, newEntry);
		else 
			root.right = insertR(root.right, newEntry);
		return root;
	}
	
	
	public void print() {
		root.show();
	}
}
