package binarytree;

class BTNode<T> {
	public BTNode<T> nil = new BTNode<>(null);
	
	BTNode<T> left;
	BTNode<T> right;
	BTNode<T> parent;
	T info;
	
	public BTNode(BTNode<T> parent) {
		this(null, null, parent, null);
	}
	
	public BTNode(BTNode<T> left, BTNode<T> right, BTNode<T> parent, T info) {
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.info = info;
	}

	public int size(BTNode<T> root) {
		if (root == nil) return 0; //bottom
		return 1 + size(root.left) + size(root.right); //recursion step
	}
}

