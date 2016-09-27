package binarytree;

import static binarytree.BTNode.nil;;
public class BSTree<T extends Comparable<T>>  {
	BTNode<T> root;
	
	@SuppressWarnings("unchecked")
	public BSTree(){
		root = BTNode.nil;
	}
	
	public void insert(T key) {
		root = insertR(root, key);
	}

	private BTNode<T> insertR(BTNode<T> root, T key) {
		if(root == nil) return 
			new BTNode<T>(nil, nil, root, key);
		if(key.compareTo(root.key) < 0)
			root.left = insertR(root.left, key);
		else 
			root.right = insertR(root.right, key);
		return root;
	}
	
	public void print() {
		root.show();
	}
}
