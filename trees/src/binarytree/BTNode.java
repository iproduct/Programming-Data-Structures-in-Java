package binarytree;

class BTNode<T> {
	@SuppressWarnings("rawtypes")
	public static BTNode nil = new BTNode();
	
	BTNode<T> left;
	BTNode<T> right;
	BTNode<T> parent;
	T info;
	
	public BTNode() {
	}
	
	public BTNode(BTNode<T> parent) {
		this(null, null, parent, null);
	}
	
	@SuppressWarnings("unchecked")
	public BTNode(BTNode<T> parent, T info) { //create leaf
		this(nil, nil, parent, info);
	}
	
	public BTNode(BTNode<T> left, BTNode<T> right, BTNode<T> parent, T info) {
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.info = info;
	}

	public int size() {
		if (this == nil) return 0; //bottom
		return 1 + left.size() + right.size(); //recursion step
	}
}

